package ru.mak.servicecenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ordering")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    @Temporal(value = TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gadget_id")
    private Gadget gadget;

    @ManyToMany
    @JoinTable(
            name = "repair_ordering",
            joinColumns = @JoinColumn(name = "ordering_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_id")
    )
    private Set<Repair> repairs;

    public boolean addRepair(Repair repair) {
        if (repair == null) {
            return false;
        }
        if (repairs == null) {
            repairs = new HashSet<>();
        }
        return repairs.add(repair);
    }
}
