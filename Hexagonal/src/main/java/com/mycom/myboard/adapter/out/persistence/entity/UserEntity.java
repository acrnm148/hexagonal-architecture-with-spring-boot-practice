package com.mycom.myboard.adapter.out.persistence.entity;

import com.mycom.myboard.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor //엔티티는 스웨거에서 제외
public class UserEntity extends BaseEntity {

    /**
     * 유저 고유 ID
     */
    private int userSeq;

    /**
     * 유저 이름
     */
    private String userName;

    /**
     * 유저 이메일
     */
    private String userEmail;

    /**
     * 유저 비밀번호
     */
    private String userPassword;
}
