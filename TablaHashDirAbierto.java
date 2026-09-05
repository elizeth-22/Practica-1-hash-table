public class TablaHashDirAbierto {
    Nodo[] tabla;

    public TablaHashDirAbierto() {
        tabla = new Nodo[7];
    }

    public int hash(int key, int i){
        int indice = (key  % tabla.length + i) % tabla.length;
        return indice;
    }

}