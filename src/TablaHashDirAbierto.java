/**
 * Clase que implementa una tabla hash con direccionamiento abierto
 * implementando sondeo lineal para manejar colisiones y la bandera 
 * DELETED para marcar elementos eliminados
 */
public class TablaHashDirAbierto {
    Nodo[] tabla;
    /**
     * Nodo especial que representa un elemento eliminado en la tabla hash.
     */
    static Nodo DELETED = new Nodo(-17, "DELETED");

    public TablaHashDirAbierto() {
        tabla = new Nodo[7];
    }

    /**
     * Metodo para calcular el indice hash de una key con sondeo lineal.
     * @param key la clave para calcular el indice hash.
     * @param i el numero de intentos (o vueltas) de sondeo lineal.
     * @return el indice hash.
     */
    public int hash(int key, int i){
        int indice = (key  % tabla.length + i) % tabla.length;
        return indice;
    }

    /**
     * Metodo para insertar un Nodo (key, valor) en la tabla
     * @param key la clave del elemento a insertar.
     * @param valor el valor asociado a la clave.
     * Si la key ya existe en la tabla, solo se actualiza el valor.
     */
    public void insertar(int key, String valor) {
        int i = 0;
        while (true) {
            int indice = hash(key, i);
            if (tabla[indice] == null || tabla[indice] == DELETED) {
                tabla[indice] = new Nodo(key, valor);
                break;
            } else if (tabla[indice] != DELETED && tabla[indice].key == key) {
                tabla[indice].valor = valor;
                break;
            } else {
                i++;
            }
        }
    }

    /**
     * Metodo para eliminar un elemento de la tabla hash dado su key
     * Se utiliza la bandera DELETED para marcar el elemento como eliminado
     * @param key la clave del elemento a eliminar.
     * @return true si el elemento fue eliminado, false si no se encontro.
     */
    public boolean eliminar(int key) {
        int i = 0;
        while (true) {
            int indice = hash(key, i);
            if (tabla[indice] == null) {
                return false;
            } else if (tabla[indice] != DELETED && tabla[indice].key == key) {
                tabla[indice] = DELETED;
                return true;
            } else {
                i++;
            }
        }
    }

    /**
     * Metodo para buscar un elemento en la tabla hash dado su key
     * @param key la clave del elemento a buscar
     * @return el valor asociado a la clave, o null si no se encuentra
     */
    public String buscar(int key){
        int i = 0; 
        while(true) {
            int indice = hash(key, i);
            if(tabla[indice] == null){
                return null;
            } else if (tabla[indice] != DELETED && tabla[indice].key == key){
                return tabla[indice].valor;
            } else {
                i++;
            }
        }
    }

    /**
     * Metodo para calcular el factor de carga de la tabla hash
     * @return el factor de carga (numero de elementos / tamaño de la tabla)
     */
    public double factorDeCarga() {
        int tamanoTotal = 0;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null && tabla[i] != DELETED) {
                tamanoTotal++;
            }
        }
        return (double) tamanoTotal / tabla.length;
    }
}