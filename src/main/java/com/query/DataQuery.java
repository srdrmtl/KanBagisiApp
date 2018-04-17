/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.entity.Bagisci;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;

import javax.persistence.TypedQuery;
/**
 *
 * @author serdar
 */
public class DataQuery {
    
    EntityManagerFactory emf ;
    EntityManager em;

    public DataQuery() {
        emf= Persistence.createEntityManagerFactory("com.staj_KanBagisiUyg_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    
    public boolean loginControl(String mail, String password){
        
        System.out.println("buraya kadarda geldin");
        try {
            Bagisci b = em.createNamedQuery("Bagisci.Login",Bagisci.class)
                    .setParameter("mail", mail)
                    .setParameter("password", password)
                    .getSingleResult();
            System.out.println(b);
            return b != null;
        } catch (Exception e) {
            
            return false;
            
        }
        
    }
    
    public String sifreGonder(String mail){

        
                List<Bagisci> personList = new ArrayList<>();
                String password=null;
        
        try {
            
            TypedQuery<Bagisci> query = em.createNamedQuery("Bagisci.findByMail",Bagisci.class)
                    .setParameter("mail", mail);
                    
                    
            
            personList = query.getResultList();
            for(Bagisci person : personList){
            password=person.getPassword();
        }
            System.out.println(password+"  xdxdxdxd");
            return password;
            
            
            
        } catch (Exception e) {
            
            return null;
        }
        
    }
    
        public boolean mailControl(String mail){
        
        System.out.println("buraya kadarda geldin");
        try {
            Bagisci b = em.createNamedQuery("Bagisci.findByMail",Bagisci.class).setParameter("mail", mail)
                    .getSingleResult();
            
                    
            System.out.println(b);
            return b != null;
        } catch (Exception e) {
            
            return false;
            
        }
        
    }
    

    
    public boolean changePassword(String sifre,String mail){
        System.out.println("4");
        try {
         Query query = em.createQuery("UPDATE Bagisci SET  password= :p WHERE mail=:m");
         query.setParameter("p", sifre);
         query.setParameter("m",mail);
         
         query.executeUpdate();
         
         return true;
         
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteUser(String mail,String sifre){
        
        try {
            Query query = em.createQuery("UPDATE Bagisci SET hide= :h WHERE mail = :m AND password= :p");
            query.setParameter("h", true);
            query.setParameter("m", mail);
            query.setParameter("p",sifre);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean registerControl(String ad,String soyad,String mail,String adres,String kanGrubu,String password,String sehir,String telefon){
        
        
        try {
           
        
            
           


            Bagisci b = new Bagisci();

            b.setAd(ad);
            b.setSoyad(soyad);
            b.setMail(mail);
            b.setTelefon(telefon);
            b.setAdres(adres);
            b.setKanGrubu(kanGrubu);
            b.setPassword(password);
            b.setSehir(sehir);
           
           em.persist(b);
           em.getTransaction().commit();

            
            return true;
            
        } catch (Exception e) {
            
            return false;
        }
        
    }
    
    public List<Bagisci> userControl(String mail){
        
        List<Bagisci> person = new ArrayList<>();
        
        try {
            
            TypedQuery<Bagisci> query = em.createNamedQuery("Bagisci.findByMail",Bagisci.class)
                    .setParameter("mail", mail);
            person = query.getResultList();
            return person;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public List<Bagisci> kanGrubuControl(String sehir, String kanGrubu){
        
        
        List<Bagisci> personList = new ArrayList<>();
        
        try {
            
            TypedQuery<Bagisci> query = em.createNamedQuery("Bagisci.kanbul",Bagisci.class)
                    .setParameter("sehir", sehir)
                    .setParameter("kanGrubu",kanGrubu);
                    
            
            personList = query.getResultList();
            
            return personList;
            
            
            
        } catch (Exception e) {
            
            return null;
        }
        
        
    }

    
    
    
}
