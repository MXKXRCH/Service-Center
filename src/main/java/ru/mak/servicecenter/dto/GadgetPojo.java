package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.GadgetType;
import ru.mak.servicecenter.entity.Order;

import java.util.Set;

@Getter
@Setter
public class GadgetPojo extends BasePojo {
    private String name;
    private Integer guarantee;
    private GadgetTypePojo gadgetType;

    public static GadgetPojo fromEntity(Gadget gadget) {
        GadgetPojo pojo = (GadgetPojo) BasePojo.fromEntity(gadget);
        pojo.setName(gadget.getName());
        pojo.setGuarantee(gadget.getGuarantee());
        pojo.setGadgetType(GadgetTypePojo.fromEntity(gadget.getGadgetType()));
        return pojo;
    }

    public static Gadget toEntity(GadgetPojo pojo, GadgetType gadgetType) {
        Gadget gadget = (Gadget) BasePojo.toEntity(pojo);
        gadget.setName(pojo.getName());
        gadget.setGuarantee(pojo.getGuarantee());
        gadget.setGadgetType(gadgetType);
        return gadget;
    }
}
