/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Person {
    private int idPerson;
    private String username;
    private String password;
    private String nama;
    private String alamat;
    private String noKTP;
    private String noHP;
    private String email;
    private int tipePerson;
    
    public Person(){}
    
    public Person(int idPerson, String username, String password, String nama, String alamat, String noKTP, String noHP, String email, int tipePerson) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.noKTP = noKTP;
        this.noHP = noHP;
        this.email = email;
        this.tipePerson = tipePerson;
    }    

    public int getIdPerson() {
        return idPerson;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getEmail() {
        return email;
    }

    public int getTipePerson() {
        return tipePerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipePerson(int tipePerson) {
        this.tipePerson = tipePerson;
    }
    
    
}