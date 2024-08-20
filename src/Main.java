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
        Empleado E1 = new Empleado("Cosme", "Fulanito", 41281401, 250000.00);
        Cliente Cl1 = new Cliente("El", "Barto", 28526445, true);
        Caja C1 = new Caja (E1, 1, Cl1 );
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
    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }
}

class Caja {
    private Empleado empleado;
    private Cliente cliente;
    private int nroCaja;
    Transaccion transaccion = new Transaccion();

    public Caja(Empleado empleado, int nroCaja, Cliente cliente) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
        this.cliente = cliente;
    }
    public void iniciaCompra() {
        transaccion.listaTransaccion();
    }
    public void totalEs() {
        System.out.println("Su total es: " +transaccion.calcularTotal() );
    }
    public void brindarTicket() {
        System.out.println("Detalle de su compra:");
        System.out.println(cliente.toString());
        if (transaccion != null && transaccion.getLista() != null) {
            if (transaccion.getLista().isEmpty()) {
                System.out.println("No hay productos en esta transacción.");
            } else {
                for (Producto producto : transaccion.getLista()) {
                    if (producto != null) {
                        System.out.println(producto.toString());
                    }
                }
            }
        } else {
            System.out.println("No hay información de transacción disponible.");
        }
        totalEs();
        System.out.println("Fue atendido por:\n" + empleado.toString() +"\nNúmero de caja " + nroCaja);
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

    @Override
    public String toString () {
        if (mayorista){
            return "Nombre: " + getNombre() + "\nApellido: " + getApellido() + "\nDNI: " + getDni()+ "\nCliente Mayorista";
        } else {
            return "Nombre: " + getNombre() + "\nApellido: " + getApellido() +"\nDNI: " + getDni()+ "\nCliente Minorista";
        }
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
    private ArrayList<Producto> lista = new ArrayList<>();
    private double total;

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public double getTotal() {
        return total;
    }
    public double calcularTotal () {
        for (Producto producto: lista) {
            total = total + (producto.getPrecio() * producto.getCantidad());
        }
        return total;
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