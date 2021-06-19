package com.hanoi.heat.idrive.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {

    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll();

    T save(T t);

    Optional<T> findById(Long id);

    void delete(Long id);
}
