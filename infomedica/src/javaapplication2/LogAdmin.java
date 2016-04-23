/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing. JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

/**
 *
 * @author super_000
 */
public class LogAdmin extends JDialog 
{

    private JComboBox selectLab;
    private JComboBox selectLab1;
    private JLabel feedbackcompletamento;
    private String[]allLab;
    private JMenu Aggiungi;
	private JMenu Home;
    @SuppressWarnings("unused")
//	private Amministratore admin;
   private final  JPanel DocPan;
    private JTextField docpassword;
    private JTextField docnome;
    private JTextField doccognome;
    private JTextField docusername;
    private JTextField docspec;
    private JLabel asterisconome;
    private JLabel asteriscocognome;
    
    private JLabel asteriscopassword;
    private JLabel asteriscousername;
    private JLabel feedbackinserimento;
    private JButton buttondottore;
    
    private DOTTORE dottore;
    private JPanel inizio;
    private JMenuItem itemDottore;
    private JMenuItem itemLaboratorio;
    private JMenuBar menuBar;
    private File file;
    private Login login;
    private JButton Aggiungilab;
    private JButton Modificalab;
    private JButton Rimuovilab;
    private JPanel lab1;
    private JPanel labagg;
    private JPanel labmod;
    private JPanel labelim;
    private JLabel oplab;
    private JLabel namelab;
    private JLabel labdesc;
    private JLabel typelab;
    private JLabel txtlab;  
    private JTextField nomelab;
    private JTextField desclab;
    private JTextField tipolab;
    
    private JLabel oplab1;
    private JLabel namelab1;
    private JLabel labdesc1;
    private JLabel typelab1;
    private JLabel txtlab1;  
    private JTextField nomelab1;
    private JTextField desclab1;
    private JTextField tipolab1;
    
    private JLabel feedback1inserimento;
    private JButton buttonagglab;
    private JButton buttonmodlab;
    private JButton buttonelilab;
    private Lab lab;
    
  
    private JComboBox labop;
    private JComboBox labop1;
   
   
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private FileOutputStream fos;

    private JLabel asterisco1nome;


