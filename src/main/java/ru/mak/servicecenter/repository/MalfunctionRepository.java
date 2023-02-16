package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Malfunction;

import java.util.Optional;

public interface MalfunctionRepository extends JpaRepository<Malfunction, Long> {
    Optional<Malfunction> getAll();
}
