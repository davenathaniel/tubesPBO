/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

/**
 *
 * @author 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public enum StatusBookingEnum {
    BOOKED("BOOKED"), CHECKEDIN("CHECKEDIN"), CHECKEDOUT("CHECKEDOUT"), CANCELLED("CANCELLED");
    
    private final String name;

    private StatusBookingEnum(String s) {
        name = s;
    }
    
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
