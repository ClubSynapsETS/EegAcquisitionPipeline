package SynapsEts.FixedChallenge2017.Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class FenetrePrincipale extends JFrame {
    private static final long serialVersionUID = 1L;
    private MenuPrincipal menuPrincipal = new MenuPrincipal();
    private PanneauChaines panneauChaines = new PanneauChaines();
    private PanneauFTT panneauFFT = new PanneauFTT();
    private PanneauCerveau panneauCerveau = new PanneauCerveau();
    private JPanel panneauSecondaire = new JPanel();

    /**
     * Create the application.
     */
    public FenetrePrincipale() {
        super.setTitle("EEG ACQUISITION PIPELINE");
        setBackground(PaletteCouleurs.background);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        setJMenuBar(menuPrincipal);
        initialiserPanneaux();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialiserPanneaux() {
        add(panneauChaines);

        panneauSecondaire.setLayout(new BoxLayout(panneauSecondaire, BoxLayout.Y_AXIS));
        panneauSecondaire.setBackground(PaletteCouleurs.background);
        panneauSecondaire.add(panneauFFT);
        panneauSecondaire.add(panneauCerveau);

        add(panneauSecondaire);
    }
}