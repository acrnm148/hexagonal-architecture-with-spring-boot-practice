package com.mycom.myboard.biz.port.in;

import com.mycom.myboard.domain.user.UserM;
import com.mycom.myboard.domain.user.UserSrch;

public interface UserServicePort {

    /**
     * @description 로그인
     */
    UserM login(UserSrch userSrch);
}
