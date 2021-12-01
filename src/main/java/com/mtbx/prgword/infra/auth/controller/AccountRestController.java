package com.mtbx.prgword.infra.auth.controller;

import com.mtbx.prgword.infra.auth.domain.Account;
import com.mtbx.prgword.infra.auth.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@RepositoryRestController
public class AccountRestController {

    private final AccountRepository accountRepository;


    @GetMapping("/account")
    public @ResponseBody
    CollectionModel<Account> getItems(@PageableDefault Pageable pageable) {
        Page<Account> accountList = accountRepository.findAll(pageable);
        PagedModel.PageMetadata pageMetadata = new PagedModel.PageMetadata(pageable.getPageSize(),
                accountList.getNumber(), accountList.getTotalElements());

        PagedModel<Account> items = PagedModel.of(accountList.getContent(), pageMetadata);
        items.add(linkTo(methodOn(AccountRestController.class).getItems(pageable)).withSelfRel());

        return items;
    }


}
