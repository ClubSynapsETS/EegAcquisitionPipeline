package SynapsEts.FixedChallenge2017.Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JMenuBar
{
    private static final long serialVersionUID = 1L;
    private final String messageAPropos = "Interface de visualisation en temps réel des signaux EEG filtrés : \n\n" +
            "Affichage des signaux en voltage et en fréquence. \n" +
            "Sauvegarde en CSV.";

    public MenuPrincipal() {
        setBackground(PaletteCouleurs.menuBackground);
        creerMenuOptions();
        creerMenuMode();
    }

    private void creerMenuOptions() {
        JButton nouveau = new JButton();
        //TODO - Creer des nouveau objets et fichiers pour l'acquisition
        nouveau.addActionListener((ActionEvent e) -> {

        });

        JButton enregistrer = new JButton();
        //TODO - Enregistrer fichier de donnees
        enregistrer.addActionListener((ActionEvent e) -> {

        });

        JButton aPropos = new JButton();
        //TODO - Ouvrir une nouvelle fenetre affichant les informations du projet
        aPropos.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(getTopLevelAncestor(),
                    messageAPropos);

        });

        setButtonIcon(nouveau, "Images/Nouveau.png");
        setButtonIcon(enregistrer, "Images/Enregistrer.png");
        setButtonIcon(aPropos, "Images/APropos.png");

        add(nouveau);
        add(enregistrer);
        add(creerMenuMode());
        add(aPropos);
    }

    private JMenu creerMenuMode() {
        JMenu mode = new JMenu();
        mode.setBackground(PaletteCouleurs.background);

        JMenuItem modeNormal = new JMenuItem("Normal");
        modeNormal.addActionListener((ActionEvent e) -> {
            //TODO - Modifier la vue pour afficher l'ensemble des chaines
        });

        JMenuItem modeAlpha = new JMenuItem("Alpha");
        modeAlpha.addActionListener((ActionEvent e) -> {
            //TODO - Modifier la vue pour afficher la chaine alpha uniquement
        });

        setMenuIcon(mode, "Images/Mode.png");
        mode.add(modeNormal);
        mode.add(modeAlpha);

        return mode;
    }

    private void creerMenuLecture() {
        JToolBar menuLecture = new JToolBar();
        JButton boutonLecture = new JButton();
        JButton boutonLectureContinu = new JButton();
        JButton boutonArret = new JButton();

        boutonLecture.addActionListener((ActionEvent e) -> {
            boutonLecture.setEnabled(false);
            boutonLectureContinu.setEnabled(false);

            //TODO - debuter une lecture simple
        });

        boutonLectureContinu.addActionListener((ActionEvent e) -> {
            boutonLecture.setEnabled(false);
            boutonLectureContinu.setEnabled(false);

            //TODO - debuter une lecture en continu
        });

        boutonArret.addActionListener((ActionEvent e) -> {
            boutonLecture.setEnabled(true);
            boutonLectureContinu.setEnabled(true);

            //TODO - arreter complement l'acquisition
        });

        setButtonIcon(boutonLecture, "Images/Lecture.png");
        setButtonIcon(boutonLectureContinu, "Images/LectureContinu.png");
        setButtonIcon(boutonArret, "Images/Arret.png");

        menuLecture.add(boutonLecture);
        menuLecture.add(boutonLectureContinu);
        menuLecture.add(boutonArret);

        menuLecture.setBorderPainted(false);
        menuLecture.setBackground(PaletteCouleurs.menuBackground);
        menuLecture.setFloatable(false);

        add(Box.createHorizontalGlue());
        add(menuLecture);
    }

    private void setButtonIcon(JButton bouton, String path) {
        bouton.setBorderPainted(false);
        bouton.setContentAreaFilled(false);
        bouton.setIcon(readImage(path));
    }

    private void setMenuIcon(JMenu menu, String path)
    {
        menu.setIcon(readImage(path));
    }

    private ImageIcon readImage(String path) {
        Image image = null;

        try {
            image = ImageIO.read(ClassLoader.getSystemResource(path));
        } catch( Exception e) {
            System.out.println(e.getStackTrace());
        }

        return new ImageIcon(image.getScaledInstance(50, 33, image.SCALE_SMOOTH));
    }
}