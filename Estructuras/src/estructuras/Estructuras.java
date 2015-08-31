/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author Denis
 */
public class Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolAVL arbolito = new ArbolAVL();
        arbolito.insertar("Pepe Monzon","correo01@hotmail.com");
        arbolito.insertar("Andrez Pascal","correo02@hotmail.com");
        arbolito.insertar("Jose Perez","correo03@hotmail.com");
        arbolito.insertar("Eduardo Gomez","correo04@hotmail.com");
        arbolito.insertar("Armando Paredes","correo05@hotmail.com");
        arbolito.insertar("Luci Fernanda","correo06@hotmail.com");
        arbolito.insertar("Pedro Cortez","correo07@hotmail.com");
        arbolito.insertar("Mario Bros","correo08@hotmail.com");
        arbolito.insertar("Mario Verde","correo09@hotmail.com");
        arbolito.insertar("Julio Cesar","correo10@hotmail.com");
        arbolito.insertar("Justiniano Primero","correo11@hotmail.com");
        arbolito.insertar("Belizario Segundo","correo12@hotmail.com");
        arbolito.insertar("Maximus Meridius","correo13@hotmail.com");
        arbolito.insertar("Juan Pablo","correo14@hotmail.com");
        arbolito.insertar("Jorge Mendoza","correo15@hotmail.com");
        arbolito.insertar("Marvin Escobar","correo16@hotmail.com");
        arbolito.insertar("Julio Mendoza","correo17@hotmail.com");
        arbolito.insertar("Mario Morales","correo18@hotmail.com");
        arbolito.insertar("Pedro juarez","correo19@hotmail.com");
        arbolito.insertar("Jose Joaquin","correo20@hotmail.com");
        arbolito.preOrden(arbolito.Raiz);
        Graphviz.Graficar(arbolito);
    }
    
}
