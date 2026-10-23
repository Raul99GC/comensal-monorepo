package com.comensal.organizacion.models;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cafeteria", uniqueConstraints = {
        @UniqueConstraint(name = "uk_cafeteria_company_name", columnNames = { "company_id", "name" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cafeteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafeteria_id")
    @EqualsAndHashCode.Include
    private Long cafeteriaId;

    @NotNull(message = "Company is required")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cafeteria_company"))
    private Company company;

    @NotBlank(message = "Cafeteria name is required")
    @Size(max = 120, message = "Name cannot exceed 120 characters")
    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @NotBlank(message = "Time zone is required")
    @Size(max = 60, message = "Time zone cannot exceed 60 characters")
    @Column(name = "time_zone", nullable = false, length = 60)
    private String timeZone;

    @NotNull(message = "Service start time is required")
    @Column(name = "service_start_time", nullable = false)
    private LocalTime serviceStartTime;

    @NotNull(message = "Service end time is required")
    @Column(name = "service_end_time", nullable = false)
    private LocalTime serviceEndTime;

    @NotNull(message = "Status is required")
    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;
}