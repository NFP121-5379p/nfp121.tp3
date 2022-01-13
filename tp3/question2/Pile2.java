package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stack;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
               if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stack = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        //this(0);
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
            if(estPleine()){
            throw new PilePleineException();
        }
        this.stack.push(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        //return null;
             if (estVide()){
            throw new PileVideException();
        }
        return this.stack.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        //return null;
        if (estVide()){
            throw new PileVideException();
        }
        return this.stack.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return false;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        return false;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
         int i, size=this.stack.size() - 1;
        String s = "[";
        // a completer
          
        for ( i = size; i >= 0; i--) {
            s+= this.stack.get(i).toString();
            if(i >0){
                s+= ", ";
            }       
        }
      
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
        //return false;
      
                
          if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 stk = (Pile2)o;

        if (stk.taille() == this.taille() &&  stk.capacite() == this.capacite()){
            int i,j;
            int egal = 0;
            int l=this.stack.size() - 1;
            for( i=l; i >=0; i--){
                Object temp = this.stack.get(i);
                for( j =l; j>=0; j--){
                    if(temp != stk.stack.get(i)){
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        //return 0;
         return this.stack.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        //return 0;
         return this.capacite;
    }

} // Pile2.java
