package org.kushinae.olapu.interfaces.controller.job;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "任务管理控制器", description = "该控制器用于对任务管理")
public interface IJobController extends IController {

    @PostMapping
    @Operation(summary = "创建任务", description = "创建任务")
    Long create(@RequestBody EditJobPayload payload);

    @PutMapping
    @Operation(summary = "修改任务", description = "修改任务")
    Detail update(@RequestBody EditJobPayload payload);

    @GetMapping
    @Operation(summary = "通过任务ID获取任务详情", description = "通过任务ID获取任务详情")
    Detail getDetail(@Parameter(description = "任务ID") @RequestParam("id") Long jobId);

    @PutMapping("/build")
    @Operation(summary = "构建任务", description = "构建任务")
    @ResponseStatus(code = HttpStatus.CREATED)
    void build(@Parameter(description = "任务ID") @RequestParam("id") Long jobId);

    @GetMapping("/start")
    @Operation(summary = "执行任务", description = "执行任务 在执行任务之前请确定任务已经构建")
    Record start(@Parameter(description = "任务ID") @RequestParam("id") Long id);

    @Override
    IJobService getService();
}
