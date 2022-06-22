package com.e.commerce.controller;

import com.e.commerce.model.Produit;
import com.e.commerce.service.CategorieService;
import com.e.commerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AccueilController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ProduitService produitService;

    @RequestMapping("/Accueil")
    public String list(Map<String, Object> modelMap)
    {
        modelMap.put("Produit",new Produit());
        modelMap.put("categorie",categorieService.findCategParent());
        modelMap.put("produit",produitService.findall());
        return "index";
    }

    @RequestMapping("/Categorie")
    public String listParCategorie(Map<String, Object> modelMap, HttpServletRequest request)
    {
        int idcat=Integer.parseInt(request.getParameter("id"));
        modelMap.put("Produit",new Produit());
        modelMap.put("categorie",categorieService.findCategParent());
        modelMap.put("produit",produitService.finByCategorie(idcat));
        return "index";
    }
}
