package SynapsEts.FixedChallenge2017.Vue;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanneauChaines extends JPanel
{
    private static final long serialVersionUID = 1L;
    private int nbrChaines = 8;
    private PanneauChaineSinguliere[] chaines = new PanneauChaineSinguliere[nbrChaines];

    public PanneauChaines()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(PaletteCouleurs.background);
        creerChainesSingulieres();
    }

    private void creerChainesSingulieres()
    {
        for(int i = 0; i < 2; i++) {
            chaines[i] = new PanneauChaineSinguliere();
            chaines[i].setMinimumSize(new Dimension(getHeight() / 8, getWidth()));
            chaines[i].setPreferredSize(new Dimension(getHeight() / 8, getWidth()));
            add(chaines[i]);
        }
    }
}
