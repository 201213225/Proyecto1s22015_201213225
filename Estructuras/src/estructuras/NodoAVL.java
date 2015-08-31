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
public class NodoAVL {
    NodoAVL Izq;
    NodoAVL Der;
    String Nombre,Correo;
    int fe;
    public NodoAVL(String Nombre,String Correo){
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Izq = null;
        this.Der = null;
        this.fe = 0;
    }
}
