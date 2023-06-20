package org.kushinae.olapu.plugin.java.adapter;

import org.kushinae.olapu.core.enums.Language;
import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.core.utils.CollectionUtils;
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
    public Handler getHandler(GenerateJob job) {
        List<Handler> handlers = new DefaultHandlerFactory()
                .getFactory(getLanguage())
                .stream()
                .filter(e -> e.getModelType().equals(job.getSettings().getModel()))
                .toList();
        if (CollectionUtils.isEmpty(handlers)) {
            throw new IllegalArgumentException("Unsupported generate model of the " + job.getSettings().getModel().getCode());
        }
        return handlers.get(0);
    }
}
