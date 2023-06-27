package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.convert.JobConvert;
import org.kushinae.olapu.interfaces.service.IJobService;
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
    private IJobService jobService;

    @Override
    public Long create(EditJobPayload payload) {
        payload.setUid(authorization.getUid());
        return getService().createJob(JobConvert.INSTANCE.edit2Entity(payload));
    }

    @Override
    public Detail update(EditJobPayload payload) {
        payload.setUid(authorization.getUid());
        return JobConvert.INSTANCE.job2Detail(getService().updateJob(JobConvert.INSTANCE.edit2Entity(payload)));
    }

    @Override
    public Detail getDetail(Long jobId) {
        return JobConvert.INSTANCE.job2Detail(getService().queryById(jobId));
    }

    @Override
    public void build(Long jobId) {
        getService().build(jobId);
    }

    @Override
    public Record start(Long id) {
        return getService().start(id);
    }

    @Override
    public IJobService getService() {
        return jobService;
    }

}
