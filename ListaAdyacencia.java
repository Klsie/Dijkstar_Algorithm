
package grafos;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Arana
 */
public class ListaAdyacencia {
   
    Arco primero,ultimo;

    public Arco getPrimero() {
        return primero;
    }

    public void setPrimero(Arco primero) {
        this.primero = primero;
    }

    public Arco getUltimo() {
        return ultimo;
    }

    public void setUltimo(Arco ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean esVacio(){
        return primero == null;
    }
    
    public ListaAdyacencia(){
        primero = null;
        ultimo = null;
    }
    
    public boolean esAdyacente(Nodo nodo){
        Arco actual;
        boolean encontrado = false;
        actual = primero;
        while(actual != null && !nodo.getDato().equals(actual.destino.getDato())){
            actual = actual.getSiguiente();          
        }
        if(actual != null){
            encontrado = true;
        }
        return encontrado;
    }
    
    public void insertar(Arco nodo, Nodo destino){
        if(esVacio()){
            primero = nodo;
            ultimo = nodo;
        }else{
            if(destino.getDato().compareTo(primero.destino.getDato()) <= 0){
                nodo.setSiguiente(primero);
                primero = nodo;
            } else {
                if(destino.getDato().compareTo(primero.destino.getDato()) >= 0){
                    ultimo.setSiguiente(nodo);
                    ultimo = nodo;
                } else{
                    Arco posicion = primero;
                    while(destino.getDato().compareTo(primero.destino.getDato()) != 0){
                        posicion = posicion.getSiguiente();
                    }
                    nodo.setSiguiente(posicion.getSiguiente());
                    posicion.setSiguiente(nodo);
                }
            }
            
        }
    }
    
    
    public String mostrar(Nodo first){
       String valores = "";
        
        Arco temporal = primero;
        Nodo nodo = first;
        while (temporal != null) {
            while (nodo != null) {
                if (esAdyacente(nodo)) {
                    valores += 1 + " ";
                } else {
                    valores += 0 + " ";
                }
                nodo = nodo.siguiente;
            }
            temporal = temporal.siguiente;
        }
        return valores; 
    }
    
    public ArrayList getArcos(){
        ArrayList <Arco> arcos = new ArrayList<Arco>();
        Arco temporal= primero;
        while(temporal != null){
            arcos.add(temporal);
            temporal = temporal.getSiguiente();
        }
        return arcos;
    }

    public void nuevaAdyacencia(Nodo destino, int costo) {
        if(!esAdyacente(destino)){
            Arco nodo = new Arco(destino, costo);
            insertar(nodo, destino);
        }
    }
}
