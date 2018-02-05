package SynapsEts.FixedChallenge2017.Application;

import SynapsEts.FixedChallenge2017.Vue.FenetrePrincipale;

import javax.swing.*;
import java.awt.*;

public class ProgrammePrincipal {
    /**
     * Launch the application.
     */
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
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