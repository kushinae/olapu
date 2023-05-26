package org.kushinae.olapu.spi.factory.handler;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.handler.Handler;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractHandlerFactory implements HandlerFactory {
    @Override
    public Handler getFactory(Language code) {
        ServiceLoader<Handler> handlers = ServiceLoader.load(Handler.class);
        for (Handler handler : handlers) {
            if (handler.getLanguage().equals(code)) {
                return handler;
            }
        }
        throw new IllegalArgumentException("Unsupported handler language");
    }
}
