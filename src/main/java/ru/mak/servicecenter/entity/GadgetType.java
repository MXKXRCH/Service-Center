package ru.mak.servicecenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "gadget_type")
public class GadgetType extends ObjectBase {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadgetType", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Gadget> gadgets;

    /*
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "malfunction_gadget",
            joinColumns = @JoinColumn(name = "malfunction_id"),
            inverseJoinColumns = @JoinColumn(name = "gadget_id")
    )
    private Set<Gadget> gadgets;*/
}
