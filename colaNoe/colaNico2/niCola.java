import java.util.Scanner;

public class niCola {

  public static void main(String[] args) {
    ColaSimple c1 = new ColaSimple();
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
    fr = -1;
    fi = -1;
  }
}

class ColaSimple extends Cola {
  public ColaSimple() {
    super();
  }

  public boolean esVacia() {
    if (fr == fi)
      return true;
    return false;
  }

  public boolean esLlena() {
    if (fi == max - 1)
      return true;
    return false;
  }

  public void adi(int elem) {
    if (esLlena()) {
      System.out.println("COLA LLENA");
    } else {
      fi++;
      v[fi] = elem;
    }
  }

  public int eli() {
    int elem = 0;
    if (esVacia()) {
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
    while (!Z.esVacia())
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
    while (!esVacia()) {
      int elem = eli();
      System.out.println(elem);
      aux.adi(elem);
    }
    vaciar(aux);
  }
}
