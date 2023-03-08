package ru.mak.servicecenter.service;

import ru.mak.servicecenter.dto.BasePojo;

import java.util.List;

public interface BaseServiceImpl {
    BasePojo getById(Long id);
    List<BasePojo> getAll();
    BasePojo save(BasePojo pojo);
    BasePojo update(Long id, BasePojo pojo);
    void deleteById(Long id);
}
