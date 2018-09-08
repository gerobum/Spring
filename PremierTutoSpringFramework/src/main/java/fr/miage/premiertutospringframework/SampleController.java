/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.premiertutospringframework;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author yvan
 */
@Controller
public class SampleController implements WebMvcConfigurer {

    @RequestMapping("/")
    public String racine() {
        return "racine";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {
        return "<h1>Bonjour tout le monde</h1>";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "tout le monde") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/form")
    public String greetingForm(Model model) {
        model.addAttribute("form", new Greeting());
        return "form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

    @GetMapping("/person")
    public String personForm(Model model) {
        model.addAttribute("person", new PersonForm());
        return "person";
    }

    @PostMapping("/person")
    public String personForm(@ModelAttribute PersonForm personForm) {
        return "personResult";
    }
    
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }*/
}
