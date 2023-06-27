package org.kushinae.olapu.interfaces.pojo.api;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface SearchPayload<T> {

     static <T> SearchBuilder<T> builder(Class<T> queryType) {
         return new SearchBuilder<>();
     }

    Integer getCurrent();

    Integer getQueryCount();

    void setCurrent(Integer current);

    void setQueryCount(Integer queryCount);

    void setQuery(T query);

    T getQuery();

    void setUid(String uid);

    String getUid();
}
