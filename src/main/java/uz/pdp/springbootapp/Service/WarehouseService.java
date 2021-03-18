package uz.pdp.springbootapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Warehouse;
import uz.pdp.springbootapp.Repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    // ADD warehouse
    public Result addWarehouse(Warehouse warehouse) {
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName) {
            return new Result("This warehouse already exists", false);
        }
        warehouseRepository.save(warehouse);
        return new Result("Warehouse added", true);
    }

    // READ all warehouse
    public List<Warehouse> readALlWarehouses() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return warehouses;
    }

    // READ warehouse by id
    public Warehouse readWarehouseById(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse warehouse = optionalWarehouse.get();
            return  warehouse;
        }
        return new Warehouse();
    }

    // UPDATE warehouse by id
    public Result updateWarehouse(Warehouse warehouse, Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
            if (existsByName) {
                return new Result("This warehouse already exists", false);
            }

            Warehouse editedWarehouse = optionalWarehouse.get();
            editedWarehouse.setName(warehouse.getName());

            warehouseRepository.save(editedWarehouse);
            return new Result("Warehouse updated", true);
        }
        return new Result("Warehouse with this id is not found", false);
    }

    // DELETE warehouse by id
    public Result deleteWarehouse(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            warehouseRepository.deleteById(id);
            return new Result("Warehouse deleted",true);
        }
        return new Result("Warehouse with this id is not found",false);

    }


}
