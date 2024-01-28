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
class cronometro {

    double startTime, endTime, Time;

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public Double getTime() {
        double time = (this.endTime - this.startTime) / 1e6;
        return time;
    }

    public void setTime(double Time) {
        this.Time = Time;
    }

    public void clear() {
        this.startTime = 0;
        this.endTime = 0;
        this.Time = 0;
    }
}

public class Algoritmos {

    //ArrayList<Punto> puntosDesordenados;
    private int comparacionesDV;
    cronometro c;

    Algoritmos() {
        //this.puntosDesordenados = p;
        comparacionesDV = 0;
        c = new cronometro();
    }

    /* ALG. ORDENAR PUNTOS*/
    public void QuicksortY(ArrayList<Punto> puntos) {
        int length = puntos.size();
        quickSortY(puntos, 0, length - 1);
    }

    public void quickSortY(ArrayList<Punto> puntos, int e, int d) {
        if (e < d) {
            int q = partitionY(puntos, e, d);
            quickSortY(puntos, e, q - 1);
            quickSortY(puntos, q + 1, d - 1);
        }
    }

    public int partitionY(ArrayList<Punto> puntos, int e, int d) {
        Punto pivote = puntos.get(e);
        int i = e;
        int j = d;
        while (i < j) {
            while (puntos.get(i).getX() <= pivote.getX() && i < j) {
                i++;
            }
            while (puntos.get(j).getX() > pivote.getX()) {
                j--;
            }
            if (i < j) {
                intercambiar(puntos, i, j);
            }
        }
        intercambiar(puntos, e, j);
        return j;

    }

    public void Quicksort(ArrayList<Punto> puntos) {
        int length = puntos.size();
        quickSort(puntos, 0, length - 1);
    }

    public void quickSort(ArrayList<Punto> puntos, int e, int d) {
        if (e < d) {
            int q = partitionX(puntos, e, d);
            quickSort(puntos, e, q - 1);
            quickSort(puntos, q + 1, d - 1);
        }
    }

    public int partitionX(ArrayList<Punto> puntos, int e, int d) {
        Punto pivote = puntos.get(e);
        int i = e;
        int j = d;
        while (i < j) {
            while (puntos.get(i).getX() <= pivote.getX() && i < j) {
                i++;
            }
            while (puntos.get(j).getX() > pivote.getX()) {
                j--;
            }
            if (i < j) {
                intercambiar(puntos, i, j);
            }
        }
        intercambiar(puntos, e, j);
        return j;

    }

    public void intercambiar(ArrayList<Punto> puntos, int i, int j) {
        Punto tmp = puntos.get(i);
        puntos.set(i, puntos.get(j));
        puntos.set(j, tmp);
    }

    /* ALGORITMOS */
    //EXHAUSTIVO
    public ArrayList<Punto> Exhaustivo(ArrayList<Punto> puntos) {
        // limpiamos crono
        c.clear();
        // para este alg no hace falta ordenarlo porque se compara a fuerza bruta "todos" los puntos
        // alg
        double distanciaMin = 9999999999.9, distancia;
        int x = -1, y = -1, cnt = 0;
        c.setStartTime(System.nanoTime());
        for (int i = 0; i < puntos.size() - 1; i++) {
            for (int j = i + 1; j < puntos.size(); j++) {
                distancia = puntos.get(i).getDistancia(puntos.get(j));
                cnt++;
                if (Double.compare(distancia, distanciaMin) < 0) {//d1 < d2
                    distanciaMin = distancia;
                    x = i;
                    y = j;
                }
            }
        }
        c.setEndTime(System.nanoTime());
        ArrayList<Punto> solucion = new ArrayList<>(2);

        solucion.add(puntos.get(x));
        solucion.add(puntos.get(y));
        // almaceno las comparaciones de esta solucion en el primer punto
        solucion.get(0).setComparaciones(cnt);
        solucion.get(0).setTiempoSolucion(String.format("%6f", c.getTime()));
        return solucion;
    }

