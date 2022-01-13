package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
      private int capacite;

    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
         if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.v = new Vector<Object>();
        this.capacite = taille;
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
          if(estPleine()){
            throw new PilePleineException();
        }
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
       // return null;
         if (estVide()){
            throw new PileVideException();
        }
        int d = v.lastIndexOf(sommet());    
        return this.v.remove(d);
    }

    public Object sommet() throws PileVideException {
        // à compléter
        //return null;
           if (estVide()){
            throw new PileVideException();
        }
        return this.v.lastElement();
    }

    public int taille() {
        // à compléter
        //return -1;
        return this.v.size();
    }

    public int capacite() {
        // à compléter
        //return -1;
        return this.capacite;
    }

    public boolean estVide() {
        // à compléter
        //return false;
         return this.v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        //return false;
         return this.v.size()==this.capacite;
    }

    public String toString() {
        // à compléter
        //return "";
         int i, size=this.v.size() - 1;
            String s = "[";
        for (i =size; i >= 0; i--) {
            s+= this.v.get(i).toString();
            if(i >0){
                s+= ", ";
            }

        }
        return s + "]"; 
    }

    public boolean equals(Object o) {
        // à compléter
        //return false;
          if(!(o instanceof Pile3)){
            return false;
        }
        Pile3 vec = (Pile3)o;

        if (vec.taille() == this.taille() &&  vec.capacite() == this.capacite()){
            int i,j;
            int egal = 0;
            int l=this.v.size() - 1;
            for( i=l; i >=0; i--){
                Object temp = this.v.get(i);
                for( j =l; j>=0; j--){
                    if(temp != vec.v.get(i)){
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

}
