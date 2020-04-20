
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
        this.buffer.add(valor);
        
        return true;
    }
    
    //Metodo para miembroTribu
    public boolean comer(){
        if (this.buffer.size() >0 ) {
            this.buffer.remove(this.buffer.size()-1);
            return true;
        }        
        return false;                
    }
    
    // Metodo para imprimir el perol
    public void imprimir(){
        for (int i = 0; i < this.buffer.size(); i++) {
            try {
                System.out.printf("%d",this.buffer.get(i));                
            } catch (Exception e) {
                
            }
        }
        System.out.println(" ");
        
    }
    
    
}
