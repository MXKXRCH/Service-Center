package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.dto.BasePojo;
import ru.mak.servicecenter.dto.RepairPojo;
import ru.mak.servicecenter.entity.Repair;
import ru.mak.servicecenter.repository.RepairRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RepairService implements BaseServiceImpl {
    @Autowired
    RepairRepository repairRepository;

    @Override
    public BasePojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Repair repair = repairRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return RepairPojo.fromEntity(repair);
    }

    @Override
    public List<BasePojo> getAll() {
        List<BasePojo> result = new ArrayList<>();
        for (Repair repair : repairRepository.findAll()) {
            result.add(RepairPojo.fromEntity(repair));
        }
        return result;
    }

    @Override
    public BasePojo save(BasePojo pojo) {
        if (pojo == null) {
            return null;
        }
        return RepairPojo.fromEntity(RepairPojo.toEntity(pojo));
    }

    @Override
    public BasePojo update(Long id, BasePojo pojo) {
        if (pojo == null || id == null) {
            return null;
        }
        repairRepository.findById(id).orElseThrow(NoSuchElementException::new);
        pojo.setId(id);
        return RepairPojo.fromEntity(RepairPojo.toEntity(pojo));
    }

    @Override
    public void deleteById(Long id) {
        repairRepository.deleteById(id);
    }
}
