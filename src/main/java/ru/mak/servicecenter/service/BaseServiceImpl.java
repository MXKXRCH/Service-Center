package ru.mak.servicecenter.service;

import ru.mak.servicecenter.entity.Base;

import java.util.List;

public interface BaseServiceImpl {
    Base getById(Long id);
    List<Base> getAll();
    Base save(Base base);
    Base update(Long id, Base base);
    void deleteById(Long id);
}
