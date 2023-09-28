import java.util.Scanner;

public class Principal{
  public static void main(String[] args) {
    Pila p1 = new Pila();
    p1.llenar(3);
    //p1.mostrar();

    //A.
    mostrarAprobados(p1);
    //B.
    System.out.println(verificarEstudiante(p1,"Noemi") ? "Si envio" : "No envio");
    //C.
    System.out.println(promedio(p1,2));
  }
  public static void mostrarAprobados(Pila P) {
    Pila aux = new Pila();
    while(!P.esVacia()) {
      Practica elem = P.elim();
      if(elem.getNota() > 50)
        elem.mostrar();
      aux.adi(elem);
    }
    P.vaciar(aux);
  }
  public static boolean verificarEstudiante(Pila P, String X){
    Pila aux = new Pila();
    boolean a = false;
    while (!P.esVacia()) {
      Practica elem = P.elim();
      if (elem.getNombre().equals(X)) {
        a = true;
      }
      aux.adi(elem);
    }
    P.vaciar(aux);
    return a;
  }
  public static double promedio(Pila P, int k){
    Pila aux = new Pila();
    int i = 0;
    double sum  = 0;
    while (!P.esVacia()) {
      Practica elem = P.elim();
      if (elem.getNumP() == k) {
        i++;
        sum = sum + elem.getNota();
      }
      aux.adi(elem);
    }
    P.vaciar(aux);
    return sum/i;
  } 
  
} 

class Practica{
  private int nota;
  private String nombre;
  private int numP;

  public Practica(){
    this.nota = 100;
    this.nombre = "";
    this.numP = 0;
  }
  public void setNota(int nota){
    this.nota = nota;
  }
  public int getNota(){
    return this.nota;
  }
   public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getNombre(){
    return this.nombre;
  }
 public void setNumP(int numP){
    this.numP = numP;
  }
  public int getNumP(){
    return this.numP;
  }
  public void leer (){
    Scanner sc = new Scanner(System.in);
    System.out.print("Nombre: "); nombre = sc.nextLine();
    System.out.print("Nota: "); nota = sc.nextInt();
    System.out.print("Nro Practica: "); numP = sc.nextInt();
  }
  public void mostrar(){

    System.out.println("Nombre: "+ nombre);  
    System.out.println("Nota: "+ nota); 
    System.out.println("Nro Practica: "+ numP);  
  }
}

class Vector{
  
  protected int max=50;
  protected Practica v[] = new Practica[max];

  public Vector() {
    for (int i = 0; i < max; i++) {
      v[i] = new Practica();
    }
  }
}
class Pila extends Vector{

  private int tope;

  public Pila() {
    super();
    tope = -1;
  }
  public boolean esVacia() {
    if(tope == -1)
      return true;
    return false;
  }
  public boolean esLlena() {
    if(tope == max-1)
      return true;
    return false;
  }
  public void adi(Practica elem){
    if (!esLlena()){
      tope++;
      v[tope] = elem;
    }
    else{
      System.out.println("PILA LLENA");
    }
  }
  public Practica elim(){
    //INSTANCIA O TE DARA ERROR
    Practica elem = new Practica();
    if (!esVacia()) {
      elem = v[tope];
      tope--;
    } else {
      System.out.println("PILA VACIA");
    }
    return elem;
  }
  public int numElem(){
    return tope+1;
  }
  public void vaciar(Pila Z){
    while (!Z.esVacia()) {
      adi(Z.elim());
      
    }
  } 

  public void llenar(int n){
    Scanner sc = new Scanner(System.in); 

    for (int i = 0; i < n; i++) {
      Practica elem = new Practica();
      elem.leer();
      adi(elem);
      
    }
  }

  public void mostrar(){

    Pila aux = new Pila();
    while (!esVacia()) {

      Practica x = elim();
      x.mostrar();
      aux.adi(x);
    }
    this.vaciar(aux);
  }
}
