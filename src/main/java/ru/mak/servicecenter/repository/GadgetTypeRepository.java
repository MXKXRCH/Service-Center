package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.GadgetType;

public interface GadgetTypeRepository extends JpaRepository<GadgetType, Long> {
}
