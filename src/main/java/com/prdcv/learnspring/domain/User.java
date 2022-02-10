package com.prdcv.learnspring.domain;

import com.prdcv.learnspring.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class User{
    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userID;
    @Setter
    @Getter
    private String userName;
    @Setter
    @Getter
    private String userFullName;
}
