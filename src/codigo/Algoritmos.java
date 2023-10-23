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

    Algoritmos() {
        //this.puntosDesordenados = p;
    }

    /* ALG. ORDENAR PUNTOS */
    public ArrayList<Punto> Quicksort(ArrayList<Punto> puntos) {
        if (puntos.size() <= 1) {
            return puntos;
        }
        //Math ceil -> redondea al alza el valor pasado por parametro
        int mitad = (int) Math.ceil(puntos.size() / 2);
        Punto pivot = puntos.get(mitad);

        ArrayList<Punto> menores = new ArrayList<>();
        ArrayList<Punto> mayores = new ArrayList<>();

        for (Punto punto : puntos) {
            if (Double.compare(punto.getX(), pivot.getX()) < 0) {//0(d1==d2) -(d1<d2) +(d1>d2)
                menores.add(punto);
            } else {
                mayores.add(punto);
            }
        }
        //return concatenar(menores, pivot, mayores);
        return concatenar(menores, mayores);
    }

    //public ArrayList<Punto> concatenar(ArrayList<Punto> menores, Punto pivot, ArrayList<Punto> mayores) {
    public ArrayList<Punto> concatenar(ArrayList<Punto> menores, ArrayList<Punto> mayores) {
        ArrayList<Punto> puntos = new ArrayList<>();
        for (Punto menor : menores) {
            puntos.add(menor);
        }
        //puntos.add(pivot);
        for (Punto mayor : mayores) {
            puntos.add(mayor);
        }
        return puntos;
    }

    /* ALGORITMOS */
    //EXHAUSTIVO
    public ArrayList<Punto> Exhaustivo(ArrayList<Punto> puntos) {
        // ordenar coords
            // para este alg no hace falta ordenarlo porque se compara a fuerza bruta "todos" los puntos
        // alg
        double distanciaMin = 9999999999.9, distancia;
        int x = -1, y = -1;
        for (int i = 0; i < puntos.size() - 1; i++) {
            for (int j = i + 1; j < puntos.size(); j++) {
                distancia = puntos.get(i).getDistanciaX(puntos.get(j));
                if (Double.compare(distancia, distanciaMin) < 0) {//d1 < d2
                    distanciaMin = distancia;
                    x = i;
                    y = j;
                }
            }
        }
        ArrayList<Punto> solucion = new ArrayList<>(2);
        solucion.add(puntos.get(x));
        solucion.add(puntos.get(y));

        return solucion;
    }

    //EXHAUSTIVO PODA
    public ArrayList<Punto> ExhaustivoPoda(ArrayList<Punto> puntos) {
        // ordenar coords
        ArrayList<Punto> p = this.Quicksort(puntos);
        //alg
        double distanciaMin = 9999999999.9, distancia;
        int x = -1, y = -1, j;
        boolean isMenor = false;
        for (int i = 0; i < p.size() - 1; i++) {
            j = i+1;
            //for(int j = i+1; j < puntos.size(); j++)
            while (j < p.size() || !isMenor) {
                distancia = p.get(i).getDistanciaX(p.get(j));
                if (Double.compare(distancia, distanciaMin) < 0) {//d1 < d2
                    distanciaMin = distancia;
                    x = i;
                    y = j;
                }
                else{
                    //  Descartamos pk > pj
                    isMenor = true;
                }
                j++;
            }
            //j = i + 1;
        }
        ArrayList<Punto> solucion = new ArrayList<>(2);
        solucion.add(p.get(x));
        solucion.add(p.get(y));
        return solucion;
    }

    //DYV
    public ArrayList<Punto> DYV(ArrayList<Punto> puntos) {
        // ordenar coords
        ArrayList<Punto> p = this.Quicksort(puntos);
        //alg
            
            
        //ArrayList<Punto> solucion = new ArrayList<>(2);
        //solucion.add(p.get(x));
        //solucion.add(p.get(y));
        return DYV(p,0,p.size());
    }
    public ArrayList<Punto> DYV(ArrayList<Punto> puntos, int izq, int der){
        ArrayList<Punto> solucion = new ArrayList<>(), solIzq, solDer;
        int mitad = (izq+der)/2;
        if((der-izq)+1 >= 3){
            solIzq = DYV(puntos,izq,mitad);
            solDer = DYV(puntos,mitad+1,der);
            
            double distIzq = solIzq.get(0).getDistanciaX(solIzq.get(1));
            double distDer = solDer.get(0).getDistanciaX(solDer.get(1));
            if(Double.compare(distIzq, distDer)<0){
                solucion = solIzq;
            }else{
                solucion = solDer;
            }
        }else{
            solucion = this.Exhaustivo(puntos);
        }
        
        return solucion;
    }

    //DYV MEJORADO
    public ArrayList<Punto> DYVMejorado(ArrayList<Punto> puntos) {
        // ordenar coords

        //alg
            //cod alg
            
        ArrayList<Punto> solucion = new ArrayList<>(2);
        //solucion.add(p.get(x));
        //solucion.add(p.get(y));
        return solucion;
    }
}
