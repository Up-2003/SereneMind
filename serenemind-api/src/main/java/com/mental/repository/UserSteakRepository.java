package com.mental.repository;

import com.mental.model.entity.User;
import com.mental.model.entity.UserGoal;
import com.mental.model.entity.UserStreak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSteakRepository extends JpaRepository<UserStreak, Long> {
    UserStreak findByUser(User user);
}
