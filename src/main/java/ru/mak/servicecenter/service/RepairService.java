package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.servicecenter.dto.RepairPojo;
import ru.mak.servicecenter.entity.Repair;
import ru.mak.servicecenter.repository.RepairRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RepairService {
    @Autowired
    RepairRepository repairRepository;

    public RepairPojo getById(Long id) {
        if (id == null) {
            return null;
        }
        Repair repair = repairRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return RepairPojo.fromEntity(repair);
    }


    public List<RepairPojo> getAll() {
        List<RepairPojo> result = new ArrayList<>();
        for (Repair repair : repairRepository.findAll()) {
            result.add(RepairPojo.fromEntity(repair));
        }
        return result;
    }


    public RepairPojo save(RepairPojo pojo) {
        if (pojo == null) {
            return null;
        }
        return RepairPojo.fromEntity(repairRepository.save(RepairPojo.toEntity(pojo)));
    }


    public RepairPojo update(RepairPojo pojo) {
        if (pojo == null) {
            return null;
        }
        repairRepository.findById(pojo.getId()).orElseThrow(NoSuchElementException::new);
        return RepairPojo.fromEntity(repairRepository.save(RepairPojo.toEntity(pojo)));
    }

    public void deleteById(Long id) {
        repairRepository.deleteById(id);
    }
}
