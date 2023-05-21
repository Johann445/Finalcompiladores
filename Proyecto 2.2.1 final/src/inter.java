import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;


public class inter extends JFrame
{	
	JMenuBar barra = new JMenuBar();
    	
    JMenu Archivo = new JMenu("Archivo");
    	JMenuItem pg1 = new JMenuItem("Abrir");
    	JMenuItem pg2 = new JMenuItem("Guardar");
    	JMenuItem pg3 = new JMenuItem("Nuevo");
    JMenu Editar = new JMenu("Editar");
		JMenuItem pg4 = new JMenuItem("Seleccionar Color");
	   	ButtonGroup contorno = new ButtonGroup();
    	JRadioButtonMenuItem con = new JRadioButtonMenuItem("Contorno",true);
    	JRadioButtonMenuItem rel = new JRadioButtonMenuItem("Relleno",false);
    JMenu Ver = new JMenu("Ayuda");
    	JMenuItem Acerca = new JMenuItem("Acerca de");
    	JMenuItem Salir = new JMenuItem("Salir");
    JButton linea, circulo, cuadrado, triangulo;
    
    JTabbedPane Fotogramas = new JTabbedPane();
    
    JPanel panel2,panel3,panel;
	static JPanel panel1 = new JPanel();
	static String textodel="",conto = "C",dtglobal="";
	public int x,x1,y,y1,numFig,r,g,b;
	
	PanelDibujo panelobj2 = new PanelDibujo(); 

	static JPanel panel1(JPanel panelobj)
    {
       	panel1.setBounds(0,0,1000,800);
       	panel1.setLayout(null);
       	panelobj.setBounds(0,0,1000,800);
       	panel1.add(panelobj);       	
       	return panel1;
    }
    
    static void obtext2(String dtGLOBAL)
    {
    	dtglobal = (dtglobal+dtGLOBAL);
    }
    static void obtext(String dtGLOBAL)
    {
    	dtglobal = (dtglobal+dtGLOBAL);
    }	    
    	
    public inter() 
    {
    	super("Integracion de Programas");
    	
    	Archivo.add (pg1);
    	pg1.addActionListener(new evento());
    	Archivo.addSeparator();
    //	Archivo.add (pg2);
    //	pg2.addActionListener(new evento());
    //	Archivo.addSeparator();
    	Archivo.add (pg3);
    	pg3.addActionListener(new evento());

        	contorno.add(con);
        	contorno.add(rel);
        	
		
    	
    	Ver.add(Acerca);
    	Acerca.addActionListener(new evento());
    	Ver.addSeparator();
    	
    	barra.add(Archivo);
    	barra.add(Editar);
    	barra.add(Ver);
    	
    	setJMenuBar(barra);
    	
    	panel = (JPanel) this.getContentPane();
    	panel.setLayout(null);
    	panel.setBackground(Color.WHITE);
    	
    	panel2 = new JPanel();
    	panel2.setLayout(null);
    	panel2.setBackground(Color.WHITE);
    	panel2.setBounds (20,115,420,885);
  		Border borde = BorderFactory.createTitledBorder(null, "instrucciones");
    	panel2.setBorder(borde); 
    
    		
        	
    	
    	panel3 = new JPanel();
    	panel3.setLayout(null);
    	panel3.setBackground(Color.WHITE);
    	panel3.setBounds(230, 0, 800, 800);
    		
    	
    		
    	panelobj2.setBounds(0, 0, 800, 800);
    	panelobj2.setLayout(null);
    	
    	Fotogramas.setBounds(20,40,950,620);
    	Fotogramas.addTab("", null, panelobj2, "Primer panel"); 
    		
    	panel.add(Fotogramas);	
    	panel.add(panel2);
    	panel.add(panel3);   	
    }
    
    class evento implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object MI = e.getSource();

			 if(MI == pg1)
			 {
			 	panelobj2.removeAll();
			    panel1.removeAll();
			    panelobj2.repaint();
			    panel1.repaint();
			    dtglobal = ("");
			    Parser in = new Parser();
			    panelobj2.add(panel1);
			    panelobj2.updateUI();
			 }
			 if(MI == pg3)
			 {
			    panelobj2.removeAll();
			    panel1.removeAll();
			    panelobj2.repaint();
			    panel1.repaint();
			    dtglobal = ("");
			 }
			 if(MI == linea)
			 {
			    numFig = 1;
			 }
			 if(MI == triangulo)
			 {
			    numFig = 2;
			 }
			 if(MI == cuadrado)
			 {
			    numFig = 3;
			 }
			 if(MI == circulo)
			 {
			    numFig = 4;
			 }
			 if(MI == Salir)
			 {
			    dispose();
			 }
			  
			 if(MI == pg4)
			 {
			    JColorChooser ventanaDeColores=new JColorChooser();
   				Color color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
   				r = color.getRed();
   				g = color.getGreen();
   				b = color.getBlue();
			 }
			 if(MI == con)
			 {
			    conto="S";
			 }
			 if(MI == rel)
			 {
			    conto="R";
			 }
			 
			 PanelDibujo.figura(numFig,r,g,b,conto);
			 
			 if(MI == pg2)
			 {
			    guardar();
			 }	 	
			 if (MI == Acerca)
			 {
		 		JFrame Acerca= new JFrame ("Acerca del Editor de Textos");
				JTextArea inf = new JTextArea ("\n                                                       ITD RODEO"
												
												+"\n                                      
												+"\n                     "
												
													);
					inf.setEditable(false);
					Acerca.setSize(400,150);
					Acerca.getContentPane().add (inf);
					Acerca.setLocationRelativeTo(null);
					Acerca.setVisible(true);
					Acerca.setResizable(false);
		 		}
		 	}
		 }
		 
		 void guardar()	
		 {
		 	try
 			{
  				String nombre="";
  				JFileChooser file=new JFileChooser(System.getProperty("user.dir"));
  				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "archivo", "archivo");
  				file.setFileFilter(filter);
  				file.showSaveDialog(this);
  				File guarda =file.getSelectedFile();
 
  				if(guarda !=null)
  				{
    				FileWriter  save=new FileWriter(guarda+".archivo");
    				save.write(dtglobal);
    				save.close();
    				JOptionPane.showMessageDialog(null,"El archivo se a guardado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
    			}
 			}
  			catch(IOException ex)
  			{
   				JOptionPane.showMessageDialog(null,"Su archivo no se ha guardado","Advertencia",JOptionPane.WARNING_MESSAGE);
  			}
 		}

	public static void main (String args[])
    {
    	inter programas = new inter();
    	programas.setVisible(true);
    	programas.setTitle("Paint 2.2.1");
    	programas.setSize(1000,720);
    	programas.setResizable(false);
    	programas.setLocationRelativeTo(null);
    	programas.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
}