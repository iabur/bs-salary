package com.bs23.esmpanel.repositories;

import com.bs23.esmpanel.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findByUserUsername(String username);

}
