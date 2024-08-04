package org.lyflexi.builderPattern;

/**
 * @Author: ly
 * @Date: 2024/3/13 22:10
 */

/**
 * 建造者模式-产品(Product)角色
 */
public class Homework {
    private String easyQc;//简答题目

    private String normalQc;//正常题目

    private String MediumQc;//中等难度题目

    private String HardQc;//困难题目

    public String getEasyQc() {
        return easyQc;
    }

    public void setEasyQc(String easyQc) {
        this.easyQc = easyQc;
    }

    public String getNormalQc() {
        return normalQc;
    }

    public void setNormalQc(String normalQc) {
        this.normalQc = normalQc;
    }

    public String getMediumQc() {
        return MediumQc;
    }

    public void setMediumQc(String mediumQc) {
        MediumQc = mediumQc;
    }

    public String getHardQc() {
        return HardQc;
    }

    public void setHardQc(String hardQc) {
        HardQc = hardQc;
    }
}

