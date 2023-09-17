package com.codingassigment.billingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "bill")
public class Bill extends BaseEntity {

    @Column
    private boolean enable;

    @Column(unique = true)
    private String name;

    @Column
    private String description;
}
