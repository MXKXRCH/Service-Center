package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "salary")
    private BigDecimal salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Ordering> orderings;
}
