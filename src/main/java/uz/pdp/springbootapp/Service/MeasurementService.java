package uz.pdp.springbootapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Measurement;
import uz.pdp.springbootapp.Repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    // ADD measurement
    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName) {
            return new Result("This measurement already exists", false);
        }
        measurementRepository.save(measurement);
        return new Result("Measurement added", true);
    }

    // READ all measurements
    public List<Measurement> readALlMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements;
    }

    // READ measurements by id
    public Measurement readMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            Measurement measurement = optionalMeasurement.get();
            return measurement;
        }
        return new Measurement();
    }

    // UPDATE measurement by id
    public Result updateMeasurement(Measurement measurement, Integer id) {
        Optional<Measurement> measurementOptional = measurementRepository.findById(id);
        if (measurementOptional.isPresent()) {
            boolean existsByName = measurementRepository.existsByName(measurement.getName());
            if (existsByName) {
                return new Result("This measurement already exists", false);
            }

            Measurement editedMeasurement = measurementOptional.get();
            editedMeasurement.setName(measurement.getName());

            measurementRepository.save(editedMeasurement);
            return new Result("Mesurement updated", true);
        }
        return new Result("Measurement with this id is not found", false);
    }

    // DELETE measurement by id
    public Result deleteMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {
            measurementRepository.deleteById(id);
            return new Result("Measurement deleted", true);
        }
        return new Result("Measurement with this id is not found", false);

    }
}
