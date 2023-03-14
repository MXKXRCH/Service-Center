package ru.mak.servicecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.servicecenter.dto.GadgetTypePojo;
import ru.mak.servicecenter.service.GadgetTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/gadgetType", produces = MediaType.APPLICATION_JSON_VALUE)
public class GadgetTypeController {
    @Autowired
    GadgetTypeService gadgetTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<GadgetTypePojo> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(gadgetTypeService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<GadgetTypePojo>> getAll() {
        try {
            return ResponseEntity.ok(gadgetTypeService.getAll());
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<GadgetTypePojo> add(@RequestBody GadgetTypePojo pojo) {
        try {
            return ResponseEntity.ok(gadgetTypeService.save(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping
    public ResponseEntity<GadgetTypePojo> update(@RequestBody GadgetTypePojo pojo) {
        try {
            return ResponseEntity.ok(gadgetTypeService.update(pojo));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gadgetTypeService.deleteById(id);
    }
}
