/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.query.DataQuery;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
@Named("panel")
public class PanelController implements Serializable{
    
    
    private String eskisifre , yenisifre , email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private boolean hide;
    private DataQuery query = new DataQuery();
    
    @PostConstruct
    public void init(){
        

    }
   public String sifredegistir(){
       
       if(query.loginControl(email, eskisifre)){
          
         if(query.changePassword(yenisifre, email)){
             RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Başarılı","Şifreniz Başarıyla Değişti."));
        return "";
         }
         RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Şifre Bilinmeyen bir sebepten değiştirilemedi"));
        return "";
         
       }

        RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Mail Adresiniz ya da Şifreniz yanlış."));
        return "";
   }
   
   public String hesapSil(){
       
     if(query.loginControl(email, eskisifre)){
         if(query.deleteUser(email, eskisifre)){
             FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
             return "index.xhtml?faces-redirect=true";
         }
         RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Kullanıcı Kaydı Silinemedi (1)"));
        return "";
     }
       RequestContext.getCurrentInstance().update("growd");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Kullanıcı Kaydı Silinemedi (2)"));
       return "";
   }

    public String getEskisifre() {
        return eskisifre;
    }

    public void setEskisifre(String eskisifre) {
        this.eskisifre = eskisifre;
    }

    public String getYenisifre() {
        return yenisifre;
    }

    public void setYenisifre(String yenisifre) {
        this.yenisifre = yenisifre;
    }



    
}
