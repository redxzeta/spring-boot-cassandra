package com.cassandra.cain.controllers;

import com.datastax.astra.sdk.AstraClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cain")
public class CainController {

    @Autowired
    private AstraClient astraClient;

    @GetMapping("/")
    public String hello() {
        return astraClient.apiDevopsOrganizations().organizationId();
    }
}
