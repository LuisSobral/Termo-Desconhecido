package jogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * Created by LuisFelipe.
 */
public class BancoDeEquacoes
{
    private Map<Integer, List<Equacao>> bd;
    private static final int NUMERO_EQUACOES = 8;

    public BancoDeEquacoes ()
    {
        bd = new HashMap<>();
    }

    public Map<Integer, List<Equacao>> getBd() {
        return bd;
    }

    public void setBd(Map<Integer, List<Equacao>> bd) {
        this.bd = bd;
    }

    public List<Equacao> adicionarEquacao (int nivel)
    {
        int cont = 0;
        List<Equacao> equacoeSorteadas = new ArrayList<>();
        List<Equacao> eq = new ArrayList<>();

        while(cont!=NUMERO_EQUACOES)
        {
            Equacao equacao = new Equacao();
            equacao.criarEquacao(nivel);
            if(!verificarEquacao(nivel, equacao))
            {
                eq.add(equacao);
                cont++;
            }
        }

        adicionarAoBanco(nivel, eq);
        equacoeSorteadas = sortearEquacoes(nivel);
        return equacoeSorteadas;
    }

    private void adicionarAoBanco(int nivel, List<Equacao> equacoes)
    {
        bd.put(nivel, equacoes);
    }

    public List<Equacao> sortearEquacoes(int nivel) {
        List<Integer> numerosSorteados = sortearNumerosDistintos(nivel);
        List<Equacao> array = new ArrayList(bd.get(nivel));

        List<Equacao> equacoesSorteadas = new ArrayList<>();
        for (int i = 0; i < NUMERO_EQUACOES; i++) {
            int numeroSorteado = numerosSorteados.get(i);
            equacoesSorteadas.add(array.get(numeroSorteado));
        }
        return equacoesSorteadas;
    }

    private List<Integer> sortearNumerosDistintos(int nivel) {
        List<Integer> numerosSorteados = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < NUMERO_EQUACOES; i++) {
            int sorteado;
            do {
                sorteado = rand.nextInt(bd.get(nivel).size());
            } while (numerosSorteados.contains(sorteado));
            numerosSorteados.add(sorteado);
        }
        return numerosSorteados;
    }

    private boolean verificarEquacao(int nivel, Equacao equacao)
    {
        if(bd.get((nivel)) != null)
        {
            for(Equacao eq : bd.get(nivel))
            {
                if(((eq.operandos[0] == equacao.operandos[0] && eq.operandos[1] == equacao.operandos[1])
                        || (eq.operandos[0] == equacao.operandos[1] && eq.operandos[1] == equacao.operandos[0]))
                        && eq.indiceOperador == equacao.indiceOperador)
                    return true;
            }
        }

        return false;
    }
}
