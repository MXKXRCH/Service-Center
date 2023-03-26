package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Employee;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeePojo {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Integer experience;
    private BigDecimal salary;

    public static EmployeePojo fromEntity(Employee employee) {
        EmployeePojo pojo = new EmployeePojo();
        pojo.setId(employee.getId());
        pojo.setName(employee.getName());
        pojo.setPhone(employee.getPhone());
        pojo.setEmail(employee.getEmail());
        pojo.setExperience(employee.getExperience());
        pojo.setSalary(employee.getSalary());
        return pojo;
    }

    public static Employee toEntity(EmployeePojo pojo) {
        Employee employee = new Employee();
        employee.setId(pojo.getId());
        employee.setName(pojo.getName());
        employee.setPhone(pojo.getPhone());
        employee.setEmail(pojo.getEmail());
        employee.setExperience(pojo.getExperience());
        employee.setSalary(pojo.getSalary());
        return employee;
    }
}
