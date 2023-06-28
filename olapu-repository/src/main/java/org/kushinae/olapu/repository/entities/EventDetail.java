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
import org.kushinae.olapu.repository.enums.PubsubEvent;
import org.kushinae.olapu.repository.enums.PubsubEventGroup;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_event")
public class EventDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 目标事件类型数据ID
     */
    @Column(name = "target_id")
    private String targetId;

    /**
     * 目标事件类型 比如 job
     */
    @Column(name = "target_type")
    private String targetType;

    /**
     * 事件组
     */
    @Column(name = "`group`")
    @Convert(converter = PubsubEventGroup.Convert.class)
    private PubsubEventGroup group;

    /**
     * 事件类型
     */
    @Column(name = "`type`")
    @Convert(converter = PubsubEvent.Convert.class)
    private PubsubEvent type;

    /**
     * 事件内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 数据创建时间
     */
    @Column(name = "create_at")
    private String createAt;

    /**
     * 数据编辑时间
     */
    @Column(name = "modified_at")
    private String modifiedAt;

    /**
     * 数据是否删除
     */
    @Column(name = "deleted")
    private String deleted;


}
