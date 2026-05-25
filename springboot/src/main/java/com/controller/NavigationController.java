package com.controller;

import com.annotation.IgnoreAuth;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路线规划接口，提供课程演示可用的坐标、距离、预计时长和高德导航链接。
 */
@RestController
@RequestMapping("/navigation")
public class NavigationController {
    private static final double CAMPUS_LAT = 31.2304;
    private static final double CAMPUS_LNG = 121.4737;

    @IgnoreAuth
    @RequestMapping("/plan")
    public R plan(@RequestBody NavigationRequest request) throws Exception {
        if(request == null) {
            return R.error("路线参数不能为空");
        }
        Point pickup = resolvePoint(request.getPickupAddress(), request.getPickupLatitude(), request.getPickupLongitude(), 1);
        Point destination = resolvePoint(request.getDestinationAddress(), request.getDestinationLatitude(), request.getDestinationLongitude(), 2);
        double distance = distanceMeters(pickup.latitude, pickup.longitude, destination.latitude, destination.longitude);
        if(distance < 30) {
            destination = new Point(destination.latitude + 0.0026, destination.longitude + 0.0028);
            distance = distanceMeters(pickup.latitude, pickup.longitude, destination.latitude, destination.longitude);
        }
        int durationMinutes = Math.max(3, (int)Math.ceil(distance / 80.0));

        List<Map<String, Double>> routePoints = new ArrayList<Map<String, Double>>();
        routePoints.add(pointMap(pickup));
        routePoints.add(midPoint(pickup, destination));
        routePoints.add(pointMap(destination));

        String amapUrl = "https://uri.amap.com/navigation?from="
                + pickup.longitude + "," + pickup.latitude + ",pickup&to="
                + destination.longitude + "," + destination.latitude + ",destination&mode=walk&policy=1&src=camphelp";
        if(StringUtils.isNotBlank(request.getPickupAddress()) || StringUtils.isNotBlank(request.getDestinationAddress())) {
            amapUrl = "https://uri.amap.com/navigation?from="
                    + pickup.longitude + "," + pickup.latitude + "," + encode(defaultText(request.getPickupAddress(), "pickup"))
                    + "&to=" + destination.longitude + "," + destination.latitude + "," + encode(defaultText(request.getDestinationAddress(), "destination"))
                    + "&mode=walk&policy=1&src=camphelp";
        }

        return R.ok()
                .put("pickup", pointMap(pickup))
                .put("destination", pointMap(destination))
                .put("routePoints", routePoints)
                .put("distanceMeters", Math.round(distance))
                .put("durationMinutes", durationMinutes)
                .put("amapUrl", amapUrl);
    }

    private Point resolvePoint(String address, Double latitude, Double longitude, int salt) {
        if(latitude != null && longitude != null) {
            return new Point(latitude, longitude);
        }
        int hash = StringUtils.defaultString(address, "campus-" + salt).hashCode();
        double latOffset = ((hash % 800) - 400) / 100000.0;
        double lngOffset = (((hash / 1000) % 800) - 400) / 100000.0;
        return new Point(CAMPUS_LAT + latOffset, CAMPUS_LNG + lngOffset);
    }

    private Map<String, Double> pointMap(Point point) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("latitude", point.latitude);
        map.put("longitude", point.longitude);
        return map;
    }

    private Map<String, Double> midPoint(Point start, Point end) {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("latitude", (start.latitude + end.latitude) / 2);
        map.put("longitude", (start.longitude + end.longitude) / 2);
        return map;
    }

    private double distanceMeters(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);
        return earthRadius * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    private String encode(String value) throws Exception {
        return URLEncoder.encode(value, "UTF-8");
    }

    private String defaultText(String value, String fallback) {
        return StringUtils.isBlank(value) ? fallback : value;
    }

    private static class Point {
        private double latitude;
        private double longitude;

        private Point(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    public static class NavigationRequest {
        private String orderId;
        private String pickupAddress;
        private String destinationAddress;
        private Double pickupLatitude;
        private Double pickupLongitude;
        private Double destinationLatitude;
        private Double destinationLongitude;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPickupAddress() {
            return pickupAddress;
        }

        public void setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
        }

        public String getDestinationAddress() {
            return destinationAddress;
        }

        public void setDestinationAddress(String destinationAddress) {
            this.destinationAddress = destinationAddress;
        }

        public Double getPickupLatitude() {
            return pickupLatitude;
        }

        public void setPickupLatitude(Double pickupLatitude) {
            this.pickupLatitude = pickupLatitude;
        }

        public Double getPickupLongitude() {
            return pickupLongitude;
        }

        public void setPickupLongitude(Double pickupLongitude) {
            this.pickupLongitude = pickupLongitude;
        }

        public Double getDestinationLatitude() {
            return destinationLatitude;
        }

        public void setDestinationLatitude(Double destinationLatitude) {
            this.destinationLatitude = destinationLatitude;
        }

        public Double getDestinationLongitude() {
            return destinationLongitude;
        }

        public void setDestinationLongitude(Double destinationLongitude) {
            this.destinationLongitude = destinationLongitude;
        }
    }
}
