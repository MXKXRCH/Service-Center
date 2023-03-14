package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.GadgetPojo;
import ru.mak.servicecenter.service.GadgetService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/gadget", produces = MediaType.APPLICATION_JSON_VALUE)
public class GadgetController {
    @Autowired
    GadgetService gadgetService;

    @GetMapping("/{id}")
    public ResponseEntity<GadgetPojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(gadgetService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<GadgetPojo>> getAll() {
        try {
            return ResponseEntity.ok(gadgetService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<GadgetPojo> add(@RequestBody GadgetPojo pojo, @PathVariable("id") Long gadgetId) {
        try {
            return ResponseEntity.ok(gadgetService.save(pojo, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GadgetPojo> update(@RequestBody GadgetPojo pojo, @PathVariable("id") Long gadgetId) {
        try {
            return ResponseEntity.ok(gadgetService.update(pojo, gadgetId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gadgetService.deleteById(id);
    }
}
