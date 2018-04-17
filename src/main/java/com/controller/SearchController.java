/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Bagisci;
import com.query.DataQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author serdar
 */
@SessionScoped
@Named("Search")
public class SearchController implements Serializable {
    
    
    private String sehir;
    private String kanGrubu;
    private DataQuery query = new DataQuery();

    public List<Bagisci> getPersonList() {
        
         for(Bagisci person : personList){
            System.out.println("1."+person.getAd());
            System.out.println("2."+person.getSoyad());
        }
         
        return personList;
    }

    public void setPersonList(List<Bagisci> personList) {
        this.personList = personList;
    }
    List<Bagisci> personList = new ArrayList<>();
    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }
    
    
        public String kanBul(){
        
        
       
          personList=query.kanGrubuControl(sehir, kanGrubu);
         
        if("secilmedi".equals(sehir)){
            RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Hata","Şehir Seçiniz."));
        return "";
        }
        else if("secilmedi".equals(kanGrubu)){
            RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Hata","Kan Grubu Seçiniz."));
        return "";
        }
        
        if(personList.isEmpty())
       {
        RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Üzgünüz :(","Kayıt Bulunamadı..."));
        return "";
        }
        else{
           
            return "sonuclar.xhtml?faces-redirect=true";
        }
        
        
    }
    
}
