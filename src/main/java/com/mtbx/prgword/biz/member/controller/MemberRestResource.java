package com.mtbx.prgword.biz.member.controller;


import com.mtbx.prgword.biz.member.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * REST FULL Controller
 */
@RepositoryRestResource(path = "member")
public interface MemberRestResource extends PagingAndSortingRepository<Member,Long> {




}
