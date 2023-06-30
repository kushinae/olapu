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
import org.kushinae.olapu.core.enums.FileType;
import org.kushinae.olapu.core.enums.ResourceCategory;

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
@Table(name = "t_resource")
public class Resource {

    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 主键ID
     */
    @Column(name = "content")
    private String content;

    /**
     * 文件内容，如果文件类型为文件时不可为空
     */
    @Column(name = "name")
    private String name;

    /**
     * 文件/文件夹名称
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 夫目录ID, 根目录则为-1
     */
    @Column(name = "type")
    @Convert(converter = FileType.Convert.class)
    private FileType type;

    /**
     * 资源所属分类 job resource等
     * @see ResourceCategory
     */
    @Convert(converter = ResourceCategory.Convert.class)
    private ResourceCategory category;

    /**
     * 用户uid
     */
    @Column(name = "uid")
    private String uid;

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
