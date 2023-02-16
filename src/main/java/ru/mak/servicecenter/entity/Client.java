package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@Entity
@Table(name = "client")
public class Client extends People {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clients", fetch = FetchType.LAZY)
    private Set<Order> orders;
}
