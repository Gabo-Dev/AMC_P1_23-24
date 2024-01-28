/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author jhony
 */
public class Punto {

    private double x;
    private double y;
    private int id; 
    private int comparaciones;
    private String tiempoSolucion;
    
    public Punto(){
        
    }
    public Punto(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Double y) {
        this.y = y;
    }
    public String getCoordenadas(){
        String coordenadas = String.valueOf(getX())+"-"+String.valueOf(getY());
        return coordenadas;
    }
            

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Nos da información de las comparaciones que se necesitaron para encontrar el punto
     * @return 
     */
    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }
    
    public double getDistancia(Punto p2) {
        return Math.sqrt(Math.pow(this.x - p2.getX(), 2) + Math.pow(this.getY() - p2.getY(), 2));
    }

    public double getDistanciaX(Punto p2) {
        return Math.sqrt(Math.pow(this.x - p2.getX(), 2));
    }

    public double getDistanciaY(Punto p2) {
        return Math.sqrt(Math.pow(this.getY() - p2.getY(), 2));
    }

    /**
     * @return the tiempoSolucion
     */
    public String getTiempoSolucion() {
        return tiempoSolucion;
    }

    /**
     * @param tiempoSolucion the tiempoSolucion to set
     */
    public void setTiempoSolucion(String tiempoSolucion) {
        this.tiempoSolucion = tiempoSolucion;
    }
    public ArrayList<Punto> generaPuntos(int cantidad, boolean mismaX) {
        Random r = new Random();
        int num, den;
        ArrayList<Punto> tmp = new ArrayList<>();
        double x, y, aux;
        Punto p;

        if (mismaX) {// caso peor
            for (int i = 0; i < cantidad; i++) {
                aux = r.nextInt(1000) + 7;
                y = aux / ((double) (i + 1) + i * 0.100);
                num = r.nextInt(3);
                y += ((i % 500) - num * (r.nextInt(100)));
                x = 1;
                // precision 10
                x = Double.parseDouble(String.format("%.10f", x));
                y = Double.parseDouble(String.format("%.10f", y));
                p = new Punto(x, y, i + 1);
                tmp.add(p);
            }
        } else {// caso medio
            for (int i = 0; i < cantidad; i++) {
                num = r.nextInt(4000) + 1; // genera un número aleatorio entre 1 y 4000
                den = r.nextInt(11) + 7; // genera un aleatorio entre 7 y 17

                // división con decimales
                x = num / ((double) den + 0.37);
                y = (r.nextInt(4000) + 1) / ((double) (r.nextInt(11) + 7) + 0.37);
                // precision 10
                x = Double.parseDouble(String.format("%.10f", x));
                y = Double.parseDouble(String.format("%.10f", y));
                p = new Punto(x, y, i + 1);
                tmp.add(p);
            }
        }
        return tmp;
    }
}
