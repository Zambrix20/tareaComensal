
package arthur.comensal;

import java.util.concurrent.*;

public class miembroTribu extends Thread {
    
    perol buffer;
    Semaphore exclMutua;
    Semaphore lleno;
    Semaphore vacio;
    int actVeces = 0;
    
    //Constructor
    public miembroTribu(perol buff, Semaphore exm, Semaphore ll, Semaphore vac, int vcs){
        this.buffer = buff;
        this.exclMutua = exm;
        this.lleno = ll;
        this.vacio = vac;
        this.actVeces = vcs;        
    }
    
    @Override
    public void run (){
        int i = 0;
        int n = 0;
        
        while (i < this.actVeces) {
            // *
            exclMutua.acquireUninterruptibly();
            if (buffer.comer()) { // Si el buffer esta lleno, empiezan a comer
                i++;                
            }else { // sino se pudo comer
                lleno.release(); //Despertar al cocinero
                vacio.acquireUninterruptibly(); // Bloquean comer 
                // buffer.comer();
            }
            buffer.imprimir();
            exclMutua.release();        
        }
    }
}
