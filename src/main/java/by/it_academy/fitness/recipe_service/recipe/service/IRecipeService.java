package by.it_academy.fitness.recipe_service.recipe.service;

import by.it_academy.fitness.recipe_service.recipe.core.dto.RecipeDTO;
import by.it_academy.fitness.recipe_service.recipe.core.dto.RecipeForCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.recipe.core.entity.RecipeEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface IRecipeService {
    void save(RecipeForCreateUpdateDTO recipe);
    void saveOrUpdate(UUID id, LocalDateTime dt_update, RecipeForCreateUpdateDTO recipe);
}
