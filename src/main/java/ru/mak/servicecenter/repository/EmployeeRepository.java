package ru.mak.servicecenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.servicecenter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
