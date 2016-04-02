package jogo.performances;

import jogo.Rodada;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuisFelipe.
 */
public class PerformanceGeral
{
    private Map<Integer, Performance> performancePorNivel;
    private Performance performanceGeral;

    public PerformanceGeral(List<Rodada> rodadas)
    {
        performanceGeral = new Performance();
        performancePorNivel = new HashMap<>();
        for (Rodada rodada : rodadas) {
            atualizarPerformances(rodada);
        }
    }

    public PerformanceGeral() {
    }

    private void atualizarPerformances(Rodada rodada)
    {
        Performance performanceRodada = obterPerformanceRodada(rodada);

        Performance performanceBanco = performancePorNivel.get(rodada.getNivel());
        if (performanceBanco == null)
            performancePorNivel.put(rodada.getNivel(), performanceRodada);
        else {
            acumularPerformance(performanceBanco, performanceRodada);
        }
        acumularPerformance(performanceGeral, performanceRodada);
    }

    private Performance obterPerformanceRodada(Rodada rodada)
    {
        Performance performanceRodada = new Performance();

        performanceRodada.numeroRodadas = 1;
        performanceRodada.totalAcertos = rodada.getPontuacao();
        performanceRodada.totalErros = 8 - performanceRodada.totalAcertos;

        return performanceRodada;
    }

    private void acumularPerformance(Performance total, Performance valor)
    {
        total.numeroRodadas++;
        total.totalAcertos += valor.totalAcertos;
        total.totalErros += valor.totalErros;
    }

    public Map<Integer, Performance> getPerformancePorNivel() {
        return performancePorNivel;
    }

    public Performance getPerformanceGeral()
    {
        return performanceGeral;
    }
}
