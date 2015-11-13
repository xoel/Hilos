
package HiloProductorConsumidor;

public class UnProd1Consum1Dato {
    
    public static int NUM_PRODUCCIONES=100;

    public static void main(String[] args) {
        Buffer datos = new Buffer();
        Productor productor = new Productor(datos, VelocidadAcceso.ALEATORIO);
        Consumidor consumidor = new Consumidor(datos, VelocidadAcceso.ALEATORIO);
        productor.start();
        consumidor.start();
    }
}
