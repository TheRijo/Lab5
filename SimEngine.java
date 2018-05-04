package com.company;

public class SimEngine {
    //tworzenie prywatnych pÃ³l
    private double m;       //masa
    private double k;       //wspó³czynnik sprê¿ystoœci	
    private double c;       //wspó³czynnik t³umienia
    private double L0;      //d³ugoœæ swobodnej sprê¿yny	
    private double xMasy;   //po³o¿enie masy
    private double yMasy;
    private double xPunkt;  //po³o¿enie punktu
    private double yPunkt;
    private double xV;      //prêdkoœæ
    private double yV;
    private double g;       //przyspieszenie grawitacyjne
    public double ay;
    public double t;
    public double temp;

        Vector2D polozenieMasy;     //wektor po³o¿enia masy
        Vector2D polozeniePunktu;   //wektor po³o¿enia punktu

    //akcesory
    public void getM(double podajM){
        m = podajM;
    }
    public void getK(double podajK){
        k = podajK;
    }
    public void getC(double podajC){
        c = podajC;
    }
    public void getL0(double podajL0){
        L0 = podajL0;
    }
    public void getxMasy(double podajxMasy){
        xMasy = podajxMasy;
    }
    public void getyMasy(double podajyMasy){
        yMasy = podajyMasy;
    }
    public void getxPunkt(double podajxPunkt){
        xPunkt = podajxPunkt;
    }
    public  void getyPunkt(double podajyPunkt){
        yPunkt = podajyPunkt;
    }
    public void getyV(double podajyV){
        yV = podajyV;
    }
    public void getG(double podajG){
        g = podajG;
    }
    public double showxPunkt(){
        return polozenieMasy.x;
    }
    public double showyPunkt(){
        return polozeniePunktu.y;
    }
    public double showxMasy(){
        return polozenieMasy.x;
    }
    public double showyMasy(){
        System.out.println(polozenieMasy.y);
        return polozenieMasy.y;
    }

    //konstruktor z parametrem
    public SimEngine(double m1, double k1, double c1, double L1, double g1, double xMasy1, double yMasy1, double yPunkt1){
        m = m1;
        k = k1;
        c = c1;
        L0 = L1;
        xV = 0;
        yV = 0;
        g = g1;
        ay = 0;
        xMasy = xMasy1;
        yMasy = yMasy1;
        xPunkt = xMasy1;
        yPunkt = yPunkt1;
        t = 0;
        polozenieMasy = new Vector2D(xMasy1, yMasy1);
        polozeniePunktu = new Vector2D(xMasy1, yPunkt1);
    }

    //metoda obliczaj¹ca przebieg symulacji
    public void przebieg(double krok){
        t = krok;
        ay = (m*g-k*polozenieMasy.y-c*yV)/m;
        temp = temp+yV*t+ay*t*t/2;
        polozenieMasy.y = (int)temp;
    }

    //metoda resetuj¹ca
    public void zerowanie(){
        yV = 0;
    }
}