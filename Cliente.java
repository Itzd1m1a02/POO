package teste1;

import java.time.LocalDate;

public class Cliente {
    public String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String numTelefone;
    private DadosFinanceiros dadosFinanceiros;
    //private ArrayList<Assinatura> assinaturas;
    
    public Cliente (String cpf) {
        this.cpf = cpf;
        //this.assinaturas = new ArrayList<Assinatura>();
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public LocalDate getDataNascimento() {return dataNascimento;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getNumTelefone() {return numTelefone;}
    public void setNumTelefone(String numTelefone) {this.numTelefone = numTelefone;}

    public DadosFinanceiros getDadosFinanceiros() {return dadosFinanceiros;}
    public void setDadosFinanceiros(DadosFinanceiros dadosFinanceiros) {this.dadosFinanceiros = dadosFinanceiros;}
    /*
    public Assinaturas getAssinaturas() {return assinaturas;}
    //public void setAssinaturas(DadosFinanceiros assinaturas) {this.assinaturas = assinaturas;}
    */
}
