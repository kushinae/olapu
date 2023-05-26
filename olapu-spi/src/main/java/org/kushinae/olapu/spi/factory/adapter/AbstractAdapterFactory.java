package org.kushinae.olapu.spi.factory.adapter;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractAdapterFactory implements AdapterFactory {

    @Override
    public HandlerAdapter getFactory(Language code) {
        ServiceLoader<HandlerAdapter> handlerAdapters = ServiceLoader.load(HandlerAdapter.class);
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.getLanguage().equals(code)) {
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("Unsupported handler adapter language");
    }
}
