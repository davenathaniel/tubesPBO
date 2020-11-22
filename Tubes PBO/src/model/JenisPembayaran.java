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
public class JenisPembayaran {
    private int idJenisPembayaran;
    private String jenisPembayaran;
    
    public JenisPembayaran(){
        
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public JenisPembayaran(int idJenisPembayaran, String jenisPembayaran) {
        this.idJenisPembayaran = idJenisPembayaran;
        this.jenisPembayaran = jenisPembayaran;
    }

    public int getIdJenisPembayaran() {
        return idJenisPembayaran;
    }

    public void setIdJenisPembayaran(int idJenisPembayaran) {
        this.idJenisPembayaran = idJenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }
    
    
}
