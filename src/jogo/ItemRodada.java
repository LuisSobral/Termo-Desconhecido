package jogo;

/**
 * Created by LuisFelipe.
 */

public class ItemRodada
{
    private Equacao equacao;
    private int resposta;

    public ItemRodada(Equacao equacao)
    {
        this.equacao = equacao;
    }

    public ItemRodada()
    {
    }

    public Equacao getEquacao() {
        return equacao;
    }

    public void setEquacao(Equacao equacao) {
        this.equacao = equacao;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public int pontuacao() {
        int pontuacao = 0;

        if (isRespostaCorreta(equacao.respostaCerta()))
            pontuacao++;

        return pontuacao;
    }

    public boolean isRespostaCorreta(int resultadoCorreto) {
        return resposta == resultadoCorreto;
    }

}
