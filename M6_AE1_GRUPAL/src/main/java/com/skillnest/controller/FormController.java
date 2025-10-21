package com.skillnest.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.skillnest.model.PersonForm;

@Controller
public class FormController {

  @GetMapping("/form")
  public String showForm(PersonForm personForm) {
    return "form"; // resources/templates/form.html
  }

  @PostMapping("/form")
  public String submit(@Valid PersonForm personForm, BindingResult br, Model model) {
    if (br.hasErrors()) return "form";
    model.addAttribute("msg",
      "Registrado: " + personForm.getNombre() + " (" + personForm.getEdad() + ")");
    return "result";
  }
}
