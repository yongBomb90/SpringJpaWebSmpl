package com.mtbx.prgword.infra.auth.repo;


import com.mtbx.prgword.infra.auth.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account getByAccIdEquals(String accId);

    @Query(
            value = "select a from Account a join fetch a.member where a.accId = :accId"
    )
    Account getByAccIdEqualsWithMember(String accId);


}