    private final JLabel Damiano;
     public LogAdmin()
    {
        setTitle("Administrator");
                getlab();
		setBounds(150, 150, 406, 356);
                inizio = new JPanel();
                inizio.setLayout(null);
                inizio.setBounds(0,0,406,356);
                getContentPane().add(inizio);
                inizio.setVisible(true);
                menuBar = new JMenuBar();
                Damiano= new JLabel("Prego utilizzare menu sovrastante per lavorare");
                Damiano.setBounds(0, 0, 280, 282);
                inizio.add(Damiano);
                setJMenuBar(menuBar);
                Home = new JMenu("Home");
		menuBar.add(Home);
                Aggiungi=new JMenu("Aggiungi");
                Home.add(Aggiungi);
                itemDottore= new JMenuItem("Dottore");
                itemLaboratorio= new JMenuItem("Laboratorio");        
                Aggiungi.add(itemDottore);
                Aggiungi.add(itemLaboratorio);  
                JMenuItem Exit = new JMenuItem("Exit");
               
                this.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e){
                        Frame[] frame;
            frame=Frame.getFrames();	
            frame[1].setVisible(false);
                    frame[0].setVisible(true);
                    }
                    
                });
                    
                
		  Exit.addActionListener(new ActionListener()
                        {@Override
			
                public void actionPerformed(ActionEvent e) {
				Frame[] frame;
            frame=Frame.getFrames();	
            frame[1].setVisible(false);
                    frame[0].setVisible(true);// il numero di frame è dato dall'ordine di apertura
			}
		});
                	
                Home.add(Exit);
                //Aggiunta Dottore
                DocPan= new JPanel();
                DocPan.setLayout(null);
                DocPan.setBounds(0,0,406,356);
                 getContentPane().add(DocPan);
               
                DocPan.setVisible(false);//tutti i tasti che userò in dottorepanel
                JLabel DOCNOME=new JLabel("Nome:");
                JLabel DOCCOGNOME=new JLabel("Cognome:");
                JLabel DOCUSERNAME=new JLabel("Username:");
                JLabel DOCPASSWORD=new JLabel("Password:");
                JLabel DOCLAB=new JLabel("LaboratorioAssociato:");
                JLabel DOCSPEC=new JLabel("Specialistica");
                DOCNOME.setBounds(10,10,70,15);
                DOCCOGNOME.setBounds(10,30,80,15);
                DOCUSERNAME.setBounds(10,50,80,15);
                DOCPASSWORD.setBounds(10,70,80,15);
                DOCLAB.setBounds(10,110,160,15);
                DOCSPEC.setBounds(10,90,110,15);
                docnome= new JTextField("");
                doccognome= new JTextField("");
                docusername= new JTextField("");
                docpassword=new JTextField("");
                JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 110, 190, 20);
                comboBox.setModel(new DefaultComboBoxModel( allLab));
		 // la STRING DEVO AVERLE DAL DATABASE LABORATORIO
                 
		
                docspec=new JTextField("");
                docnome.setBounds(180,10,190,20);
                doccognome.setBounds(180,30,190,20);
                docusername.setBounds(180,50,190,20);
                docpassword.setBounds(180,70,190,20);
                docspec.setBounds(180,90,190,20);
                DocPan.add(comboBox);
                DocPan.add(docnome);
                DocPan.add(doccognome);
                DocPan.add(docusername);
                DocPan.add(docpassword);
                DocPan.add(docspec);
                DocPan.add(DOCNOME);
                DocPan.add(DOCCOGNOME);
                DocPan.add(DOCUSERNAME);
                DocPan.add(DOCPASSWORD);
                DocPan.add(DOCLAB);
                DocPan.add(DOCSPEC);
                feedbackinserimento = new JLabel("");
		feedbackinserimento.setBounds(10, 152, 196, 14);
		DocPan.add(feedbackinserimento);
                feedbackinserimento.setText("Alcuni dati non sono stati inseriti");
                feedbackcompletamento=new JLabel("");
                feedbackcompletamento.setBounds(10,152,250,14);
                inizio.add(feedbackcompletamento);
                feedbackcompletamento.setVisible(false);
                
		feedbackcompletamento.setForeground(Color.BLUE);
               
		feedbackinserimento.setForeground(Color.RED);
		feedbackinserimento.setVisible(false);
		asterisconome = new JLabel("");
                
                
		asterisconome.setBounds(380, 10, 8, 14);
		
               
		asteriscocognome = new JLabel("");
		asteriscocognome.setBounds(380, 30, 8, 14);
		
		asteriscousername = new JLabel("");
		asteriscousername.setBounds(380, 50, 8, 14);
		
		
		asteriscopassword = new JLabel("");
		asteriscopassword.setBounds(380, 70, 8, 14);
		DocPan.add(asteriscocognome);
		DocPan.add(asterisconome);
		DocPan.add(asteriscousername);
		DocPan.add(asteriscopassword);
                 
                itemDottore.addActionListener(new ActionListener(){
                @Override
            
            public void actionPerformed(ActionEvent e){ 
                
                inizio.setVisible(false);
                lab1.setVisible(false);
                labmod.setVisible(false);
                labagg.setVisible(false);
                labelim.setVisible(false);
                getlab();
                 comboBox.setModel(new DefaultComboBoxModel( allLab));
                 DocPan.setVisible(true);
                
            }
            
        
        });
                buttondottore=new JButton("Inserisci");
                buttondottore.setBounds(250,150,110,40);
                DocPan.add(buttondottore);
                buttondottore.addKeyListener(new KeyAdapter(){
                 public void KeyPressed(KeyEvent arg0){
                    
                     if (Daticorretti()){
                        feedbackinserimento.setVisible(false);
                        if( InserimentoDottore(docusername.getText(),docpassword.getText(),"1")!=0)
                        {
                            dottore=new DOTTORE(docnome.getText(),doccognome.getText(),(String)comboBox.getSelectedItem(),docusername.getText(),docspec.getText());
				
				//DOTTORE dottore= new Dottore(nome.getText(),cognome.getText(),(String)comboBox.getSelectedItem(),username.getText());
				ArrayList<DOTTORE> lista=new ArrayList<DOTTORE>();
                
				File file=new File("Dottori.txt");
                                    if(!(file.exists())){
                                                try {
						file.createNewFile();
                                                } catch (IOException e1) {
						
						e1.printStackTrace();
                                                }
                                            }
                                    if(file.length()==0){
                                        lista.add(dottore);
		
                                        FileOutputStream fos;
                                    try {
			
                                    fos = new FileOutputStream(file);
                                    ObjectOutputStream oos= new ObjectOutputStream(fos);
                                      oos.writeObject(lista); 
				
                                    } catch (FileNotFoundException e1) {
				
                                        e1.printStackTrace();
                                    }
                                       catch (IOException e2) {
                                        e2.printStackTrace();
                                     }
	                        }
				else{ //si avvia quando esiste il file
				       try{			
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<DOTTORE>)ois.readObject();
                                        lista.add(dottore);
                                        FileOutputStream fos=new FileOutputStream(file);
                                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                                        oos.writeObject(lista);             
				
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
                                        }
				DocPan.setVisible(false);
                                feedbackcompletamento.setText("Inserimento avvenuto con successo.");
                                 inizio.setVisible(true);
                                 feedbackcompletamento.setVisible(true);
                               
                                docnome= new JTextField("");
                                doccognome= new JTextField("");
                                docusername= new JTextField("");
                                docpassword=new JTextField("");
                                comboBox.setModel(new DefaultComboBoxModel(allLab));
                                docspec=new JTextField("");
                                 
				
                        }
                    }
				
				
					
                        
                    
                   
                        
                        
                        
                        
                        
                        
                    
                    
                 
                    
                    else
                        feedbackinserimento.setVisible(true);
                 
                 }
                });
                buttondottore.addActionListener(new ActionListener() {
                    @Override
	    	public void actionPerformed(ActionEvent e) {   
                    if (Daticorretti()){
                        feedbackinserimento.setVisible(false);
                        if( InserimentoDottore(docusername.getText(),docpassword.getText(),"1")!=0)
                        {
                            dottore=new DOTTORE(docnome.getText(),doccognome.getText(),(String)comboBox.getSelectedItem(),docusername.getText(),docspec.getText());
				
				//DOTTORE dottore= new Dottore(nome.getText(),cognome.getText(),(String)comboBox.getSelectedItem(),username.getText());
				ArrayList<DOTTORE> lista=new ArrayList<DOTTORE>();
                
				File file=new File("Dottori.txt");
                                    if(!(file.exists())){
                                                try {
						file.createNewFile();
                                                } catch (IOException e1) {
						
						e1.printStackTrace();
                                                }
                                            }
                                    if(file.length()==0){
                                        lista.add(dottore);
		
                                        FileOutputStream fos;
                                    try {
			
                                    fos = new FileOutputStream(file);
                                    ObjectOutputStream oos= new ObjectOutputStream(fos);
                                      oos.writeObject(lista); 
				
                                    } catch (FileNotFoundException e1) {
				
                                        e1.printStackTrace();
                                    }
                                       catch (IOException e2) {
                                        e2.printStackTrace();
                                     }
	                        }
				else{ //si avvia quando esiste il file
				       try{			
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<DOTTORE>)ois.readObject();
                                        lista.add(dottore);
                                        FileOutputStream fos=new FileOutputStream(file);
                                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                                        oos.writeObject(lista);             
				
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
                                        }
				DocPan.setVisible(false);
                                 inizio.setVisible(true);
                                 feedbackcompletamento.setText("Inserimento avvenuto con successo.");
                               
                                 feedbackcompletamento.setVisible(true);
                                     
                                docnome.setText("");
                                doccognome.setText("");
                                docusername.setText("");
                                docpassword.setText("");
                                comboBox.setModel(new DefaultComboBoxModel( allLab));
                                docspec.setText("");
                                 
				
                        }
                    }
				
				
					
                        
                    
                   
                        
                        
                        
                        
                        
                        
                    
                    
                 
                    
                    else
                        feedbackinserimento.setVisible(true);
                }
                 });
                //FINE DOTTORE INIZIO LAB
                
                itemLaboratorio.addActionListener(new ActionListener(){
                @Override
            
                public void actionPerformed(ActionEvent e){ 
                inizio.setVisible(false);
                lab1.setVisible(true);
                DocPan.setVisible(false);
                labmod.setVisible(false);
                labagg.setVisible(false);
                labelim.setVisible(false);
                
                    }
                });
                lab1= new JPanel();
                lab1.setLayout(null);
                lab1.setBounds(0,0,406,356);
                getContentPane().add(lab1);
                lab1.setVisible(false);
                txtlab=new JLabel("Gestione Laboratori");
                txtlab.setBounds(130,10,150,150);
                Aggiungilab=new JButton("Aggiungi");
                Modificalab=new JButton("Modifica");
                Rimuovilab=new JButton("Rimuovi");
                Aggiungilab.setBounds(10,120,100,50);
                Modificalab.setBounds(140,120,100,50);
                Rimuovilab.setBounds(270,120,100,50);
                lab1.add(txtlab);
                lab1.add(Aggiungilab);
                lab1.add(Modificalab);
                lab1.add(Rimuovilab);
                labagg=new JPanel();
                labmod=new JPanel ();
                labelim=new JPanel();
                labagg.setLayout(null);
                labagg.setBounds(0,0,406,356);
                getContentPane().add(labagg);
                labagg.setVisible(false);
                labmod.setLayout(null);
                labmod.setBounds(0,0,406,356);
                labmod.setVisible(false);
                getContentPane().add(labmod);
                labelim.setVisible(false);
                labelim.setLayout(null);
                labelim.setBounds(0,0,406,356);
                getContentPane().add(labelim);
                labop=new JComboBox();
                
		labop.setModel(new DefaultComboBoxModel(new String[] {"Si","No"}));
                nomelab=new JTextField();
                tipolab=new JTextField();
                desclab=new JTextField();
                namelab=new JLabel("NomeLaboratorio:");
                typelab=new JLabel("TipoDiLaboratorio:");
                labdesc=new JLabel ("Descrizione Laboratorio:");
                oplab=new JLabel ("Laboratorio Operativo :");
                feedback1inserimento=new JLabel("");
                feedback1inserimento.setBounds(10,120,196,14);
                labagg.add(feedback1inserimento);
                feedback1inserimento.setForeground(Color.RED);
                feedback1inserimento.setVisible(false);
                labagg.add(nomelab);
                labagg.add(tipolab);
                labagg.add(desclab);
                labagg.add(typelab);
                labagg.add(namelab);
                labagg.add(labdesc);
                labagg.add(oplab);
                labagg.add(labop);
                nomelab.setBounds(150,30,100,20);
                tipolab.setBounds(150,50,100,20);
                desclab.setBounds(150,90,200,20);
                namelab.setBounds(10,30,110,20);
                typelab.setBounds(10,50,110,20);
                labdesc.setBounds(10,90,150,20);
                oplab.setBounds(10,70,150,20);
                labop.setBounds(180,70, 50, 20); 
                asterisco1nome=new JLabel("");       
                asterisco1nome.setVisible(false);
               
                asterisco1nome.setBounds(260,30,10,10);
                labagg.add(asterisco1nome);
                buttonagglab=new JButton("Aggiungi");
                buttonagglab.setVisible(true);
                buttonagglab.setBounds(130,150,100,100);
                labagg.add(buttonagglab);
                selectLab=new JComboBox();
                selectLab.setModel(new DefaultComboBoxModel(allLab));
                selectLab.setBounds(10,10,150,20);
                selectLab.setVisible(true);

                labmod.add(selectLab);
    
                labop1=new JComboBox();
                
		labop1.setModel(new DefaultComboBoxModel(new String[] {"Si","No"}));
                nomelab1=new JTextField();
                tipolab1=new JTextField();
                desclab1=new JTextField();
                
                namelab1=new JLabel("NomeLaboratorio:");
                typelab1=new JLabel("TipoDiLaboratorio:");
                labdesc1=new JLabel ("Descrizione Laboratorio:");
                oplab1=new JLabel ("Laboratorio Operativo :");
                labmod.add(nomelab1);
                labmod.add(tipolab1);
                labmod.add(desclab1);
                labmod.add(typelab1);
                labmod.add(namelab1);
                labmod.add(labdesc1);
                labmod.add(oplab1);
                labmod.add(labop1);
                nomelab1.setBounds(150,30,100,20);
                tipolab1.setBounds(150,50,100,20);
                desclab1.setBounds(150,90,200,20);
                namelab1.setBounds(10,30,110,20);
                typelab1.setBounds(10,50,110,20);
                labdesc1.setBounds(10,90,200,20);
                oplab1.setBounds(10,70,150,20);
                labop1.setBounds(180,70, 50, 20); 
                buttonmodlab=new JButton("Modifica");
                buttonelilab=new JButton("Elimina");
                
                buttonmodlab.setBounds(130,150,100,100);
             
                buttonelilab.setBounds(130,150,100,100);
                    
                
                
                
                
                
                Aggiungilab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                     
                       inizio.setVisible(false);
                       lab1.setVisible(false);
                       labagg.setVisible(true);
                       labmod.setVisible(false);
                       
                }
                        
                        
                 });
                Modificalab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                       getlab();
                       selectLab.setModel(new DefaultComboBoxModel( allLab));
                       inizio.setVisible(false);
                       lab1.setVisible(false);
                       labmod.setVisible(true);
                       labagg.setVisible(false);
                       labmod.remove(buttonelilab);
                       labmod.add(buttonmodlab); 
                      
                        buttonmodlab.setVisible(true);
                }
                        
                        
                 });
                Rimuovilab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                    getlab();
                    selectLab.setModel(new DefaultComboBoxModel( allLab));
                       inizio.setVisible(false);
                       lab1.setVisible(false);
                       labmod.add(buttonelilab);
                       labmod.remove(buttonmodlab);
                      buttonelilab.setVisible(true);
                       labmod.setVisible(true);
                       labagg.setVisible(false);
                       
                }
                        
                        
                 });
                 buttonagglab.addActionListener(new ActionListener() {
                    @Override
	    	public void actionPerformed(ActionEvent e)
               {
                    feedback1inserimento.setVisible(false);
                    lab=new Lab(nomelab.getText(),tipolab.getText(),desclab.getText(),(String)labop.getSelectedItem());
                     
                    if (Labcorretti())
                        {
                            
                            	
			
				ArrayList<Lab> lista=new ArrayList<Lab>();
                             
				File file=new File("Laboratori.txt");
                                 int check=-1;
                                             
                                
                                    if(!(file.exists())){
                                       
                                                try {
						file.createNewFile();
                                                } catch (IOException e1) {
						
						e1.printStackTrace();
                                                }
                                            }
                                    if(file.length()==0){
                                        lista.add(lab);
		
                                        FileOutputStream fos;
                                    try {
			
                                    fos = new FileOutputStream(file);
                                    ObjectOutputStream oos= new ObjectOutputStream(fos);
                                      oos.writeObject(lista);
                                        labagg.setVisible(false);
                                         inizio.setVisible(true);
                                        nomelab.setText("");
                                         tipolab.setText("");
                                         desclab.setText("");
				
                                    } catch (FileNotFoundException e1) {
				
                                        e1.printStackTrace();
                                    }
                                       catch (IOException e2) {
                                        e2.printStackTrace();
                                     }
	                        }
				else{ //si avvia quando esiste il file
				       try{	
                                          
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<Lab>)ois.readObject();
                                        ArrayList<Lab> controllo=new ArrayList<Lab>();
                                        controllo=lista;
			                 Iterator<Lab> it= controllo.iterator();
			                  Lab temporaneo;
                                        while(it.hasNext()&& check!=0){
				temporaneo=it.next();
				if(temporaneo.getnome().equalsIgnoreCase(lab.getnome())){
					
					feedback1inserimento.setText("Attenzione.Laboratorio gia presente.");
					
					feedback1inserimento.setVisible(true);
					
						
					
					
					check=0;
					
				}
				
			        }
                                        
                                        
                                        
                                        if (check!=0)
                                        
                                        { lista.add(lab);
                                        FileOutputStream fos=new FileOutputStream(file);
                                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                                        oos.writeObject(lista);  
                                        labagg.setVisible(false);
                                         inizio.setVisible(true);
                                        nomelab.setText("");
                                         tipolab.setText("");
                                         desclab.setText("");
                                        }
                                      
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
                                        }
				
                               
                            feedbackcompletamento.setText("Laboratorio aggiunto correttamente");
                            feedbackcompletamento.setVisible(true);   
                        }    
                    else
                        feedbackcompletamento.setVisible(false);
                   
                 
                   getlab();
               }
                });
                  selectLab.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed( ActionEvent e)
                     {
                       JComboBox lol =(JComboBox) e.getSource();
                       Object selected=lol.getSelectedItem();
                         nomelab1.setText("");
                         tipolab1.setText("");
                         desclab1.setText("");
                        
                       ArrayList<Lab> lista=new ArrayList<Lab>();
                       File file=new File("Laboratori.txt");
                                 try{	
                                          
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<Lab>)ois.readObject();
                                        
			                 Iterator<Lab> it= lista.iterator();
			                  Lab temporaneo;
                                          int check=-1;
                                        while(it.hasNext()&& check!=0){
				temporaneo=it.next();
				if(temporaneo.getnome().equalsIgnoreCase(selected.toString())){
					
					nomelab1.setText(temporaneo.getnome());
                                        tipolab1.setText(temporaneo.getTipo());
                                        desclab1.setText(temporaneo.getDescrizione());
                                        oplab1.setText(temporaneo.getOperativo());
					
					
					
						
					
					
					check=0;
					
				}
				
			        }
                                        
                                        
                                       
                                        
                                      
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
                                        }
				
                               
                       
                     
                 });
                 buttonelilab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                       elilab((String)selectLab.getSelectedItem());
                      
                       nomelab1.setText("");
                       tipolab1.setText("");
                       oplab1.setText("");
                       desclab1.setText("");
                       labmod.setVisible(false);
                       inizio.setVisible(true);
                       feedbackcompletamento.setText("Laboratorio eliminato con successo.");
                       feedbackcompletamento.setVisible(true);
                       
                }
                        
                        
                 });
                buttonmodlab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e)
                {
                     modlab((String)selectLab.getSelectedItem());
                      
                      nomelab1.setText("");
                       tipolab1.setText("");
                       oplab1.setText("");
                       desclab1.setText("");
                       labmod.setVisible(false);
                       inizio.setVisible(true);
                       feedbackcompletamento.setText("Modifica effettuata con successo.");
                       feedbackcompletamento.setVisible(true);
                }
                        
                        
                 });
    
    
                
             
            

    

    }
  public boolean Labcorretti()
  {
      boolean temp=true;
      if (nomelab.getText().trim().length()==0)
      {
          asterisco1nome.setText("*");
          asterisco1nome.setForeground(Color.RED);
          asterisco1nome.setVisible(true);
          feedback1inserimento.setText("Inserire il nome prego.");
          feedback1inserimento.setVisible(true);
          temp=false;
          
      }
      else
      asterisco1nome.setVisible(false);
      return temp;
  }
  public boolean Daticorretti(){
			boolean temp=true;
			feedbackinserimento.setText("Alcuni dati non sono stati inseriti");
			if(docnome.getText().trim().length()==0){
			asterisconome.setText("*");	
			asterisconome.setForeground(Color.RED);
			asterisconome.setVisible(true);
			temp=false;
			}
                        else asterisconome.setText("");
			if(doccognome.getText().trim().length()==0){
			
		        asteriscocognome.setText("*");	
			asteriscocognome.setForeground(Color.RED);
			temp=false;
			}else asteriscocognome.setText("");
			
			if(docusername.getText().trim().length()==0){
				asteriscousername.setText("*");	
			asteriscousername.setForeground(Color.RED);
			temp=false;}
                        else asteriscousername.setText("");
			if(docpassword.getText().trim().length()==0){
				asteriscopassword.setText("*");	
			asteriscopassword.setForeground(Color.RED);
			temp=false;
			}
                        else asteriscopassword.setText("");
			return temp;
			
		}
