package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.BasePojo;
import ru.mak.servicecenter.dto.EmployeePojo;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeService implements BaseServiceImpl {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public BasePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return EmployeePojo.fromEntity(employee);
    }

    @Override
    public List<BasePojo> getAll() {
        List<BasePojo> result = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            result.add(EmployeePojo.fromEntity(employee));
        }
        return result;
    }

    @Override
    public BasePojo save(BasePojo pojo) {
        if (pojo == null) {
            return null;
        }
        return EmployeePojo.fromEntity(EmployeePojo.toEntity(((EmployeePojo) pojo)));
    }

    @Override
    public BasePojo update(Long id, BasePojo pojo) {
        if (pojo == null || id == null) {
            return null;
        }
        employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        return EmployeePojo.fromEntity(EmployeePojo.toEntity(((EmployeePojo) pojo)));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
