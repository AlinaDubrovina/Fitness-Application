package by.it_academy.fitness.recipe_service.recipe.core.entity;

import by.it_academy.fitness.recipe_service.product.core.entity.BaseEntityDateTime;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "recipes", schema = "app")
public class RecipeEntity extends BaseEntityDateTime {
    @Column
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            schema = "app",
            name = "recipe_composition",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<CompositionEntity> compositions = new ArrayList<>();

    public RecipeEntity(UUID uuid, LocalDateTime dateTimeUpdate, String title, List<CompositionEntity> compositions) {
        super(uuid, dateTimeUpdate);
        this.title = title;
        this.compositions = compositions;
    }

    public RecipeEntity(String title, List<CompositionEntity> compositions) {
        this.title = title;
        this.compositions = compositions;
    }

    public RecipeEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CompositionEntity> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<CompositionEntity> compositions) {
        this.compositions = compositions;
    }

    public int getWeight() {
        return compositions.stream().map(CompositionEntity::getWeight).mapToInt(Integer::intValue).sum();   }

    public int getCalories() {
        return compositions.stream().map(CompositionEntity::getCalories).mapToInt(Integer::intValue).sum();
    }

    public double getProteins() {
        return compositions.stream().map(CompositionEntity::getProteins).mapToDouble(Double::doubleValue).sum();
    }

    public double getFats() {
        return compositions.stream().map(CompositionEntity::getFats).mapToDouble(Double::doubleValue).sum();
    }

    public double getCarbohydrates() {
        return compositions.stream().map(CompositionEntity::getCarbohydrates).mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntity that = (RecipeEntity) o;
        return Objects.equals(title, that.title) && Objects.equals(compositions, that.compositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, compositions);
    }
}