public  int InserimentoDottore(String user,String pass,String mode)
{
    file=new File("Data_access.txt");
    login=new Login( user, pass, mode);
    
    ArrayList<Login> listLogin=new ArrayList<Login>();
    if(file.exists()){int check = -1;
		FileInputStream fis ;
		try {		
			fis= new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			fis = new FileInputStream(file);
		    listLogin=(ArrayList<Login>) ois.readObject();
			Iterator<Login> it= listLogin.iterator();
			Login temporaneo;
			
			while(it.hasNext()&& check!=0){
				temporaneo=it.next();
				if(temporaneo.getUsername().equalsIgnoreCase(login.getUsername())){
					
					feedbackinserimento.setText("Attenzione. Username utilizzato.");
					feedbackinserimento.setForeground(Color.RED);
					feedbackinserimento.setVisible(true);
					
						
					
					
					check=0;
					
				}
				
			}
			if(check!=0){
				listLogin.add(login);
				FileOutputStream fos=new FileOutputStream(file);
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				oos.writeObject(listLogin);
				
					
				feedbackcompletamento.setVisible(true);
                
				
			}
                        
                }catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}
                return check;
		
    
    }
    else{  //Caso in cui il file non esiste e deve essere creato
		try {
			file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			listLogin.add(login);
		    oos.writeObject(listLogin);
			
		} 
                catch (IOException e) {
			e.printStackTrace();
		}
                return 1;
	}
    
		
		
	
}
public void getlab()
{
    File lab;
    lab=new File("Laboratori.txt");
    ArrayList<Lab> listlab=new ArrayList<Lab>();
    
    
    int i=0;
    if (lab.exists())
    {
        try{
            FileInputStream In= new FileInputStream(lab);
        
			ObjectInputStream ois=new ObjectInputStream(In);
			In = new FileInputStream(lab);
		    listlab=(ArrayList<Lab>) ois.readObject();
                       ArrayList<Lab> controllo=listlab;
			Iterator<Lab> it= controllo.iterator();
			Lab temporaneo;
                       
                        
			
			while(it.hasNext()){
				it.next();
          			i++;
                                
                        }
                        
                        Iterator<Lab> il=listlab.iterator();
                        allLab=new String[i];
                        i=0;
                        
                        while(il.hasNext()){
                            
                            temporaneo=il.next();
                             String l=temporaneo.getnome();
                             
                             allLab[i]=l;
                            
                             i++;
                             
                             
                            
                        }
                        
             }
                        
        catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}
		
   


}
      else
     {
             allLab=new String[1];
             allLab[0]=("non c'è nulla");
             }
    

   
}

