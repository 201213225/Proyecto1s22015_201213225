/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.text.Collator;

/**
 *
 * @author Denis
 */
public class ArbolAVL {

    NodoAVL Raiz;
    public ArbolAVL(){
        Raiz = null;
    }
    public NodoAVL buscar(String Nombre, NodoAVL Nodo){
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.TERTIARY);
        if(Raiz==null){
            return null;
        }else if(comparador.compare(Nombre, Nodo.Nombre)==0){
            return Nodo;
        }else if(comparador.compare(Nombre, Nodo.Nombre)<0){
            return buscar(Nombre,Nodo.Der);
        }else{
            return buscar(Nombre,Nodo.Izq);
        }
    }
    public int obtenerFE(NodoAVL Nodo){
        if(Nodo == null){
            return -1;
        }else{
            return Nodo.fe;
        }
    }
    public NodoAVL rotacionIzq(NodoAVL Nodo){
        NodoAVL Aux = Nodo.Izq;
        Nodo.Izq = Aux.Der;
        Aux.Der = Nodo;
        Nodo.fe = Math.max(obtenerFE(Nodo.Izq), obtenerFE(Nodo.Der)) +1;
        Aux.fe = Math.max(obtenerFE(Aux.Izq), obtenerFE(Aux.Der)) +1;
        return Aux;
    }
    public NodoAVL rotacionDer(NodoAVL Nodo){
        NodoAVL Aux = Nodo.Der;
        Nodo.Der = Aux.Izq;
        Aux.Izq = Nodo;
        Nodo.fe = Math.max(obtenerFE(Nodo.Izq), obtenerFE(Nodo.Der)) +1;
        Aux.fe = Math.max(obtenerFE(Aux.Izq), obtenerFE(Aux.Der)) +1;
        return Aux;
    }
    public NodoAVL rotacionDobleIzq(NodoAVL Nodo){
        NodoAVL Aux;
        Nodo.Izq=rotacionDer(Nodo.Izq);
        Aux = rotacionIzq(Nodo);
        return Aux;
    }
    public NodoAVL rotacionDobleDer(NodoAVL Nodo){
        NodoAVL Aux;
        Nodo.Der=rotacionIzq(Nodo.Der);
        Aux = rotacionDer(Nodo);
        return Aux;
    }
    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr){
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.TERTIARY);
        NodoAVL nuevoPadre = subAr;
        if(comparador.compare(nuevo.Correo, subAr.Correo)<0){
            if(subAr.Izq==null){
                subAr.Izq = nuevo;
            }else{
                subAr.Izq = insertarAVL(nuevo,subAr.Izq);
                if((obtenerFE(subAr.Izq)-obtenerFE(subAr.Der)==2)){
                    if(comparador.compare(nuevo.Correo, subAr.Izq.Correo)<0){
                        nuevoPadre = rotacionIzq(subAr);
                    }else{
                        nuevoPadre = rotacionDobleIzq(subAr);
                    }
                }
            }
        }else if(comparador.compare(nuevo.Correo, subAr.Correo)>0){
            if(subAr.Der==null){
                subAr.Der = nuevo;
            }else{
                subAr.Der = insertarAVL(nuevo,subAr.Der);
                if((obtenerFE(subAr.Der)-obtenerFE(subAr.Izq)==2)){
                    if(comparador.compare(nuevo.Correo, subAr.Der.Correo)>0){
                        nuevoPadre = rotacionDer(subAr);
                    }else{
                        nuevoPadre = rotacionDobleDer(subAr);
                    }
                }
            }
        }else{
            System.out.println("nodo duplicado");
        }
        if((subAr.Izq==null)&&(subAr.Der!=null)){
            subAr.fe=subAr.Der.fe+1;
        }else if((subAr.Der==null)&&(subAr.Izq!=null)){
            subAr.fe=subAr.Izq.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.Izq), obtenerFE(subAr.Der))+1;
        }
        return nuevoPadre;
    }
    public void insertar(String nombre, String correo){
        NodoAVL nuevo = new NodoAVL(nombre, correo);
        if(Raiz==null){
            Raiz = nuevo;
        }else{
            Raiz = insertarAVL(nuevo,Raiz);
        }
    }
    public void inOrden(NodoAVL Nodo){
        if(Nodo!=null){
            inOrden(Nodo.Izq);
            System.out.println(Nodo.Nombre);
            inOrden(Nodo.Der);
        }
    }
    public void preOrden(NodoAVL Nodo){
        if(Nodo!=null){
            System.out.println(Nodo.Nombre);
            preOrden(Nodo.Izq);
            preOrden(Nodo.Der);
        }
    }
    public void postOrden(NodoAVL Nodo){
        if(Nodo!=null){
            postOrden(Nodo.Izq);
            postOrden(Nodo.Der);
            System.out.println(Nodo.Nombre);
        }
    }
}