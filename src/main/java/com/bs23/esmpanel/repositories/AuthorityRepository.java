package com.bs23.esmpanel.repositories;

import com.bs23.esmpanel.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
