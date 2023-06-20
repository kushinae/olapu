package org.kushinae.olapu.generate.handler;

import org.kushinae.olapu.core.enums.ModelType;
import org.kushinae.olapu.core.job.entities.generate.GenerateJob;

import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractHandler implements Handler {
    @Override
    public String getTemplate(GenerateJob job) {
        return job.getSettings().getTemplate();
    }
}
