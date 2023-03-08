package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gadget_type")
public class GadgetType extends Base {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadgetType", fetch = FetchType.LAZY)
    private Set<Gadget> gadgets;
}
