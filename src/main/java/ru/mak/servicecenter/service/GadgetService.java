package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.repository.GadgetRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GadgetService implements BaseServiceImpl {
    @Autowired
    GadgetRepository gadgetRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return gadgetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return gadgetRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return gadgetRepository.save((Gadget) base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return gadgetRepository.save((Gadget) base);
    }

    @Override
    public void deleteById(Long id) {
        gadgetRepository.deleteById(id);
    }
}
