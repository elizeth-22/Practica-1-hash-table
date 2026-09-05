public class TablaHashDirAbierto {
    Nodo[] tabla;

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
            if (tabla[indice] = null) {
                tabla[indice] = new Nodo(int key, String valor);
            } else if (tabla[indice].key == key) {
                tabla[indice].valor = valor;
                break;
            }
        }
    }
            
}