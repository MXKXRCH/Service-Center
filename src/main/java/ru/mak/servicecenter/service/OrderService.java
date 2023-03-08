package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.OrderPojo;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.Order;
import ru.mak.servicecenter.repository.EmployeeRepository;
import ru.mak.servicecenter.repository.GadgetRepository;
import ru.mak.servicecenter.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GadgetRepository gadgetRepository;

    public OrderPojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return OrderPojo.fromEntity(order);
    }

    public List<OrderPojo> getAll() {
        List<OrderPojo> result = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            result.add(OrderPojo.fromEntity(order));
        }
        return result;
    }

    public OrderPojo save(OrderPojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null) {
            return null;
        }
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Order order = OrderPojo.toEntity(pojo, employee, gadget);
        return OrderPojo.fromEntity(orderRepository.save(order));
    }

    public OrderPojo update(Long id, OrderPojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null || id == null) {
            return null;
        }
        orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Order order = OrderPojo.toEntity(pojo, employee, gadget);
        return OrderPojo.fromEntity(orderRepository.save(order));
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