    /**
     * Devuelve los puntos con menor distancia sobre una lista de puntos ordenas
     * crecientemente en función de su eje X (si los ejes son iguales el orden
     * es en fnc de su llegada)
     *
     * @param puntos
     * @return
     */
    public ArrayList<Punto> ExhaustivoPoda(ArrayList<Punto> puntos) {
        ArrayList<Punto> solucion = new ArrayList<>(2);
        //  limpiamos crono
        c.clear();
        // ordenar coords
        Quicksort(puntos);
        //alg
        double distanciaMin = Double.MAX_VALUE, distancia;
        int j;
        boolean isMenor = false;
        int tam = puntos.size(), cnt = 0;
        c.setStartTime(System.nanoTime());
        for (int i = 0; i < tam; i++) {
            j = i + 1;
            while (j < tam && !isMenor) {
                cnt++;
                // iteramos mientras distancia ( de los ejes x) < distancia minima
                if (Math.abs(puntos.get(i).getX() - puntos.get(j).getX()) < distanciaMin) {
                    distancia = puntos.get(i).getDistancia(puntos.get(j));
                    if (distancia < distanciaMin) {
                        distanciaMin = distancia;
                        solucion.clear();
                        solucion.add(puntos.get(i));
                        solucion.add(puntos.get(j));
                    }
                    j++;
                } else {
                    isMenor = true;
                }
            }
            isMenor = false;
        }

        c.setEndTime(System.nanoTime());
        solucion.get(0).setComparaciones(cnt);
        solucion.get(0).setTiempoSolucion(String.format("%6f", c.getTime()));
        return solucion;
    }

    //DYV
    public ArrayList<Punto> DYV(ArrayList<Punto> puntos) throws Exception {
        Quicksort(puntos);
        this.comparacionesDV = 0;
        //  limpiamos crono
        c.clear();
        c.setStartTime(System.nanoTime());
        ArrayList<Punto> aux = DYV(puntos, 0, puntos.size() - 1);
        c.setEndTime(System.nanoTime());
        return aux;
    }

    public ArrayList<Punto> DYV(ArrayList<Punto> puntos, int izq, int der) throws Exception {
        ArrayList<Punto> solucionIzq, solucionDer, solucionActual = null, solucion = new ArrayList<>(2);
        double distancia, dminIzq, dmin, dminDer;

        //c.setStartTime(System.nanoTime());
        if (der - izq <= 3) { // caso base
            dmin = Double.MAX_VALUE;
            for (int i = izq; i <= der; i++) {
                for (int j = i + 1; j <= der; j++) {
                    // comparamos distancias de la franja con la distancia actual
                    distancia = puntos.get(i).getDistancia(puntos.get(j));
                    comparacionesDV++;
                    if (Double.compare(distancia, dmin) < 0) {//d1 < d2
                        dmin = distancia;
                        solucionActual = new ArrayList<>();
                        solucionActual.add(puntos.get(i));
                        solucionActual.add(puntos.get(j));
                    }
                }
            }

            solucion = solucionActual;

        } else {
            int medio = (der + izq) / 2;

            // Recursion cada parte
            solucionIzq = DYV(puntos, izq, medio);
            solucionDer = DYV(puntos, medio + 1, der);
            // Elegimos la dmin entre los valores de izq y der
            dminIzq = solucionIzq.get(0).getDistancia(solucionIzq.get(1));
            dminDer = solucionDer.get(0).getDistancia(solucionDer.get(1));
            if (dminIzq <= dminDer) {
                dmin = dminIzq;
                solucion = solucionIzq;

            } else {
                dmin = dminDer;
                solucion = solucionDer;
            }
            // valores dentro de la franja
            ArrayList<Punto> aux = new ArrayList<>();
            for (int i = izq; i <= der; i++) {
                if (Math.abs(puntos.get(i).getX() - puntos.get(medio).getX()) < dmin) {
                    aux.add(puntos.get(i));
                }
            }
            // busqueda exhaustiva en franja

            for (int i = 0; i < aux.size(); i++) {
                for (int j = i + 1; j < aux.size(); j++) {
                    // comparamos distancias de la franja con la distancia actual
                    distancia = puntos.get(i).getDistancia(puntos.get(j));
                    comparacionesDV++;
                    if (Double.compare(distancia, dmin) < 0) {//d1 < d2
                        dmin = distancia;
                        solucion.add(aux.get(i));
                        solucion.add(aux.get(j));
                    }
                }
            }

        }
        //c.setEndTime(System.nanoTime());
        return solucion;
    }

