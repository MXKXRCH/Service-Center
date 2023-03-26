package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.servicecenter.dto.GadgetPojo;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.repository.GadgetRepository;
import ru.mak.servicecenter.repository.GadgetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GadgetService {
    @Autowired
    GadgetRepository gadgetRepository;
    @Autowired
    GadgetTypeRepository gadgetTypeRepository;

    public GadgetPojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Gadget gadget = gadgetRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return GadgetPojo.fromEntity(gadget);
    }


    public List<GadgetPojo> getAll() {
        List<GadgetPojo> result = new ArrayList<>();
        for (Gadget gadget : gadgetRepository.findAll()) {
            result.add(GadgetPojo.fromEntity(gadget));
        }
        return result;
    }

    public GadgetPojo save(GadgetPojo pojo, Long gadgetTypeId) {
        if (pojo == null) {
            return null;
        }
        GadgetType gadgetType = gadgetTypeRepository.findById(gadgetTypeId).orElseThrow();
        Gadget gadget = GadgetPojo.toEntity(pojo, gadgetType);
        return GadgetPojo.fromEntity(gadgetRepository.save(gadget));
    }

    public GadgetPojo update(GadgetPojo pojo, Long gadgetTypeId) {
        if (pojo == null) {
            return null;
        }
        gadgetRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        GadgetType gadgetType = gadgetTypeRepository.findById(gadgetTypeId).orElseThrow();
        Gadget gadget = GadgetPojo.toEntity(pojo, gadgetType);
        return GadgetPojo.fromEntity(gadgetRepository.save(gadget));
    }

    public void deleteById(Long id) {
        gadgetRepository.deleteById(id);
    }
}
