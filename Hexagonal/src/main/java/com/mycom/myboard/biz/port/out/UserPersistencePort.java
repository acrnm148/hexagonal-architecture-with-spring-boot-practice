package com.mycom.myboard.biz.port.out;

import com.mycom.myboard.adapter.out.persistence.entity.UserEntity;
import com.mycom.myboard.domain.user.UserM;

public interface UserPersistencePort {

    /**
     * @description 로그인
     */
    UserM selectUser(UserEntity userEntity);
}
