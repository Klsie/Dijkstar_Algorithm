
package grafos;

public class Arco {
    Nodo destino;
    int costo;
    Arco siguiente;
    
    public Arco(Nodo destino){
        this.destino = destino;
        siguiente = null;
    }
    
    public Arco(Nodo destino, int costo){
        this.destino = destino;
        this.costo = costo;
        siguiente = null;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Arco getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Arco siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
