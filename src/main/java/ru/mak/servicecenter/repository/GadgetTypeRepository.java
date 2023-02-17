package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.GadgetType;

import java.util.Optional;

public interface MalfunctionRepository extends JpaRepository<GadgetType, Long> {
    Optional<GadgetType> getAll();
}
