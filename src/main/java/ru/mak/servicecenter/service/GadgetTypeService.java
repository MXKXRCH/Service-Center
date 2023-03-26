package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.servicecenter.dto.GadgetTypePojo;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.repository.GadgetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GadgetTypeService {
    @Autowired
    GadgetTypeRepository gadgetTypeRepository;

    public GadgetTypePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        GadgetType gadgetType = gadgetTypeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return GadgetTypePojo.fromEntity(gadgetType);
    }

    public List<GadgetTypePojo> getAll() {
        List<GadgetTypePojo> result = new ArrayList<>();
        for (GadgetType gadgetType : gadgetTypeRepository.findAll()) {
            result.add(GadgetTypePojo.fromEntity(gadgetType));
        }
        return result;
    }

    public GadgetTypePojo save(GadgetTypePojo pojo) {
        if (pojo == null) {
            return null;
        }
        return GadgetTypePojo.fromEntity(gadgetTypeRepository.save(GadgetTypePojo.toEntity(pojo)));
    }

    public GadgetTypePojo update(GadgetTypePojo pojo) {
        if (pojo == null) {
            return null;
        }
        gadgetTypeRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        return GadgetTypePojo.fromEntity(gadgetTypeRepository.save(GadgetTypePojo.toEntity(pojo)));
    }

    public void deleteById(Long id) {
        gadgetTypeRepository.deleteById(id);
    }
}
