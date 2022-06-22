package com.e.commerce.controller;


import com.e.commerce.model.User;
import com.e.commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService utilisateurService;

    @RequestMapping(value = "/formInsert")
    public String FormLogin(Map<String, Object> modelMap)
    {

        return "FormLogin";
    }

    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String TraitLogin(@ModelAttribute("User") @Validated User utilisateur,
                             BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("User",new User());
            return "FormLogin";
        }
        else
        {
            User util=utilisateurService.getUtilisateur(request.getParameter("utilisateur"),request.getParameter("mdp"));
            int test=0;
            if(util.getId()==0)
            {
                model.addAttribute("erreur","Verifier votre identifiant et votre mot de passe");
                model.addAttribute("User",new User());
                return "FormLogin";
            }
            else
            {
                HttpSession sess=request.getSession();
                sess.setAttribute("IdUtilisateur",util.getId());
                return "index";
            }
        }
    }




}
