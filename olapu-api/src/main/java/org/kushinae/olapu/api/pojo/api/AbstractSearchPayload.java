package org.kushinae.olapu.api.pojo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractSearchPayload<T> implements SearchPayload<T> {

    private Integer current;

    @JsonProperty("query_count")
    private Integer queryCount;

    @JsonProperty("q")
    private T query;

    private String uid;

    @Override
    public Integer getCurrent() {
        return this.current;
    }

    @Override
    public Integer getQueryCount() {
        return this.queryCount;
    }

    @Override
    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public void setQueryCount(Integer queryCount) {
        this.queryCount = queryCount;
    }

    @Override
    public void setQuery(T query) {
        this.query = query;
    }

    @Override
    public T getQuery() {
        return query;
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public void setUid(String uid) {
        this.uid = uid;
    }
}
