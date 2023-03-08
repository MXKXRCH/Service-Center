package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.BasePojo;
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

public class OrderService implements BaseServiceImpl {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GadgetRepository gadgetRepository;

    @Override
    public BasePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Order order = orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return OrderPojo.fromEntity(order);
    }

    @Override
    public List<BasePojo> getAll() {
        List<BasePojo> result = new ArrayList<>();
        for (Order order : orderRepository.findAll()) {
            result.add(OrderPojo.fromEntity(order));
        }
        return result;
    }

    public OrderPojo save(BasePojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null) {
            return null;
        }
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Order order = OrderPojo.toEntity((OrderPojo) pojo, employee, gadget);
        return OrderPojo.fromEntity(orderRepository.save(order));
    }

    public OrderPojo update(Long id, BasePojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null || id == null) {
            return null;
        }
        orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Order order = OrderPojo.toEntity((OrderPojo) pojo, employee, gadget);
        return OrderPojo.fromEntity(orderRepository.save(order));
    }

    @Override
    public BasePojo save(BasePojo pojo) {
        return null;
    }

    @Override
    public BasePojo update(Long id, BasePojo pojo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
