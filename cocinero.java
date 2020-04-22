
package arthur.comensal;

import java.util.concurrent.*;

public class cocinero extends Thread {
    
    perol buffer;
    //Semaphore exclMutua;
    Semaphore lleno;
    Semaphore vacio;
    int actVeces = 0; // Numero de veces que va actuar el hilo
    
    //Constructor
    public cocinero (perol buff, /*Semaphore exm,*/ Semaphore ll, Semaphore vac, int vcs){
        this.buffer = buff;
        //this.exclMutua = exm;
        this.lleno = ll;
        this.vacio = vac;
        this.actVeces = vcs;        
    }
    
    @Override
    public void run(){
        
        int i = 0;        
        while (i < this.actVeces) {
            lleno.acquireUninterruptibly(); //Bloqueamos al cocinero
            buffer.cocinar(6); //Se cocina determinada cantidad de comida en el buffer 
            i++; //Se hace la comparacion
            buffer.imprimir(); //Imprimimos el buffer
            vacio.release(); //Liberamos al miembroTribu
        }
    }   
    
}
