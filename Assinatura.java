package teste1;

public class Assinatura {
    public String id;
    private String nome;
    private String tipoCategoria;
    private String dadosTecnicos;
    private String descricaoVisual;
    private String valorCusto;
    private String valorAvaliado;
    private String valorMensal;
    private String tempoContrato;
    private String multa;
    private int[][] coberturaDano = new int[4][3];
    private int[][] coberturaPT = new int[4][3];

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTipoCategoria() {return tipoCategoria;}
    public void setTipoCategoria(String tipoCategoria) {this.tipoCategoria = tipoCategoria;}

    public String getDadosTecnicos() {return dadosTecnicos;}
    public void setDadosTecnicos(String dadosTecnicos) {this.dadosTecnicos = dadosTecnicos;}

    public String getDescricaoVisual() {return descricaoVisual;}
    public void setDescricaoVisual(String descricaoVisual) {this.descricaoVisual = descricaoVisual;}

    public String getValorCusto() {return valorCusto;}
    public void setValorCusto(String valorCusto) {this.valorCusto = valorCusto;}

    public String getValorAvaliado() {return valorAvaliado;}
    public void setValorAvaliado(String valorAvaliado) {this.valorAvaliado = valorAvaliado;}

    public String getValorMensal() {return valorMensal;}
    public void setValorMensal(String valorMensal) {this.valorMensal = valorMensal;}

    public String getTempoContrato() {return tempoContrato;}
    public void setTempoContrato(String tempoContrato) {this.tempoContrato = tempoContrato;}

    public String getMulta() {return multa;}
    public void setMulta(String multa) {this.multa = multa;}

    public int[][] getCoberturaDano() {return coberturaDano;}
    public void setCoberturaDano(int[][] coberturaDano) {this.coberturaDano = coberturaDano;}

    public int[][] getCoberturaPT() {return coberturaPT;}
    public void setCoberturaPT(int[][] coberturaPT) {this.coberturaPT = coberturaPT;}
    
}
