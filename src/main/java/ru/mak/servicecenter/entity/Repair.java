package ru.mak.servicecenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "repair_service")
public class RepairService extends ObjectBase {
    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "repair_service_order",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<Order> orders;
}