public void modlab(String nomelab)
{
    lab=new Lab(nomelab1.getText(),tipolab1.getText(),desclab1.getText(),oplab1.getText());
     ArrayList<Lab> lista=new ArrayList<Lab>();
                       File file=new File("Laboratori.txt");
                                 try{	
                                          
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<Lab>)ois.readObject();
                                        ArrayList<Lab> controllo=lista;
                                        
			                 Iterator<Lab> it= controllo.iterator();
			                  Lab temporaneo;
                                          int check=-1;
                                         
                                          
                                        while(it.hasNext()&& check!=0){
				temporaneo=it.next();
				if(temporaneo.getnome().equalsIgnoreCase(nomelab)){
					
				
					lista.remove(lista.indexOf(temporaneo));
                                       
					check=0;
                                        
					
                                               }  }
                                        lista.add(lab);
                                        FileOutputStream fos=new FileOutputStream(file);
                                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                                        oos.writeObject(lista); 
                                        
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
      }
public void elilab(String nomelab)
{
    lab=new Lab(nomelab1.getText(),tipolab1.getText(),desclab1.getText(),oplab1.getText());
     ArrayList<Lab> lista=new ArrayList<Lab>();
                       File file=new File("Laboratori.txt");
                                 try{	
                                          
					FileInputStream fis=new FileInputStream(file);
                                            ObjectInputStream ois=new ObjectInputStream(fis);
                                        lista=(ArrayList<Lab>)ois.readObject();
                                        ArrayList<Lab> controllo=lista;
                                        
			                 Iterator<Lab> it= controllo.iterator();
			                  Lab temporaneo;
                                          int check=-1;
                                          
                                        while(it.hasNext()&& check!=0){
				temporaneo=it.next();
				if(temporaneo.getnome().equalsIgnoreCase(nomelab)){
					
				
					lista.remove(lista.indexOf(temporaneo));
					check=0;
                                        
					
                                               }  }
                                       
                                        FileOutputStream fos=new FileOutputStream(file);
                                        ObjectOutputStream oos=new ObjectOutputStream(fos);
                                        oos.writeObject(lista); 
                                        
                                        }catch(Exception exc){
					exc.printStackTrace();
                                        }
      }
				
                               
                       
                     
                

}
