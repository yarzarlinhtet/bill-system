package com.codingassigment.billingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "transaction")
public class Transaction extends AuditEntity {

    @Column(nullable = false)
    private String apiCaller;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "bill_id",
            referencedColumnName = "id",
            nullable = false)
    private Bill bill;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false, unique = true)
    private String referenceNo;

    @Column(nullable = false)
    private Date transactionDate;

    @Column(nullable = false)
    private String phoneNumber;
}
