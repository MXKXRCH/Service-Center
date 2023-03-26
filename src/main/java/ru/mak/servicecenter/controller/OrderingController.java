package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.OrderingPojo;
import ru.mak.servicecenter.service.OrderingService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/ordering", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderingController {
    @Autowired
    OrderingService orderingService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderingPojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderingService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderingPojo>> getAll() {
        try {
            return ResponseEntity.ok(orderingService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{employeeId}/{gadgetId}")
    public ResponseEntity<OrderingPojo> add(
            @RequestBody OrderingPojo pojo,
            @PathVariable("employeeId") Long employeeId,
            @PathVariable("gadgetId") Long gadgetId
    ) {
        try {
            return ResponseEntity.ok(orderingService.save(pojo, employeeId, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{employeeId}/{gadgetId}")
    public ResponseEntity<OrderingPojo> update(
                                            @RequestBody OrderingPojo pojo,
                                            @PathVariable("employeeId") Long employeeId,
                                            @PathVariable("gadgetId") Long gadgetId
    ) {
        try {
            return ResponseEntity.ok(orderingService.update(pojo, employeeId, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderingService.deleteById(id);
    }
}
