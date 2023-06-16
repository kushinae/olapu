package org.kushinae.olapu.api.vo;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Page<T> {

    static <T> PageBuilder<T> builder(Class<T> recordType) {
        return new PageBuilder<>();
    }

    Integer getCurrent();

    Integer getQueryCount();

    Long getTotal();

    void setCurrent(Integer current);

    void setQueryCount(Integer queryCount);

    void setTotal(Long total);

    List<T> getRecords();

    void setRecords(List<T> records);

}
