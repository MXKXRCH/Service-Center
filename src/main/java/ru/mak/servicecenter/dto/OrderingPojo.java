package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.Ordering;
import ru.mak.servicecenter.entity.Repair;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OrderingPojo {
    private Long id;
    private String description;
    private Date startDate;
    private Date endDate;
    private EmployeePojo employee;
    private GadgetPojo gadget;
    private Set<RepairPojo> repairs;
    private BigDecimal totalPrice;

    public static OrderingPojo fromEntity(Ordering ordering) {
        OrderingPojo pojo = new OrderingPojo();
        pojo.setId(ordering.getId());
        pojo.setDescription(ordering.getDescription());
        pojo.setStartDate(ordering.getStartDate());
        pojo.setEndDate(ordering.getEndDate());
        pojo.setEmployee(EmployeePojo.fromEntity(ordering.getEmployee()));
        pojo.setGadget(GadgetPojo.fromEntity(ordering.getGadget()));
        Set<RepairPojo> repairs = new HashSet<>();
        BigDecimal price = new BigDecimal(0);
        for(Repair repair : ordering.getRepairs()) {
            repairs.add(RepairPojo.fromEntity(repair));
            price = price.add(repair.getPrice());
        }
        pojo.setRepairs(repairs);
        pojo.setTotalPrice(price);
        return pojo;
    }

    public static Ordering toEntity(OrderingPojo pojo, Employee employee, Gadget gadget) {
        Ordering ordering = new Ordering();
        ordering.setId(pojo.getId());
        ordering.setDescription(pojo.getDescription());
        ordering.setStartDate(pojo.getStartDate());
        ordering.setEndDate(pojo.getEndDate());
        ordering.setEmployee(employee);
        ordering.setGadget(gadget);
        return ordering;
    }
}
