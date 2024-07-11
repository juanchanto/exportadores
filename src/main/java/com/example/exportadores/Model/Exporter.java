package com.example.exportadores.Model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "exporter")
public class Exporter {

    @Column(name = "status", length = 1, nullable = false)
    private String status;

    @Embedded
    private Company company;

    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "acceptance", nullable = false)
    private LocalDate acceptance;

    @Column(name = "expiration", nullable = false)
    private LocalDate expiration;

    @Column(name = "province", length = 2, nullable = false)
    private String province;

    @Column(name = "canton", length = 2, nullable = false)
    private String canton;

    @Column(name = "district", length = 2, nullable = false)
    private String district;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "sector", length = 4, nullable = false)
    private String sector;

    @Id
    @Column(name = "id", nullable = false, length = 35)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDate getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(LocalDate acceptance) {
        this.acceptance = acceptance;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Embeddable
    public static class Company {
        @Column(name = "identificationType", length = 1, nullable = false)
        private String identificationType;

        @Column(name = "identification", length = 35, nullable = false)
        private String identification;

        @Column(name = "name", length = 100, nullable = false)
        private String name;

        // Getters and setters
        public String getIdentificationType() {
            return identificationType;
        }

        public void setIdentificationType(String identificationType) {
            this.identificationType = identificationType;
        }

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
