package com.cn.cloud.provider.repository;

import com.cn.cloud.provider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-08-24.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
