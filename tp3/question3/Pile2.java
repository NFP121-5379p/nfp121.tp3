package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacit� de la pile */
    private int capacite;

    /** Cr�ation d'une pile.
     * @param taille la "taille maximale" de la pile, doit �tre > 0
     */
    public Pile2(int taille){
        // � compl�ter
           if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        // � compl�ter
              this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        // � compl�ter
          if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        // � compl�ter
             if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        // � compl�ter
                 if (estVide())
            throw new PileVideException();
        return this.stk.peek();

    }
    public int capacite(){
         return this.capacite;
    }
     public int taille(){
         return this.stk.size();
    }
       public boolean estVide(){
        return this.stk.empty();
    }
      public boolean estPleine(){
        return this.stk.size() == this.capacite;
    }
     public boolean equals(Object o) {
        // a completer
        //return false;
             
        if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 pile = (Pile2)o;

        if (pile.taille() == this.taille() && pile.capacite() == this.capacite()){
            int i,j;
            int egal = 0;
            int l=stk.size()-1;
            for( i=l; i >=0; i--){
                Object temp = this.stk.get(i);
                for( j =l; j>=0; j--){
                    if(temp != pile.stk.get(i)){
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
        int i ,size = this.stk.size() - 1;
         StringBuffer sb = new StringBuffer("[");
        for (i = size; i >= 0; i--) {
            sb.append(this.stk.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    // recopier ici toutes les autres m�thodes
    // qui ne sont pas modifi�es en fonction
    // du type des �l�ments de la pile

}
 // Pile2