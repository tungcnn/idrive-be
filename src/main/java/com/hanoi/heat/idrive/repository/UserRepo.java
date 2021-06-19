package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
