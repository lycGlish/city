package com.nit.city.bean;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer resultId;

    private String resultName;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName == null ? null : resultName.trim();
    }
}