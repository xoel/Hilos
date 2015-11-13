package HiloProductorConsumidor;

public class Productor extends Thread {

    Buffer buffer;
    VelocidadAcceso velocidad;

    public Productor(Buffer buffer, VelocidadAcceso velocidad) {
        this.buffer = buffer;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        for (int i = 0; i < UnProd1Consum1Dato.NUM_PRODUCCIONES; i++)
            try {
                buffer.put("" + i);
                sleep(velocidad.getMilisegundos());
            } catch (InterruptedException e) {}
    }
}
