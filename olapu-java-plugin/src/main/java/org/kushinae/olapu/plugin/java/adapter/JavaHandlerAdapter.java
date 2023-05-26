package org.kushinae.olapu.plugin.java.adapter;

import org.kushinae.olapu.generate.BuildOption;
import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.adapter.AbstractHandlerAdapter;
import org.kushinae.olapu.generate.handler.Handler;
import org.kushinae.olapu.spi.factory.handler.DefaultHandlerFactory;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class JavaHandlerAdapter extends AbstractHandlerAdapter {
    @Override
    public Language getLanguage() {
        return Language.JAVA;
    }

    @Override
    public List<Handler> getHandlers(BuildOption option) {
        return new DefaultHandlerFactory().getFactory(getLanguage())
                .stream()
                .filter(e -> option.getModel().contains(e.getModelType()))
                .toList();
    }
}
