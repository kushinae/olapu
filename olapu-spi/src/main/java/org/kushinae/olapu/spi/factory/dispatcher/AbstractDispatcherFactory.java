package org.kushinae.olapu.spi.factory.dispatcher;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractDispatcherFactory implements DispatcherFactory {

    @Override
    public Dispatcher getFactory(Language language) {
        ServiceLoader<Dispatcher> dispatchers = ServiceLoader.load(Dispatcher.class);
        for (Dispatcher dispatcher : dispatchers) {
            if (dispatcher.getLanguage().equals(language)) {
                return dispatcher;
            }
        }
        throw new IllegalArgumentException("Unsupported dispatcher language");
    }
}
