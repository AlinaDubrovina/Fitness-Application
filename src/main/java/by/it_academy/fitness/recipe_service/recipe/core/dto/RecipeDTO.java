package by.it_academy.fitness.recipe_service.recipe.core.dto;

import by.it_academy.fitness.util.UnixSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class RecipeDTO {
    private UUID id;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;
    private String title;
    private List<CompositionDTO> composition;
    private int weight;
    private int calories;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public RecipeDTO(UUID id, LocalDateTime dt_create, LocalDateTime dt_update, String title,
                     List<CompositionDTO> composition, int weight, int calories, double proteins, double fats, double carbohydrates) {
        this.id = id;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.title = title;
        this.composition = composition;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public RecipeDTO(String title, List<CompositionDTO> composition, int weight, int calories, double proteins, double fats, double carbohydrates) {
        this.dt_create = LocalDateTime.now();
        this.title = title;
        this.composition = composition;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public RecipeDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDt_create() {
        return dt_create;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public LocalDateTime getDt_update() {
        return dt_update;
    }

    @JsonSerialize(using = UnixSerializer.class)
    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CompositionDTO> getComposition() {
        return composition;
    }

    public void setComposition(List<CompositionDTO> composition) {
        this.composition = composition;
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
        RecipeDTO recipeDTO = (RecipeDTO) o;
        return weight == recipeDTO.weight && calories == recipeDTO.calories && Double.compare(recipeDTO.proteins, proteins) == 0 && Double.compare(recipeDTO.fats, fats) == 0 && Double.compare(recipeDTO.carbohydrates, carbohydrates) == 0 && Objects.equals(id, recipeDTO.id) && Objects.equals(dt_create, recipeDTO.dt_create) && Objects.equals(dt_update, recipeDTO.dt_update) && Objects.equals(title, recipeDTO.title) && Objects.equals(composition, recipeDTO.composition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dt_create, dt_update, title, composition, weight, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", dt_create=" + dt_create +
                ", dt_update=" + dt_update +
                ", title='" + title + '\'' +
                ", composition=" + composition +
                ", weight=" + weight +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}