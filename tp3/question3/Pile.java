package question3;

import question1.PilePleineException;
import question1.PileVideException;
 import java.lang.reflect.Array ;
/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile<T> implements PileI<T> {
    //public final static int DEFAULT= 5;
    private T[] zone;
    private int ptr;

    public Pile(Class<T> clazz,int taille) {
         if (taille < 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
       this.zone= (T[]) Array.newInstance(clazz, taille); 
        this.ptr = 0;
    }

    public Pile(Class<T> clazz) {
        //this(0);
        this(clazz,CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException {
        // a completer  
        if (estPleine()){
            throw new PilePleineException();
        }
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public T depiler() throws PileVideException {
        // a completer
       // return null;
      if (estVide()){
          throw new PileVideException();
        }
        this.ptr--;
        return zone[ptr];   
    }

    public T sommet() throws PileVideException {
        // a completer
        //return null;
                if (estVide()){
            throw new PileVideException();
        }
        int t= this.ptr;
        return this.zone[ptr-1];
        
    }

    public int capacite() {
        // a completer
        //return -1;
         return this.zone.length;
    }

    public int taille() {
        // a completer
        //return -1;
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }

    public boolean estVide() {
        // a completer
        //return false;
         return this.ptr == 0;
    }

    public boolean estPleine() {
        // a completer
       //return false;
        return this.ptr == this.zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        //return false;
             
        if(!(o instanceof Pile)){
            return false;
        }
        Pile pile = (Pile)o;

        if (pile.taille() == this.taille() && pile.capacite() == this.capacite()){
            int i,j;
            int egal = 0;
            int l=zone.length - 1;
            for( i=l; i >=0; i--){
                Object temp = zone[i];
                for( j =l; j>=0; j--){
                    if(temp != pile.zone[i]){
                        egal ++;
                    }       
                }
                if(egal==0){
                    return true;
                }else{
                    return false;
                }
            }
            
        }      
            return false;
        
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        //return null;
         StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}