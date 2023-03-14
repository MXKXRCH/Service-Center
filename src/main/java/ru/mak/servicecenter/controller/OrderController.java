package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.OrderPojo;
import ru.mak.servicecenter.service.OrderService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderPojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderPojo>> getAll() {
        try {
            return ResponseEntity.ok(orderService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{employeeId}/{gadgetId}")
    public ResponseEntity<OrderPojo> add(
            @RequestBody OrderPojo pojo,
            @PathVariable("employeeId") Long employeeId,
            @PathVariable("gadgetId") Long gadgetId
    ) {
        try {
            return ResponseEntity.ok(orderService.save(pojo, employeeId, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{employeeId}/{gadgetId}")
    public ResponseEntity<OrderPojo> update(
                                            @RequestBody OrderPojo pojo,
                                            @PathVariable("employeeId") Long employeeId,
                                            @PathVariable("gadgetId") Long gadgetId
    ) {
        try {
            return ResponseEntity.ok(orderService.update(pojo, employeeId, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
