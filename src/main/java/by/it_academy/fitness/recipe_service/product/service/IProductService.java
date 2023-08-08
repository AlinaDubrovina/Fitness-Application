package by.it_academy.fitness.recipe_service.product.service;

import by.it_academy.fitness.recipe_service.product.core.dto.ProductCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.product.core.entity.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IProductService {
    void save(ProductCreateUpdateDTO product);
    void saveOrUpdate(UUID uuid, LocalDateTime dtUpdate, ProductCreateUpdateDTO productCreateUpdateDTO);
    Product getByID(UUID uuid);
}
