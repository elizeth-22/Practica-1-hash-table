public class Main {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash();
        //Tabla vacia
        if(tabla.buscar(10) == null){
            System.out.println("Prueba tabla vacia: OK");
        }else{
            System.out.println("Prueba de tabla vacia: ERROR");
        }
        System.out.println(tabla);

        //Insertar
        tabla.insertar(18, "Ana");
        tabla.insertar(18, "Ana");
        tabla.insertar(10, "Luis");
        tabla.insertar(23, "Elena");
        if("Ana".equals(tabla.buscar(18)) && "Luis".equals(tabla.buscar(10)) && "Elena".equals(tabla.buscar(23))){
            System.out.println("Prueba insercion : OK");
        }else{
            System.out.println("Prueba insercion: ERROR");
        }
        System.out.println(tabla);

        //Colision
        tabla.insertar(24, "Maria");
        tabla.insertar(31, "Carlos");
        if("Luis".equals(tabla.buscar(10)) && "Maria".equals(tabla.buscar(24)) && "Carlos".equals(tabla.buscar(31))){
            System.out.println("Prueba colision : OK ");
        }else{
            System.out.println("Prueba colision : ERROR");
        }
        System.out.println(tabla);

        //Eliminacion
        tabla.eliminar(24);
        if(tabla.buscar(24) == null && "Luis".equals(tabla.buscar(10)) && "Carlos".equals(tabla.buscar(31))){
            System.out.println("Prueba eliminar : OK");
        }else{
            System.out.println("Prueba eliminar : ERROR");
        }
        System.out.println("Tabla por eliminar 24: ");
        System.out.println(tabla);

        //Llave inexistente
        boolean elim = tabla.eliminar(471134323);
        if(!elim){
            System.out.println("Prueba llave inexistente: OK");
        }else{
            System.out.println("Prueba llave inexistente: ERROR");
        }
        System.out.println(tabla);

        //Actualizacion de llave
        tabla.insertar(18, "Ana Maria");

        if("Ana Maria".equals(tabla.buscar(18))){
            System.out.println("Prueba actualizacion de llave: OK");
        }else{
            System.out.println("Prueba actualizacion de llave : ERROR");
        }
        System.out.println(tabla);
        //Tabla llena
        tabla.eliminar(23);
        tabla.eliminar(10);
        tabla.eliminar(31);
        tabla.eliminar(18);

        tabla.insertar(0, "A");
        tabla.insertar(1, "B");
        tabla.insertar(2, "C");
        tabla.insertar(3, "D");
        tabla.insertar(4, "F");
        tabla.insertar(5, "G");
        tabla.insertar(6, "H");

        if("A".equals(tabla.buscar(0)) && "B".equals(tabla.buscar(1)) && "C".equals(tabla.buscar(2)) && "D".equals(tabla.buscar(3)) &&
        "F".equals(tabla.buscar(4)) && "G".equals(tabla.buscar(5)) && "H".equals(tabla.buscar(6))){
            System.out.println("Prueba tabla llena: OK");
        }else{
            System.out.println("Prueba tabla llena: ERROR");
        }
        System.out.println(tabla);
    }

    
}
