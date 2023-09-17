package com.codingassigment.billingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity extends BaseEntity {
    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private Integer createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private Integer updatedBy;
}
