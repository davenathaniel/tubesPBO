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
public class Receptionist extends Person {
    private int idCabang;
    private int salary;
    private int absensi;

    public Receptionist(int idPerson, String username, String password, String nama, String alamat, String noKTP, String noHP, String email, int tipePerson) {
        super(idPerson, username, password, nama, alamat, noKTP, noHP, email, tipePerson);
    }

    public int getIdCabang() {
        return idCabang;
    }

    public int getSalary() {
        return salary;
    }

    public int getAbsensi() {
        return absensi;
    }
    
}