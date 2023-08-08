package by.it_academy.fitness.recipe_service.product.core.mapper;

import by.it_academy.fitness.recipe_service.product.core.dto.ProductCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.product.core.dto.ProductDTO;
import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    Product toEntity(ProductCreateUpdateDTO dto);

    ProductDTO toDTO(Product entity);

    void map(ProductCreateUpdateDTO dto, @MappingTarget Product entity);
}
