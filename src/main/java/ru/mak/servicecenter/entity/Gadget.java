package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "gadget_info")
public class Gadget extends ObjectBase {
    @Column(name = "guarantee")
    private Integer guarantee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadgetInfo", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @JoinColumn(name="type_id")
    private GadgetType gadgetType;

    /*@ManyToMany(mappedBy = "gadgets")
    private  Set<GadgetType> gadgetTypes;*/
}
