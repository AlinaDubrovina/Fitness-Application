package by.it_academy.fitness.recipe_service.product.core.dto;

import by.it_academy.fitness.util.UnixSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@JsonPropertyOrder({
        "id",
        "dtCreate",
        "dtUpdate",
        "title",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public class ProductDTO {
    private UUID id;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private String title;
    private int weight;
    private int calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    @JsonCreator
    public ProductDTO(@JsonProperty(value = "id") UUID id,
                      @JsonProperty(value = "title") String title,
                      @JsonProperty(value = "weight") int weight,
                      @JsonProperty(value = "calories") int calories,
                      @JsonProperty(value = "proteins") double proteins,
                      @JsonProperty(value = "fats") double fats,
                      @JsonProperty(value = "carbohydrates") double carbohydrates) {
        this.id = id;
        this.dtCreate = LocalDateTime.now();
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return weight == that.weight && calories == that.calories && Double.compare(that.proteins, proteins) == 0 && Double.compare(that.fats, fats) == 0 && Double.compare(that.carbohydrates, carbohydrates) == 0 && Objects.equals(id, that.id) && Objects.equals(dtCreate, that.dtCreate) && Objects.equals(dtUpdate, that.dtUpdate) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dtCreate, dtUpdate, title, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
