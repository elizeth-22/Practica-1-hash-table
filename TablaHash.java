import java.util.ArrayList;

public class TablaHash{
    ArrayList<Nodo>[] = tabla[];
    tabla = new ArrayList[7];

    for (int i = 0; i < tabla.length; i++){
        tabla[i] = new ArrayList<Nodo>();
    }

    private int hash(int key){
        return key % tabla.length;
    }

    public void insertar (int key, String valor){
        int indice = obtenerIndice(key);
        ArrayList<Nodo> cubeta = tabla[indice];
    } 

    public int buscar(int key){
        
        int indice = obtenerIndice(key);
        ArrayList<Nodo> cubeta = tabla[indice];

        for (Nodo nodo : cubeta ) {
            if (nodo.key == key) {
                return nodo.valor;
            } else {
                return null;
            }
        }
    }
}