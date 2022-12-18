package com.mycompany.projetoav3;


public class TimeDeBasquete extends Time{
    protected double mediaAltura;
    protected double aproveitamentoTiroLivre;
    
    public TimeDeBasquete(String nome, String cidade, String tecnico, int anoFundacao, int tamanhoElenco, double mediaAltura, double aproveitamentoTiroLivre){
        super(nome, "Basquete", cidade, tecnico, anoFundacao, tamanhoElenco);  
        this.aproveitamentoTiroLivre = aproveitamentoTiroLivre;
        this.mediaAltura = mediaAltura;
    }

    public double getAproveitamentoTiroLivre() {
        return aproveitamentoTiroLivre;
    }

    public void setAproveitamentoTiroLivre(double aproveitamentoTiroLivre) {
        this.aproveitamentoTiroLivre = aproveitamentoTiroLivre;
    }

    public double getMediaAltura() {
        return mediaAltura;
    }

    public void setMediaAltura(double mediaAltura) {
        this.mediaAltura = mediaAltura;
    }
    
    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Média de altura: "+mediaAltura+"M");
        System.out.println("Aproveitamento em tiro livre: "+aproveitamentoTiroLivre+"%");}
}
