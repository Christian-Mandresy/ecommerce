package com.e.commerce.controller;

import com.e.commerce.model.Carte;
import com.e.commerce.model.Panier;
import com.e.commerce.model.Produit;
import com.e.commerce.service.CategorieService;
import com.e.commerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @RequestMapping("/RechercheMulti")
    public String RechercheMulti(Map<String, Object> modelMap, HttpServletRequest request)
    {
        modelMap.put("Produit",new Produit());
        modelMap.put("categorie",categorieService.findCategParent());
        modelMap.put("produit",produitService.findMulti(request.getParameter("nom"),request.getParameter("categorie"),request.getParameter("prix1"),request.getParameter("prix2")));
        return "index";
    }

    @RequestMapping("/AjouterPanier")
    public String AjoutPanier(Map<String, Object> modelMap, HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie[] cookies=request.getCookies();
        String Strpanier ="";
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("panier"))
            {
                Strpanier=cookies[i].getValue();
            }
        }

        Carte carte=new Carte();
        carte.setQuantite(1);
        Produit produit=new Produit();
        produit.setId(Integer.parseInt(request.getParameter("id")));
        produit.setPrix(Double.parseDouble(request.getParameter("prix")));
        produit.setNom(request.getParameter("name"));
        carte.setProduit(produit);
        Panier panier=new Panier(Strpanier);
        panier.ajouter(carte);
        Cookie cookie=new Cookie("panier", URLEncoder.encode(panier.parseIntoCookie(), "UTF-8"));
        response.addCookie(cookie);


        modelMap.put("produit",panier.getCarteList());
        modelMap.put("total",panier.getPrix());
        modelMap.put("page","cart.jsp");
        return "eshopper";
    }


}
