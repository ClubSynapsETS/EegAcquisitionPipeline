package SynapsEts.FixedChallenge2017.Vue;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingWorker;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

//Lien de reference : https://knowm.org/how-to-make-real-time-charts-in-java/
//section Swing Worker Java Real-time Java Chart Example
public class PanneauChaineSinguliere extends JPanel {
    private static final long serialVersionUID = 1L;

    MySwingWorker mySwingWorker;
    SwingWrapper<XYChart> sw;
    XYChart chart;

    public PanneauChaineSinguliere() {
        setBackground(PaletteCouleurs.background);
        creerGraphiques();
    }

    //Tout le code dans cette methode est copie
    private void creerGraphiques() {

        // Create Chart
        chart = QuickChart.getChart("SwingWorker XChart Real-time Demo", "Time", "Value", "randomWalk", new double[]{0}, new double[]{0});
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setXAxisTicksVisible(false);

        // Show it
        sw = new SwingWrapper<XYChart>(chart);


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                sw.displayChart();
            }

        });
        t.start();

        mySwingWorker = new MySwingWorker();
        mySwingWorker.execute();
    }

    //Cette methode est copie du lien ci-haut
    private class MySwingWorker extends SwingWorker<Boolean, double[]> {

        final LinkedList<Double> fifo = new LinkedList<Double>();

        public MySwingWorker() {

            fifo.add(0.0);
        }

        @Override
        protected Boolean doInBackground() throws Exception {

            while (!isCancelled()) {

                fifo.add(fifo.get(fifo.size() - 1) + Math.random() - .5);
                if (fifo.size() > 500) {
                    fifo.removeFirst();
                }

                double[] array = new double[fifo.size()];
                for (int i = 0; i < fifo.size(); i++) {
                    array[i] = fifo.get(i);
                }
                publish(array);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // eat it. caught when interrupt is called
                    System.out.println("MySwingWorker shut down.");
                }
            }

            return true;
        }

        //Cette methode est copie du lien ci-haut
        @Override
        protected void process(List<double[]> chunks) {

            System.out.println("number of chunks: " + chunks.size());

            double[] mostRecentDataSet = chunks.get(chunks.size() - 1);

            chart.updateXYSeries("randomWalk", null, mostRecentDataSet, null);
            sw.repaintChart();

            long start = System.currentTimeMillis();
            long duration = System.currentTimeMillis() - start;
            try {
                Thread.sleep(40 - duration); // 40 ms ==> 25fps
            } catch (InterruptedException e) {
                System.out.println("InterruptedException occurred.");
            }
        }
    }
}