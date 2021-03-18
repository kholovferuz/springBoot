package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.InputDTO;
import uz.pdp.springbootapp.DTO.OutputDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Input;
import uz.pdp.springbootapp.Entity.Output;
import uz.pdp.springbootapp.Service.InputService;
import uz.pdp.springbootapp.Service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    // CREATE new output
    @PostMapping
    public Result addOutputs(@RequestBody OutputDTO outputDTO) {
        Result result = outputService.addOutput(outputDTO);
        return result;
    }

    // READ all outputs
    @GetMapping
    public List<Output> readAllOutput() {
        List<Output> outputs = outputService.readAllOutputs();
        return outputs;
    }

    // READ output by id
    @GetMapping("/{id}")
    public Output readOutputsById(@PathVariable Integer id) {
        Output output = outputService.getOutputById(id);
        return output;
    }

    // UPDATE output by id
    @PutMapping("/{id}")
    public Result updateOutputById(@PathVariable Integer id, @RequestBody OutputDTO outputDTO) {
        Result updateOutputs= outputService.updateOutput(id, outputDTO);
        return updateOutputs;
    }

    // DELETE output by id
    @DeleteMapping("/{id}")
    public Result deleteOutputById(@PathVariable Integer id) {
        Result deleteOutputs = outputService.deleteOutput(id);
        return deleteOutputs;

    }
}
