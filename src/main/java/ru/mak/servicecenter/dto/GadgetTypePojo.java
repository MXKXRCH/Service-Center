package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.GadgetType;

@Getter
@Setter
public class GadgetTypePojo extends BasePojo {
    private String name;

    public static GadgetTypePojo fromEntity(GadgetType gadgetType) {
        GadgetTypePojo pojo = (GadgetTypePojo) BasePojo.fromEntity(gadgetType);
        pojo.setName(gadgetType.getName());
        return pojo;
    }

    public static GadgetType toEntity(GadgetTypePojo pojo) {
        GadgetType gadgetType = (GadgetType) BasePojo.toEntity(pojo);
        gadgetType.setName(pojo.getName());
        return gadgetType;
    }
}
