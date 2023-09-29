import java.util.Scanner;
public class noeMultiPila {

  public static void main(String[] args) {
    
  }
}
class Docente {
  private int id;
  private String nombre;
  private int cargaHoraria;
  private int nroMaterias;
  private double salario;

  public Docente(){
    id = 0;
    nombre = "";
    cargaHoraria = 0;
    nroMaterias = 0;
    salario = 0;
  }

  public void setId(int id) {
    this.id = id;
  }
  public int getId(){
    return idi;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getNombre(){
    return nombre;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }
  public int getCargaHoraria(){
    return cargaHoraria;
  }

  public void setNroMaterias(int nroMaterias) {
    this.nroMaterias = nroMaterias;
  }
  public int getNroMaterias(){
    return nroMaterias;
  }
   
  public void setSalario(int salario) {
    this.salario = salario;
  }
  public int getSalario(){
    return salario;
  }

  public void leer(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Id: "); id = sc.nextInt();
    System.out.print("Nombre: "); nombre = sc.nextLine();
    System.out.print("Carga Horaria: "); cargaHoraria = sc.nextInt();
    System.out.print("Numero Materias: "); nroMaterias = sc.nextInt();
    System.out.print("Salario: "); salario = sc.nextDouble()
  }

  public void mostrar(){

    System.out.println("Id: "+ id); 
    System.out.println("Nombre: "+ nombre); 
    System.out.println("Carga Horaria: "+ cargaHoraria); 
    System.out.println("Numero Materias: "+ nroMaterias); 
    System.out.println("Salario: "+ salario);
    
  }
}

class Vector{
  protected int max = 50;
  protected Docente v [] = new Docente[max]; 
  public Vector(){
    for (int i = 0; i < max; i++) {
      Docente v [i] = new Docente() ;
    }
  }
}

class Pila extends Vector{
  private int tope;
  public Pila(){
    super();
    tope = -1;
  }



}
