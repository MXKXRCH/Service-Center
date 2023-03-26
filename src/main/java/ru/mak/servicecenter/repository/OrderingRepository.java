package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Ordering;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {
}
