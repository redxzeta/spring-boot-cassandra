package com.cassandra.cain.repository;

import com.cassandra.cain.entity.Stands;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StandsRepository extends CassandraRepository<Stands, String> {

}
