/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Avita
 */
public class View extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton=new JButton("Select file to Compress");  // creating a button i JFrame and adding name of the button
        compressButton.addActionListener(this);  //calling actionListener which will further invoke actionPerfomred method to do the job of the button 
        compressButton.setBounds(20, 100, 200, 30); //setting the positioning in frame and size of the button
        
        decompressButton=new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);  //this refers all the contents inside View,JFrame ,ActionListener
        decompressButton.setBounds(250, 100, 200, 30);
        
        this.add(compressButton);  //earlier created the button , now adding the button to JFrame
        this.add(decompressButton);
        
        this.getContentPane().setBackground(Color.ORANGE); //Setting the background of JFrame
        this.setSize(500, 300);  //Setting the size of the JFrame
        
         }

    @Override  //we can skip writing override ,written bcz actionPerformed method is overriding some other method which might be present in JFrame & ActnLtnr interface  
            //this doesnt have any implementation it belongs to ActionListener interface
                          
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource() ==compressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                try{
                    Compress.method(file);
              }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
              }
            }
        }
        
        if(e.getSource()==decompressButton)
        {
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                try{
                    Decompress.method(file);
              }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
              }
            }
        }
    }
    
    public static void main(String[] args){
        View view =new View();
         view.setVisible(true);  // getting the Jframe visible 
    }
}
