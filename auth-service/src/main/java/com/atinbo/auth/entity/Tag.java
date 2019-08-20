package com.atinbo.auth.entity;


import com.atinbo.auth.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 会员标签
 *
 * @author breggor
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "tag")
@Where(clause = "deleted = 0")
@DynamicInsert
@DynamicUpdate
public class Tag extends BaseEntity {

    @Id
    private Long id;

    @Column(columnDefinition = "varchar(50) default null comment '标签名称'")
    private String name;
}
