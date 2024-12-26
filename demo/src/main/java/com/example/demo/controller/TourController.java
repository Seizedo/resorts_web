package com.example.demo.controller;

import com.example.demo.dao.MySQLDAO;
import com.example.demo.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private MySQLDAO tousService;

    // Відображення всіх турів
    @GetMapping
    public String displayAllTours(Model model) {
        List<Tour> tours = tousService.displayAllTours();
        model.addAttribute("tours", tours);
        return "tours"; // Назва HTML-шаблону
    }

    // Додавання туру
    @PostMapping("/add")
    public String addTour(@RequestParam String name, @RequestParam double price,
                          @RequestParam String startDate, @RequestParam String endDate,
                          @RequestParam int resortId, Model model) {
        tousService.addTour(name, price, startDate, endDate, resortId);
        model.addAttribute("message", "Тур успішно додано!");
        return "redirect:/tours";
    }

    // Оновлення туру
    @PostMapping("/update")
    public String updateTour(@RequestParam int id, @RequestParam String name,
                             @RequestParam double price, @RequestParam String startDate,
                             @RequestParam String endDate, @RequestParam int resortId,
                             Model model) {
        tousService.updateTour(id, name, price, startDate, endDate, resortId);
        model.addAttribute("message", "Тур успішно оновлено!");
        return "redirect:/tours";
    }

    // Видалення туру
    @PostMapping("/delete")
    public String deleteTour(@RequestParam int id, Model model) {
        tousService.deleteTour(id);
        model.addAttribute("message", "Тур успішно видалено!");
        return "redirect:/tours";
    }

    // Пошук турів
    @PostMapping("/search")
    public String searchTours(@RequestParam String keyword, Model model) {
        List<Tour> tours = tousService.searchTours(keyword);
        model.addAttribute("tours", tours);
        return "tours";
    }
}
