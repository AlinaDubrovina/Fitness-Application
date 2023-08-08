package by.it_academy.fitness.recipe_service.product.web;

import by.it_academy.fitness.recipe_service.product.core.dto.ProductCreateUpdateDTO;
import by.it_academy.fitness.recipe_service.product.core.dto.ProductDTO;
import by.it_academy.fitness.recipe_service.product.core.entity.Product;
import by.it_academy.fitness.recipe_service.product.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductCreateUpdateDTO product){;
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/{id}/version/{dt_update}", method = RequestMethod.PUT)
    public void saveOrUpdate(@PathVariable("id") UUID id,
                             @PathVariable("dt_update") LocalDateTime dtUpdate,
                             @RequestBody ProductCreateUpdateDTO product) {
        productService.saveOrUpdate(id, dtUpdate, product);
    }
}
