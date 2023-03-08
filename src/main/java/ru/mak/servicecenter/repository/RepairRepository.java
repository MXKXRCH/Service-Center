package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}
