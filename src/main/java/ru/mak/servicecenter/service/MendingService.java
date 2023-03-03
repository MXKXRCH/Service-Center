package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Mending;
import ru.mak.servicecenter.repository.MendingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MendingService implements BaseServiceImpl {
    @Autowired
    MendingRepository mendingRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return mendingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return mendingRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return mendingRepository.save((Mending)base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return mendingRepository.save((Mending)base);
    }

    @Override
    public void deleteById(Long id) {
        mendingRepository.deleteById(id);
    }
}
