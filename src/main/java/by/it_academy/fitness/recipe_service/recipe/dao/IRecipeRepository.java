package by.it_academy.fitness.recipe_service.recipe.dao;


import by.it_academy.fitness.recipe_service.recipe.core.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IRecipeRepository extends JpaRepository<RecipeEntity, UUID> {
    Optional<RecipeEntity> getByUuid(UUID uuid);
}
