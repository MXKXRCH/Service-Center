package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Mending;

import java.util.Optional;

public interface MendingRepository extends JpaRepository<Mending, Long> {
    Optional<Mending> getAll();
}
