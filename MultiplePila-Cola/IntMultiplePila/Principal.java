/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author noemi
 */
public class Principal {

    public static void main(String[] args) {
        MpPila MP1 = new MpPila();
        MP1.llenar(3);
        MP1.mostrar();
    }   
}
class Vector {
    protected int max = 50;
    protected int v[] = new int [max];
    
    public Vector() {
        
    }
}
class Pila extends Vector {
    private int tope;
    
    public Pila() {
        super();
        tope = -1;
    }
    public boolean esVacia() {
        return (tope == -1);
    }
    public boolean esLlena() {
        return (tope == max-1);
    }
    public void adi(int elem) {
        if(!esLlena()) {
            tope ++;
            v[tope] = elem;
        } else
            System.out.println("PILA LLENA");
    }
    public int eli() {
        int elem = 0;
        if(!esVacia()) {
            elem = v[tope];
            tope--;
        } else
            System.out.println("PILA VACIA");
        return elem;
    }
    public int nroElem() {
        return tope+1;
    }
    public void vaciar(Pila Z) {
        while(!Z.esVacia()) 
            adi(Z.eli());
    }
    public void llenar(int n) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++) {
            int elem = sc.nextInt();
            adi(elem);
        }
    }
    public void mostrar() {
        Pila aux = new Pila();
        while(!esVacia()) {
            int elem = eli();
            System.out.print(elem+" ");
            aux.adi(elem);
        }
        System.out.println();
        this.vaciar(aux);
    }
}
class MpPila {
    private int n;
    private Pila c[] = new Pila[100];
    
    public MpPila() {
        for(int i=0; i<100; i++)
            c[i] = new Pila();
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public int nroElem(int i) {
        return c[i].nroElem();
    }
    public boolean esVacia(int i) {
        return c[i].esVacia();
    }
    public boolean esLlena(int i) {
        return c[i].esLlena();
    }
    public void adi(int i, int elem) {
        c[i].adi(elem);
    }
    public int eli(int i) {
        return c[i].eli();
    }
    public void llenar(int i, int n) {
        c[i].llenar(n);
    }
    public void llenar(int n) {
        Scanner sc = new Scanner(System.in);
        this.n = n;
        for(int i=0; i<n; i++) {
            System.out.print("Numero de elementos en la pila "+i+": ");
            int np = sc.nextInt();
            c[i].llenar(np);
        }
    }
    public void mostrar(int i) {
        c[i].mostrar();
    }
    public void mostrar() {
        for(int i=0; i<this.n; i++) {
            System.out.println("MOSTRAR DATO PILA "+i);
            c[i].mostrar();
        }
    }
    public void vaciar(int i, Pila Z) {
        c[i].vaciar(Z);
    }
    public void vaciar(int i, int j) {
        c[i].vaciar(c[j]);
    }
}
