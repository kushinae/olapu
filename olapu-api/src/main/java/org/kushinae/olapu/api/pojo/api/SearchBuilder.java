package org.kushinae.olapu.api.pojo.api;

import org.kushinae.olapu.api.vo.DefaultPage;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class SearchBuilder<T> {

    private final SearchPayload<T> searchPayload;

    protected SearchBuilder() {
        searchPayload = new DefaultSearchPayload<>();
    }

    public SearchBuilder<T> current(Integer current) {
        this.searchPayload.setCurrent(current - 1);
        return this;
    }

    public SearchBuilder<T> queryCount(Integer queryCount) {
        this.searchPayload.setQueryCount(queryCount);
        return this;
    }

    public SearchBuilder<T> query(T query) {
        this.searchPayload.setQuery(query);
        return this;
    }

    public SearchBuilder<T> uid(String uid) {
        this.searchPayload.setUid(uid);
        return this;
    }

    public SearchPayload<T> build() {
        return this.searchPayload;
    }

}
