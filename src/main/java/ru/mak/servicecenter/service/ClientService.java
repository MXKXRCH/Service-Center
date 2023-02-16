package ru.mak.servicecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mak.servicecenter.entity.Base;
import ru.mak.servicecenter.entity.Client;
import ru.mak.servicecenter.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService implements BaseServiceImpl {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Base getById(Long id) {
        if (id == null) {
            return null;
        }
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Base> getAll() {
        return clientRepository.getAll().stream().collect(Collectors.toList());
    }

    @Override
    public Base save(Base base) {
        if (base == null) {
            return null;
        }
        return clientRepository.save((Client) base);
    }

    @Override
    public Base update(Long id, Base base) {
        if (base == null || id == null) {
            return null;
        }
        base.setId(id);
        return clientRepository.save((Client) base);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
