package com.company;

public class Vector2D {
    //pola publiczne wspó³rzêdnych
    public double x;
    public double y;

   //konstruktor domyœlny
    public Vector2D(){
        x = 0;
        y = 0;
    }

    //konstruktor z paramterem
    public Vector2D(double x1, double y1){
        x = x1;
        y = y1;
    }

    //metoda zwaracaj¹ca sumê wektorów
    public Vector2D suma(Vector2D dodWektor){
        return new Vector2D(x+dodWektor.x, y+dodWektor.y);
    }

    //mertoda zwracaj¹ca ró¿nicê wektorów
    public Vector2D roznica(Vector2D rozWektor){
        return new Vector2D(x-rozWektor.x, y-rozWektor.y);
    }

    //metoda zwracaj¹ca iloczyn wektora i k
    public Vector2D mnozenie(double k){
        return new Vector2D(x*k, y*k);
    }

    //metoda zwracaj¹ca d³ugoœæ wektora
    public double dlugosc(){
        return (Math.sqrt(x*x+y*y));
    }

    //metoda zwracaj¹ca wektor znormalizowany
    public Vector2D normalizacja(){
        return new Vector2D(x/dlugosc(), y/dlugosc());
    }

}

