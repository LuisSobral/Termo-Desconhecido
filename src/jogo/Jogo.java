package jogo;

import jogo.performances.PerformanceGeral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuisFelipe.
 */

public class Jogo {

    private BancoDeEquacoes bd;
    private List<Rodada> rodadasExecutadas;

    public Jogo()
    {
        bd = new BancoDeEquacoes();
        rodadasExecutadas = new ArrayList<>();
    }

    public BancoDeEquacoes getBd() {
        return bd;
    }

    public void setBd(BancoDeEquacoes bd) {
        this.bd = bd;
    }

    public List<Rodada> getRodadasExecutadas() {
        return rodadasExecutadas;
    }

    public void setRodadasExecutadas(List<Rodada> rodadasExecutadas) {
        this.rodadasExecutadas = rodadasExecutadas;
    }

    public void adicionarBancoDeEquacoes(BancoDeEquacoes banco) {
        bd = banco;
    }

    public void adicionarRodada(Rodada rodada) {
        rodadasExecutadas.add(rodada);
    }

    public PerformanceGeral getPerformanceGeral()
    {
        return new PerformanceGeral(rodadasExecutadas);
    }
}
