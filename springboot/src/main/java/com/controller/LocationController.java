package com.controller;

import com.annotation.IgnoreAuth;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配送员实时位置接口。
 */
@RestController
@RequestMapping("/location")
public class LocationController {
    private static final Map<String, LocationPayload> CURRENT_BY_ORDER = new ConcurrentHashMap<String, LocationPayload>();
    private static final Map<String, List<LocationPayload>> TRACK_BY_ORDER = new ConcurrentHashMap<String, List<LocationPayload>>();

    @IgnoreAuth
    @RequestMapping("/report")
    public R report(@RequestBody LocationPayload payload) {
        if(payload == null || StringUtils.isBlank(payload.getOrderId())) {
            return R.error("订单号不能为空");
        }
        if(payload.getLatitude() == null || payload.getLongitude() == null) {
            return R.error("定位坐标不能为空");
        }
        payload.setUpdateTime(new Date());
        payload.setOnline(true);
        CURRENT_BY_ORDER.put(payload.getOrderId(), payload);

        List<LocationPayload> track = TRACK_BY_ORDER.get(payload.getOrderId());
        if(track == null) {
            track = new ArrayList<LocationPayload>();
            TRACK_BY_ORDER.put(payload.getOrderId(), track);
        }
        synchronized (track) {
            track.add(payload.copy());
            if(track.size() > 200) {
                track.remove(0);
            }
        }
        return R.ok().put("data", payload);
    }

    @IgnoreAuth
    @RequestMapping("/current")
    public R current(@RequestParam String orderId) {
        LocationPayload payload = CURRENT_BY_ORDER.get(orderId);
        if(payload == null) {
            return R.ok().put("data", null).put("msg", "暂无配送员实时位置");
        }
        return R.ok().put("data", payload);
    }

    @IgnoreAuth
    @RequestMapping("/track")
    public R track(@RequestParam String orderId) {
        List<LocationPayload> track = TRACK_BY_ORDER.get(orderId);
        if(track == null) {
            track = new ArrayList<LocationPayload>();
        }
        return R.ok().put("data", track);
    }

    @IgnoreAuth
    @RequestMapping("/active")
    public R active() {
        return R.ok().put("data", new ArrayList<LocationPayload>(CURRENT_BY_ORDER.values()));
    }

    public static class LocationPayload {
        private String orderId;
        private String peisongzhanghao;
        private String peisongren;
        private Double latitude;
        private Double longitude;
        private Date updateTime;
        private Boolean online;

        public LocationPayload copy() {
            LocationPayload copy = new LocationPayload();
            copy.orderId = this.orderId;
            copy.peisongzhanghao = this.peisongzhanghao;
            copy.peisongren = this.peisongren;
            copy.latitude = this.latitude;
            copy.longitude = this.longitude;
            copy.updateTime = this.updateTime;
            copy.online = this.online;
            return copy;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPeisongzhanghao() {
            return peisongzhanghao;
        }

        public void setPeisongzhanghao(String peisongzhanghao) {
            this.peisongzhanghao = peisongzhanghao;
        }

        public String getPeisongren() {
            return peisongren;
        }

        public void setPeisongren(String peisongren) {
            this.peisongren = peisongren;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Boolean getOnline() {
            return online;
        }

        public void setOnline(Boolean online) {
            this.online = online;
        }
    }
}
