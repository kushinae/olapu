package org.kushinae.olapu.spi.factory.mapping;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.generate.mapping.HandlerMapping;

import java.util.ServiceLoader;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractHandlerMappingFactory implements HandlerMappingFactory {
    @Override
    public HandlerMapping getFactory(Language code) {
        ServiceLoader<HandlerMapping> handlerMappings = ServiceLoader.load(HandlerMapping.class);
        for (HandlerMapping handlerMapping : handlerMappings) {
            if (handlerMapping.getLanguage().equals(code)) {
                return handlerMapping;
            }
        }
        throw new IllegalArgumentException("Unsupported handler mapping language");
    }
}
