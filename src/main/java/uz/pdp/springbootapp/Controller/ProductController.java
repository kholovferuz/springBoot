package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.ProductDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Product;
import uz.pdp.springbootapp.Entity.Warehouse;
import uz.pdp.springbootapp.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // CREATE new product
    @PostMapping
    public Result addProduct(@RequestBody ProductDTO productDTO) {
        Result result = productService.addProduct(productDTO);
        return result;
    }

    // READ all products
    @GetMapping
    public List<Product> readAllProduct() {
        List<Product> products = productService.readAllProducts();
        return products;
    }

    // READ product by id
    @GetMapping("/{id}")
    public Product readProductsById(@PathVariable Integer id) {
        Product product = productService.readProductById(id);
        return product;
    }

    // UPDATE product by id
    @PutMapping("/{id}")
    public Result updateProductsById(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        Result updateProduct= productService.updateProductById(id, productDTO);
        return updateProduct;
    }

    // DELETE product by id
    @DeleteMapping("/{id}")
    public Result deleteProductById(@PathVariable Integer id) {
        Result deleteProduct = productService.deleteProduct(id);
        return deleteProduct;

    }

}
