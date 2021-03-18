package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.InputProductDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.InputProduct;
import uz.pdp.springbootapp.Service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/ipnutProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    // CREATE new inputProduct
    @PostMapping
    public Result addInputProducts(@RequestBody InputProductDTO inputProductDTO) {
        Result result = inputProductService.addInputProduct(inputProductDTO);
        return result;
    }

    // READ all inputProduct
    @GetMapping
    public List<InputProduct> readAllInputProduct() {
        List<InputProduct> products = inputProductService.readAllInputProducts();
        return products;
    }

    // READ inputProduct by id
    @GetMapping("/{id}")
    public InputProduct readInputProductsById(@PathVariable Integer id) {
        InputProduct inputProduct = inputProductService.readInputProductById(id);
        return inputProduct;
    }

    // UPDATE inputProduct by id
    @PutMapping("/{id}")
    public Result updateInputProductsById(@PathVariable Integer id, @RequestBody InputProductDTO inputProductDTO) {
        Result updateInputProduct= inputProductService.updateInputProduct(id, inputProductDTO);
        return updateInputProduct;
    }

    // DELETE inputProduct by id
    @DeleteMapping("/{id}")
    public Result deleteInputProductById(@PathVariable Integer id) {
        Result deleteInputProduct = inputProductService.deleteInputProduct(id);
        return deleteInputProduct;

    }
}
