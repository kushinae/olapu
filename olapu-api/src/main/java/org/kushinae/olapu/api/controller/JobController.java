package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.JobConvert;
import org.kushinae.olapu.api.service.JobService;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.interfaces.controller.AbstractController;
import org.kushinae.olapu.interfaces.controller.job.IJobController;
import org.kushinae.olapu.interfaces.pojo.api.job.EditJobPayload;
import org.kushinae.olapu.interfaces.vo.job.Detail;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
public class JobController extends AbstractController implements IJobController {

    @Resource
    JobService jobService;

    @Override
    public Long create(EditJobPayload payload) {
        payload.setUid(authorization.getUid());
        return jobService.createJob(JobConvert.INSTANCE.edit2Entity(payload));
    }

    @Override
    public Detail update(EditJobPayload payload) {
        payload.setUid(authorization.getUid());
        return JobConvert.INSTANCE.job2Detail(jobService.updateJob(JobConvert.INSTANCE.edit2Entity(payload)));
    }

    @Override
    public Detail getDetail(Long jobId) {
        return JobConvert.INSTANCE.job2Detail(jobService.queryById(jobId));
    }

    @Override
    public void build(Long jobId) {
        jobService.build(jobId);
    }

    @Override
    public Record start(Long id) {
        return jobService.start(id);
    }

}
