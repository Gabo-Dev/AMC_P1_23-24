/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jhony
 */
public class Punto {
    
    private Double x;
    private Double y;
    private int id;

    public Punto(Double x, Double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * @return the x
     */
    public Double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Double y) {
        this.y = y;
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

    public double getDistancia(Punto p2) {
        return Math.sqrt(Math.pow(this.x - p2.getX(), 2) + Math.pow(this.getY(), 2));
    }
    public double getDistanciaX(Punto p2){
        return Math.sqrt(Math.pow(this.x - p2.getX(), 2));
    }
    public void dibujaPunto(Graphics g){
        g.fillOval(getX().intValue(), getY().intValue(),8, 8);
        g.setColor(Color.red);
    }
}
