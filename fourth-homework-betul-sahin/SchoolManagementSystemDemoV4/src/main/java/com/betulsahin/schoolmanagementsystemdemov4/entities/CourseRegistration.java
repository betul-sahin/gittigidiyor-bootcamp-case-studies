package com.betulsahin.schoolmanagementsystemdemov4.entities;

import com.betulsahin.schoolmanagementsystemdemov4.entities.abtraction.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Bu sinif kendi id si olan bagimsiz bir kayit sinifi. (join sinifi degil)
 * Bu sinifi ayrıca oluşturmamın sebebi, öğrencilerin kursa
 * ne zaman kaydolduğunu tutmak istiyorum.
 */
@Data
@NoArgsConstructor
@Entity
public class CourseRegistration extends AbstractBaseEntity {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
}
