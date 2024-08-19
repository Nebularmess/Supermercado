// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
//Tu misión:

//        Crea los productos: Cada producto tiene un nombre, precio y cantidad.
  //      Registra las compras: Cuando un cliente compra, se crea una transacción. Esta transacción guarda qué productos compró, cuánto pagó y en qué caja lo hizo.
   //     Simula una compra: Haz que un cliente vaya a una caja, compre varios productos y pague. ¡Muestra en pantallatodo lo que compro y cuanto pago
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado E1 = new Empleado("Nico", "Soria", 41281401, 250000.00);
        Caja C1 = new Caja (E1, 1);
        Cliente Cl1 = new Cliente("Maxi", "Fernandez", 28526445, true);
        C1.iniciaCompra();
        C1.brindarTicket();
        }
    }

class Humane {

    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }

}

class Empleado extends Humane {

    private double sueldo;
    private ArrayList<String> lista = new ArrayList<>();

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }
    public void cargaProductos () {
        System.out.println("Ingrese nombre de producto");

    }

    public String toString() {
        return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
    }
}

class Caja {
    private Empleado empleado;
    private int nroCaja;
    Transaccion transaccion = new Transaccion();

    public Caja(Empleado empleado, int nroCaja) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
    }
    public void iniciaCompra() {
        transaccion.listaTransaccion();
    }
    public void brindarTicket() {
        System.out.println("Detalle de su compra");
        for (Producto producto : transaccion.getLista()) {
            System.out.println(producto.toString());
        }
    }

    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }

}

class Cliente extends Humane {

    private boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }
    public String iniciarCompra (boolean com) {
        if (com) {
            return "Iniciando compra en caja, cliente: "+ getNombre() + " " + getApellido();
        } else {
            return "No aún";
        }
    }

    public String toString() {
        return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
    }
}
class Producto {
    private double precio;
    private int cantidad;
    private String nombre;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString () {
        return "Producto: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }
}
class Transaccion {
    ArrayList<Producto> lista = new ArrayList<>();

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public void listaTransaccion (){
        int otro = 1;
        while (otro == 1) {
            Producto con = new Producto();
            System.out.println("Ingrese el producto, nombre, precio y cantidad, en ese orden");
            Scanner sc = new Scanner(System.in);
            con.setNombre(sc.nextLine());
            con.setPrecio(sc.nextDouble());
            con.setCantidad(sc.nextInt());
            System.out.println("Desea ingresar otro? 1 sigue, 0 termina transaccion");
            otro = sc.nextInt();
            lista.add(con);
        }
        System.out.println("Finalizo transaccion");
    }
}