    //DYV MEJORADO
    public ArrayList<Punto> DYVMejorado(ArrayList<Punto> puntos) throws Exception {
        //Quicksort(puntos, 0);
        // resetComparaciones
        this.comparacionesDV = 0;
        //  limpiamos crono
        c = new cronometro();
        c.setStartTime(System.nanoTime());
        ArrayList<Punto> aux = DYVMejorado(puntos, 0, puntos.size() - 1);
        c.setEndTime(System.nanoTime());
        return aux;
    }

    public ArrayList<Punto> DYVMejorado(ArrayList<Punto> puntos, int izq, int der) {
        ArrayList<Punto> solucionIzq, solucionDer, solucionActual = null, solucion;
        double distancia, dminIzq, dmin, dminDer;

        // c.setStartTime(System.nanoTime());
        if (der - izq <= 3) { // caso base
            dmin = Double.MAX_VALUE;
            for (int i = izq; i <= der; i++) {
                for (int j = i + 1; j <= der; j++) {
                    distancia = puntos.get(i).getDistancia(puntos.get(j));
                    comparacionesDV++;
                    if (Double.compare(distancia, dmin) < 0) {//d1 < d2
                        dmin = distancia;
                        solucionActual = new ArrayList<>();
                        solucionActual.add(puntos.get(i));
                        solucionActual.add(puntos.get(j));
                    }
                }
            }

            solucion = solucionActual;

        } else {
            int medio = (der + izq) / 2;

            // Recursion cada parte
            solucionIzq = DYVMejorado(puntos, izq, medio);
            solucionDer = DYVMejorado(puntos, medio + 1, der);
            // Elegimos la dmin entre los valores de izq y der
            dminIzq = solucionIzq.get(0).getDistancia(solucionIzq.get(1));
            dminDer = solucionDer.get(0).getDistancia(solucionDer.get(1));
            if (dminIzq <= dminDer) {
                dmin = dminIzq;
                solucion = solucionIzq;
            } else {
                dmin = dminDer;
                solucion = solucionDer;
            }
            // valores dentro de la franja
            ArrayList<Punto> aux = new ArrayList<>();
            for (int i = izq; i <= der; i++) {
                if (Math.abs(puntos.get(i).getX() - puntos.get(medio).getX()) < dmin) {
                    aux.add(puntos.get(i));
                }
            }

            //  Ordenamos franja en fnc del eje y
            QuicksortY(aux);
            int j = 0;
            // busqueda exhaustiva en franja
            for (int i = 0; i < aux.size(); i++) {
                j = i + 1;
                if (j - i < 12) {
                    while (j < aux.size()) {
                        // comparamos distancias de la franja con la distancia actual
                        distancia = puntos.get(i).getDistancia(puntos.get(j));
                        comparacionesDV++;
                        if (Double.compare(distancia, dmin) < 0) {//d1 < d2
                            dmin = distancia;
                            solucion.add(aux.get(i));
                            solucion.add(aux.get(j));
                        }
                        j++;
                    }
                }
                /*for (int j = i + 1; j < aux.size() && j - i < 12; j++) {
                    // comparamos distancias de la franja con la distancia actual
                    distancia = puntos.get(i).getDistancia(puntos.get(j));
                    comparacionesDV++;
                    if (Double.compare(distancia, dmin) < 0) {//d1 < d2
                        dmin = distancia;
                        solucion.add(aux.get(i));
                        solucion.add(aux.get(j));
                    }
                }*/
            }
        }

        return solucion;
    }

    /**
     * @return the comparacionesDV
     */
    public int getComparacionesDV() {
        return comparacionesDV;
    }

}
