package teste1;

public class DadosFinanceiros {
    private String profissao;
    private String rendaMedia;
    private String situacaoSerasa;
    
    public DadosFinanceiros () {
        this.profissao = "";
        this.rendaMedia = "";
        this.situacaoSerasa = "";
    }
    
    public DadosFinanceiros (String profissao, String rendaMedia, String situacaoSerasa) {
        this.profissao = profissao;
        this.rendaMedia = rendaMedia;
        this.situacaoSerasa = situacaoSerasa;
    }

    public void setProfissao(String profissao) {this.profissao = profissao;}
    public void setRendaMedia(String rendaMedia) {this.rendaMedia = rendaMedia;}
    public void setSituacaoSerasa(String situacaoSerasa) {this.situacaoSerasa = situacaoSerasa;}

    public String getProfissao() {return profissao;}
    public String getRendaMedia() {return rendaMedia;}
    public String getSituacaoSerasa() {return situacaoSerasa;}
    
}
