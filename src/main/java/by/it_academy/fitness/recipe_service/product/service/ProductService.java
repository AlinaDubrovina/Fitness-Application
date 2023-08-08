package by.it_academy.fitness.recipe_service.product.service;

import by.it_academy.fitness.recipe_service.product.core.dto.ProductCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import by.it_academy.fitness.recipe_service.product.core.mapper.IProductMapper;
import by.it_academy.fitness.recipe_service.product.dao.IProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    private final IProductMapper mapper;

    public ProductService(IProductRepository productRepository, IProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(ProductCreateUpdateDTO productCreateUpdateDto) {
        Product product = mapper.toEntity(productCreateUpdateDto);
        product.setUuid(UUID.randomUUID());
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void saveOrUpdate(UUID uuid, LocalDateTime dtUpdate, ProductCreateUpdateDTO productCreateUpdateDTO) {
        Product product = productRepository.getReferenceById(uuid);
        mapper.map(productCreateUpdateDTO, product);
        product.setDtUpdate(dtUpdate);
        productRepository.save(product);
    }

    @Override
    public Product getByID(UUID uuid) {
        return this.productRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Product not found!"));
    }
}
