/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.enums;

/**
 *
 * @author User
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
