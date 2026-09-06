# Practica-1-hash-table
# Preguntas README:<br>

## ¿Por qué tener una colisión no significa que la tabla hash esté implementada incorrectamente?
Ya que las tablas hash se encargan de distribuir una cantidad enorme de llaves, por lo que por el principo del palomar el numero de posibles claves es mayor al numero de posiciones en la tabla, pero igual una buena implementación se encarga de manejar esas colisiones, con encadenamiento o direccionamiento abierto<br>

## 1. lenguaje utilizado <br>
Java<br>

## 2. instrucciones para ejecutar el programa:
Primero para compilar: javac -cp src test/Main.java <br>
O para compilar la tabla con direccionamiento abierto: javac -cp src test/MainDirAbierto.java <br>
Despues para ejecutar con las pruebas: java -cp test:src Main

## 3. explicación de cómo ejecutar los casos de prueba;
ejecutar: java -cp test:src Main <br> 
ejecutar con direccionamiento abierto: java -cp test:src MainDirAbierto
## 4. explicación de la función hash<br>
Calcula el modulo de la llave, para así obtener el indice, despues en casos de las llaves negativas se crea un espacio en la tabla con indice positivo. <br>

## 5. explicación del manejo de colisiones;<br>
Cada colisión en Tabla Hash, se  maneja teniendo un arrelgo a traves de un "if" cuando ocurre la colisión, se agrega al final del arreglo en la posición de la llave.<br>
Mientras que en Tabla Hash Dir Abierto, se encarga de buscar la siguiente posición desocupada para colocar cuando ocurrio una colisión<br>

## 6. explicación de qué ocurre cuando dos llaves producen el mismo hash;<br>
En Tablas Hash, ambas se almacenan en la misma cubeta (en el mismo ArrayList), se agrega un nuevo nodo al final de la lista y en la busqueda recorre la lista para encontrar la clave especifica.<br>
En Tabla Hash Dir Abierto ocurre la colisión causando que entre el manejo de colocarla en la siguiente posición libre que encuentre.<br>

## 7. explicación de qué ocurre cuando varias llaves caen en la misma cubeta;<br>
En Tabla Hash Dir no puedo ocurrir que caigan en la misma cubeta por su manejo de colisiones, por lo que se distribuyen en la tabla sin que exista una cubeta explicita que las contenga.<br>
En Tabla Hash, se usa el manejo de la colisión donde todas conviven en un ArrayList. <br>

## 8. factor de carga final obtenido durante sus pruebas.<br>
Hay 4 elementos y un total de ocupación de 7 cubetas por lo que: <br>
FACTOR DE CARGA: 4/7 ≈ 0.5714.<br>

documentación en el archivo README.md.
