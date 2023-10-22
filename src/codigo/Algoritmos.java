/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Ramso
 */
public class Algoritmos {
    //ArrayList<Punto> puntosDesordenados;
    
    Algoritmos(){
        //this.puntosDesordenados = p;
    }

/* ALG. ORDENAR PUNTOS */
    public ArrayList<Punto> Quicksort(ArrayList<Punto> puntos){
        if(puntos.size()<=1){
            return puntos;
        }
        //Math ceil -> redondea al alza
        int mitad = (int)Math.ceil(puntos.size()/2);
        Punto pivot = puntos.get(mitad);
        
        ArrayList<Punto> menores = new ArrayList<>();
        ArrayList<Punto> mayores = new ArrayList<>();
        
        for (Punto punto : puntos) {
            if(Double.compare(punto.getX(), pivot.getX())<=0){//0(d1==d2) -(d1<d2) +(d1>d2)
                menores.add(punto);
            }else{
                mayores.add(punto);
            }
        }
        return concatenar(menores, pivot, mayores);
    }
    public ArrayList<Punto> concatenar(ArrayList<Punto> menores, Punto pivot, ArrayList<Punto> mayores){
        ArrayList<Punto> puntos = new ArrayList<>();
        for (Punto menor : menores) {
            puntos.add(menor);
        }
        puntos.add(pivot);
        for (Punto mayor : mayores) {
            puntos.add(mayor);
        }
        return puntos;
    }
    
/* ALGORITMOS */
    //EXHAUSTIVO
    public void Exhaustivo(){
        // ordenar coords
        
        // alg
        
    }
    //EXHAUSTIVO PODA
    public void ExhaustivoPoda(){
        // ordenar coords
        
        //alg
        
    }
    //DYV
    public void DYV(){
        // ordenar coords
        
        //alg
        
    }
    //DYV MEJORADO
    public void DYVMejorado(){
        // ordenar coords
        
        //alg
        
    }
}
