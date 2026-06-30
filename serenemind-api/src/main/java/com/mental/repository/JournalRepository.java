package com.mental.repository;

import com.mental.model.entity.Journal;
import com.mental.model.entity.RefreshToken;
import com.mental.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository  extends JpaRepository<Journal,Long> {
    List<Journal> findByUser(User user);
}
