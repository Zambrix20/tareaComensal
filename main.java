
package arthur.comensal;

import java.util.concurrent.*;

public class main {
    
    public static void main(String[] args) {
        
        // Declaramos el buffer a utilizar
        perol buffer = new perol(10);
        
        // Declaramos 3 semaforos
        Semaphore exclMutua = new Semaphore(1, true);
        Semaphore lleno = new Semaphore(10,true);
        Semaphore vacio = new Semaphore(10,true);
        
        // Declaramos el que consume
        miembroTribu memTrib = new miembroTribu(buffer, exclMutua, lleno, vacio, 10);
        
        // Declaramos el que cocina
        cocinero chef = new cocinero(buffer, lleno, vacio, 10);
        
        vacio.drainPermits();
        
        //Iniciamos hilos
        memTrib.start();
        chef.start();
        
        
        
    }
    
}
