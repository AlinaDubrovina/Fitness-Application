package by.it_academy.fitness.recipe_service.product.core.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products", schema = "app")
public class Product extends BaseEntityDateTime{
    @Column
    private String title;
    @Column
    private int weight;
    @Column
    private int calories;
    @Column
    private double proteins;
    @Column
    private double fats;
    @Column
    private double carbohydrates;

    public Product(UUID uuid, LocalDateTime dtUpdate, String title, int weight, int calories, double proteins, double fats, double carbohydrates) {
        super(uuid, dtUpdate);
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Product() {
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

    public static final class ProductBuilder {
        private UUID id;
        private LocalDateTime dtCreate;
        private LocalDateTime dtUpdate;
        private String title;
        private int weight;
        private int calories;
        private double proteins;
        private double fats;
        private double carbohydrates;

        private ProductBuilder() {
        }

        public ProductBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withDtCreate(LocalDateTime dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public ProductBuilder withDtUpdate(LocalDateTime dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

        public ProductBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public ProductBuilder withCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public ProductBuilder withProteins(double proteins) {
            this.proteins = proteins;
            return this;
        }

        public ProductBuilder withFats(double fats) {
            this.fats = fats;
            return this;
        }

        public ProductBuilder withCarbohydrates(double carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Product build() {
            return new Product(id, dtUpdate, title, weight, calories, proteins, fats, carbohydrates);
        }
    }
}
