package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Gadget;
import ru.mak.servicecenter.entity.GadgetType;

@Getter
@Setter
public class GadgetPojo {
    private Long id;
    private String name;
    private Integer guarantee;
    private GadgetTypePojo gadgetType;

    public static GadgetPojo fromEntity(Gadget gadget) {
        GadgetPojo pojo = new GadgetPojo();
        pojo.setId(gadget.getId());
        pojo.setName(gadget.getName());
        pojo.setGuarantee(gadget.getGuarantee());
        pojo.setGadgetType(GadgetTypePojo.fromEntity(gadget.getGadgetType()));
        return pojo;
    }

    public static Gadget toEntity(GadgetPojo pojo, GadgetType gadgetType) {
        Gadget gadget = new Gadget();
        gadget.setId(pojo.getId());
        gadget.setName(pojo.getName());
        gadget.setGuarantee(pojo.getGuarantee());
        gadget.setGadgetType(gadgetType);
        return gadget;
    }
}
