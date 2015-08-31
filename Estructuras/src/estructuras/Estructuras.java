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
        arbolito.insertar("a");
        arbolito.insertar("b");
        arbolito.insertar("c");
        arbolito.insertar("d");
        arbolito.insertar("e");
        arbolito.preOrden(arbolito.Raiz);
    }
    
}
