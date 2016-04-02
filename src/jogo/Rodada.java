package jogo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuisFelipe.
 */
public final class Rodada
{
    private BancoDeEquacoes bancoDeEquacoes;
    private ArrayList<ItemRodada> itens;
    private int nivel;
    private int pontuacao;
    private long inicio;
    private long fim;
    private long tempoTotal;

    public Rodada(Instant inicio, BancoDeEquacoes bancoDeEquacoes, int nivel) {
        setInicio(inicio);
        pontuacao = 0;
        this.bancoDeEquacoes = bancoDeEquacoes;
        this.nivel = nivel;
        criarItensRodada();
    }

    public Rodada()
    {
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFim() {
        return fim;
    }

    public void setFim(long fim) {
        this.fim = fim;
    }

    public long getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public Instant getInicioAsInstant() {
        return Instant.ofEpochSecond(inicio);
    }

    public Instant getFimAsInstant() {
        return Instant.ofEpochSecond(fim);
    }

    public final void setInicio(Instant instant) {
        inicio = instant.toEpochMilli();
    }

    public final void setFim(Instant instant) {
        fim = instant.toEpochMilli();
    }

    public long getTempo()
    {
        setFim(Instant.now());
        tempoTotal = (fim - inicio)/1000;
        return tempoTotal;
    }

    public BancoDeEquacoes getBancoDeEquacoes() {
        return bancoDeEquacoes;
    }

    public void setBancoDeEquacoes(BancoDeEquacoes bancoDeEquacoes) {
        this.bancoDeEquacoes = bancoDeEquacoes;
    }

    public ArrayList<ItemRodada> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemRodada> itens) {
        this.itens = itens;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    private void criarItensRodada() {
        this.itens = new ArrayList<>();

        List<Equacao> equacoes = bancoDeEquacoes.adicionarEquacao(nivel);
        for (Equacao equacao : equacoes) {
            itens.add(new ItemRodada(equacao));
        }
    }

    public int pontuacao()
    {
        for (ItemRodada item : itens) {
            pontuacao += item.pontuacao();
        }
        return pontuacao;
    }

    public ItemRodada obterItem(int numero) {
        return itens.get(numero);
    }
}
