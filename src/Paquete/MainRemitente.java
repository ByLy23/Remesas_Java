/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete;

import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import javax.swing.*;

/**
 *
 * @author byron
 */
public class MainRemitente extends JFrame{
    public static Venta[] venta= new Venta[20];
    public static int Contadorventa=0;
    public MainRemitente(){
        inicializarComponentes();
    }

    private void inicializarComponentes(){
        //botones
        realizarRemesa= new JButton("Realizar Remesa");
        realizarRemesa.setBounds(50,20,150,40);
        realizarRemesa.addActionListener(this::realizarRemesaActionPerformed);
        /*----------------------*/
        consultar= new JButton("Consultar");
        consultar.setBounds(215,20,100,40);
        consultar.addActionListener(this::consultarRemesa);
        /*----------------------*/
        cancelarRemesa= new JButton("Cancelar Remesa");
        cancelarRemesa.setBounds(50,80,150,40);
        cancelarRemesa.addActionListener(this::cancelarRemesa);
         /*----------------------*/
         cerrarSesion= new JButton("Cerrar Sesion");
         cerrarSesion.setBounds(215,80,150,40);
         cerrarSesion.addActionListener(this::cerrarSesion);
         //textfiedl
         /*----------------------*/
         usuario= new JTextField();
         usuario.setBounds(100,170,150,40);
         /*-------------------------*/
         dinero= new JTextField();
         dinero.setBounds(100,210,150,40);
         //labels
         Lusuario= new JLabel("Correo");
         Lusuario.setBounds(20,170,100,40);
         /*----------------------*/
         Ldinero= new JLabel("Dinero en $");
         Ldinero.setBounds(20,210,100,40);
        //frame
        this.setSize(400,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle(Sesion.temp[0].getNombre()+" - Sistema de Remesas");
        this.add(realizarRemesa);
        this.add(consultar);
        this.add(usuario);
        this.add(cancelarRemesa);
        this.add(cerrarSesion);
        this.add(Lusuario);
        this.add(dinero);
        this.add(Ldinero);
    }
    private void realizarRemesaActionPerformed(ActionEvent evt){

    }
    private void cancelarRemesa(ActionEvent evt){
        
    }
    private void consultarRemesa(ActionEvent evt){
        
    }
    private void cerrarSesion(ActionEvent evt){
        dispose();
        new Sesion().setVisible(true);
    }
    private void generarnumero(){
         rnd=(int)((Math.random()+1)*20);
        comprobarnumero(venta, rnd, Contadorventa);
    }
    private void comprobarnumero(Venta[] venta,int numeroaleatorio,int limite){
        for (int i = 0; i < limite; i++) {
            if (numeroaleatorio== venta[i].getNumeroRemesa()) {       
                generarnumero();
            }
        }
        continuar=true;
    }
    private void comprobarUser(){
        for (i = 0; i < Registro.ContadorBeneficiario; i++) {
             if (usuario.getText().equals(Registro.remitente[i])) {
            generarRemesa();
        }
             else{
                 JOptionPane.showMessageDialog(null, "Usuario inexistente");
             }
        }
       
    }
    private void generarRemesa(){
        try{
        Monto= Integer.parseInt(dinero.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        if (Monto>6000) {
            JOptionPane.showMessageDialog(null, "No se puede hacer una transaccion tan voluminosa");
        }
        else if(Monto<0){
            System.out.println("");
        }
        else{
            System.out.println("si prro");
            generarnumero();
            if (continuar) {
                venta[Contadorventa]= new Venta(HEIGHT, ICONIFIED, pais, fechaVenta, horaVenta, Monto, NORMAL, continuar, continuar)
            }
        }
    }
    private JButton realizarRemesa;
    private JButton consultar;
    private JButton cancelarRemesa;
    private JButton cerrarSesion;
    private JTextField usuario;
    private JLabel Lusuario;
    private JTextField dinero;
    private JLabel Ldinero;
    private boolean continuar=false;
    private int Monto=-1;
    private int rnd=0;
    private int i=0;
}