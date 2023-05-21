package com.mycom.myboard.adapter.out.persistence;

import com.mycom.myboard.adapter.out.persistence.entity.UserEntity;
import com.mycom.myboard.biz.port.out.UserPersistencePort;
import com.mycom.myboard.domain.user.UserM;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

//@Configuration
@Repository
@MapperScan(value="com.mycom.myboard.adapter.out.persistence")
public class UserAdapter implements UserPersistencePort {

    private final UserMapper userMapper;

    //@Autowired
    public UserAdapter(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserM selectUser(UserEntity userEntity) {
        //UserEntity user = userMapper.selectUser(userEntity);
        System.out.println("before: "+userEntity);
        UserEntity user = userMapper.selectUser(userEntity);
        System.out.println("after: "+user);
        UserM userM = UserM.builder()
                .userSeq(user.getUserSeq())
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .build();
        return userM;
    }
}
