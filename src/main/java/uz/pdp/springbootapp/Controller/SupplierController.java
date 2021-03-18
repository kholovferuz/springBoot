package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Supplier;
import uz.pdp.springbootapp.Service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    // CREATE new supplier
    @PostMapping
    public Result addSuppliers(@RequestBody Supplier supplier) {
        Result result = supplierService.addSupplier(supplier);
        return result;
    }

    // READ all suppliers
    @GetMapping
    public List<Supplier> readAllSupplier() {
        List<Supplier> suppliers = supplierService.readALlSuppliers();
        return suppliers;
    }

    // READ supplier by id
    @GetMapping("/{id}")
    public Supplier readSupplierById(@PathVariable Integer id) {
        Supplier supplier = supplierService.readSupplierById(id);
        return supplier;
    }

    // UPDATE supplier by id
    @PutMapping("/{id}")
    public Result updateSupplierById(@PathVariable Integer id, @RequestBody Supplier supplier) {
        Result updateSupplier = supplierService.updateSupplier(supplier, id);
        return updateSupplier;
    }

    // DELETE supplier by id
    @DeleteMapping("/{id}")
    public Result deleteSupplierById(@PathVariable Integer id) {
        Result deleteSupplier = supplierService.deleteSupplier(id);
        return deleteSupplier;

    }
}
