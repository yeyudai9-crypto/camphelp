package com.controller;

import com.annotation.IgnoreAuth;
import com.utils.RiskUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AI 风险识别接口。课程演示版使用本地规则模型，便于离线运行。
 */
@RestController
@RequestMapping("/risk")
public class RiskController {
    @IgnoreAuth
    @RequestMapping("/check")
    public R check(@RequestBody RiskRequest request) {
        String content = request == null ? "" : StringUtils.defaultString(request.getContent());
        RiskUtils.RiskResult result = RiskUtils.check(content);
        boolean pass = result.isPass();
        String level = result.getLevel();
        String suggestion = pass ? "内容风险较低，可提交" : "内容包含高风险词，请修改后再提交";
        return R.ok()
                .put("pass", pass)
                .put("riskLevel", level)
                .put("hits", result.getHits())
                .put("suggestion", suggestion);
    }

    public static class RiskRequest {
        private String content;
        private String scene;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getScene() {
            return scene;
        }

        public void setScene(String scene) {
            this.scene = scene;
        }
    }
}
