package by.it_academy.fitness.recipe_service.recipe.core.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RecipeForCreateUpdateDTO {
    private String title;
    private List<CompositionCreateDTO> compositionRecipeDTOS;

    @JsonCreator
    public RecipeForCreateUpdateDTO(@JsonProperty(value = "title") String title,
                                    @JsonProperty(value = "compositions") List<CompositionCreateDTO> compositionRecipeDTOS) {
        this.title = title;
        this.compositionRecipeDTOS = compositionRecipeDTOS;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CompositionCreateDTO> getComposition() {
        return this.compositionRecipeDTOS != null ? this.compositionRecipeDTOS : new ArrayList<>();
    }

    public void setComposition(List<CompositionCreateDTO> composition) {
        this.compositionRecipeDTOS= composition;
    }

    public void addRecipe(CompositionCreateDTO recipe) {
        if (this.compositionRecipeDTOS == null) {
            this.compositionRecipeDTOS = new ArrayList<>();
        }
        this.compositionRecipeDTOS.add(recipe);
    }

    public void deleteRecipe(CompositionCreateDTO recipe) {
        if (this.compositionRecipeDTOS == null) {
            this.compositionRecipeDTOS = new ArrayList<>();
            return;
        }
        this.compositionRecipeDTOS.remove(recipe);
    }
}
