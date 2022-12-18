package com.mycompany.projetoav3;

public abstract class Time {
    protected String nome, modalidade, cidade, tecnico;
    protected int anoFundacao, tamanhoElenco;
    
    public Time(String nome, String modalidade, String cidade, String tecnico, int anoFundacao, int tamanhoElenco){
        this.nome = nome;
        this.modalidade = modalidade;
        this.cidade = cidade;
        this.tecnico = tecnico;
        this.anoFundacao = anoFundacao;
        this.tamanhoElenco = tamanhoElenco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public int getTamanhoElenco() {
        return tamanhoElenco;
    }

    public void setTamanhoElenco(int tamanhoElenco) {
        this.tamanhoElenco = tamanhoElenco;
    }
    
    public void imprimirInformacoes(){
        System.out.println();
        System.out.println("Nome: "+nome);
        System.out.println("Modalidade: "+modalidade);
        System.out.println("Cidade: "+cidade);
        System.out.println("Técnico: "+tecnico);
    }

}
