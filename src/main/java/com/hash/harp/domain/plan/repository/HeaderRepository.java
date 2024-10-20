package com.hash.harp.domain.plan.repository;

import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.exception.HeaderNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaderRepository extends JpaRepository<Header, Long> {

    List<Header> findByUserId(Long userId);

    default Header getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new HeaderNotFoundException(id));
    }
}
