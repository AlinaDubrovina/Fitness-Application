package by.it_academy.fitness.recipe_service.product.core.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntityDateTime extends BaseEntity {

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    public BaseEntityDateTime() {
    }

    public BaseEntityDateTime(UUID uuid, LocalDateTime dtUpdate) {
        super(uuid);
        this.dtUpdate = dtUpdate;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @PrePersist
    void initDateCreate() {
        this.dtCreate = LocalDateTime.now();
        this.dtUpdate = LocalDateTime.now();
    }
}
