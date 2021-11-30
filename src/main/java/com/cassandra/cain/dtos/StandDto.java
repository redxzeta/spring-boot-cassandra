package com.cassandra.cain.dtos;

public class StandDto {

    private String name;
    private String standUser;
    private String ability;

    @Override
    public String toString() {
        return "StandDto [ability=" + ability + ", name=" + name + ", standUser=" + standUser + "]";
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

}
