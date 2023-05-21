import java.io.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Parser
{
	static String dtGLOBAL = "",nuevalinea,DTGLOBAL = "";
	static int ro,ve,az;
	boolean retval=false;
	boolean pintar=false;

    public Parser()
    {
        String line = "";
		String letra = "";
		String let2 = "",let="";
		Color col = new Color(0,0,0),col1;
		int estado,R=0,G=0,B=0;
		String Colores[][] = new String[30][4];
//////////////////////////////////////
String nombcol = "";
String color = "";
CharSequence parametro1="";
//////////////////////////////////////
		PanelDibujo panelobj = new PanelDibujo();

		//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
				String foto="";
				int fot=0,Y1=0,X1=0,ANC=0,ALT=0,X3=0,Y3=0;
                String x1="";
                String y1="";
                String anc="";
                String alt="";
                String x3="";
                String y3="";
                String r="";
                String g="";
                String b="";
		//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
		estado = 0;
		try
		{
			int caracter;
			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		//	FileNameExtensionFilter filter = new FileNameExtensionFilter("MIFLA", "mifla", "MIFLA");
		//	fc.setFileFilter(filter);
		 	fc.showOpenDialog(null);
		 	File Abrir = fc.getSelectedFile();

		 	FileReader Fichero = new FileReader(Abrir);
		 //	BufferedReader br = new BufferedReader(Fichero);
			int h=0;
				while ((caracter = Fichero.read()) != -1)
				{
					char Caracter = ((char)caracter);
					
					if(((char)caracter)!='\n'&&((char)caracter)!='\t'&&((char)caracter)!=' '&& caracter!=13)
					{
						estado = Matriz.getEstado(estado, Matriz.getColumn((char)caracter));

						if(estado<1000 && estado>=0)
						{
							switch(estado)
							 {
							 	case 16:
							 		nombcol=nombcol+Caracter;
							 		break;
							 	case 17:
							 		Colores[h][0]=nombcol;
							 		h++;
							 		if(b!="")
							 		{
							 			Colores[h-2][3]=b;b="";
							 		}
							 		nombcol="";break;
							 	case 18:break;
							 	case 19:
							 		r = r+Caracter+"";break;
							 	case 20:
							 		r = r+Caracter+"";break;
							 	case 21:
							 		r = r+Caracter+"";break;
							 	case 22:
							 		Colores[h-1][1]=r;
							 		r="";break;
							 	case 23:
							 		g = g+Caracter+"";break;
							 	case 24:
							 		g = g+Caracter+"";break;
							 	case 25:
							 		g = g+Caracter+"";break;
							 	case 26:
							 		Colores[h-1][2]=g;
							 		g="";break;
							 	case 27:
							 		b = b+Caracter+"";break;
							 	case 28:
							 		b = b+Caracter+"";break;
							 	case 29:
							 		b = b+Caracter+"";break;
							 	case 30:
							 		if(b!="")
							 		{
							 			Colores[h-1][3]=b;b="";
							 		}
							 		break;
							 	case 31:
							 		System.out.println("nombre: "+Colores[0][0]+" R "+Colores[0][1]+" G "+Colores[0][2]+" B "+Colores[0][3]);
							 		System.out.println("nombre: "+Colores[1][0]+" R "+Colores[1][1]+" G "+Colores[1][2]+" B "+Colores[1][3]);
							 		System.out.println("nombre: "+Colores[2][0]+" R "+Colores[2][1]+" G "+Colores[2][2]+" B "+Colores[2][3]);
							 		break;
							 		//coordenada x ovalo
							 	case 51:
							 		x1=x1+Caracter;break;
							 	case 52:
							 		x1=x1+Caracter;break;
							 	case 53:
							 		x1=x1+Caracter;break;
							 		//coordenada y ovalo
							 	case 55:
							 		y1=y1+Caracter;break;
							 	case 56:
							 		y1=y1+Caracter;break;
							 	case 57:
							 		y1=y1+Caracter;break;
							 		//ancho	ovalo
							 	case 59:
							 		anc=anc+Caracter;break;
							 	case 60:
							 		anc=anc+Caracter;break;
							 	case 61:
							 		anc=anc+Caracter;break;
							 		//alto del ovalo
							 	case 63:
							 		alt=alt+Caracter;break;
							 	case 64:
							 		alt=alt+Caracter;break;
							 	case 65:	
							 		alt=alt+Caracter;break;
							 	case 66:
							 		X1 = Integer.parseInt(x1);
		      		    			Y1 = Integer.parseInt(y1);
		      		    			ANC = Integer.parseInt(anc);
		      		    			ALT = Integer.parseInt(alt);
							 		x1="";y1="";anc="";alt="";
							 		break;
							 	case 69:
							 		let = "S";
							 		break;	
							 	case 78:
							 		let = "R";
							 		break;
							 	case 40://pinta rectangulo en el estado 39 trmina
							 		letra=Caracter+"";
							 		System.out.println("figura 84"+letra);
							 		break;
							 	case 84: //pinta ovalo en el estado 39 trmina
							 		letra=Caracter+"";
							 		System.out.println("figura 84"+letra);
							 		break;
							 	case 88: //pinta linea en el estado 39 trmina
							 		letra=Caracter+"";
							 		System.out.println("figura 88"+letra);
							 		break;
							 /////////////////////////////////////////////////////////coordenada en x de la linea		
							 	case 94:
							 		x1=x1+Caracter;break;
							 	case 95:
							 		x1=x1+Caracter;break;
							 	case 96:
							 		x1=x1+Caracter;break;
							 /////////////////////////////////////////////////////////coordenada en y de la linea
							 	case 98:
							 		y1=y1+Caracter;break;
							 	case 99:
							 		y1=y1+Caracter;break;
							 	case 100:
							 		y1=y1+Caracter;break;
							 /////////////////////////////////////////////////////////ancho de la linea		
							 	case 102:
							 		anc=anc+Caracter;break;
							 	case 103:
							 		anc=anc+Caracter;break;
							 	case 104:
							 		anc=anc+Caracter;break;
							 ////////////////////////////////////////////////////////alto de la linea
							 	case 106:
							 		alt=alt+Caracter;break;
							 	case 107:
							 		alt=alt+Caracter;break;
							 	case 108:
							 		alt=alt+Caracter;
							 		break;
							 	case 109:
							 		X1 = Integer.parseInt(x1);
		      		    			Y1 = Integer.parseInt(y1);
		      		    			ANC = Integer.parseInt(anc);
		      		    			ALT = Integer.parseInt(alt);
							 		x1="";y1="";anc="";alt="";
							 		break;
							 	
							 /////////////////////////////////////////////////////////lee color de la linea
							 	case 110:
							 		color=color+Caracter;
							 		break;
							 	case 67:
							 		color=color+Caracter;
							 		break;
							 /////////////////////////////////////////////////////////compara colores con la lista
							 	case 68: //ovalo
							 		for(int n=0; n<30; n++)
							 		{
							 			if(Colores[n][0]!=null)
							 			{
							 			parametro1=Colores[n][0];
							 			retval = color.contains(parametro1);
							 			if(retval==true)
							 			{
							 				r=Colores[n][1];g=Colores[n][2];b=Colores[n][3];break;
							 			}
							 			else if(retval==false)
							 			{
							 				r="0";g="0";b="0";
							 			}}
							 		}
							 		parametro1="";
							 		color="";
							 	break;
							 	case 111: //linea
							 		for(int n=0; n<30; n++)
							 		{
							 			if(Colores[n][0]!=null)
							 			{
							 			parametro1=Colores[n][0];
							 			retval = color.contains(parametro1);
							 			if(retval==true)
							 			{
							 				r=Colores[n][1];g=Colores[n][2];b=Colores[n][3];
							 				break;
							 			}
							 			else if(retval==false)
							 			{
							 				r="0";g="0";b="0";
							 			}}
							 		}
							 		parametro1="";
							 		color="";
							 		break;
							 	case 112:
							 		let=let+Caracter;
							 		break;
							 	case 120: //linea
							 		System.out.println("guardado "+letra);
							 		if(letra.equals("L") || letra.equals("l"))
							 		{
							 			System.out.println("entro "+letra);
							 			pintar=true;
							 		}
							 		else
							 		{
							 			pintar = false;
							 		}
							 		System.out.println("guardado 2 "+letra);
							 		break;
							 	case 77:
							 		System.out.println("guardado "+letra);
							 		if(letra.equals("O") || letra.equals("o") || letra.equals("r") || letra.equals("R"))
							 		{
							 			System.out.println("entro "+letra);
							 			pintar=true;
							 		}
							 		else
							 		{
							 			pintar = false;
							 		}
							 		System.out.println("guardado 2 "+letra);
							 		break;
							 	case 83:
							 		System.out.println("guardado "+letra);
							 		if(letra.equals("O") || letra.equals("o")|| letra.equals("r") || letra.equals("R"))
							 		{
							 			System.out.println("entro "+letra);
							 			pintar=true;
							 		}
							 		else
							 		{
							 			pintar = false;
							 		}
							 		System.out.println("guardado 2 "+letra);
							 		break;
							 }
							 if(pintar == true)
							 {
							 	R= Integer.parseInt(r);
							 	G= Integer.parseInt(g);
							 	B= Integer.parseInt(b);
							 	if(R<=255 && G<=255 && B<=255)
							 	{
							 		col=new Color(R,G,B);
							 	}
							 	else{
							 		JOptionPane.showMessageDialog(null,"Se encontró un color invalido","Advertencia",JOptionPane.WARNING_MESSAGE);
							 		col=new Color(0,0,0);
							 	}
							 	System.out.println("pintando:"+letra);
							 	if (letra.equals("r")||letra.equals("R"))
							 	{
							 		panelobj.Rect(X1,Y1,ALT,ANC,col,let);
							 		System.out.println("pintando OVALO "+X1+" "+Y1+" "+ANC+" "+ALT+" "+r+" "+g+" "+b+" "+let);
							 		X1=0;Y1=0;ALT=0;ANC=0;col=null;
							 		pintar = false;
							 		let="";
							 	}
							 	if (letra.equals("o")||letra.equals("O"))
							 	{
							 		panelobj.Circ(X1,Y1,ALT,ANC,col,let);
							 		System.out.println("pintando OVALO "+X1+" "+Y1+" "+ANC+" "+ALT+" "+r+" "+g+" "+b+" "+let);
							 		X1=0;Y1=0;ALT=0;ANC=0;col=null;
							 		pintar = false;
							 		let="";
							 	}
							 	if (letra.equals("L")||letra.equals("L"))
							 	{
							 		panelobj.Lin(X1,Y1,ALT,ANC,col);
							 		System.out.println("pintando LINEA "+X1+" "+Y1+" "+ANC+" "+ALT+" "+r+" "+g+" "+b+" "+let);
							 		pintar = false;
							 		X1=0;Y1=0;ALT=0;ANC=0;col=null;
							 		let="";
							 	}
							 	letra="";
							 }
							 System.out.println("                            sale ddel switch "+h);
						//	System.out.println("colores "+r+" "+g+" "+b+" ");
							/*R = Integer.parseInt(r);
							G = Integer.parseInt(g);
							B = Integer.parseInt(b);
							nomcol=new Color(R,G,B);
							
							if(estado==88)
							{
								System.out.println("inicia linea");
							}	*/	
										
						}
						
						else if (estado > 1000)
						{
							JOptionPane.showMessageDialog(null,"Se encontró un caracter no válido\n"+Matriz.Error(estado)+ "\nSe obtubo "+(char)caracter,"Advertencia",JOptionPane.WARNING_MESSAGE);
						    break;
						}

						System.out.println(""+estado+" "+Matriz.getColumn((char)caracter)+ "Se leyo: "+(char)caracter);
					//	System.out.println(" nuevo estado "+estado);
				 	}
				}

				panelobj.repaint();
				inter.panel1(panelobj);
		}

		catch (Exception ex)
		     {
		     	JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    	//ex.printStackTrace();
		     }

		finally
	       	 {

		     }
    }

}