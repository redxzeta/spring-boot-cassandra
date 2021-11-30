package com.cassandra.cain.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Stands {
    @PrimaryKey
    @CassandraType(type = Name.UUID)

    private String uid = UUID.randomUUID().toString();

    public Stands(String name, String standUser, String ability) {

        this.name = name;
        this.standUser = standUser;
        this.ability = ability;
    }

    private String name;
    private String standUser;
    private String ability;

    public String getUID() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandUser() {
        return standUser;
    }

    public void setStandUser(String standUser) {
        this.standUser = standUser;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Stands [ability=" + ability + ", name=" + name + ", standUser=" + standUser + ", uid=" + uid + "]";
    }

}
