package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService implements BaseServiceImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return employeeRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return employeeRepository.save((Employee) base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return employeeRepository.save((Employee) base);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
