/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class SplashClass extends javax.swing.JFrame {
    public static void main (String[] args){
        Loader1 sp = new Loader1();
        sp.setVisible(true);
        try{
            for (int i=0; i<=100; i++){
                Thread.sleep(70);
                sp.LoadingValue.setText(i + "%");
                LoginPage lp = new LoginPage();
                
                if(i == 0){
                sp.LoadingName.setText("Turning on Modules...");
                }
                if(i == 20){
                sp.LoadingName.setText("Loading on Modules...");
                }
                if(i == 35){
                sp.LoadingName.setText("Connecting to Database...");
                }
                if(i == 60){
                sp.LoadingName.setText("Connection Successful...");
                }
                if(i == 70){
                sp.LoadingName.setText("Launching Application...");
                }
                
                sp.LoadingBar.setValue(i);
                
                if(i == 100){
                    sp.setVisible(false);
                    lp.setVisible(true);
                   
                }
                
            }
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
    
}
