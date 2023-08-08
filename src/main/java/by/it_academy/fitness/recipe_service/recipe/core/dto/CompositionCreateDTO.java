package by.it_academy.fitness.recipe_service.recipe.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class CompositionCreateDTO {
    private UUID product;

    private int weight;

    public CompositionCreateDTO(UUID product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    public UUID getProduct() {
        return product;
    }

    public void setProduct(UUID product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionCreateDTO that = (CompositionCreateDTO) o;
        return weight == that.weight && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, weight);
    }
}
