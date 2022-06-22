package com.e.commerce.controller;

import com.e.commerce.model.Produit;
import com.e.commerce.service.CategorieService;
import com.e.commerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class ProduitController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ProduitService produitService;

    @RequestMapping("/FormAjout")
    public String list(Map<String, Object> modelMap)
    {
        modelMap.put("Produit",new Produit());
        modelMap.put("categorie",categorieService.findCategParent());
        modelMap.put("page","Ajout.jsp");
        return "template";
    }


}
