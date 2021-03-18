package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Measurement;
import uz.pdp.springbootapp.Service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    // CREATE new measurement
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }

    // READ all measurements
    @GetMapping
    public List<Measurement> readAllMeasurement() {
        List<Measurement> measurements = measurementService.readALlMeasurements();
        return measurements;
    }

    // READ measurements by id
    @GetMapping("/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id) {
        Measurement measurementById = measurementService.readMeasurementById(id);
        return measurementById;
    }

    // UPDATE measurement by id
    @PutMapping("/{id}")
    public Result updateMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement) {
        Result updateMeasurements = measurementService.updateMeasurement(measurement, id);
        return updateMeasurements;
    }

    // DELETE measurement by id
    @DeleteMapping("/{id}")
    public Result deleteMeasurementById(@PathVariable Integer id) {
        Result deleteMeasurement = measurementService.deleteMeasurement(id);
        return deleteMeasurement;

    }
}
