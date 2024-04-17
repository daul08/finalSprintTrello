package finalsprinttask.controller;

import finalsprinttask.exception.TrelloNotFoundException;
import finalsprinttask.model.Task;
import finalsprinttask.model.TaskCategory;
import finalsprinttask.service.TaskCategoryService;
import finalsprinttask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskCategoryController {
    private final TaskCategoryService taskCategoryService;

    @PostMapping("/category/add")
    public String addCategory(TaskCategory taskCategory) {
        taskCategoryService.create(taskCategory);
        return "redirect:/category";
    }

    @PostMapping("/category/edit")
    public String editCategory(TaskCategory taskCategory) {
        taskCategoryService.update(taskCategory);
        return "redirect:/category";
    }
    @PostMapping("/category/delete")
    public String deleteCategory(Long id) {
        taskCategoryService.delete(id);
        return "redirect:/category";
    }
    @GetMapping("/category")
    public String getCategories(Model model) {
        List<TaskCategory> taskCategoryList = taskCategoryService.getCategories();
        model.addAttribute("categories", taskCategoryList);
        return "categoryPage";
    }
    @GetMapping("/category/{id}")
    public String getCategoryById(@PathVariable Long id, Model model) throws TrelloNotFoundException {
        TaskCategory taskCategory = taskCategoryService.getById(id);
        model.addAttribute("category", taskCategory);
        return "category";
    }



}
