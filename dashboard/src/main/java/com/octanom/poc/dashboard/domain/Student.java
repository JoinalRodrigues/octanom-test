package com.octanom.poc.dashboard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private String name;

    private Double m1;
    private Double m2;
    private Double m3;
    private Double m4;
    private Double m5;

    @Override
    public String toString(){
        return this.name
                + ","
                + this.m1
                + ","
                + this.m2
                + ","
                + this.m3
                + ","
                + this.m4
                + ","
                + this.m5;
    }

}
