package ru.mak.servicecenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order extends Base {

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="gadget_id")
    private Gadget gadget;

    @ManyToMany(mappedBy = "orders")
    @JsonIgnore
    private Set<Repair> repairs;
}
