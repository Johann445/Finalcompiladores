import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

class PanelDibujo extends JPanel
{
        ArrayList<Rectangulo> rectangulos = new ArrayList<Rectangulo>();
        ArrayList<Circulo> circulos = new ArrayList<Circulo>();
        ArrayList<Linea> lineas = new ArrayList<Linea>();
        ArrayList<Triangulo> triangulos = new ArrayList<Triangulo>();
        public int x,y,x1,y1,X1,Y1,ALT,ANC,R,G;
        static int Figura,ro,ve,az;
        static Color color1,col,col1; static String let,contorno,datos="",dtGLOBAL="",nuevalinea;
        
		public PanelDibujo()
		{
			eventoR  manejador = new eventoR ();
			addMouseListener( manejador );
		}

        void Circ(int X1, int Y1, int ALT, int ANC,Color col,String let)
        	{
            	circulos.add(new Circulo(X1,Y1,ALT,ANC,col,let)); 
            	repaint();
        	}
        void Rect(int X1, int Y1, int ALT, int ANC,Color col,String let)
        	{
            	rectangulos.add(new Rectangulo(X1,Y1,ALT,ANC,col,let));
            	repaint();
        	}
        void Lin(int X1, int Y1, int ALT, int ANC,Color col)
        	{
            	lineas.add(new Linea(X1,Y1,ALT,ANC,col));
            	repaint();
        	}
        void Tri(int X1, int Y1, int ALT, int ANC,int R, int G, Color col1,String let)
        	{
        		triangulos.add(new Triangulo(X1,Y1,ALT,ANC,R,G,col1,let));
        		repaint();
        	}
        	//////////////////////////////////////////////////////////////////////////////////////////
        static void figura(int numFig, int r,int g, int b, String conto)
        {
        	ro=r;ve=g;az=b;
        	color1 = new Color(r,g,b);
        	Figura=numFig;
        	contorno=conto;
        }

        public void paint(Graphics g)
        {
        	super.paint(g);
        	
        	for(Circulo c:circulos)
          	{
          		g.setColor(c.COL);
          		if(c.LET.equals("S"))
          		{
          			g.drawOval(c.x1, c.y1, c.ancho, c.alto);
          		}
          		else
          			g.fillOval(c.x1, c.y1, c.ancho, c.alto);
          	}
          
          	for(Rectangulo r:rectangulos)
          	{
          		g.setColor(r.COL);
          		if(r.LET.equals("S"))
          		{
          			g.drawRect(r.x1, r.y1, r.ancho, r.alto);
          		}
          		else
          			g.fillRect(r.x1, r.y1, r.ancho, r.alto);
          	}
          	
          	for(Linea l:lineas)
          	{
          		g.setColor(l.COL);
              	g.drawLine(l.x1, l.y1, l.ancho, l.alto);
          	}
          	
          	for(Triangulo t:triangulos)
          	{
          		int arx[] = {t.x1,t.x2,t.x3};
        		int ary[] = {t.y1,t.y2,t.y3};
        		g.setColor(t.COL);
        		if(t.LET.equals("S"))
          		{
          			g.drawPolygon(arx,ary,3);
          		}
          		else
          			g.fillPolygon(arx,ary,3);
          	}
        }
        
        public class eventoR implements MouseListener
		 {
		 	public void mousePressed(MouseEvent evt1) 
		 	{
		 		x = evt1.getX();
		 		y = evt1.getY();
		 	}
		 	public void mouseReleased(MouseEvent evt1)
		 	{
		 		if(Figura == 1)
		 		{
		 			X1=x;Y1=y;ANC=evt1.getX();ALT=evt1.getY();col=color1;
					Lin(X1,Y1,ALT,ANC,col);
					datos=("LINEA,"+X1+","+Y1+","+ANC+","+ALT+","+ro+","+ve+","+az+",SOLO-CONTORNO");
		 		}
		 		if(Figura == 2)
		 		{
		 			X1=x;Y1=x+((evt1.getX()-x)/2);ALT=evt1.getX();ANC=evt1.getY();R=y;G=evt1.getY();let=contorno;col1=color1;
		 			Tri(X1,Y1,ALT,ANC,R,G,col1,let);
		 			datos=("triangulo,1,"+X1+","+Y1+","+ANC+","+ALT+","+R+","+G+","+ro+","+ve+","+az+","+let);
	
		 		}
		 		if(Figura == 3)
		 		{		 				
		 			X1=x;Y1=y;ANC=evt1.getX()-x;ALT=evt1.getY()-y;let=contorno;col=color1;
		 			if(ALT<0 || ANC<0)
		 			{
		 				X1=evt1.getX();Y1=evt1.getY();ANC=x-evt1.getX();ALT=y-evt1.getY();
		 			}
		 			Rect(X1,Y1,ALT,ANC,col,let);
		 			datos=("rectangulo,1,"+X1+","+Y1+","+ANC+","+ALT+","+ro+","+ve+","+az+","+let);
		 		}
		 		if(Figura == 4)
		 		{
		 			X1=x;Y1=y;ANC=evt1.getX()-x;ALT=evt1.getY()-y;let=contorno;col=color1;
		 			if(ALT<0 || ANC<0)
		 			{
		 				X1=evt1.getX();Y1=evt1.getY();ANC=x-evt1.getX();ALT=y-evt1.getY();
		 			}
		 			Circ(X1,Y1,ALT,ANC,col,let);
		 			datos=("circulo,1,"+X1+","+Y1+","+ANC+","+ALT+","+ro+","+ve+","+az+","+let);
		 		}
		 		nuevalinea = System.getProperty("line.separator");
		 		dtGLOBAL = (dtGLOBAL+datos+nuevalinea);
		 		inter.obtext(dtGLOBAL);
		 	}
    		public void mouseExited(MouseEvent arg0) {}
    		public void mouseEntered(MouseEvent arg0) {}
    		public void mouseClicked(MouseEvent arg0) {}
		 }
        

        class Circulo
        {
            int x1,y1,ancho,alto;
            Color COL;
            String LET;
            
            public Circulo(int X1, int Y1, int ALT, int ANC,Color col,String let)
            {
            	this.LET = let;
                this.x1 = X1;
                this.y1 = Y1;
                this.ancho = ANC;
                this.alto = ALT;
                this.COL = col;
            }
        }
        
        class Rectangulo
        {
            int x1,y1,ancho,alto;
            Color COL;
            String LET;
            
            public Rectangulo(int X1, int Y1, int ALT, int ANC,Color col,String let)
            {
            	this.LET = let;
                this.x1 = X1;
                this.ancho = ANC;
                this.y1 = Y1;
                this.alto = ALT;
                this.COL = col;
            }
    	}
    	
    	class Linea
        {
            int x1,y1,ancho,alto;
            Color COL;
            public Linea(int X1, int Y1, int ALT, int ANC,Color col)
            {
                this.x1 = X1;
                this.ancho = ANC;
                this.y1 = Y1;
                this.alto = ALT;
                this.COL = col;
            }
        }
        
        class Triangulo
        {
        	Color COL;
        	int x1,y1,x2,y2,x3,y3;
        	String LET;
        	public Triangulo(int X1, int Y1, int ALT, int ANC, int R, int G, Color col1, String let)
        	{
        		this.x1=X1;
        		this.x2=Y1;
        		this.x3=ALT;
        		this.y1=ANC;
        		this.y2=R;
        		this.y3=G;
        		this.COL=col1;
        		this.LET=let;
        	}
        }
}