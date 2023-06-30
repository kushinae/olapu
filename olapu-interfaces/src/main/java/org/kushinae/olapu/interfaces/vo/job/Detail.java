package org.kushinae.olapu.interfaces.vo.job;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kushinae.olapu.core.enums.EJobType;
import org.kushinae.olapu.core.enums.JobModel;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
public class Detail {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 任务模式 script gui
     */
    private JobModel model;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务执行脚本
     */
    private String script;

    /**
     * generate
     */
    private EJobType type;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务所属目录
     */
    @JsonProperty("resource_id")
    private Long resourceId;

    /**
     * 工作流id
     */
    @JsonProperty("workflow_id")
    private Long workflowId;

    /**
     * 前置工作流id
     */
    @JsonProperty("before_workflow_id")
    private Long beforeWorkflowId;

    /**
     * 任务配置
     */
    private String settings;

}
