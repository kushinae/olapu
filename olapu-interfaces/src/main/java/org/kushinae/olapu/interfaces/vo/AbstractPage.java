package org.kushinae.olapu.interfaces.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractPage<T> implements Page<T> {

    private Integer current;

    @JsonProperty("query_count")
    private Integer queryCount;

    private Long total;

    private List<T> records;

    @Override
    public Integer getCurrent() {
        return current;
    }

    @Override
    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public Integer getQueryCount() {
        return queryCount;
    }

    @Override
    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    @Override
    public Long getTotal() {
        return total;
    }

    @Override
    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
