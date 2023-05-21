package com.mycom.myboard.biz.service;

import com.mycom.myboard.adapter.out.persistence.entity.UserEntity;
import com.mycom.myboard.biz.port.in.UserServicePort;
import com.mycom.myboard.biz.port.out.UserPersistencePort;
import com.mycom.myboard.domain.user.UserM;
import com.mycom.myboard.domain.user.UserSrch;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserM login(UserSrch userSrch) {
        System.out.println("login 함수 진입");

        return userPersistencePort.selectUser(
            UserEntity.builder()
                    .userEmail(userSrch.getUserEmail())
                    .userPassword(userSrch.getUserPassword())
                    .build()
        ); //out port에 보내줄 때는 entity로 보내줘야 한다.
    }
}
