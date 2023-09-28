import java.util.Scanner;

public class nico {

  public static void main(String[] args) {
    ColaSimple c1 = new ColaSimple();
    c1.llenar(2);
    c1.mostrar();
    //A.
    prioridad(c1);
    c1.mostrar();
    //B.
    mostrarCiK(c1,1);
  }
  public static void prioridad(ColaSimple C){
    ColaSimple aux = new ColaSimple();
    int nro = C.nroElem();
    for (int i = 0; i < nro; i++) {
      Persona P = C.elim();
      if (P.getEdad()>60) {
        C.adi(P);
      }else{
        aux.adi(P);
      } 
    }
    C.vaciar(aux);
  }
  public static void mostrarCiK(ColaSimple C, int k){
    ColaSimple aux = new ColaSimple();
    while (!C.esVacia()) {
      Persona elem = C.elim();
      int ultiDig = elem.getCi()%10;
      if (ultiDig == k) {
        System.out.println("Mismo Ci ultimo digito: "+elem.getNombre());
      }
      aux.adi(elem);
    }
    C.vaciar(aux);
  }

}
class Persona{
  private String nombre;
  private int ci;
  private int edad;

  public Persona() {
    this.nombre = "";
    this.ci = 0;
    this.edad = 0;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getNombre(){
    return nombre;
  }
  public void setCi(int ci){
    this.ci = ci;
  }
  public int getCi(){
    return ci;
  }
  public void setEdad(int edad){
    this.edad = edad;
  }
  public int getEdad(){
    return edad;
  }
  public void mostrar(){
    System.out.println("Nombre: "+nombre);
    System.out.println("Ci: "+ci);
    System.out.println("Edad: "+edad);
  }
   public void leer(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Nombre: "); nombre = sc.nextLine();
    System.out.print("Ci: "); ci = sc.nextInt();
    System.out.print("Edad: "); edad = sc.nextInt();
  }
}
class Vector{
  protected int max = 50;
  protected Persona v[] = new Persona[max];

  public Vector() {
    for (int i = 0; i < max; i++) {
      v[i] = new Persona();
    }
  }
}
class Cola extends Vector {
  protected int fr;
  protected int fi;
  
  public Cola() {
    super();
    fr = fi = -1;
  }
}
class ColaSimple extends Cola {
  public ColaSimple() {
    super();
  }
  public boolean esVacia() {
    return (fr == fi) ? true : false;
  }
  public boolean esLlena() {
    return (fi == max) ? true : false;
  }
  public void adi(Persona elem){
    if (!esLlena()) {
      fi++;
      v[fi] = elem;
    }else{
      System.out.println("COLA LLENA");
    }
  }
  public Persona elim(){
    Persona elem = new Persona();
    if (!esVacia()) {
      fr++;
      elem = v[fr];   
    }else{
      System.out.println("COLA VACIA");
    }
    return elem;
  }
  public int nroElem(){
    return fi - fr;
  }
  public void vaciar(ColaSimple X){
    while (!X.esVacia()) {
      adi(X.elim());
    } 
  }
  public void llenar(int n){
    for (int i = 0; i < n; i++) {
      Persona elem = new Persona();
      elem.leer();
      this.adi(elem); 
    }
  }
  public void mostrar(){
    ColaSimple aux = new ColaSimple();
    while (!esVacia()) {
      Persona elem = elim();
      elem.mostrar();
      aux.adi(elem);
    }
    vaciar(aux); 
  }
}
 
