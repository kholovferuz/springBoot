package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.InputProductDTO;
import uz.pdp.springbootapp.DTO.OutputProductDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.InputProduct;
import uz.pdp.springbootapp.Entity.OutputProduct;
import uz.pdp.springbootapp.Service.InputProductService;
import uz.pdp.springbootapp.Service.OutputProductService;
import uz.pdp.springbootapp.Service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    // CREATE new outputProduct
    @PostMapping
    public Result addOutputProduct(@RequestBody OutputProductDTO outputProductDTO) {
        Result result = outputProductService.addOutputProduct(outputProductDTO);
        return result;
    }

    // READ all outputProducts
    @GetMapping
    public List<OutputProduct> readAllOutputProduct() {
        List<OutputProduct> outputProducts = outputProductService.readAllOutputProducts();
        return outputProducts;
    }

    // READ outputProduct by id
    @GetMapping("/{id}")
    public OutputProduct readOutputProductsById(@PathVariable Integer id) {
        OutputProduct outputProduct = outputProductService.readOutputProductById(id);
        return outputProduct;
    }

    // UPDATE outputProduct by id
    @PutMapping("/{id}")
    public Result updateOutputProductsById(@PathVariable Integer id, @RequestBody OutputProductDTO outputProductDTO) {
        Result updateOutputProduct= outputProductService.updateOutputProduct(id, outputProductDTO);
        return updateOutputProduct;
    }

    // DELETE outputProduct by id
    @DeleteMapping("/{id}")
    public Result deleteOutputById(@PathVariable Integer id) {
        Result deleteOutputProduct = outputProductService.deleteOutputProduct(id);
        return deleteOutputProduct;

    }
}
