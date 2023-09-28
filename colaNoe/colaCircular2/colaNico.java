import java.util.Scanner;
public class colaNico {

  public static void main(String[] args) {
    ColaCircular c1 = new ColaCircular();
    c1.llenar(3);
    c1.mostrar();
  }
}
class Cancion {
 //poner sus metodos 
}
class Vector {
  protected int max = 50;
  protected Cancion v[] = new Cancion[max];

  public Vector() {
    for (int i = 0; i < max; i++) {
      Cancion[i] = new Cancion(); 
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
  public void adi(Cancion elem) {
    if(!esLLena()) {
      fi = (fi+1) % max;
      v[fi] = elem;
    } else
      System.out.println("COLA CIRCULAR LLENA");
  }
  public Cancion eli() {
    Cancion elem = new Cancion();
    if(!esVacia()) {
      fr = (fr+1) % max;
      elem = v[fr];
    } else
      System.out.println("COLA CIRCULAR VACIA");
    return elem;
  }
  public void llenar(int n) {
    for (int i = 0; i < n; i++) {
      Cancion elem = new Cancion();
      elem.leer();
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
      Cancion elem = eli();
      elem.mostrar();
      aux.adi(elem);
    }
    this.vaciar(aux);
  }
}

