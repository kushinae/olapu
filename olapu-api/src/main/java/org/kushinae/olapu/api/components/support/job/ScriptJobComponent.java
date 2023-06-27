package org.kushinae.olapu.api.components.support.job;

import org.kushinae.olapu.api.components.AbstractJobComponent;
import org.kushinae.olapu.repository.enums.JobModel;
import org.springframework.stereotype.Component;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Component
public class ScriptJobComponent extends AbstractJobComponent {

    @Override
    public JobModel model() {
        return JobModel.SCRIPT;
    }
}
