/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Bagisci;
import com.query.DataQuery;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Session;
import org.primefaces.context.RequestContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.internet.AddressException;

/**
 *
 * @author serdar
 */
@SessionScoped
@Named("login")

public class LoginController implements Serializable{
    private String value1="Giriş Yap";
    private String value2="Kayıt Ol";
     List<Bagisci> person = new ArrayList<>();
    private String mail;
    private String password;
    private DataQuery query = new DataQuery();
    private String ad;
    private String soyad;
    private String sehir;
    private String adres;
    private String telefon;
    private String kangrubu;
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKangrubu() {
        return kangrubu;
    }

    public void setKangrubu(String kangrubu) {
        this.kangrubu = kangrubu;
    }

    
    public List<Bagisci> getPerson() {
     
           return person;
    }

    public void setPerson(List<Bagisci> person) {
        this.person = person;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
        public String value1Control(){
        
        if(value1.equals("Giriş Yap")){
            
            System.out.println("Buraya Girdiin");
            
            return "login.xhtml?faces-redirect=true";
        }
        
             value1="Giriş Yap";
             value2="Kayıt Ol";
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "index.xhtml?faces-redirect=true";
        
 
        
      
    }
    

    
    public String value2Control(){
        System.out.println("value2controle girdin.");
         person = query.userControl(mail);
        
        if(value2.equals("Kayıt Ol")){
            return "register.xhtml?faces-redirect=true";
        }
        if(person.isEmpty()){
            return "login.xhtml?faces-redirect=true";
        }
         return "panel.xhtml?faces-redirect=true";
        
    }
    

    public String LoginControl(){
        
       
            System.out.println("Buraya Girdin1");
       if(query.loginControl(mail, password)){
           
           person = query.userControl(mail);
            System.out.println("Buraya Girdin2");
            value1="Çıkış Yap";
            value2="Ayarlar";
            
            return "panel.xhtml?faces-redirect=true";
            
            
            
        }
       
            
        
       
       
        
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Mail Adresiniz ya da Şifreniz yanlış."));
        return "";
    }
    
    public String RegisterControl(){
        
                if(query.mailControl(mail)){
            
        RequestContext.getCurrentInstance().update("growr");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Bu mail adresi daha önce kullanılmış."));
        }
        else if(query.registerControl(ad, soyad, mail, adres, kangrubu, password, sehir, telefon)){
             RequestContext.getCurrentInstance().update("growr");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Başarılı","Kaydınız Başarıyla Tamamlandı."));
        value1="Çıkış Yap";
        value2="Ayarlar";
         person = query.userControl(mail);
        return "panel.xhtml?faces-redirect=true";
        }
        else{
             RequestContext.getCurrentInstance().update("growr");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata","Kayıt Esnasında Bir Hata Oluştu. Lütfen Tekrar Deneyin."));
        }
        return "";
    }
    
    private String posta;

    public String getPosta() {
        return posta;
    }

    public void setPosta(String posta) {
        this.posta = posta;
    }
    
    private String onayyazisi="";

    public String getOnayyazisi() {
        return onayyazisi;
    }

    public void setOnayyazisi(String onayyazisi) {
        this.onayyazisi = onayyazisi;
    }
    
    public String SendMail(){
        String sifre;
        
        sifre=query.sifreGonder(posta);
        
        if(sifre == null){
         onayyazisi="Hata oluştu";
         return "login.xhtml?faces-redirect=true";
        }
        else{
            
        final String username="mail adı";
        final String password="mail şifresi";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host","smtp.egebilgisayar.net");
        prop.put("mail.smtp.port","587");
        

        
        Session sessioObject =Session.getInstance(prop, new javax.mail.Authenticator()
        {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        
        
                try {
        Message messageObjectMessage = new MimeMessage(sessioObject);
        messageObjectMessage.setFrom(new InternetAddress(username));
        messageObjectMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(posta));
        messageObjectMessage.setSubject("Şifreniz:");
        messageObjectMessage.setText(sifre);
        Transport.send(messageObjectMessage);
         onayyazisi="Başarılı";
           return "login.xhtml?faces-redirect=true";
            
        } catch (MessagingException e) {
            System.out.println(e);
             onayyazisi="Hata oluştu";
           return "login.xhtml?faces-redirect=true";
        }
        }
       
        } 

  
        
        
             
    }
    

