package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.InputDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Input;
import uz.pdp.springbootapp.Service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    // CREATE new input
    @PostMapping
    public Result addNewInput(@RequestBody InputDTO inputDTO) {
        Result result = inputService.addInput(inputDTO);
        return result;
    }

    // READ all inputs
    @GetMapping
    public List<Input> readAllInput() {
        List<Input> inputs = inputService.readAllInputs();
        return inputs;
    }

    // READ ipnut by id
    @GetMapping("/{id}")
    public Input readInputsById(@PathVariable Integer id) {
        Input input = inputService.getInputById(id);
        return input;
    }

    // UPDATE input by id
    @PutMapping("/{id}")
    public Result updateInputById(@PathVariable Integer id, @RequestBody InputDTO inputDTO) {
        Result updateInputs= inputService.updateInput(id, inputDTO);
        return updateInputs;
    }

    // DELETE input by id
    @DeleteMapping("/{id}")
    public Result deleteInputById(@PathVariable Integer id) {
        Result deleteInputs = inputService.deleteInput(id);
        return deleteInputs;

    }
}
