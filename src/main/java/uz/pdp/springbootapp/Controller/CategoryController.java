package uz.pdp.springbootapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapp.DTO.CategoryDTO;
import uz.pdp.springbootapp.DTO.Result;
import uz.pdp.springbootapp.Entity.Category;
import uz.pdp.springbootapp.Service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // CREATE new category
    @PostMapping
    public Result addNewCategory(@RequestBody CategoryDTO categoryDTO) {
        Result result = categoryService.addCategory(categoryDTO);
        return result;
    }

    // READ all categories
    @GetMapping
    public List<Category> getAllCategories(){
        List<Category> categoryList = categoryService.readALlCategories();
        return categoryList;
    }

    // READ category by id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        Category category = categoryService.readCategoryById(id);
        return category;
    }

    // UPDATE category by id
    @PutMapping("/{id}")
    public Result updateCategoryById(@PathVariable Integer id,@RequestBody CategoryDTO categoryDTO){
        Result result = categoryService.updateCategory(id, categoryDTO);
        return result;
    }

    // DELETE category by id
    @DeleteMapping("/{id}")
    public Result deleteCategoryById(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return result;
    }
}
