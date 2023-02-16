package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Malfunction;
import ru.mak.servicecenter.repository.MalfunctionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MalfunctionService implements BaseServiceImpl {
    @Autowired
    MalfunctionRepository malfunctionRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return malfunctionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return malfunctionRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return malfunctionRepository.save((Malfunction) base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return malfunctionRepository.save((Malfunction) base);
    }

    @Override
    public void deleteById(Long id) {
        malfunctionRepository.deleteById(id);
    }
}
