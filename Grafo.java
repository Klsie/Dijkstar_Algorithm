package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Rodrigo Arana
 */
public class Grafo {

    Nodo primero, ultimo;

    public Grafo() {
        primero = null;
        ultimo = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public boolean existeVertice(Nodo node) {
        boolean existe = false;
        if (!esVacio()) {
            Nodo temporal = primero;
            while (temporal != null && !existe) {
                if (temporal.getDato().equals(node.getDato())) {
                    existe = true;
                }
                temporal = temporal.getSiguiente();
            }
        }

        return existe;
    }

        public void nuevoArco (Nodo origen, Nodo destino) {
        if (existeVertice(origen) && existeVertice(destino)) {
            Nodo posicion = primero;
            while (!posicion.dato.equals(origen.getDato())) {
                posicion = posicion.getSiguiente();
            }
            int costo = (int) (Math.random() * (10 - 1) + 1);
            posicion.lista.nuevaAdyacencia(destino, costo);
            posicion = primero;
            while (!posicion.dato.equals(destino.getDato())) {
                posicion = posicion.getSiguiente();
            }
            posicion.lista.nuevaAdyacencia(origen, costo);

            System.out.println("Origen: " + origen.getDato() + " Costo: " + costo + " Destino: " + destino.getDato()+ "\n");

        }
    }
    
    public void nuevoArco(Nodo origen, Nodo destino, int costo) {
    if (existeVertice(origen) && existeVertice(destino)) {
        Nodo posicion = primero;
        while (!posicion.dato.equals(origen.getDato())) {
            posicion = posicion.getSiguiente();
        }
        posicion.lista.nuevaAdyacencia(destino, costo);

        System.out.println("Origen: " + origen.getDato() + " Costo: " + costo + " Destino: " + destino.getDato() + "\n");
    }
}

    
    public void nuevoNodo (Nodo nodo){
        if(!existeVertice(nodo)){
            if(esVacio()){
                primero = nodo;
                ultimo = nodo;
            } else{
                if(nodo.getDato().compareTo(primero.getDato()) <=0){
                    nodo.setSiguiente(primero);
                    primero = nodo;
                } else {
                    if (nodo.getDato().compareTo(primero.getDato()) >= 0) {
                        ultimo.setSiguiente(nodo);
                        ultimo = nodo;
                    } else {
                        Nodo temp = primero;
                        while (nodo.getDato().compareTo(primero.getDato()) != 0) {
                            temp = temp.getSiguiente();
                        }
                        nodo.setSiguiente(temp.getSiguiente());
                        temp.setSiguiente(nodo);
                    }
                }
                
            }
        }
    }
    
    public String mostrar (){
       String valores = "   ";
        Nodo temporal = primero;
        while (temporal != null) {
            valores += temporal.dato + " ";
            temporal = temporal.siguiente;
        }
        valores += "\n";
        temporal = primero;
        while (temporal != null) {
            valores += temporal.dato + "->" + temporal.lista.mostrar(primero) + "\n";
            temporal = temporal.siguiente;
        }
        return valores; 
    }
    
    public Grafo dijkstra (Grafo grafo, Nodo source) {
        source.setCosto(0);
        Set<Nodo> visitados = new HashSet<>();
        Set<Nodo> noVisitados = new HashSet<>();

        noVisitados.add(source);
        while (noVisitados.size() != 0) {
            Nodo actual = getLowestDistanceNode(noVisitados);
            noVisitados.remove(actual);
            ArrayList<Arco> links = actual.getLista().getArcos();
            for (Arco link : links) {
                Nodo adjacentNode = link.getDestino();
                int costoLink = link.getCosto();
                if (!visitados.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, costoLink, actual);
                    noVisitados.add(adjacentNode);
                }
            }
            visitados.add(actual);
        }
        Nodo temp = primero;
        while (temp != null) {
            String route = "";
            System.out.println("Nodo: " + temp.getDato() + " costo: " + temp.getCosto());
            for(Nodo node : temp.getCaminoCorto()){
                route += node.getDato() + " -> ";
            }
            System.out.println("Ruta mas corta: " + route);
            temp = temp.getSiguiente();
        }
        return grafo;
    }
    
    public Nodo getLowestDistanceNode (Set<Nodo> noVisitados) {
        Nodo lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Nodo node : noVisitados) {
            int distancia = node.getCosto();
            if (distancia < lowestDistance) {
                lowestDistance = distancia;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public void calculateMinimumDistance (Nodo destino, int costoLink, Nodo source) {
        int costoSource = source.getCosto();
        if (costoSource + costoLink < destino.getCosto()) {
            destino.setCosto(costoSource + costoLink);
            LinkedList<Nodo> shortestPath = new LinkedList<>(source.getCaminoCorto());
            shortestPath.add(source);
            destino.setCaminoCorto(shortestPath);
        }
    }

}
