package by.it_academy.fitness.recipe_service.recipe.service;

import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import by.it_academy.fitness.recipe_service.product.service.IProductService;
import by.it_academy.fitness.recipe_service.recipe.core.dto.CompositionCreateDTO;
import by.it_academy.fitness.recipe_service.recipe.core.dto.RecipeForCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.recipe.core.entity.CompositionEntity;
import by.it_academy.fitness.recipe_service.recipe.core.entity.RecipeEntity;
import by.it_academy.fitness.recipe_service.recipe.dao.IRecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RecipeService implements IRecipeService{
    private final IRecipeRepository recipeRepository;
    private final IProductService productService;

    public RecipeService(IRecipeRepository recipeRepository, IProductService productService) {
        this.recipeRepository = recipeRepository;
        this.productService = productService;
    }

    @Override
    public void save(RecipeForCreateUpdateDTO recipeDTO) {
        RecipeEntity recipe = convertToEntity(recipeDTO);
        recipeRepository.save(recipe);
    }

    @Transactional
    @Override
    public void saveOrUpdate(UUID uuid, LocalDateTime dtUpdate, RecipeForCreateUpdateDTO recipeDTO) {
        RecipeEntity recipe = this.recipeRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found!"));

        List<CompositionEntity> productComposition = convertToProductComposition(recipeDTO.getComposition());
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setCompositions(productComposition);
        this.recipeRepository.save(recipe);
    }

    private RecipeEntity convertToEntity(RecipeForCreateUpdateDTO recipeCreateDTO) {

        RecipeEntity recipe = new RecipeEntity();
        recipe.setTitle(recipeCreateDTO.getTitle());

        List<CompositionCreateDTO> composition = recipeCreateDTO.getComposition();
        List<CompositionEntity> productList = convertToProductComposition(composition);
        recipe.setCompositions(productList);

        return recipe;
    }

    private List<CompositionEntity> convertToProductComposition(
            List<CompositionCreateDTO> compositionCreateDTOS) {

        return compositionCreateDTOS.stream()
                .map(dto -> {
                    Product product = this.productService.getByID(dto.getProduct());
                    CompositionEntity composition = new CompositionEntity();

                    composition.setProduct(product);
                    composition.setWeight(dto.getWeight());

                    return composition;
                })
                .collect(Collectors.toList());
    }
}
