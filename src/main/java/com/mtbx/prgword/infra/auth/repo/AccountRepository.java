package com.mtbx.prgword.infra.auth.repo;


import com.mtbx.prgword.infra.auth.domain.AccountETT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<AccountETT,Long> {

    AccountETT getByAccIdEquals(String accId);

}
