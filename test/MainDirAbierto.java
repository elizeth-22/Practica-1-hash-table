public class MainDirAbierto {
    public static void main (String [] args) {
        TablaHashDirAbierto tabla = new TablaHashDirAbierto();
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
    }
}