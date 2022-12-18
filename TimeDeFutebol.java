package com.mycompany.projetoav3;

public class TimeDeFutebol extends Time{
    public String capitao;
    protected double aproveitamentoCasa;
    //protected String[] lista = new String[7];
    
    public TimeDeFutebol(String nome, String cidade, String tecnico, int anoFundacao, int tamanhoElenco, String capitao, double aproveitamentoCasa){
        super(nome, "Futebol", cidade, tecnico, anoFundacao, tamanhoElenco);
        this.capitao = capitao;
        this.aproveitamentoCasa = aproveitamentoCasa;
        
        /*
        lista[0] = nome;
        lista[1] = cidade;
        lista[2] = tecnico;
        lista[3] = Integer.toString(anoFundacao);
        lista[4] = Integer.toString(tamanhoElenco);
        lista[5] = capitao;
        lista[6] = Double.toString(aproveitamentoCasa);
        */
    }

    public String getCapitao() {
        return capitao;
    }

    public void setCapitao(String capitao) {
        this.capitao = capitao;
    }

    public double getAproveitamentoCasa() {
        return aproveitamentoCasa;
    }

    public void setAproveitamentoCasa(double aproveitamentoCasa) {
        this.aproveitamentoCasa = aproveitamentoCasa;
    }
    
    @Override
    public void imprimirInformacoes(){
        super.imprimirInformacoes();
        System.out.println("Capitão: "+capitao);
        System.out.println("Aproveitamento em casa: "+aproveitamentoCasa);
    }
 
}
