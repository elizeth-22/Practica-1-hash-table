public class TablaHashDirAbierto {
    Nodo[] tabla;
    static Nodo DELETED = new Nodo(-1, "DELETED");

    public TablaHashDirAbierto() {
        tabla = new Nodo[7];
    }

    public int hash(int key, int i){
        int indice = (key  % tabla.length + i) % tabla.length;
        return indice;
    }

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
}