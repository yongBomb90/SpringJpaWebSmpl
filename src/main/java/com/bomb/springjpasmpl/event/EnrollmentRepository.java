package com.bomb.springjpasmpl.event;

import com.bomb.springjpasmpl.domain.Account;
import com.bomb.springjpasmpl.domain.Enrollment;
import com.bomb.springjpasmpl.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByEventAndAccount(Event event, Account account);

    Enrollment findByEventAndAccount(Event event, Account account);
}
