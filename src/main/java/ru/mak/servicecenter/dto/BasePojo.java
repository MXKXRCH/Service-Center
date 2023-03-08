package ru.mak.servicecenter.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Base;

@Getter
@Setter
@MappedSuperclass
public class BasePojo {
    private long id;

    public static BasePojo fromEntity(Base base) {
        BasePojo pojo = new BasePojo();
        pojo.setId(base.getId());
        return pojo;
    }

    public static Base toEntity(BasePojo pojo) {
        Base base = new Base();
        base.setId(pojo.getId());
        return base;
    }
}
