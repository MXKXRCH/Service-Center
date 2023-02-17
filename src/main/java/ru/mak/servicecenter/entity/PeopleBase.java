package ru.mak.servicecenter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class People extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "email")
    private String email;
}
