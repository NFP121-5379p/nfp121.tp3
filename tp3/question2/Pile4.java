package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        // à compléter
        stk = new Maillon (o,stk);     
        this.nombre++;     
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
         Maillon tmp = this.stk;
        this.stk = this.stk.suivant;
        nombre--;
        return tmp.element;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element ; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
         return stk == null;  // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
          return this.taille() >= capacite;  // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        // à compléter
         Maillon tmp = stk;
        while (tmp != null){
            s = s + tmp.element() ;
            tmp = tmp.suivant();
            if (tmp !=null) {s = s + ", ";}  
        }  
        return s + "]";
    }

    public boolean equals(Object o) {
         int i, b=0, nb=this.nombre - 1;
        if (o instanceof Pile4) {
            // à compléter
            
           Pile4 p4 = (Pile4)o;
            Maillon m1;
            Maillon m2;
            try{
                if (p4.taille() == this.taille() && p4.capacite() == this.capacite()){
                m1 = stk;
                m2 = p4.stk;
                    for (i = nb; i >= 0; i--) {
                        if(!(m1.element() == m2.element())){
                            b ++;
                        }
                        m1 = m1.suivant();
                        m2 = m2.suivant();
                    }
                }
                else{
                    b ++;
                }
            }catch (Exception e){
                b ++;
            }
            
        }else{
            b ++;
        }
        if (b !=0){
        return false;
    }
    else {
        return true;
    }
}


    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}