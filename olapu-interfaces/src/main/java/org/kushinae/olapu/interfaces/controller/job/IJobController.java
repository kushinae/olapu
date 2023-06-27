package org.kushinae.olapu.interfaces.controller.job;

import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.job.EditJobPayload;
import org.kushinae.olapu.interfaces.service.IJobService;
import org.kushinae.olapu.interfaces.vo.job.Detail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/job")
public interface IJobController extends IController {

    @PostMapping
    Long create(@RequestBody EditJobPayload payload);

    @PutMapping
    Detail update(@RequestBody EditJobPayload payload);

    @GetMapping
    Detail getDetail(@RequestParam("id") Long jobId);

    @PutMapping("/build")
    @ResponseStatus(code = HttpStatus.CREATED)
    void build(@RequestParam("id") Long jobId);

    @GetMapping("/start")
    Record start(@RequestParam("id") Long id);

    @Override
    IJobService getService();
}
