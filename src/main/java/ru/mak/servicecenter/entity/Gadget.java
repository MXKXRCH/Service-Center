package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "gadget")
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "guarantee")
    private Integer guarantee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadget", fetch = FetchType.LAZY)
    private Set<Ordering> orderings;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="type_id")
    private GadgetType gadgetType;
}
