package SynapsEts.FixedChallenge2017.Application;

import SynapsEts.FixedChallenge2017.Vue.FenetrePrincipale;
import java.awt.EventQueue;

public class ProgrammePrincipal {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
                    fenetrePrincipale.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
