package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "gadget_info")
public class Gadget extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "guarantee")
    private Integer guarantee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadgetInfo", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="type_id")
    private GadgetType gadgetType;
}
