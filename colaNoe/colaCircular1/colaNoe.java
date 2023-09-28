import java.util.Scanner;
public class colaNoe {

  public static void main(String[] args) {
    ColaCircular c1 = new ColaCircular();
    c1.llenar(3);
    c1.mostrar();
  }
}
class Vector {
  protected int max = 50;
  protected int v[] = new int[max];

  public Vector() {

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
class ColaCircular extends Cola {
  public ColaCircular() {
    super();
  }
  public int nroElem() {
    return (fi - fr + max) % max;
  }
  public boolean esVacia() {
    return (nroElem() == 0);
  }
  public boolean esLLena() {
    return (nroElem() == max - 1);
  }
  public void adi(int elem) {
    if(!esLLena()) {
      fi = (fi+1) % max;
      v[fi] = elem;
    } else
      System.out.println("COLA CIRCULAR LLENA");
  }
  public int eli() {
    int elem = 0;
    if(!esVacia()) {
      fr = (fr+1) % max;
      elem = v[fr];
    } else
      System.out.println("COLA CIRCULAR VACIA");
    return elem;
  }
  public void llenar(int n) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      int elem = sc.nextInt();
      adi(elem);
    }
  }
  public void vaciar(ColaCircular Z) {
    while(!Z.esVacia()) {
      adi(Z.eli());
    }
  }
  public void mostrar() {
    ColaCircular aux = new ColaCircular();
    while(!esVacia()) {
      int elem = eli();
      System.out.println(elem);
      aux.adi(elem);
    }
    this.vaciar(aux);
  }
}
class ColaSimple extends Cola {
  public ColaSimple() {
    super();
  }
  public boolean esVacia() {
    if(fr == fi)
      return true;
    return false;
  }
  public boolean esLlena() {
    if(fi == max-1)
      return true;
    return false;
  }
  public void adi(int elem) {
    if(esLlena()) {
      System.out.println("COLA LLENA");
    } else {
      fi++;
      v[fi] = elem;
    }
  }
  public int eli() {
    int elem = 0;
    if(esVacia()) {
      System.out.println("COLA VACIA");
    } else {
      fr++;
      elem = v[fr];
    }
    return elem;
  }
public int nroElem() {
    return fi - fr;
  }
  public void vaciar(ColaSimple Z) {
    while(!Z.esVacia())
      adi(Z.eli());
  }
  public void llenar(int n) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < n; i++) {
      int elem = sc.nextInt();
      adi(elem);
    }
  }
  public void mostrar() {
    ColaSimple aux = new ColaSimple();
    while(!esVacia()) {
      int elem = eli();
      System.out.println(elem);
      aux.adi(elem);
    }
    vaciar(aux);
  }
}
