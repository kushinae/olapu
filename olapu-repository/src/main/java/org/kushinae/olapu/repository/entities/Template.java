package org.kushinae.olapu.repository.entities;

import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.kushinae.olapu.repository.enums.TemplateModel;
import org.kushinae.olapu.repository.enums.TemplateSource;
import org.kushinae.olapu.repository.enums.TemplateType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "t_template")
public class Template {

    /**
     * 自增主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模版原始来源
     * @see TemplateSource
     */
    @Column(name = "source")
    @Convert(converter = TemplateSource.Convert.class)
    private TemplateSource source;

    /**
     * 模版类型
     *  如java、golang、python等
     * @see TemplateType
     */
    @Column(name = "type")
    @Convert(converter = TemplateType.Convert.class)
    private TemplateType type;

    /**
     * 生成模型
     * @see TemplateModel
     */
    @Column(name = "model")
    @Convert(converter = TemplateModel.Convert.class)
    private TemplateModel model;

    /**
     * 模版名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 模版描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 模版数据, 使用${key}进行模版字符占位
     */
    @Column(name = "template")
    private String template;

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
