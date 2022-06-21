package com.e.commerce.controller;

import com.e.commerce.model.Produit;
import com.e.commerce.model.ProduitCategorie;
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

    @RequestMapping("/AjoutProduit")
    public String traitAjout(@ModelAttribute("Trajet") @Validated Produit produit,
                             BindingResult bindingResult, Model model, HttpServletRequest request) throws ParseException
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("Produit",new Produit());
            model.addAttribute("categorie",categorieService.findCategParent());
            model.addAttribute("page","Ajout.jsp");
            return "template";
        }
        else
        {
            //HttpSession session =request.getSession();
            Produit produitAzo=new Produit();
            produitAzo.setNom(request.getParameter("nom"));
            produitAzo.setPrix(Double.parseDouble(request.getParameter("prix")));
            String categorie=request.getParameter("categorie");
            String[] StrCategories=request.getParameterValues("categorie[]");
            ProduitCategorie[] produitCategories=new ProduitCategorie[StrCategories.length+1];
            produitCategories[0]=new ProduitCategorie();
            produitCategories[0].setIdcategorie(Integer.parseInt(categorie));
            int indice=0;
            for (int i = 1; i <produitCategories.length ; i++) {
                produitCategories[i]=new ProduitCategorie();
                produitCategories[i].setIdcategorie(Integer.parseInt(StrCategories[indice]));
                indice++;
            }

            try {
                produitService.save(produitAzo,produitCategories);
                model.addAttribute("Produit",new Produit());
                model.addAttribute("categorie",categorieService.findCategParent());
                model.addAttribute("page","Ajout.jsp");
                model.addAttribute("success","Produit ajouter avec success");
                return "template";
            }catch (Exception e)
            {
                e.printStackTrace();
                model.addAttribute("error","une erreur est survenue");
                model.addAttribute("Produit",new Produit());
                model.addAttribute("categorie",categorieService.findCategParent());
                model.addAttribute("page","Ajout.jsp");
                return "template";
            }
        }

    }
}
