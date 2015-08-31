/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author Denis
 */
public  class Graphviz {
    static String nodos = "";
    static String aristas = "";
    static String cadena = "";
    public static void Graficar(ArbolAVL Arbol){
        cadena = "";
        nodos = "";
        aristas = "";
        if(Arbol!=null){
            Recorrer(Arbol.Raiz);
            cadena = "digraph structs {\nnode [shape=oval];\n"+nodos+aristas+"}";
            EscribirFichero("AVL.dot", cadena);
            dibujar("AVL.dot", "AVL.png");
        }
        
    }
    private static void Recorrer(NodoAVL Nodo){
            nodos = nodos + "\""+Nodo.Nombre+"\"" + "[label=\"Nombre: "+Nodo.Nombre+"\\nCorreo: "+Nodo.Correo+"\"];\n";
            if(Nodo.Izq!=null){
                aristas = aristas+"\""+Nodo.Nombre+"\"->\""+Nodo.Izq.Nombre+"\";\n";
                Recorrer(Nodo.Izq);
            }
            if(Nodo.Der!=null){
                aristas = aristas+"\""+Nodo.Nombre+"\"->\""+Nodo.Der.Nombre+"\";\n";
                Recorrer(Nodo.Der);
            }
            
            
    }

    private static void EscribirFichero(String ArchDot, String cadena) {
        Writer fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ArchDot);
            pw = new PrintWriter(fichero);
            pw.write(cadena);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            File fichero = new File(direccionDot);
            while (!fichero.exists()) {
            }

            System.out.println(direccionDot);
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
