package SynapsEts.FixedChallenge2017.Vue;

import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;
import java.util.ArrayList;
import java.util.List;

//WARNING : code copie du lien suivant https://knowm.org/open-source/xchart/xchart-example-code/
//Ce qui est en commentaire indique les modifications essaye, sinon le nom de certaines variable on ete change (voir le lien)
public class ChartMatrix {
    public static void main(String[] args) {

        List<XYChart> listeGraphiques = new ArrayList();

        for (int i = 0; i < 8; i++) {
            //Modification du nom des axes seulement
            XYChart graphique = new XYChartBuilder().xAxisTitle("Temps (s)").yAxisTitle("uVMS").width(600).height(400).build();
            graphique.getStyler().setYAxisMin((double) -10);
            graphique.getStyler().setYAxisMax((double) 10);
            XYSeries series = graphique.addSeries("" + i, null, getRandomWalk(200));
            //XYSeries series = graphique.addSeries("first", null, getRandomWalk(200));
            series.setMarker(SeriesMarkers.NONE);
            listeGraphiques.add(graphique);
        }

        /*SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(listeGraphiques);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                sw.displayChartMatrix();
            }

        });
        t.start();

        int y = 0;

        do{
            graphique.removeSeries("first");
            graphique.addSeries(String.valueOf(y), null, getRandomWalk(200));
            y++;
        }while(y<10);*/
    }

    /**
     * Generates a set of random walk data
     *
     * @param numPoints
     * @return
     */
    private static double[] getRandomWalk(int numPoints) {

        double[] y = new double[numPoints];
        y[0] = 0;
        for (int i = 1; i < y.length; i++) {
            y[i] = y[i - 1] + Math.random() - .5;
        }
        return y;
    }
}