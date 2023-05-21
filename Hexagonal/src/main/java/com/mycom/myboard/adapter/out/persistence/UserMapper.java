package com.mycom.myboard.adapter.out.persistence;

import com.mycom.myboard.adapter.out.persistence.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper
public interface UserMapper {

    UserEntity selectUser(UserEntity userEntity);
}
