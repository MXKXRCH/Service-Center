package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.EmployeePojo;
import ru.mak.servicecenter.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeePojo>> getAll() {
        try {
            return ResponseEntity.ok(employeeService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeePojo> add(@RequestBody EmployeePojo pojo) {
        try {
            return ResponseEntity.ok(employeeService.save(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeePojo> update(@RequestBody EmployeePojo pojo) {
        try {
            return ResponseEntity.ok(employeeService.update(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
