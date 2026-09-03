import java.util.ArrayList;


/**
 *  Clase que implementa una tabla hash con encadenamiento separado para manejar colisiones.
 */
public class TablaHash{
    ArrayList<Nodo>[] tabla;

    public void tabla(){
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
        return indice;
    }

    /**
     * Metodo público para insertar un par clave y valor (Nodo) en la tabla hash.
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
     * Método público para buscar un valor asociado a una clave en la tabla hash.
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
     * Metodo publico para generar la impresión visual de la tabla
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

}