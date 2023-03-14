package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.RepairPojo;
import ru.mak.servicecenter.service.RepairService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/repair", produces = MediaType.APPLICATION_JSON_VALUE)
public class RepairController {
    @Autowired
    RepairService repairService;

    @GetMapping("/{id}")
    public ResponseEntity<RepairPojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(repairService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<RepairPojo>> getAll() {
        try {
            return ResponseEntity.ok(repairService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<RepairPojo> add(@RequestBody RepairPojo pojo) {
        try {
            return ResponseEntity.ok(repairService.save(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping
    public ResponseEntity<RepairPojo> update(@RequestBody RepairPojo pojo) {
        try {
            return ResponseEntity.ok(repairService.update(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repairService.deleteById(id);
    }
}
