package ru.mak.servicecenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
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
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="gadget_id")
    private Gadget gadget;
}
