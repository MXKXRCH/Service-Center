package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.BasePojo;
import ru.mak.servicecenter.dto.GadgetTypePojo;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.repository.GadgetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GadgetTypeService implements BaseServiceImpl {
    @Autowired
    GadgetTypeRepository gadgetTypeRepository;

    @Override
    public BasePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        GadgetType gadgetType = gadgetTypeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return GadgetTypePojo.fromEntity(gadgetType);
    }

    @Override
    public List<BasePojo> getAll() {
        List<BasePojo> result = new ArrayList<>();
        for (GadgetType gadgetType : gadgetTypeRepository.findAll()) {
            result.add(GadgetTypePojo.fromEntity(gadgetType));
        }
        return result;
    }

    @Override
    public BasePojo save(BasePojo pojo) {
        if (pojo == null) {
            return null;
        }
        return GadgetTypePojo.fromEntity(GadgetTypePojo.toEntity(pojo));
    }

    @Override
    public BasePojo update(Long id, BasePojo pojo) {
        if (pojo == null || id == null) {
            return null;
        }
        gadgetTypeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        return GadgetTypePojo.fromEntity(GadgetTypePojo.toEntity(pojo));
    }

    @Override
    public void deleteById(Long id) {
        gadgetTypeRepository.deleteById(id);
    }
}
