import java.util.Scanner;     

public class Pila1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Pila a = new Pila();
    int n;
    n = sc.nextInt();
    a.llenar(n);
   
  }
}

class Vector {
  protected int max=50;
  protected int v[] = new int[max];

  public Vector() {
   
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
  public void adi(int elem){
    if (!esLlena()){
      tope++;
      v[tope] = elem;
    }
    else{
      System.out.println("PILA LLENA");
    }
  }
  public int elim(){
    int elem = 0;
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
      int elem = sc.nextInt();
      adi(elem);
      
    }
  }

  public void mostrar(){

    Pila aux = new Pila();
    while (!esVacia()) {

      int x = elim();
      System.out.println(x);
      aux.adi(x);
    }
    this.vaciar(aux);
  }
}
