package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.repository.GadgetTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GadgetTypeService implements BaseServiceImpl {
    @Autowired
    GadgetTypeRepository gadgetTypeRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return gadgetTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return gadgetTypeRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return gadgetTypeRepository.save((GadgetType) base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return gadgetTypeRepository.save((GadgetType) base);
    }

    @Override
    public void deleteById(Long id) {
        gadgetTypeRepository.deleteById(id);
    }
}
