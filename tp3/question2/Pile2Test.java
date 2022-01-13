package question2;

/**
 * Classe-test Pile2Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile2Test extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test Pile2Test
     */
    private PileI p1;
    private PileI p2;
    
    public Pile2Test() {
    }

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        p1 = new question2.Pile2();
        p2 = new question2.Pile2();
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */
    
    
    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }
        public void testestPleine() throws Exception {
        PileI p = new question2.Pile2(3);
        p.empiler(3);
        assertEquals(10, p.taille());
        p.empiler(2);
        assertEquals(7, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail("La pile est pleine !");
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void testestVide() throws Exception {
        PileI p = new question2.Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail("La pile est vide !");
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }
        public void testequals() throws Exception {

        p1.empiler(20);
        p1.empiler(11);
        p1.empiler(100);

        p2.empiler(20);
        p2.empiler(11);
        p2.empiler(100);

        assertTrue("�galit� de deux piles ? ", p1.equals(p2));
        assertTrue("�galit� de deux piles ? ", p2.equals(p1));
       
        p2.empiler(1);
        assertFalse("�galit� de deux piles ? ", p1.equals(p2));
        
        p1.empiler(1);
        assertTrue("�galit� de deux piles ? ", p2.equals(p1));
        
        p1.depiler();
        assertFalse("�galit� de deux piles ? ", p1.equals(p2));

    }

}
