package SynapsEts.FixedChallenge2017.Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class FenetrePrincipale extends JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Create the application.
     */
    public FenetrePrincipale() {
        super.setTitle("EEG ACQUISITION PIPELINE");
        setBackground(PaletteCouleurs.background);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        setJMenuBar(new MenuPrincipal());
        initialiserPanneaux();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialiserPanneaux() {
        add(new PanneauChaines());

        JPanel panneauSecondaire = new JPanel();
        panneauSecondaire.setLayout(new BoxLayout(panneauSecondaire, BoxLayout.Y_AXIS));
        panneauSecondaire.setBackground(PaletteCouleurs.background);
        panneauSecondaire.add(new PanneauFTT());
        panneauSecondaire.add(new PanneauCerveau());

        add(panneauSecondaire);
    }
}