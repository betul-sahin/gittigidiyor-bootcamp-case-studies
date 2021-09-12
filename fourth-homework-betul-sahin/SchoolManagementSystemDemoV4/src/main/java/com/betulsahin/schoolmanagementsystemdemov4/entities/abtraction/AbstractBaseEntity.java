package com.betulsahin.schoolmanagementsystemdemov4.entities.abtraction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false)
    private Instant createdDate = Instant.now();

    @JsonIgnore
    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();
}

/**
 * @CreatedBy : created user (who created)
 * @CreatedDate : created date (when created)
 * @LastModifiedBy : last updated user (who updated)
 * @LastModifiedDate : last updated date (when updated)
 */