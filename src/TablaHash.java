import java.util.ArrayList;

/**
 *  Clase que implementa una tabla hash con encadenamiento separado para manejar colisiones.
 */
public class TablaHash{
    ArrayList<Nodo>[] tabla;

    /**
     * Constructor de la clase TablaHash. Inicializa la tabla hash con un tamaño inicial de 7 y crea una lista vacía para cada cubeta.  
     */
    public TablaHash(){
        tabla = new ArrayList[7];
        for (int i = 0; i < tabla.length; i++){
            tabla[i] = new ArrayList<Nodo>();
        } 
    }
    
    /** 
     * Metodo privado para calcular el indice hash de una clave.
     * @param key la clave para calcular el indice hash.
     * @return el indice hash.
     */
    public int hash(int key){
        int indice = key % tabla.length;
        if (indice < 0){
            indice += tabla.length;
        }
        return indice;
    }

    /**
     * Metodo para insertar un par clave y valor (Nodo) en la tabla hash.
     * 
     * @param key la clave del elemento a insertar.
     * @param valor el valor asociado a la clave.
     */
    public void insertar (int key, String valor){
        int indice = hash(key);
        ArrayList<Nodo> cubeta = tabla[indice];
        for (Nodo nodo : cubeta) {
            if (nodo.key == key) {
                nodo.valor = valor;
                return;
            }
        }
        Nodo nuevoNodo = new Nodo(key, valor);
        cubeta.add(nuevoNodo);
    } 

    /**
     * Metodo para eliminar un elemento de la tabla hash dado su clave.
     * @param key la clave del elemento a eliminar.
     * @return true si el elemento fue eliminado, false si no se encontró la clave.
     */
    public boolean eliminar(int key) {
        int pos = hash(key);
        ArrayList<Nodo> cubeta = tabla[pos];
        for(Nodo nodo : cubeta){
            if(nodo.key == key){
                cubeta.remove(nodo);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para buscar un valor asociado a una clave en la tabla hash.
     * @param key la clave para buscar.
     * @return el valor asociado a la clave, o null si no se encuentra.
     */
    public String buscar(int key){
        int indice = hash(key);
        ArrayList<Nodo> cubeta = tabla[indice];

        for (Nodo nodo : cubeta ) {
            if (nodo.key == key) {
                return nodo.valor;
            }
        }
        return null;
    }

    /**
     * Metodo para generar la impresión de ta tabla en la terminal
     * @return impresion de la tabla
     */
    @Override
    public String toString(){
        String acumula = ""; 
        //recorre la tabla
        for (int i = 0; i< tabla.length  ; i++) {
            acumula += i + " -> ";
            //recorre cada cubeta
            for (int j = 0; j < tabla[i].size(); j++ ) {
                Nodo nodo = tabla[i].get(j);
                if (j < tabla[i].size() - 1) { 
                    acumula += "(" + nodo.key + "," + nodo.valor + ")" + " -> ";  
                } else{
                    acumula += "(" + nodo.key + "," + nodo.valor + ")";
                }
            }
            acumula += "\n";
        }
        return acumula;
    }

    /**
     * Metodo para calcular el factor de carga de la tabla hash
     * @return factor de carga
     */
    public double factorDeCarga() {
        int tamanoTotal = 0;
        double factorCarga;
        for (int i = 0; i < tabla.length; i++) {
            tamanoTotal = tamanoTotal + tabla[i].size();
        }
        factorCarga = (double) tamanoTotal / tabla.length;
        return factorCarga;
    }
}