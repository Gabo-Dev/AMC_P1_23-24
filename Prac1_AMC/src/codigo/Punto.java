/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Graphics;

/**
 *
 * @author jhony
 */
public class Punto {
    
    private int x;
    private int y;
    private int id;

    public Punto(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
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
    public void dibujaPunto(Graphics g){
        g.fillOval(getX(), getY(),5, 5);
    }
}
