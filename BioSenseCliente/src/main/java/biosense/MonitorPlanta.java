/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import java.awt.GridLayout;

/**
 *
 * @author Victor Ribeiro
 */
public class MonitorPlanta extends javax.swing.JPanel {

    private static double[][] umidadeData = {{1, 2, 3}, {0.1, 0.2, 0.3}};
    private static double[][] temperaturaData = {{1, 2, 3}, {0.4, 0.5, 0.3}};
    private static double[][] phData = {{1, 2, 3}, {0.8, 0.9, 0.2}};
    private static double[][] soloData = {{1, 2, 3}, {0.1, 0.2, 0.3}};

    /**
     * Gera um dataset do tipo double, para um gráfico xy
     *
     * @param componentName Nome do gráfico a ser atendido
     * @return XYDataset um dataset de double[][] com valores de XY
     * @author Victor Ribeiro
     */
    private static XYDataset createDataset(String componentName) {

        DefaultXYDataset ds = new DefaultXYDataset();

        switch (componentName) {
            case "Umidade":
                ds.addSeries("Leitura", umidadeData);
                break;
            case "Temperatura":
                ds.addSeries("Leitura", temperaturaData);
                break;
            case "PH":
                ds.addSeries("Leitura", phData);
                break;
            case "Solo":
                ds.addSeries("Solo", soloData);
                break;
            default:
                break;
        }

        return ds;
    }

    /**
     * Construtor de um gráfico de monitoramento
     *
     * @param title Título do gráfico
     * @param xTitle Título do eixo X
     * @param yTitle Título do eixo Y
     * @author Victor Ribeiro
     */
    public MonitorPlanta(String title, String xTitle, String yTitle) {
        this.setLayout(new FlowLayout());
        XYDataset dataset = createDataset(title);

        JFreeChart chart = ChartFactory.createXYLineChart(title,
                xTitle, yTitle, dataset, PlotOrientation.VERTICAL, true, true,
                false);
        ChartPanel cp = new ChartPanel(chart);
        this.add(cp);

    }

    /**
     * Função Principal - Constrói os gráficos dentro de um JFrame
     *
     * @param args the command line arguments
     * @author Victor Ribeiro
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Monitor Planta");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(2, 0));

                frame.add(new MonitorPlanta("Umidade", "Nível", "Tempo"));
                frame.add(new MonitorPlanta("Temperatura", "Nível", "Tempo"));
                frame.add(new MonitorPlanta("PH", "Nível", "Tempo"));
                frame.add(new MonitorPlanta("Solo", "Nível", "Tempo"));
                frame.pack();
                frame.setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
