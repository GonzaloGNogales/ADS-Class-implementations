public class HashTable<K,V> {
    /*
       Tamaño de la tabla N = 13
       n = 8
       Colisiones por direccionamiento abierto.
       h(k,i) = h2(h1(x)) + i, donde i = 0,1,2,...,+oo.
                                                            h(k) = h2(h1(k))
                                                            h1: Object ---> int
       [][][][][][][][][][][] [] []                         h2: int ---> {0, N-1}
       0 1 2 3 4 5 6 7 8 9 10 11 12                         ----------------------
                                                              h2 = x mod 13
       <18,"A"> = h(18) = 5

       [][][][][][18,"A"][][][][][] [] []
       0 1 2 3 4    5    6 7 8 9 10 11 12

       <41,"Y"> = h(41) = 2  //  <22,"C"> = h(22) = 9  //  <44,"D"> = h(44) = 5 - 6 -> SE REPITE EL 5, COLISIÓN!!!!
                                                                      por lo que se le suma 1 hasta que esté libre.
       [][][41,"Y"][][][18,"A"][44,"D"][][][22,"C"][] [] []
       0 1    2    3 4    5       6    7 8    9    10 11 12

       <59,"E"> = h(59) = 7  //  <32,"F"> = h(32) = 6 - 7 - 8  //  <31,"Z"> = h(31) = 5 - 6 - 7 - 8 - 9 - 10  //
       <23,"W"> = h(23) = 8 - 9 - 10 - 11

       [][][41,"Y"][][][18,"A"][44,"D"][59,"E"][32,"F"][22,"C"][31,"Z"] [23,"W"] []
       0 1    2    3 4    5       6       7       8       9       10       11    12

       CLUSTERING PRIMARIO (Agrupación Primaria) ===> Fenómeno que sucede en las tablash hash por direccionamiento abierto
       que indica que la probabilidad de ocupar espacios libres aumenta cuanto más elementos se inserten en la tabla.
       El clustering primario expone la degradación en eficiencia de las tablas hash, cuanto mayor es el cluster, menor es
       la eficiencia.
     */



}
