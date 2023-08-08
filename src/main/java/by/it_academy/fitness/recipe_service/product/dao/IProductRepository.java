package by.it_academy.fitness.recipe_service.product.dao;

import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> getByUuid(UUID uuid);
}