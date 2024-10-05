package com.wlabs.api_rest_bank_2024.domain.repository;

import com.wlabs.api_rest_bank_2024.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);

    boolean findUserById(Long id);

}
