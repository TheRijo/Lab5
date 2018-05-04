package com.company;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;

public class SpringApplet extends JApplet implements MouseListener, MouseMotionListener, ActionListener {

    //tworzenie prywatnych pól
    private static final long serialVersionUTD = 1L;
    private SimEngine simE;
    private SimTask simT;
    private Timer czas;
    
    //tworzenie prywatnych pól do przechowywania wartoœci logicznej
    private boolean stanMysz; 
    private int x;
    private int y;
    
    //tworzenie prywatnych pól do interfejsu graficznego
    private TextField masa, wsK, wsC, G, Lpocz;
    private Button reset;
    
    //metody do omplementacji interfejsów myszy
    @Override
    public void mouseMoved(MouseEvent arg0) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override 
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    
    
    //odczyt po³o¿enia kursora
    x = e.getX();
    y = e.getY();
    
    //sprawdzenie po³o¿enia kursora
    if((x>=(int) simE.polozenieMasy.x-25 && x<=(int)simE.polozenieMasy.x+25)&&(y>=(int) simE.polozenieMasy.y && y<=(int)simE.polozenieMasy.y+100)) {
    	czas.cancel();
    	simE.zerowanie();
    	stanMysz = true;
    }
    e.consume();
    }
    
    //sprawdzenie przeci¹gnia myszy
    @Override
    public void mouseReleased(MouseEvent e) {
    	if(stanMysz==true) {
    		simT = new SimTask(simE,this,0.01);
    		czas = new Timer();
    		czas.scheduleAtFixedRate(simT, 0, 1);
    		stanMysz = false;
    	}
    	e.consume();
    }
    
    public void mouseDragged(MouseEvent arg0) {
    	if(stanMysz==true) {
    		simE.polozenieMasy.y = arg0.getY();
    		repaint();
    	}
    	arg0.consume();
    }
    
    
    //metoda publiczna
    @Override public void init(){
        this.setSize(400,300);

        simE = new SimEngine(3, 0.5, 0.1, 100, 10, 100, 100, 0);
        simT = new SimTask(simE, this, 0.01);
        czas = new Timer();
        czas.scheduleAtFixedRate(simT, 0, 1);
        stanMysz = false;
        addMouseListener(this);
        addMouseMotionListener(this);
        
        reset = new Button("reset");
        reset.addActionListener(this);
        add(reset);
        
        masa = new TextField("1",4);
        wsK = new TextField("2",4);
        wsC = new TextField("3",4);
        Lpocz = new TextField("4",4);
        G = new TextField("5",4);
        
        add(masa);
        add(wsK);
        add(wsC);
        add(Lpocz);
        add(G);
    }

    @Override public void paint(Graphics gDC){
        gDC.fillRect(0, 0, 400, 300);                                                               //czyszczenie appletu
        gDC.setColor(Color.CYAN);                                                                                       //rysowanie sprÄ™Å¼yny
        gDC.drawLine((int) simE.showxPunkt(), (int)simE.showyPunkt(), (int) simE.showxMasy(), (int) simE.showyMasy());
        gDC.setColor(Color.PINK);
        gDC.fillOval(((int) simE.showxMasy()-25), (int) simE.showyMasy(), 50, 100);                       //rysowanie masy
        
        masa.setBounds(30,40,20,20);
        wsK.setBounds(30,80,20,20);
        wsC.setBounds(30,120,20,20);
        Lpocz.setBounds(30,160, 20, 20);
        G.setBounds(30, 200, 20, 20);
        reset.setBounds(10, 240, 50, 50);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==reset) {
    		czas.cancel();
    		double m = Double.parseDouble(masa.getText());
    		double k = Double.parseDouble(wsK.getText());
    		double c = Double.parseDouble(wsC.getText());
    		double l = Double.parseDouble(Lpocz.getText());
    		double g = Double.parseDouble(G.getText());
    		simE = new SimEngine(m,k,c,l,g,100,20,0);
    		simT = new SimTask(simE,this,0.01);
    		czas = new Timer();
    		czas.scheduleAtFixedRate(simT, 0, 1);
    		repaint();
    	}
    }
}