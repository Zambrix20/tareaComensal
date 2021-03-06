
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
        
        while (i < this.actVeces) {
            
            exclMutua.acquireUninterruptibly();
            if (buffer.buffer.isEmpty()) { // Si el buffer esta vacio
                lleno.release();// Liberamos Al cocinero
                vacio.acquireUninterruptibly();//Bloqueamos al miembroTribu
                //Cocinero hizo
                System.out.println("El Cocinero hizo esta cantidad de comida (Porciones): " + buffer.buffer.size());
                i++;
                
                //System.out.print("Miembro comiendo");                
                //lleno.release(); //Despertar al cocinero
                //buffer.cocinar(1);
                //vacio.acquireUninterruptibly(); // Bloquean comer                 
            }
            
            if(buffer.comer()){ //Para ver el miembroTribu que come
                //El miembro come
                System.out.println("El Miembro de la Tribu se sirve con este tamaño: " + buffer.buffer.size());
                //buffer.imprimir();
                //i++;
            }
            //buffer.imprimir();
            exclMutua.release();            
        }
    }
}
