package com.green.nowon.domain.entity;

import javax.persistence.*;

@Entity
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @JoinColumn //member_mno
    @OneToOne
    private MemberEntity member;
}
