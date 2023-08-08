package by.it_academy.fitness.recipe_service.recipe.core.dto;

import by.it_academy.fitness.recipe_service.product.core.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;
import java.util.UUID;

@JsonPropertyOrder({
        "product",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})

public class CompositionDTO {
    private UUID uuid;
    private ProductDTO product;
    private int weight;
    private int calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public CompositionDTO(ProductDTO product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUUid(UUID uuid) {
        this.uuid = uuid;
    }

    @JsonGetter
    public ProductDTO getProduct() {
        return product;
    }

    @JsonSetter
    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @JsonGetter
    public int getWeight() {
        return weight;
    }

    @JsonSetter
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @JsonGetter
    public int getCalories() {
        return calories;
    }

    @JsonSetter
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @JsonGetter
    public double getProteins() {
        return proteins;
    }

    @JsonSetter
    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    @JsonGetter
    public double getFats() {
        return fats;
    }

    @JsonSetter
    public void setFats(double fats) {
        this.fats = fats;
    }

    @JsonGetter
    public double getCarbohydrates() {
        return carbohydrates;
    }

    @JsonSetter
    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionDTO that = (CompositionDTO) o;
        return weight == that.weight && calories == that.calories && Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "CompositionDTO{" +
                ", product=" + product +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
