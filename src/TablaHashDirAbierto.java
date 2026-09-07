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

    /**
     * Constructor de la clase TablaHashDirAbierto. Inicializa la tabla hash con un tamaño inicial de 7.
     */
    public TablaHashDirAbierto() {
        tabla = new Nodo[7];
    }

    /**

     * Metodo para calcular el indice hash de una key con sondeo lineal.
     * @param key la clave para calcular el indice hash.
     * @param i el numero de intentos (o vueltas) de sondeo lineal.
     * @return el indice hash.
     * Calcula la posición en el arreglo mediante una función de busqueda lineal.
     * @param key
     * @param i
     * @return regresa el indice valido
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
     * Inserta un nuevo par clave-valor en la tabla, si la clave existe actualiza su valor asociado
     * si ocure una colisión pasa a la siguiente casilla disponible.
     * @param key
     * @param i
     */
    public void insertar(int key, String valor) {
        int i = 0;
        while (i < tabla.length) {
            int indice = hash(key, i);
            if (tabla[indice] == null || tabla[indice] == DELETED) {
                tabla[indice] = new Nodo(key, valor);
                return;
            } else if (tabla[indice] != DELETED && tabla[indice].key == key) {
                tabla[indice].valor = valor;
                return;
            } else {
                i++;
            }
        } 
        throw new RuntimeException("Tabla llena, no se puede insertar el elemento.");
    }

    /**
     * Metodo para eliminar un elemento de la tabla hash dado su key
     * Se utiliza la bandera DELETED para marcar el elemento como eliminado
     * @param key la clave del elemento a eliminar.
     * @return true si el elemento fue eliminado, false si no se encontro.
     * Elimina un elemento de la tabla asociando la etiqueta Deleted
     * @param key
     * @return si la clave fue encontrada y eliminada regresa true
     * @return false en caso contrario
     */
    public boolean eliminar(int key) {
        int i = 0;
        while (i < tabla.length) {
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
        return false;
    }


    /**
     * Busca un elemento asociado a una clave dentro de la tabla hash.
     * 
     * @param key La clave entera del elemento a buscar.
     * @return El valor asociado a la clave, o null si la clave no existe.
     */
    public String buscar(int key){
        int i = 0; 
        while(i < tabla.length) {
            int indice = hash(key, i);
            if(tabla[indice] == null){
                return null;
            } else if (tabla[indice] != DELETED && tabla[indice].key == key){
                return tabla[indice].valor;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * Metodo para calcular el factor de carga de la tabla hash
     * @return el factor de carga (numero de elementos / tamaño de la tabla)
     * Calcula la relación entre la cantidad de elementos activos ocupados y la capacidad total de la tabla.
     * Excluye las casillas vacías (null) y las marcadas como DELETED.
     *
     * @return Factor de carga actual como un valor numérico decimal (double).
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

    /**
     * Metodo para generar la impresión de la tabla en la terminal
     * @return impresion de la tabla
     */
    @Override
    public String toString(){
        String acumula = ""; 
        // recorre la tabla
        for (int i = 0; i < tabla.length; i++) {
            acumula += i + " -> ";
            
            if (tabla[i] == null) {
                acumula += "null";
            } else if (tabla[i] == DELETED) {
                acumula += "DELETED";
            } else {
                acumula += "(" + tabla[i].key + "," + tabla[i].valor + ")";
            }
            
            acumula += "\n";
        }
        return acumula;
    }
}