package com.prdcv.learnspring.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import com.prdcv.learnspring.domain.User;

@EnableScan
public interface UserRepository extends CrudRepository<User,String> {
    User findByUserId(String userId);
}
