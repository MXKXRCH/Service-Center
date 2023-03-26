package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.GadgetType;

@Getter
@Setter
public class GadgetTypePojo {
    private Long id;
    private String name;

    public static GadgetTypePojo fromEntity(GadgetType gadgetType) {
        GadgetTypePojo pojo = new GadgetTypePojo();
        pojo.setId(gadgetType.getId());
        pojo.setName(gadgetType.getName());
        return pojo;
    }

    public static GadgetType toEntity(GadgetTypePojo pojo) {
        GadgetType gadgetType = new GadgetType();
        gadgetType.setId(pojo.getId());
        gadgetType.setName(pojo.getName());
        return gadgetType;
    }
}
