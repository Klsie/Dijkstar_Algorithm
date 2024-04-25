package grafos;

public class Ggrafos {

    static Grafo grafo = new Grafo();

    public static void main(String[] args) {
        Nodo nodo1 = new Nodo("A");
        Nodo nodo2 = new Nodo("B");
        Nodo nodo3 = new Nodo("C");
        Nodo nodo4 = new Nodo("D");
        Nodo nodo5 = new Nodo("E");

        grafo.nuevoNodo(nodo1);
        grafo.nuevoNodo(nodo2);
        grafo.nuevoNodo(nodo3);
        grafo.nuevoNodo(nodo4);
        grafo.nuevoNodo(nodo5);
        
        
        grafo.nuevoArco(nodo5, nodo3,4); 
        grafo.nuevoArco(nodo4, nodo2,53); 
        grafo.nuevoArco(nodo1, nodo4,12); 
        grafo.nuevoArco(nodo3, nodo1,12);
        grafo.nuevoArco(nodo2, nodo1,8); 
        grafo.nuevoArco(nodo2, nodo5,10); 

        System.out.println(grafo.mostrar());

        grafo = grafo.dijkstra(grafo, nodo1);

    }

}
