package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.Order;
import ru.mak.servicecenter.entity.Repair;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OrderPojo extends BasePojo {
    private String description;
    private Date startDate;
    private Date endDate;
    private EmployeePojo employeePojo;
    private GadgetPojo gadgetPojo;
    private Set<RepairPojo> repairsId;
    private BigDecimal totalPrice;

    public static OrderPojo fromEntity(Order order) {
        OrderPojo pojo = (OrderPojo) BasePojo.fromEntity(order);
        pojo.setDescription(order.getDescription());
        pojo.setStartDate(order.getStartDate());
        pojo.setEndDate(order.getEndDate());
        pojo.setEmployeePojo(EmployeePojo.fromEntity(order.getEmployee()));
        pojo.setGadgetPojo(GadgetPojo.fromEntity(order.getGadget()));
        Set<RepairPojo> repairs = new HashSet<>();
        BigDecimal price = new BigDecimal(0);
        for(Repair repair : order.getRepairs()) {
            repairs.add(RepairPojo.fromEntity(repair));
            price = price.add(repair.getPrice());
        }
        pojo.setRepairsId(repairs);
        pojo.setTotalPrice(price);
        return pojo;
    }

    public static Order toEntity(OrderPojo pojo, Employee employee, Gadget gadget) {
        Order order = (Order) BasePojo.toEntity(pojo);
        order.setDescription(pojo.getDescription());
        order.setStartDate(pojo.getStartDate());
        order.setEndDate(pojo.getEndDate());
        order.setEmployee(employee);
        order.setGadget(gadget);
        return order;
    }
}
