package org.kushinae.olapu.api.controller;

import jakarta.annotation.Resource;
import org.kushinae.olapu.api.authorization.Authorization;
import org.kushinae.olapu.api.convert.JobConvert;
import org.kushinae.olapu.api.pojo.api.job.EditJobPayload;
import org.kushinae.olapu.api.service.JobService;
import org.kushinae.olapu.generate.Record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Resource
    JobService jobService;

    @Resource
    Authorization authorization;

    @PostMapping
    public Long create(@RequestBody EditJobPayload payload) {
        payload.setUid(authorization.getUid());
        return jobService.createJob(JobConvert.INSTANCE.edit2Entity(payload));
    }

    @GetMapping("/start")
    public Record start(@RequestParam("id") Long id) {
        return jobService.start(id);
    }

}
