package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Gadget;

public interface GadgetRepository extends JpaRepository<Gadget, Long> {
}
