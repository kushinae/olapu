package org.kushinae.olapu.api.components;

import org.kushinae.olapu.repository.entities.Job;
import org.kushinae.olapu.repository.enums.JobModel;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface JobComponent {

    default boolean supportedSave(Job job) {
        return false;
    };

    default Job onSaveBefore(Job job) {
        return job;
    }

    String buildScript(Job job);

    /**
     * life cycle:
     *  {@link JobComponent#supportedSave(Job)} -> {@link JobComponent#onSaveBefore(Job)} -> {@link JobComponent#buildScript(Job)} -> {@link org.kushinae.olapu.repository.repository.impl.JobRepository#save(Object)};
     *
     * @param job 任务对象
     * @return 入库之后的job对象
     */
    Job save(Job job);

    JobModel model();

}
