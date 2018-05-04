package com.company;
import java.util.TimerTask;

public class SimTask extends TimerTask {

    //tworzenie prywatnych pol
    private static final long serialVersionUTD = 1L;
    private SimEngine pole1;
    private SpringApplet pole2;
    private double odstep;

    //przypisanie klasy obiektu klasy SimEngine,SpringApplet i odstêpu 
    public SimTask(SimEngine pole1, SpringApplet pole2, double odstep){
        this.pole1 = pole1;
        this.pole2 = pole2;
        this.odstep = odstep;
    }

    public void run(){
        pole1.przebieg(odstep); //obliczenie kroku
        pole2.repaint();        //odœwie¿enie wyœwietlania powierzchni
    }
}