package com.example.demo.controller;

import com.example.demo.dao.MySQLDAO;
import com.example.demo.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private MySQLDAO serviceService; // DAO для роботи з сервісами

    // Відображення всіх сервісів
    @GetMapping
    public String displayAllServices(Model model) {
        List<Service> services = serviceService.displayAllServices();
        model.addAttribute("services", services);
        return "service"; // Назва HTML-шаблону
    }

    // Додавання сервісу
    @PostMapping("/add")
    public String addService(@RequestParam String name, @RequestParam String description, @RequestParam int resortId, Model model) {
        serviceService.addService(name, description, resortId);
        model.addAttribute("message", "Сервіс успішно додано!");
        return "redirect:/services"; // Перенаправлення на сторінку сервісів
    }

    // Оновлення сервісу
    @PostMapping("/update")
    public String updateService(@RequestParam int id, @RequestParam String name, @RequestParam String description, @RequestParam int resortId, Model model) {
        serviceService.updateService(id, name, description, resortId);
        model.addAttribute("message", "Сервіс успішно оновлено!");
        return "redirect:/services"; // Перенаправлення на сторінку сервісів
    }

    // Видалення сервісу
    @PostMapping("/delete")
    public String deleteService(@RequestParam int id, Model model) {
        serviceService.deleteService(id);
        model.addAttribute("message", "Сервіс успішно видалено!");
        return "redirect:/services"; // Перенаправлення на сторінку сервісів
    }

    // Пошук сервісів
    @PostMapping("/search")
    public String searchServices(@RequestParam String name, Model model) {
        List<Service> services = serviceService.searchServices(name);
        model.addAttribute("services", services);
        return "service"; // Назва HTML-шаблону
    }
}
