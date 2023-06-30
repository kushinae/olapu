package org.kushinae.olapu.interfaces.pojo.api.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.kushinae.olapu.core.enums.EJobType;
import org.kushinae.olapu.core.enums.JobModel;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class EditJobPayload {

    /**
     * 主键ID
     */
    @Parameter(description = "主键ID 在编辑任务时这个参数是不能为空的，如果为空会执行创建任务逻辑")
    private Long id;

    /**
     * 用户uid
     */
    @Parameter(description = "用户的uid", hidden = true)
    private String uid;

    /**
     * 任务模式 script gui
     */
    @Parameter(description = "任务模式")
    private JobModel model;

    /**
     * 任务名称
     */
    @Parameter(description = "任务名称 它时唯一的")
    private String name;

    /**
     * 任务执行脚本
     */
    @Parameter(description = "任务构建之后的执行脚本")
    private String script;

    /**
     * generate
     */
    @Parameter(description = "任务类型")
    private EJobType type;

    /**
     * 任务描述
     */
    @Parameter(description = "任务描述")
    private String description;

    /**
     * 任务所属目录
     */
    @Parameter(description = "任务所属资源ID 这个资源类型必须属于job")
    @JsonProperty("resource_id")
    private Long resourceId;

    /**
     * 工作流id
     */
    @Parameter(description = "任务所属工作流ID 预留属性", hidden = true)
    @JsonProperty("workflow_id")
    private Long workflowId;

    /**
     * 前置工作流id
     */
    @Parameter(description = "该任务执行的前置任务id")
    @JsonProperty("before_workflow_id")
    private Long beforeWorkflowId;

    /**
     * 任务配置
     */
    @Parameter(description = "任务配置")
    private String settings;

}
