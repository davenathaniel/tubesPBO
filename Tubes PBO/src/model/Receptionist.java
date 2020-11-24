/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.enums.TipePersonEnum;

/**
 *
 * @author
 * 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 * 
 */
public class Receptionist extends Person {
    private int idCabang;
    private int salary;
    
    public Receptionist(){
        
    }

    public Receptionist(int idCabang, int salary, int idPerson, String username, String password, String nama, String alamat, String noKTP, String noHP, String email, TipePersonEnum tipePerson) {
        super(idPerson, username, password, nama, alamat, noKTP, noHP, email, tipePerson);
        this.idCabang = idCabang;
        this.salary = salary;
    }
    
    public Receptionist(int idCabang, int salary, String username, String password, String nama, String alamat, String noKTP, String noHP, String email, TipePersonEnum tipePerson) {
        super(username, password, nama, alamat, noKTP, noHP, email, tipePerson);
        this.idCabang = idCabang;
        this.salary = salary;
    }
    
    public Receptionist(int idCabang, int salary){
        this.idCabang = idCabang;
        this.salary = salary;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public int getSalary() {
        return salary;
    }  
}