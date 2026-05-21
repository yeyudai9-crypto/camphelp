package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RiskUtils {
    private static final List<String> HIGH_RISK_WORDS = Arrays.asList("诈骗", "欺诈", "骗钱", "恐吓", "威胁", "暴力", "辱骂", "死", "杀");
    private static final List<String> MEDIUM_RISK_WORDS = Arrays.asList("加微信", "私下转账", "先付款", "押金", "刷单", "兼职返利", "恶意差评");

    public static RiskResult check(String content) {
        String text = StringUtils.defaultString(content).replaceAll("<[^>]+>", "").toLowerCase();
        List<String> hits = new ArrayList<String>();
        String level = "low";
        for(String word : HIGH_RISK_WORDS) {
            if(text.contains(word.toLowerCase())) {
                hits.add(word);
                level = "high";
            }
        }
        if(!"high".equals(level)) {
            for(String word : MEDIUM_RISK_WORDS) {
                if(text.contains(word.toLowerCase())) {
                    hits.add(word);
                    level = "medium";
                }
            }
        }
        return new RiskResult(!"high".equals(level), level, hits);
    }

    public static class RiskResult {
        private boolean pass;
        private String level;
        private List<String> hits;

        public RiskResult(boolean pass, String level, List<String> hits) {
            this.pass = pass;
            this.level = level;
            this.hits = hits;
        }

        public boolean isPass() {
            return pass;
        }

        public String getLevel() {
            return level;
        }

        public List<String> getHits() {
            return hits;
        }
    }
}
