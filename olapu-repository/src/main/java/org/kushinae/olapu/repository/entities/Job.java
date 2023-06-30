package org.kushinae.olapu.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kushinae.olapu.core.enums.EJobType;
import org.kushinae.olapu.core.enums.JobModel;

import java.util.Date;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_job")
public class Job {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户uid
     */
    @Column(name = "uid")
    private String uid;

    /**
     * 任务模式 script gui
     */
    @Column(name = "model")
    @Convert(converter = JobModel.Convert.class)
    private JobModel model;

    /**
     * 任务名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 任务执行脚本
     */
    @Column(name = "script")
    private String script;

    /**
     * generate
     */
    @Column(name = "type")
    @Convert(converter = EJobType.Convert.class)
    private EJobType type;

    /**
     * 已经构建? true 已经完成 false 没有完成
     */
    @Column(name = "built")
    private Boolean built;

    /**
     * 任务描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 任务所属目录
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 工作流id
     */
    @Column(name = "workflow_id")
    private Long workflowId;

    /**
     * 前置工作流id
     */
    @Column(name = "before_workflow_id")
    private Long beforeWorkflowId;

    /**
     * 任务配置
     */
    @Column(name = "settings")
    private String settings;

    /**
     * 数据创建时间
     */
    @Column(name = "create_at")
    private Date createAt;

    /**
     * 数据编辑时间
     */
    @Column(name = "modified_at")
    private Date modifiedAt;

    /**
     * 数据是否删除
     */
    @Column(name = "deleted")
    private Boolean deleted;

}
