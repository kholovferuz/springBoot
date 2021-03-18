package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Currency;
import uz.pdp.springbootapp.Entity.Measurement;
import uz.pdp.springbootapp.Service.CurrencyService;
import uz.pdp.springbootapp.Service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    // CREATE new currency
    @PostMapping
    public Result addNewCurrency(@RequestBody Currency currency) {
        Result result = currencyService.addCurrency(currency);
        return result;
    }

    // READ all currency
    @GetMapping
    public List<Currency> readAllCurrency() {
        List<Currency> currencies = currencyService.readALlCurrencies();
        return currencies;
    }

    // READ currencies by id
    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id) {
        Currency currencyById = currencyService.readCurrencyById(id);
        return currencyById;
    }

    // UPDATE currency by id
    @PutMapping("/{id}")
    public Result updateCurrencies(@PathVariable Integer id, @RequestBody Currency currency) {
        Result updateCurrency = currencyService.updateCurrency(currency, id);
        return updateCurrency;
    }

    // DELETE currency by id
    @DeleteMapping("/{id}")
    public Result deleteCurrencies(@PathVariable Integer id) {
        Result deleteCurrency = currencyService.deleteCurrency(id);
        return deleteCurrency;

    }
}
