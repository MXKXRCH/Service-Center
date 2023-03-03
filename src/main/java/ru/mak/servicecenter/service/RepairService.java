package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Repair;
import ru.mak.servicecenter.repository.RepairRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepairService implements BaseServiceImpl {
    @Autowired
    RepairRepository repairRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return repairRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return repairRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return repairRepository.save((Repair)base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return repairRepository.save((Repair)base);
    }

    @Override
    public void deleteById(Long id) {
        repairRepository.deleteById(id);
    }
}
