package org.kushinae.olapu.spi.factory.handler;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.core.utils.CollectionUtils;
import org.kushinae.olapu.generate.handler.Handler;

import java.util.List;
import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractHandlerFactory implements HandlerFactory {
    @Override
    public List<Handler> getFactory(Language code) {
        ServiceLoader<Handler> providers = ServiceLoader.load(Handler.class);
        List<Handler> handlers = providers.stream()
                .filter(handlerProvider -> handlerProvider.get().getLanguage().equals(code))
                .map(ServiceLoader.Provider::get)
                .toList();
        if (CollectionUtils.isEmpty(handlers)) {
            throw new IllegalArgumentException("Unsupported handler language");
        }
        return handlers;
    }
}
