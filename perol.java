
package arthur.comensal;

import java.util.ArrayList;

public class perol {
    
    ArrayList <Integer> buffer = null;
    
    // Constructor
    public perol (int tamaño){
        this.buffer = new ArrayList <Integer> (tamaño);
    }
    
    //Metodo para cocinero
    public boolean cocinar (int valor){
        //System.out.print("Cocinando");
        System.out.print("Esta es la comida cocinada: ");
        for (int i = 0; i < valor; i++) { // Para que el cocinero cocine determinada contidad de comida (Porciones)
            // System.out.println("Esta es la comida cocinada");
            buffer.add(1);
        }
        //System.out.print("Cocinando");
        return true;
    }
    
    //Metodo para miembroTribu
    public boolean comer(){
        if (this.buffer.size() > 0) {
            //System.out.print("Comiendo");
            this.buffer.remove(this.buffer.size()-1);            
            //System.out.print("Comiendo");            
            return true;
        }
        
        //System.out.println("No hay comida");
        return false;        
    }
    
    // Metodo para imprimir el perol
    public void imprimir(){
        for (int i = 0; i < buffer.size(); i++) {
            try {
                System.out.printf("%d",this.buffer.get(i));
            } catch (Exception e) {
                
            }            
            //System.out.printf("%d",this.buffer.get(i));            
        }
        System.out.println(" ");
        
    }
    
    
}
