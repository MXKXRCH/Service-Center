package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
