package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.servicecenter.dto.OrderingPojo;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.Ordering;
import ru.mak.servicecenter.repository.EmployeeRepository;
import ru.mak.servicecenter.repository.GadgetRepository;
import ru.mak.servicecenter.repository.OrderingRepository;
import ru.mak.servicecenter.repository.RepairRepository;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderingService {
    @Autowired
    OrderingRepository orderingRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GadgetRepository gadgetRepository;
    @Autowired
    RepairRepository repairRepository;

    public OrderingPojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Ordering ordering = orderingRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return OrderingPojo.fromEntity(ordering);
    }

    public List<OrderingPojo> getAll() {
        List<OrderingPojo> result = new ArrayList<>();
        for (Ordering ordering : orderingRepository.findAll()) {
            result.add(OrderingPojo.fromEntity(ordering));
        }
        return result;
    }

    public OrderingPojo save(OrderingPojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null) {
            return null;
        }
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(gadgetId).orElseThrow(NoSuchElementException::new);
        Ordering ordering = OrderingPojo.toEntity(pojo, employee, gadget);
        Set<Long> repairsId = pojo.getRepairsId();
        for (Long repairId : repairsId) {
            ordering.addRepair(repairRepository.findById(repairId).orElse(null));
        }
        return OrderingPojo.fromEntity(orderingRepository.save(ordering));
    }

    public OrderingPojo update(OrderingPojo pojo, Long employeeId, Long gadgetId) {
        if (pojo == null) {
            return null;
        }
        orderingRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new);
        Gadget gadget = gadgetRepository.findById(gadgetId).orElseThrow(NoSuchElementException::new);
        Ordering ordering = OrderingPojo.toEntity(pojo, employee, gadget);
        Set<Long> repairsId = pojo.getRepairsId();
        for (Long repairId : repairsId) {
            ordering.addRepair(repairRepository.findById(repairId).orElse(null));
        }
        return OrderingPojo.fromEntity(orderingRepository.save(ordering));
    }

    public void deleteById(Long id) {
        orderingRepository.deleteById(id);
    }
}
