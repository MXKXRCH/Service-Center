package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Repair;

import java.util.Optional;

public interface RepairServiceRepository extends JpaRepository<Long, Repair> {
    Optional<Repair> getAll();
}
