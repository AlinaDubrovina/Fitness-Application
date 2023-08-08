package by.it_academy.fitness.recipe_service.recipe.web;

import by.it_academy.fitness.recipe_service.recipe.core.dto.RecipeForCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.recipe.core.entity.RecipeEntity;
import by.it_academy.fitness.recipe_service.recipe.service.IRecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final IRecipeService recipeService;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody RecipeForCreateUpdateDTO recipe){
        recipeService.save(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/{id}/version/{dt_update}", method = RequestMethod.PUT)
    public void saveOrUpdate(@PathVariable("id") UUID id,
                             @PathVariable("dt_update") LocalDateTime dt_update,
                             @RequestBody RecipeForCreateUpdateDTO recipe) {
        recipeService.saveOrUpdate(id, dt_update, recipe);
    }
}
