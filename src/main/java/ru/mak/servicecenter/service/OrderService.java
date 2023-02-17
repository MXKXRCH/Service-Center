package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Order;
import ru.mak.servicecenter.entity.Repair;
import ru.mak.servicecenter.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements BaseServiceImpl {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return orderRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return orderRepository.save((Order)base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return orderRepository.save((Order)base);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public BigDecimal getTotalPrice(Order order) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Repair repair : order.getRepairs()) {
            totalPrice.add(repair.getPrice());
        }
        return totalPrice;
    }
}
