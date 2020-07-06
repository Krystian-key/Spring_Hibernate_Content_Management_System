package pl.springhibernate.springcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springhibernate.springcms.dao.CategoryDao;
import pl.springhibernate.springcms.entity.Category;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    private CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/category/all")
    @ResponseBody
    public String showAll() {
        List<Category> categories = categoryDao.getAll();
      return categories.stream()
                .map(Category::toString)
                .collect(Collectors.joining(", \r\n <br>"));


    }

    @RequestMapping("/category/add")
    @ResponseBody
    public String add(){
        Category category = new Category();
        category.setName("Programing");
        category.setDescription("You are the best in the world");
        categoryDao.save(category);
        return "Id to :" + category.getId();
    }


    @RequestMapping("/category/update/{id}/{name}/{description}")
    @ResponseBody
    public String update(@PathVariable long id,@PathVariable String name,@PathVariable String description){
        Category category = categoryDao.findById(id);
        category.setName(name);
        category.setDescription(description);
        categoryDao.update(category);
        return "updated: " + category.toString();
    }

    @RequestMapping("/category/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id){
        Category category = categoryDao.findById(id);
        return category.toString();
    }




    @RequestMapping("/category/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable  long id){
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "deleted";

    }


}


