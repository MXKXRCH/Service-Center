package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.BasePojo;
import ru.mak.servicecenter.dto.GadgetPojo;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.repository.GadgetRepository;
import ru.mak.servicecenter.repository.GadgetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GadgetService implements BaseServiceImpl {
    @Autowired
    GadgetRepository gadgetRepository;
    @Autowired
    GadgetTypeRepository gadgetTypeRepository;

    @Override
    public BasePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Gadget gadget = gadgetRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return GadgetPojo.fromEntity(gadget);
    }

    @Override
    public List<BasePojo> getAll() {
        List<BasePojo> result = new ArrayList<>();
        for (Gadget gadget : gadgetRepository.findAll()) {
            result.add(GadgetPojo.fromEntity(gadget));
        }
        return result;
    }

    public GadgetPojo save(BasePojo pojo, Long gadgetTypeId) {
        if (pojo == null) {
            return null;
        }
        GadgetType gadgetType = gadgetTypeRepository.findById(gadgetTypeId).orElseThrow();
        Gadget gadget = GadgetPojo.toEntity((GadgetPojo) pojo, gadgetType);
        return GadgetPojo.fromEntity(gadget);
    }

    public GadgetPojo update(Long id, BasePojo pojo, Long gadgetTypeId) {
        if (pojo == null || id == null) {
            return null;
        }
        gadgetRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        GadgetType gadgetType = gadgetTypeRepository.findById(gadgetTypeId).orElseThrow();
        Gadget gadget = GadgetPojo.toEntity((GadgetPojo) pojo, gadgetType);
        return GadgetPojo.fromEntity(gadget);
    }

    @Override
    public BasePojo save(BasePojo pojo) {
        return null;
    }

    @Override
    public BasePojo update(Long id, BasePojo pojo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        gadgetRepository.deleteById(id);
    }
}
