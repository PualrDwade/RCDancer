package com.RCDancer.core;


import java.util.List;
import java.util.Map;

/**
 * @author xuanxuan
 * 条件类,默认根据页数,页数大小,列条件进行条件查询
 */
public class MyCondition {
    //条件列表
    private Map<Object, Object> conditions;
    private Integer page;

    @Override
    public String toString() {
        return "MyCondition{" +
                "conditions=" + conditions +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public Map<Object, Object> getConditions() {
        return conditions;
    }

    public void setConditions(Map<Object, Object> conditions) {
        this.conditions = conditions;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public MyCondition() {
    }

    public MyCondition(Map<Object, Object> conditions, Integer page, Integer size) {
        this.conditions = conditions;
        this.page = page;
        this.size = size;
    }

    private Integer size;
}
