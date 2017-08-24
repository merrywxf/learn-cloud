package com.cn.cloud.repository;

import com.cn.cloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-08-24.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
