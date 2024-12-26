package com.example.demo.controller;

import com.example.demo.dao.MySQLDAO;
import com.example.demo.model.Resort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/resorts")
public class ResortController {

    @Autowired
    private MySQLDAO mySQLDAO; // DAO для роботи з курортами

    // Відображення всіх курортів
    @GetMapping
    public String displayAllResorts(Model model) {
        List<Resort> resorts = mySQLDAO.displayAllResorts();
        model.addAttribute("resorts", resorts);
        return "resorts"; // Назва HTML-шаблону
    }

    // Додавання курорту
    @PostMapping("/add")
    public String addResort(@RequestParam String name, @RequestParam String location,
                            @RequestParam String type, @RequestParam double rating, Model model) {
        mySQLDAO.addResort(name, location, type, rating);
        model.addAttribute("message", "Курорт успішно додано!");
        return "redirect:/resorts"; // Перенаправлення на сторінку курортів
    }

    // Оновлення курорту
    @PostMapping("/update")
    public String updateResort(@RequestParam int id, @RequestParam String name,
                               @RequestParam String location, @RequestParam String type,
                               @RequestParam double rating, Model model) {
        mySQLDAO.updateResort(id, name, location, type, rating);
        model.addAttribute("message", "Курорт успішно оновлено!");
        return "redirect:/resorts"; // Перенаправлення на сторінку курортів
    }

    // Видалення курорту
    @PostMapping("/delete")
    public String deleteResort(@RequestParam int id, Model model) {
        mySQLDAO.deleteResort(id);
        model.addAttribute("message", "Курорт успішно видалено!");
        return "redirect:/resorts"; // Перенаправлення на сторінку курортів
    }

    // Пошук курортів
    @PostMapping("/search")
    public String searchResorts(@RequestParam String keyword, Model model) {
        List<Resort> resorts = mySQLDAO.searchResorts(keyword);
        model.addAttribute("resorts", resorts);
        return "resorts"; // Назва HTML-шаблону
    }
}
