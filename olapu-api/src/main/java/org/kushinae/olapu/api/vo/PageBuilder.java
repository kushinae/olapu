package org.kushinae.olapu.api.vo;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class PageBuilder<T> {

    private final Page<T> page;

    protected PageBuilder() {
        page = new DefaultPage<>();
    }

    public PageBuilder<T> current(Integer current) {
        this.page.setCurrent(current + 1);
        return this;
    }

    public PageBuilder<T> total(Long total) {
        this.page.setTotal(total);
        return this;
    }

    public PageBuilder<T> queryCount(Integer queryCount) {
        this.page.setQueryCount(queryCount);
        return this;
    }

    public PageBuilder<T> records(List<T> records) {
        this.page.setRecords(records);
        return this;
    }

    public Page<T> build() {
        return this.page;
    }


}
