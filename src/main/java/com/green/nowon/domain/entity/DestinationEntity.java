package com.green.nowon.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@SequenceGenerator(name = "sticky_gen_dest", sequenceName = "sticky_seq_dest",allocationSize = 1)
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "stick_dest")
public class DestinationEntity {
    @Id
    @GeneratedValue(generator = "sticky_gen_dest",strategy = GenerationType.SEQUENCE)
    private long dno;
    @Column(nullable = false)
    private String zonecode;
    @Column(nullable = false)
    private String address;

}
