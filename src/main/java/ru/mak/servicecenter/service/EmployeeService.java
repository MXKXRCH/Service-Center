package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.servicecenter.dto.EmployeePojo;
import ru.mak.servicecenter.entity.Employee;
import ru.mak.servicecenter.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
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
        try {
            return EmployeePojo.fromEntity(employeeRepository.save(EmployeePojo.toEntity(pojo)));
        } catch (Exception e) {
            System.out.println("Error!\n" + e);
            return null;
        }
    }


    public EmployeePojo update(EmployeePojo pojo) {
        if (pojo == null) {
            return null;
        }
        employeeRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        return EmployeePojo.fromEntity(employeeRepository.save(EmployeePojo.toEntity(pojo)));
    }


    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
