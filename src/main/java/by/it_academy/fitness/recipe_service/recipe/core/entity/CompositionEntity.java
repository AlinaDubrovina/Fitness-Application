package by.it_academy.fitness.recipe_service.recipe.core.entity;

import by.it_academy.fitness.recipe_service.product.core.entity.BaseEntity;
import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_composition", schema = "app")
public class CompositionEntity extends BaseEntity {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "weight")
    private int weight;

    public CompositionEntity() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return (int) (product.getCalories() / 100.00 * weight);
    }

    public double getProteins() {
        return Math.round(product.getProteins() / 100.00 * weight);
    }

    public double getFats() {
        return Math.round(product.getFats() / 100.00 * weight);
    }

    public double getCarbohydrates() {
        return Math.round(product.getCarbohydrates() / 100.00 * weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionEntity that = (CompositionEntity) o;
        return weight == that.weight && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, weight);
    }
}
