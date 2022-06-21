package com.e.commerce.controller;

import com.e.commerce.model.Categorie;
import com.e.commerce.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/categorie/*")
public class CategorieRestController {
    @Autowired
    private CategorieService categorieService;


    @GetMapping(value = "/categories/")
    public ResponseEntity<Collection<Categorie>> getAllSign() {
        Collection<Categorie> categ = categorieService.findCategParent();
        return new ResponseEntity<Collection<Categorie>>(categ, HttpStatus.FOUND);
    }

    @GetMapping(value = "/categories/{Id}")
    public ResponseEntity<Collection<Categorie>> getSignRegion(@PathVariable("Id") String Id) {
        int IdRegion=Integer.parseInt(Id);
        Collection<Categorie> signal = categorieService.findSousCat(IdRegion);
        return new ResponseEntity<Collection<Categorie>>(signal, HttpStatus.FOUND);
    }
}
