package com.hanoi.heat.idrive.service.user;

import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Long id) {

    }
}
