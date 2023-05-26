package org.kushinae.olapu.spi.factory;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface Factory<T, E> {

    T getFactory(E code);

}
