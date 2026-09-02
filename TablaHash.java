import java.util.ArrayList;

public class TablaHash{
    ArrayList<Nodo>[] tabla;

    public void tabla(){
        tabla = new ArrayList[7];
        for (int i = 0; i < tabla.length; i++){
            tabla[i] = new ArrayList<Nodo>();
        } 
    }
    

    private int hash(int key){
        return key % tabla.length;
    }

    public void insertar (int key, String valor){
        int indice = hash(key);
        ArrayList<Nodo> cubeta = tabla[indice];
    } 

    public int buscar(int key){
            
        int indice = hash(key);
        ArrayList<Nodo> cubeta = tabla[indice];

        for (Nodo nodo : cubeta ) {
            if (nodo.key == key) {
                return nodo.valor;
            } else {
                return null;
            }
        }
    }

    /**
     * Metodo publico para generar la impresión visual de la tabla
     * @return impresion de la tabla
     * */
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