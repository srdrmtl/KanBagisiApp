/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author serdar
 */
@Entity
@Table(name = "bagisci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Bagisci.kanbul", query="SELECT b FROM Bagisci b WHERE b.sehir= :sehir AND b.kanGrubu= :kanGrubu"),
    @NamedQuery(name="Bagisci.Login", query="SELECT b FROM Bagisci b WHERE b.mail= :mail AND b.password= :password"),
    @NamedQuery(name = "Bagisci.findAll", query = "SELECT b FROM Bagisci b")
    , @NamedQuery(name = "Bagisci.findById", query = "SELECT b FROM Bagisci b WHERE b.id = :id")
    , @NamedQuery(name = "Bagisci.findByAd", query = "SELECT b FROM Bagisci b WHERE b.ad = :ad")
    , @NamedQuery(name = "Bagisci.findBySoyad", query = "SELECT b FROM Bagisci b WHERE b.soyad = :soyad")
    , @NamedQuery(name = "Bagisci.findByMail", query = "SELECT b FROM Bagisci b WHERE b.mail = :mail")
    , @NamedQuery(name = "Bagisci.findByAdres", query = "SELECT b FROM Bagisci b WHERE b.adres = :adres")
    , @NamedQuery(name = "Bagisci.findByTelefon", query = "SELECT b FROM Bagisci b WHERE b.telefon = :telefon")
    , @NamedQuery(name = "Bagisci.findByKanGrubu", query = "SELECT b FROM Bagisci b WHERE b.kanGrubu = :kanGrubu")
    , @NamedQuery(name = "Bagisci.findByPassword", query = "SELECT b FROM Bagisci b WHERE b.password = :password")
    , @NamedQuery(name = "Bagisci.findBySehir", query = "SELECT b FROM Bagisci b WHERE b.sehir = :sehir")
    , @NamedQuery(name = "Bagisci.findByHide", query = "SELECT b FROM Bagisci b WHERE b.hide = :hide")})
public class Bagisci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ad")
    private String ad;
    @Size(max = 255)
    @Column(name = "soyad")
    private String soyad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mail")
    private String mail;
    @Size(max = 255)
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 255)
    @Column(name = "kan_grubu")
    private String kanGrubu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "sehir")
    private String sehir;
    @Column(name = "hide")
    private Boolean hide;

    public Bagisci() {
    }

    public Bagisci(Integer id) {
        this.id = id;
    }

    public Bagisci(Integer id, String mail, String telefon, String password) {
        this.id = id;
        this.mail = mail;
        this.telefon = telefon;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bagisci)) {
            return false;
        }
        Bagisci other = (Bagisci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Bagisci[ id=" + id + " ]";
    }
    
}
