package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.EmployeePojo;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return EmployeePojo.fromEntity(employee);
    }


    public List<EmployeePojo> getAll() {
        List<EmployeePojo> result = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            result.add(EmployeePojo.fromEntity(employee));
        }
        return result;
    }


    public EmployeePojo save(EmployeePojo pojo) {
        if (pojo == null) {
            return null;
        }
        return EmployeePojo.fromEntity(EmployeePojo.toEntity(pojo));
    }


    public EmployeePojo update(EmployeePojo pojo) {
        if (pojo == null) {
            return null;
        }
        employeeRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        return EmployeePojo.fromEntity(EmployeePojo.toEntity(pojo));
    }


    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
