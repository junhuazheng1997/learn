package com.junhuazheng.generator.pojo;

import java.io.Serializable;
import java.util.List;

public class SQLPo implements Serializable {

    private List<String> selectList;
    private List<String> fromList;
    private List<String> condition;

    public void setCondition(List<String> condition) {
        this.condition = condition;
    }

    public void setFromList(List<String> fromList) {
        this.fromList = fromList;
    }

    public void setSelectList(List<String> selectList) {
        this.selectList = selectList;
    }

    public List<String> getCondition() {
        return condition;
    }

    public List<String> getFromList() {
        return fromList;
    }

    public List<String> getSelectList() {
        return selectList;
    }
}
