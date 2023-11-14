package com.example.ASBPappProjekt.service;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.query.SearchScope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersService {
    private final LdapTemplate ldapTemplate;

    public GetUsersService(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<String> getAllUsers() {
        ldapTemplate.setIgnorePartialResultException(true);
        LdapQuery query = LdapQueryBuilder.query()
                .searchScope(SearchScope.SUBTREE)
                .attributes("sAMAccountName")
                .where("objectClass").is("user");

        return ldapTemplate.search(query, (AttributesMapper<String>) attrs -> attrs.get("sAMAccountName").get().toString());
    }



}
