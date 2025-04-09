package com.springboot.dev_spring_boot_demo.controller;

import com.springboot.dev_spring_boot_demo.entity.Product;
import com.springboot.dev_spring_boot_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about-us")
    public String aboutUs() {
        return "about-us";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }
    @GetMapping("/service")
    public String service(){
        return "service";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/offer")
    public String offer() {
        return "offer";
    }

    // @GetMapping("/learn")
    // public String learn() {
    //     return "learn";
    // }

    @GetMapping("/contact")
    public String contactUs() {
        return "contact";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        try {
            Product product = productService.getProductById(id);
            if (product != null) {
                model.addAttribute("product", product);
                return "product-detail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/shop";
    }
}
