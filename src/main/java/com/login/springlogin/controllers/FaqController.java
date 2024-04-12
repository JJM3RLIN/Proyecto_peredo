package com.login.springlogin.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.springlogin.DTO.FaqDTO;
import com.login.springlogin.DTO.IdDTO;
import com.login.springlogin.services.FaqService;

@RestController
@RequestMapping("/api/faq")
public class FaqController {
    @Autowired
    FaqService faqService;
    @PostMapping("/crear")
    public ResponseEntity<?> createFaq(@RequestBody FaqDTO faqDTO) {
        Map<String,String> response = new HashMap<>();
        response.put("mensaje", faqService.create(faqDTO));
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/actualizar")
    public ResponseEntity<?> updateFaq(@RequestBody FaqDTO faqDTO) {
        Map<String,String> response = new HashMap<>();
        response.put("mensaje", faqService.update(faqDTO));
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/eliminar")
    public ResponseEntity<?> deleteFaq(@RequestBody IdDTO idDTO) {   
        return ResponseEntity.ok().body(getResponse(faqService.delete(idDTO.getId())));
    }
    @GetMapping
    public ResponseEntity<?> getAllFaqs() {
        return ResponseEntity.ok().body(faqService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFaqById(@PathVariable int id) {
        Optional<?> faq = faqService.getById(id);
        if (!faq.isPresent()) {
            return ResponseEntity.ok().body("No se encontró el faq");
        }
        return ResponseEntity.ok().body(faq.get());
    }
    private Map<String,String> getResponse(String mensaje) {
        Map<String,String> response = new HashMap<>();
        response.put("mensaje", mensaje);
        return response;
    }
}