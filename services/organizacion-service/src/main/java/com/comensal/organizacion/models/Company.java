package com.comensal.organizacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(name = "uk_company_slug", columnNames = { "slug" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    @EqualsAndHashCode.Include
    private Long companyId;

    @NotBlank(message = "Company name is required")
    @Size(max = 150, message = "Name cannot exceed 150 characters")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotBlank(message = "Slug is required")
    @Size(max = 100, message = "Slug cannot exceed 100 characters")
    @Pattern(regexp = "^[a-z0-9-]+$", message = "Slug can only contain lowercase letters, numbers, and hyphens")
    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @NotNull(message = "Status is required")
    @Builder.Default
    @Column(name = "status", nullable = false)
    private Boolean status = true;
}