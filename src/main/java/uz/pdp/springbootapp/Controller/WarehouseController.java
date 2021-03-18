package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Warehouse;
import uz.pdp.springbootapp.Service.WarehouseService;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    // CREATE new warehouse
    @PostMapping
    public Result addNewWarehouse(@RequestBody Warehouse warehouse) {
        Result result = warehouseService.addWarehouse(warehouse);
        return result;
    }

    // READ all warehouses
    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.readALlWarehouses();
        return warehouses;
    }

    // READ warehouse by id
    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id) {
        Warehouse warehouseById = warehouseService.readWarehouseById(id);
        return warehouseById;
    }

    // UPDATE warehouse by id
    @PutMapping("/{id}")
    public Result updateWarehouseById(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        Result updateWarehouse = warehouseService.updateWarehouse(warehouse, id);
        return updateWarehouse;
    }

    // DELETE warehouse by id
    @DeleteMapping("/{id}")
    public Result deleteWarehouseById(@PathVariable Integer id) {
        Result deleteWarehouse = warehouseService.deleteWarehouse(id);
        return deleteWarehouse;

    }
}
