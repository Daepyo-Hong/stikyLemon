package com.green.nowon.domain.dto.member;

import com.green.nowon.domain.entity.MemberEntity;
import com.green.nowon.security.MyRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MemberDTO {
    private long mno;
    private String email;
    private String pass;
    private String name;
    private String nickName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean social;
    private boolean deleted;

    private Set<MyRole> roles = new HashSet<>();

    public MemberDTO addRole(MyRole role){
        this.roles.add(role);
        return this;
    }
}
