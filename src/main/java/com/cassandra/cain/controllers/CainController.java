package com.cassandra.cain.controllers;

import java.util.List;
import java.util.UUID;

import com.cassandra.cain.dtos.StandDto;
import com.cassandra.cain.entity.Stands;
import com.cassandra.cain.repository.StandsRepository;
import com.datastax.astra.sdk.AstraClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stands")
public class CainController {

    @Autowired
    private AstraClient astraClient;

    @Autowired
    private StandsRepository standsRepository;

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @GetMapping("/org")
    public String hello() {
        return astraClient.apiDevopsOrganizations().organizationId();
    }

    @PostMapping
    public Stands insertNewStand(@RequestBody StandDto standDto) {
        Stands stands = new Stands(standDto.getName(), standDto.getStandUser(), standDto.getAbility());

        return standsRepository.save(stands);
    }

    @GetMapping("/firstten")
    public List<Stands> getList() {
        return standsRepository.findAll(CassandraPageRequest.first(10)).toList();
    }

    // @DeleteMapping("/{id}")
    // public String deleteById(@PathVariable String id) {
    // UUID uid = UUID.fromString(id);
    // standsRepository.delete(uid);

    // return id;
    // }

    @GetMapping("/datacenter")
    public String datacenter() {
        return cassandraTemplate
                .getCqlOperations()
                .queryForObject("SELECT data_center FROM system.local", String.class);
    }

    @GetMapping("/{id}")
    public Stands findStandById(@PathVariable String id) {
        return cassandraTemplate.getCqlOperations().queryForObject("SELECT * FROM stands where uid = ? ", Stands.class,
                id);
    }

}
