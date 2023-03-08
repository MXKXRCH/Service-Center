package ru.mak.servicecenter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.mak.servicecenter.entity.Repair;

import java.math.BigDecimal;

@Getter
@Setter
public class RepairPojo extends BasePojo {
    private String name;
    private BigDecimal price;

    public static RepairPojo fromEntity(Repair repair) {
        RepairPojo pojo = (RepairPojo) BasePojo.fromEntity(repair);
        pojo.setName(repair.getName());
        pojo.setPrice(repair.getPrice());
        return pojo;
    }

    public static Repair toEntity(RepairPojo pojo) {
        Repair repair = (Repair) BasePojo.toEntity(pojo);
        repair.setName(pojo.getName());
        repair.setPrice(pojo.getPrice());
        return repair;
    }
}
