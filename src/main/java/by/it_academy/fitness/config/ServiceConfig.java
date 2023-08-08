package by.it_academy.fitness.config;

import by.it_academy.fitness.recipe_service.product.core.mapper.IProductMapper;
import by.it_academy.fitness.recipe_service.product.dao.IProductRepository;
import by.it_academy.fitness.recipe_service.product.service.ProductService;
import by.it_academy.fitness.recipe_service.product.service.IProductService;
import by.it_academy.fitness.recipe_service.recipe.dao.IRecipeRepository;
import by.it_academy.fitness.recipe_service.recipe.service.IRecipeService;
import by.it_academy.fitness.recipe_service.recipe.service.RecipeService;
import by.it_academy.fitness.user_service.creation.IUserCreateRepository;
import by.it_academy.fitness.user_service.creation.UserCreateService;
import by.it_academy.fitness.user_service.creation.IUserCreateService;
import by.it_academy.fitness.user_service.registration_login.IUserRegistrationLoginRepository;
import by.it_academy.fitness.user_service.registration_login.IUserRegistrationLoginService;
import by.it_academy.fitness.user_service.registration_login.UserRegistrationLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public IUserCreateService userService(IUserCreateRepository dao){
        return new UserCreateService(dao);
    }

    @Bean
    public IUserRegistrationLoginService userRegistrationLoginService(IUserRegistrationLoginRepository dao){
        return new UserRegistrationLoginService(dao);
    }

    @Bean
    public IProductService productService(IProductRepository productRepository, IProductMapper productMapper){
        return new ProductService(productRepository, productMapper);
    }

    @Bean
    public IRecipeService recipeService(IRecipeRepository dao, IProductService productService){
        return new RecipeService(dao, productService);
    }
}
