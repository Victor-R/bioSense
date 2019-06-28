/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biosense;

import biosensews.ws.BioSenseWS;
import biosensews.ws.BioSenseWS_Service;
import biosensews.ws.Leitura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Graficos {

    private Timer timer = new Timer();
    private boolean firstTime = true;
    private BioSenseWS_Service service = new BioSenseWS_Service();
    private List<Double> temp;
    private List<Double> umidade;
    private List<Double> solo;
    private List<Double> ph;
    private List<Double> irrigacao;
    private List<Date> data;
    private List<Leitura> leituras;
    private List<XYChart> charts = new ArrayList<XYChart>();
    private SwingWrapper<XYChart> sw = null;
    private final BioSenseWS port;
    private final int selectedPlanta;

    public Graficos(int selectedPlanta) throws Exception {

        this.port = this.service.getBioSenseWSPort();
        this.selectedPlanta = selectedPlanta;
        timer.schedule(new MonitoraLeituraTask(), 0, 5000);
    }

    public class MonitoraLeituraTask extends TimerTask {

        @Override
        public void run() {
            temp = new ArrayList<Double>();
            umidade = new ArrayList<Double>();
            solo = new ArrayList<Double>();
            ph = new ArrayList<Double>();
            irrigacao = new ArrayList<Double>();
            data = new ArrayList<Date>();

            leituras = port.todasLeituraPorPlanta(selectedPlanta);
            if (leituras.isEmpty()) {
                preencheLeituraDefault();
            }
            for (Leitura leitura : leituras) {
                temp.add((double) leitura.getTemperatura());
                umidade.add((double) leitura.getUmidade());
                solo.add((double) leitura.getSolo());
                ph.add((double) leitura.getPh());
                irrigacao.add((double) leitura.getIrrigacao());
                data.add(leitura.getData().toGregorianCalendar().getTime());
            }

            if (firstTime) {
                charts.add(geraGrafico(data, temp, "Temperatura"));
                charts.add(geraGrafico(data, umidade, "Umidade"));
                charts.add(geraGrafico(data, solo, "Solo"));
                charts.add(geraGrafico(data, ph, "PH"));
                charts.add(geraGrafico(data, irrigacao, "Irrigação"));
                sw = new SwingWrapper<XYChart>(charts);
                sw.displayChartMatrix();
                firstTime = false;
            } else {
                charts.get(0).updateXYSeries("Temperatura", data, temp, null);
                charts.get(1).updateXYSeries("Umidade", data, umidade, null);
                charts.get(2).updateXYSeries("Solo", data, solo, null);
                charts.get(3).updateXYSeries("PH", data, ph, null);
                charts.get(4).updateXYSeries("Irrigação", data, irrigacao, null);
                sw.repaintChart(0);
                sw.repaintChart(1);
                sw.repaintChart(2);
                sw.repaintChart(3);
                sw.repaintChart(4);
            }
        }
    }

    private static XYChart geraGrafico(List<Date> x, List<Double> y, String yAxis) {
        XYChart chart = new XYChartBuilder().xAxisTitle("Data").yAxisTitle(yAxis).build();
        XYSeries series = chart.addSeries(yAxis, x, y);
        series.setMarker(SeriesMarkers.NONE);
        return chart;
    }

    private void preencheLeituraDefault() {
        temp.add(0.0);
        solo.add(0.0);
        umidade.add(0.0);
        irrigacao.add(0.0);
        ph.add(0.0);
        data.add(new Date());
    }
}
