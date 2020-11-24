/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckController;
import static controller.DataController.getPersonByID;
import static controller.DataController.listCabangHotel;
import static controller.DataController.listJenisPembayaran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Person;
import model.Room;
import model.TransaksiManager;
import model.enums.StatusBookingEnum;

/**
 *
 * @author 
 * 1119001 Dave Nathaniel K
 * 1119035 Maria Vabiolla V
 * 1119043 Tridia Enjeliani S M
 */
public class CheckOutPopUp implements ActionListener {
    JFrame checkInPopUpFrame = new JFrame("CheckOut Pop Up");
    JLabel title, labelHotel,labelTransaksi, labelTanggalBooking, labelPerson, labelTelepon, labelJenisKamar, labelNoKamar, labelTanggalCheckIn, labelTanggalCheckOut,
            labelJenisPembayaran, labelTotalBayar;
    Person person = getPersonByID(TransaksiManager.getInstance().getTransaction().getIdPerson());
    Room room = CheckController.getDataRoom(TransaksiManager.getInstance().getTransaction().getIdHotel(), TransaksiManager.getInstance().getTransaction().getNo_Kamar());
    JButton cancelButton, confirmButton;
    
    public CheckOutPopUp(){
        checkInPopUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        checkInPopUpFrame.setSize(520, 700);
        checkInPopUpFrame.getContentPane().setBackground(StyleSheet.colorPopUp);
        
        title = new JLabel("Check-Out Data Confirmation", JLabel.CENTER);
        title.setBounds(0, 0,520,40);
        title.setFont(StyleSheet.buttonFont);
        
        labelHotel = new JLabel(listCabangHotel.get(TransaksiManager.getInstance().getTransaction().getIdHotel()-1).getNamaHotel(),JLabel.CENTER);
        labelHotel.setBounds(0,50,520,30);
        labelHotel.setFont(StyleSheet.formFont);
        
        labelTransaksi = new JLabel("ID TRANSAKSI       : " + TransaksiManager.getInstance().getTransaction().getIdTransaksi());
        labelTransaksi.setBounds(20,90,300,30);
        labelTransaksi.setFont(StyleSheet.formFont);
        
        labelTanggalBooking = new JLabel("Tanggal Booking      : "+TransaksiManager.getInstance().getTransaction().getTanggal_Booking());
        labelTanggalBooking.setBounds(20,130,300,30);
        labelTanggalBooking.setFont(StyleSheet.formFont);
        
        labelTanggalCheckIn = new JLabel("Tanggal Check-In     :"+ TransaksiManager.getInstance().getTransaction().getCheckIn());
        labelTanggalCheckIn.setBounds(20,170,300,30);
        labelTanggalCheckIn.setFont(StyleSheet.formFont);
        
        labelTanggalCheckOut = new JLabel("Tanggal Check-Out  :"+ TransaksiManager.getInstance().getTransaction().getCheckOut());
        labelTanggalCheckOut.setBounds(20,210,500,30);
        labelTanggalCheckOut.setFont(StyleSheet.formFont);
        
        labelPerson = new JLabel("Nama Customer      : "+ person.getNama());
        labelPerson.setBounds(20,250,500,30);
        labelPerson.setFont(StyleSheet.formFont);
        
        labelTelepon = new JLabel("No.Telepon             : "+ person.getNoHP());
        labelTelepon.setBounds(20,290,500,30);
        labelTelepon.setFont(StyleSheet.formFont);
        
        labelJenisKamar = new JLabel("Jenis Kamar           : "+ room.getTipeKamar());
        labelJenisKamar.setBounds(20,330,500,30);
        labelJenisKamar.setFont(StyleSheet.formFont);
        
        labelNoKamar = new JLabel("Nomor Kamar         : "+ TransaksiManager.getInstance().getTransaction().getNo_Kamar());
        labelNoKamar.setBounds(20,370,300,30);
        labelNoKamar.setFont(StyleSheet.formFont);
        
        labelJenisPembayaran = new JLabel("Jenis Pembayaran  : "+ listJenisPembayaran.get(TransaksiManager.getInstance().getTransaction().getIdJenisPembayaran()).getJenisPembayaran());
        labelJenisPembayaran.setBounds(20,410,500,30);
        labelJenisPembayaran.setFont(StyleSheet.formFont);
        
        labelTotalBayar = new JLabel("Total bayar             : "+ TransaksiManager.getInstance().getTransaction().HitungTotalBayar());
        labelTotalBayar.setBounds(20,450,500,30);
        labelTotalBayar.setFont(StyleSheet.formFont);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20,500,150,40);
        cancelButton.setBackground(StyleSheet.cancelButtonColor);
        cancelButton.setFont(StyleSheet.formFont);
        cancelButton.addActionListener(this);
        
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(330,500,150,40);
        confirmButton.setFont(StyleSheet.formFont);
        confirmButton.addActionListener(this);
        
        checkInPopUpFrame.add(title);
        checkInPopUpFrame.add(labelHotel);
        checkInPopUpFrame.add(labelTransaksi);
        checkInPopUpFrame.add(labelTanggalBooking);
        checkInPopUpFrame.add(labelTanggalCheckIn);
        checkInPopUpFrame.add(labelTanggalCheckOut);
        checkInPopUpFrame.add(labelPerson);
        checkInPopUpFrame.add(labelTelepon);
        checkInPopUpFrame.add(labelJenisKamar);
        checkInPopUpFrame.add(labelNoKamar);
        checkInPopUpFrame.add(labelJenisPembayaran);
        checkInPopUpFrame.add(labelTotalBayar);
        checkInPopUpFrame.add(cancelButton);
        checkInPopUpFrame.add(confirmButton);
        checkInPopUpFrame.setLocationRelativeTo(null);;
        checkInPopUpFrame.setLayout(null);
        checkInPopUpFrame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonClick = e.getActionCommand();
        switch(buttonClick){
            case "Confirm":
                if(TransaksiManager.getInstance().getTransaction().getStatus().equals(StatusBookingEnum.CHECKEDIN) && CheckController.updateCheckOut(TransaksiManager.getInstance().getTransaction().getIdTransaksi())){
                    TransaksiManager.getInstance().getTransaction().setStatus(StatusBookingEnum.CHECKEDOUT);
                    JOptionPane.showMessageDialog(null, "Update Status Success!");
                    checkInPopUpFrame.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Owww Owwwhh Check-Out Failed", "Alert", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Cancel" :
                checkInPopUpFrame.dispose();
                break;
        }
    }
}
