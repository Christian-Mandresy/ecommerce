package com.e.commerce.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Carte> CarteList=new ArrayList<Carte>();


    public Panier(String panierJson) {
        if (panierJson.equals(""))
        {

        }else
        {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter();

            List<Carte> payload = null;

            try {
                payload = objectMapper.readValue(URLDecoder.decode(panierJson, "UTF-8"), objectMapper.getTypeFactory().constructCollectionType(List.class, Carte.class));
            } catch (IOException e) {
                e.printStackTrace();
            }

            payload.forEach(System.out::println);
            this.CarteList=payload;
        }
    }

    public List<Carte> getCarteList() {
        return CarteList;
    }

    public void setCarteList(List<Carte> CarteList) {
        this.CarteList = CarteList;
    }

    public void ajouter(Carte carte)
    {
        Boolean test=false;
        for (int i = 0; i < this.CarteList.size(); i++) {
            if(this.CarteList.get(i).equals(carte))
            {
                this.CarteList.get(i).setQuantite(CarteList.get(i).getQuantite()+1);
                test=true;
            }
        }
        if(this.CarteList.size()==0 || test==false)
        {
            this.CarteList.add(carte);
        }
    }

    public void effacer(Carte carte)
    {
        for (int i = 0; i < this.CarteList.size(); i++) {
            if(CarteList.get(i).equals(carte))
            {
                CarteList.remove(i);
            }
        }
    }

    public double getPrix()
    {
        double total=0.0;
        for (int i = 0; i < this.CarteList.size(); i++) {
            if(this.CarteList.get(i).getProduit()!=null)
            {
                total += this.CarteList.get(i).getQuantite() * this.CarteList.get(i).getProduit().getPrix();
            }
        }
        return total;
    }

    public int getQte()
    {
        int total=0;
        for (int i = 0; i < this.CarteList.size(); i++) {
            if(this.CarteList.get(i).getProduit()!=null)
            {
                total += this.CarteList.get(i).getQuantite();
            }
        }
        return total;
    }


    public String parseIntoCookie()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        String arrayToJson="";
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        try {
            arrayToJson = objectMapper.writeValueAsString(this.CarteList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return arrayToJson;
    }


}
