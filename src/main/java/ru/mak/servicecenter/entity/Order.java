package ru.mak.servicecenter.entity;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="gadget_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Gadget gadget;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Repair> repairs;
}
