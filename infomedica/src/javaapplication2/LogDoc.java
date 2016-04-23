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
import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author super_000
 * 
 */
public class LogDoc extends JDialog{
    private   Calendar tempo;
    private   DateFormat formatotempo;
   
    private JLabel docspec;
    private JPanel inizio;
    private JLabel docname;
    private JLabel doccogn;
    private File file;
    private JLabel labass;
    private DOTTORE DOC;
    private int anno;
    private int mese;
    private int giorno;
    private int ora;
    private Lab Lab;
    private JTable TabPaz;
    private TableModel Mode;
    private JScrollPane scrollpane;
    private JButton insPaz;
    
    
    
  public  LogDoc(String A){
    
        setTitle(A);
        setBounds(350, 10, 700, 400);
        DOC=checkdoc(A);
        //QUando chiudo riapro la finestra autenticator
        this.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        Frame[] frame;
            frame=Frame.getFrames();	
            
            frame[0].setVisible(true);
      }});
      
        Lab=getlab(DOC.getLab());
        inizio = new JPanel();
        inizio.setLayout(null);
        inizio.setBounds(0,0,700,700);
      getContentPane().add(inizio);
        inizio.setVisible(true);
        docname=new JLabel();
        doccogn=new JLabel();
        labass=new JLabel();
        docspec=new JLabel();
        docname.setBounds(10,10,150,25);
        docname.setText("Nome:"+" "+DOC.getNome());
        doccogn.setBounds(130,10,150,25);
        doccogn.setText("Cognome:"+" "+DOC.getCognome());
        labass.setBounds(470,10,250,25);
        labass.setText("LaboratorioAssegnato:"+" "+DOC.getLab());
        docspec.setBounds(270,10,150,25);
        docspec.setText("Specializzazione:"+" "+DOC.getSpec());
        inizio.add(docname);
        inizio.add(doccogn);
        inizio.add(labass);
        inizio.add(docspec); 
        Object data[][]={
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"aaa","bbb","CCC","DDD"},
            {"fff","eee","ppp","fll"}
        
        
        };
        String col_names[]={"AAAA",",,","ppP","èèèé"};
        Mode=new AbstractTableModel(){
            @Override
            public int getColumnCount(){return col_names.length;};
            @Override
            public int getRowCount(){return data.length;};
            @Override
            public Object getValueAt (int row,int col){return data[row][col];};
            @Override
            public  String getColumnName(int column){return col_names[column];	};
             @Override
             public Class<?> getColumnClass(int column)
             {
                 return getValueAt(0,column).getClass();
             }
          
          };
        TabPaz=new JTable(Mode);  
        TabPaz.setAutoCreateRowSorter(true);
        TabPaz.setVisible(true);
        TabPaz.setBounds(10,50,650,150);
        scrollpane = new JScrollPane(); 
        scrollpane.setViewportView(TabPaz);
        scrollpane.setBounds(10,50,650,150);
        inizio.add(scrollpane);
        insPaz=new JButton("Aggiungi Paziente");
        inizio.add(insPaz);
        insPaz.setVisible(true);
        insPaz.setBounds(10,250,200,80);
        tempo=Calendar.getInstance();
        System.out.println(tempo.getTime());
        System.out.println(tempo.get(Calendar.DAY_OF_MONTH));
        
        
      
       
       
      
        
        
        
        
        
    }
    
  
    
    
    public  DOTTORE checkdoc (String user)
{
    file=new File("Dottori.txt");
    
    FileInputStream fis ;
    ArrayList<DOTTORE> listDoc=new ArrayList<DOTTORE>();

		
		try {		
                        fis= new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			fis = new FileInputStream(file);

			
		       listDoc=(ArrayList<DOTTORE>) ois.readObject();
                       
			Iterator<DOTTORE> it= listDoc.iterator();
			DOTTORE temporaneo;
			 
			while(it.hasNext()){
                           
				temporaneo=it.next();
				if(temporaneo.getUsername().equalsIgnoreCase(user)){
					
                                        
					return temporaneo;
				}
				
                         
			}
                        
                        
			
                }catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}
               		
    
    
    DOTTORE temporaneo;
   temporaneo=new DOTTORE("NULL","NULL","NULL","NULL","NULL");
   return temporaneo;
  } 
    
    public  Lab getlab(String labass){
       File  file=new File("Laboratori.txt");
    
    FileInputStream fis ;
    ArrayList<Lab> listLab=new ArrayList<Lab>();

		
		try {		
                        fis= new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			fis = new FileInputStream(file);

			
		       listLab=(ArrayList<Lab>) ois.readObject();
                       
			Iterator<Lab> it= listLab.iterator();
			Lab temporaneo;
			 
			while(it.hasNext()){
                           
				temporaneo=it.next();
				if(temporaneo.getnome().equalsIgnoreCase(labass)){
					
                                        
					return temporaneo;
				}
				
                         
			}
                        
                        
			
                }catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
		}
               		
    
    
    Lab temporaneo;
   temporaneo=new Lab(-1);
   return temporaneo;
  } 
    
    
    public void getocc()
    {
        if (Lab.getAnno(0)!=-1)
        {
                   
        }
    
    }
}


