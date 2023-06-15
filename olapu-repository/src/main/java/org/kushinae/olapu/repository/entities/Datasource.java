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
import org.kushinae.olapu.repository.enums.DatasourceType;

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
@Table(name = "t_datasource")
public class Datasource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源主键ID 标识此数据源目录
     * 该资源类型不能为 {@link org.kushinae.olapu.repository.enums.FileType#FILE}
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 数据源名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 数据源类型
     */
    @Column(name = "type")
    @Convert(converter = DatasourceType.Convert.class)
    private DatasourceType type;

    /**
     * 该数据是否为模版
     */
    @Column(name = "template")
    private Boolean template;

    /**
     * 所属人uid
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
