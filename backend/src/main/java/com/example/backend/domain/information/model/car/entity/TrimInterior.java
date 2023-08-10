package com.example.backend.domain.information.model.car.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table("Trim_Interior")
public class TrimInterior {
    @Id
    private Long id;
    private Long trimId;
    private Long interiorColorId;

    @Transient
    private Trim trim;
    @Transient
    private InteriorColor interiorColor;

    public TrimInterior(Long id, Long trimId, Long interiorColorId, Trim trim, InteriorColor interiorColor) {
        this.id = id;
        this.trimId = trimId;
        this.interiorColorId = interiorColorId;
        this.trim = trim;
        this.interiorColor = interiorColor;
    }

    public String getTrimName() {
        return trim.getBaseInfo().getName();
    }


    public InteriorColor getInteriorColor() {
        return interiorColor;
    }
}
