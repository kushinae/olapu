package org.kushinae.olapu.core.job.entities;

import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.core.enums.JobType;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class Job {

    /**
     * job type
     */
    private List<JobType> types;

    /**
     * 代码生成工作参数
     */
    private List<GenerateJob> generate;

    public List<JobType> getTypes() {
        return types;
    }

    public void setTypes(List<JobType> types) {
        this.types = types;
    }

    public List<GenerateJob> getGenerate() {
        return generate;
    }

    public void setGenerate(List<GenerateJob> generate) {
        this.generate = generate;
    }
}
