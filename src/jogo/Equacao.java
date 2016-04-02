package jogo;

/**
 * Created by LuisFelipe.
 */
public class Equacao {

    public final int operandos[];
    private int termoDesconhecido;
    private final char operadores[];
    public int indiceOperador;
    private int resultado;
    private final String parcelas[];
    private String expressao;

    public Equacao()
    {
        operandos = new int[2];
        this.operadores = new char[] {'+', '-', '*', '/'};
        parcelas = new String[2];
    }

    public int getTermoDesconhecido() {
        return termoDesconhecido;
    }

    public void setTermoDesconhecido(int termoDesconhecido) {
        this.termoDesconhecido = termoDesconhecido;
    }

    public int getIndiceOperador() {
        return indiceOperador;
    }

    public void setIndiceOperador(int indiceOperador) {
        this.indiceOperador = indiceOperador;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    private void sortearOperandos(int nivel)
    {
        int valMaximo = 0;

        switch(nivel)
        {
            case 1: valMaximo = 9; break;
            case 2: valMaximo = 99; break;
            case 3: valMaximo = 999; break;
        }

        operandos[0] = sorteia(valMaximo);
        operandos[1] = sorteia(valMaximo);
    }

    private int sorteia(int Valor)
    {
        Math.random();
        return (int) (Math.random() * Valor + 1);
    }

    private void sortearOperador()
    {
        Math.random();
        indiceOperador = (int) (Math.random() * 4);
    }

    private void calcularResultado()
    {
        char op = operadores[indiceOperador];

        switch(op)
        {
            case '+': resultado = operandos[0] + operandos[1]; break;
            case '-': resultado = operandos[0] - operandos[1]; break;
            case '*': resultado = operandos[0] * operandos[1]; break;
            case '/': resultado = operandos[0] / operandos[1]; break;
        }
    }

    private void formarEquacao()
    {
        Math.random();
        termoDesconhecido = (int) (Math.random() * 2);

        if(termoDesconhecido == 0)
        {
            parcelas[0] = "x";
            parcelas[1] = Integer.toString(operandos[1]);
        }

        else
        {
            parcelas[1] = "x";
            parcelas[0] = Integer.toString(operandos[0]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(parcelas[0]);
        sb.append(" ");
        sb.append(operadores[indiceOperador]);
        sb.append(" ");
        sb.append(parcelas[1]);
        sb.append(" = ");
        sb.append(resultado);
        expressao = sb.toString();
    }

    public void criarEquacao(int nivel)
    {
        sortearOperandos(nivel);
        sortearOperador();
        verificarEquacao(nivel);
        calcularResultado();
        formarEquacao();
    }

    public int respostaCerta()
    {
        return operandos[termoDesconhecido];
    }

    public void verificarEquacao(int nivel)
    {
        int eq_certa = 0;

        if(operadores[indiceOperador] == '-')
        {
            if(operandos[0] < operandos[1])
            {
                while(eq_certa == 0)
                {
                    sortearOperandos(nivel);
                    if(operandos[0] > operandos[1])
                        eq_certa = 1;
                }
            }
        }

        if(operadores[indiceOperador] == '/')
        {
            if(operandos[0]%operandos[1] != 0)
            {
                while(eq_certa == 0)
                {
                    sortearOperandos(nivel);
                    if(operandos[0]%operandos[1] == 0)
                        eq_certa = 1;
                }
            }
        }
    }

}
