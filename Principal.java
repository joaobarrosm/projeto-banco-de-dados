package com.mycompany.projetoav3;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<TimeDeFutebol> listaTimesFutebol = new ArrayList<TimeDeFutebol>();
        ArrayList<TimeDeBasquete> listaTimesBasquete = new ArrayList<TimeDeBasquete>();
        cadastroAutomatico(listaTimesFutebol, listaTimesBasquete);
        menuPrincipal(listaTimesFutebol, listaTimesBasquete);
    }
    
    public static void menuPrincipal(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        boolean finalizar = false;
        int modalidade, opcao;
        
        do{
            opcao = escolhaMenu("Digite sua opção: ");
            
            switch(opcao){
                case 1:
                    modalidade = escolhaModalidades("Digite a modalidade do time que será cadastrado: ");
                    cadastroManual(modalidade, listaTimesFutebol, listaTimesBasquete);
                    break;
                case 2:
                    editarTime(listaTimesFutebol, listaTimesBasquete);
                    break;
                case 3:
                    excluirTime(listaTimesFutebol, listaTimesBasquete);
                    break;
                case 4:
                    tipoListagem("Digite a sua opção: ", listaTimesFutebol, listaTimesBasquete);
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Finalizando o sistema...");
                    finalizar = true;
            }
        }while(finalizar == false);
    }
    
    public static int escolhaMenu(String frase){
        System.out.println("--------------- MENU ---------------");
        System.out.println("1| Cadastrar time");
        System.out.println("2| Editar time");
        System.out.println("3| Excluir time");
        System.out.println("4| Listar times");
        System.out.println("5| Finalizar o programa");
        return lerInt(frase);
    }
    
    public static int escolhaAtributoEdit(String frase, int modalidade){
        System.out.println("1| Nome");
        System.out.println("2| Cidade");
        System.out.println("3| Técnico");
        System.out.println("4| Ano de fundação");
        System.out.println("5| Tamanho do elenco");
        if (modalidade == 1){
            System.out.println("6| Capitão");
            System.out.println("7| Aproveitamento como mandante");  
        }
        else{
            System.out.println("6| Média de altura");
            System.out.println("7| Aproveitamento em tiro livre");
        }
        
        return lerInt(frase);
    }
    
    public static int escolhaModalidades(String frase){
        System.out.println("1| Futebol");
        System.out.println("2| Basquete");
        return lerInt(frase);
    }
            
    public static void cadastroAutomatico(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        listaTimesFutebol.add(new TimeDeFutebol("TimeA", "Salvador", "João Gomes", 2022, 24, "Pedro", 100));
        listaTimesFutebol.add(new TimeDeFutebol("TimeB", "Santo Antônio de Jesus", "Abel Braga", 1999, 33, "Davi", 42.8));
        listaTimesFutebol.add(new TimeDeFutebol("TimeC", "Recife", "Mano Menezes", 1957, 22, "Ramon", 78.5));
        listaTimesBasquete.add(new TimeDeBasquete("TimeD", "São Paulo", "Pedrinho", 2020, 24, 1.92, 75));
        listaTimesBasquete.add(new TimeDeBasquete("TimeE", "Rio de Janeiro", "Jorge Jesus", 2010, 24, 1.90, 81.4));
        listaTimesBasquete.add(new TimeDeBasquete("TimeF", "Granada", "Gonçalves", 2021, 24, 1.91, 71.2));
        listaTimesBasquete.add(new TimeDeBasquete("TimeG", "Lisboa", "Mourinho", 1993, 24, 1.89, 77)); 
    }
    
    public static void cadastroManual(int modalidade, ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        String nome, cidade, tecnico;
        int anoFundacao, tamanhoElenco; 
        
        nome = lerString("Digite o nome do time: ");
        cidade = lerString("Digite a cidade em que o " + nome + " foi fundado: ");
        anoFundacao = lerInt("Digite o ano em que o " + nome + " nasceu: ");
        tecnico = lerString("Digite o nome do técnico atual: ");
        tamanhoElenco = lerInt("Digite o tamanho do elenco de jogadores: ");
        
        if(modalidade == 1){
            String capitao = lerString("Digite o nome do capitão do time: ");
            double aproveitamentoCasa = lerDouble("Digite o aproveitamento em casa do time na atual temporada: ");
            
            TimeDeFutebol NovoTime = new TimeDeFutebol(nome, cidade, tecnico, anoFundacao, tamanhoElenco, capitao, aproveitamentoCasa);  
            listaTimesFutebol.add(NovoTime);
            //System.out.println((listaTimesFutebol.get(0)).nome + " | " + (listaTimesFutebol.get(0)).cidade + " | " + (listaTimesFutebol.get(0)).tecnico + " | " + (listaTimesFutebol.get(0)).anoFundacao + " | " + (listaTimesFutebol.get(0)).tamanhoElenco + " | "  + (listaTimesFutebol.get(0)).getCapitao());
        }
        else{
            double mediaAltura = lerDouble("Digite a média de altura do time: ");
            double aproveitamentoTiroLivre = lerDouble("Digite o aproveitamento de tiro livre geral do time: ");
            
            TimeDeBasquete NovoTime = new TimeDeBasquete(nome, cidade, tecnico, anoFundacao, tamanhoElenco, mediaAltura, aproveitamentoTiroLivre);
            listaTimesBasquete.add(NovoTime);
        }  
    }
    
    public static void editarTime(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        boolean verificacaoFutebol = false, verificacaoBasquete = false;
        int decisao;
        
        String timeEscolhido = lerString("Digite o nome do time que você deseja alterar: ");
        
        for (TimeDeFutebol time : listaTimesFutebol){
            if (time.nome.equals(timeEscolhido)){
                verificacaoFutebol = true;
                decisao = escolhaAtributoEdit("Digite o atributo que você deseja alterar: ", 1);
                switch (decisao){
                    case 1:
                        String nome = lerString("Digite o novo nome: ");
                        time.setNome(nome);
                        break;
                    case 2:
                        String cidade = lerString("Digite a nova cidade: ");
                        time.setCidade(cidade);
                        break;
                    case 3:
                        String tecnico = lerString("Digite o novo tecnico: ");
                        time.setTecnico(tecnico);
                        break;
                    case 4:
                        int ano = lerInt("Digite o novo ano de fundação: ");
                        time.setAnoFundacao(ano);
                        break;
                    case 5:
                        int elenco = lerInt("Digite o tamanho do novo elenco: ");
                        time.setTamanhoElenco(elenco);
                        break;
                    case 6:
                        String capitao = lerString("Digite o nome do novo capitão: ");
                        time.setCapitao(capitao);
                        break;
                    case 7:
                        double aproveitamentoCasa = lerDouble("Digite o aproveitamento em casa atualizado: ");
                        time.setAproveitamentoCasa(aproveitamentoCasa);
                        break;
                }
                System.out.println("Time alterado.");
                break;
            }   
        }
        for (TimeDeBasquete time : listaTimesBasquete){
            if (time.nome.equals(timeEscolhido)){
                verificacaoBasquete = true;
                decisao = escolhaAtributoEdit("Digite o atributo que você deseja alterar: ", 2);
                switch (decisao){
                    case 1:
                        String nome = lerString("Digite o novo nome: ");
                        time.setNome(nome);
                        break;
                    case 2:
                        String cidade = lerString("Digite a nova cidade: ");
                        time.setCidade(cidade);
                        break;
                    case 3:
                        String tecnico = lerString("Digite o novo tecnico: ");
                        time.setTecnico(tecnico);
                        break;
                    case 4:
                        int ano = lerInt("Digite o novo ano de fundação: ");
                        time.setAnoFundacao(ano);
                        break;
                    case 5:
                        int elenco = lerInt("Digite o tamanho do novo elenco: ");
                        time.setTamanhoElenco(elenco);
                        break;
                    case 6:
                        double altura = lerDouble("Digite a nova média de altura do time: ");
                        time.setMediaAltura(altura);
                        break;
                    case 7:
                        double aproveitamento = lerDouble("Digite a nova porcentagem de aproveitamento geral de tiro livre do time: ");
                        time.setAproveitamentoTiroLivre(aproveitamento);
                        break;
                }
                System.out.println("Time alterado.");
                break;
            }   
        }
        
        if (verificacaoBasquete == false && verificacaoFutebol == false){
            System.out.println("Esse time não está cadastrado.");
        }
    }
    
    public static void excluirTime(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        boolean verificacaoFutebol = false, verificacaoBasquete = false;
        int decisao;
        
        String timeEscolhido = lerString("Digite o nome do time que você deseja excluir: ");
        
        for (TimeDeFutebol time : listaTimesFutebol){
            if (time.nome.equals(timeEscolhido)){
                verificacaoFutebol = true;
                decisao = confirmacaoRemocao();
                if (decisao == 1){
                    listaTimesFutebol.remove(time);
                }
                System.out.println("Time removido.");
                break;
            }   
        }
        for (TimeDeBasquete time : listaTimesBasquete){
            if (time.nome.equals(timeEscolhido)){
                verificacaoBasquete = true;
                decisao = confirmacaoRemocao();
                if (decisao == 1){
                    listaTimesBasquete.remove(time);
                }
                System.out.println("Time removido.");
                break;
            }   
        }
        
        if (verificacaoBasquete == false && verificacaoFutebol == false){
            System.out.println("Esse time não está cadastrado.");
        }
    }
    
    public static int confirmacaoRemocao(){
        System.out.println("1| Sim");
        System.out.println("2| Não");
        return lerInt("Realmente deseja excluir esse clube? ");
    }
    
    public static void tipoListagem(String frase, ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){
        System.out.println("1| Listar todos os times registrados");
        System.out.println("2| Listar todas as informações de um time através do seu nome");
        int decisao = lerInt(frase);
        
        if (decisao == 1){
            System.out.println("Nome | Cidade | Ano de Fundação");
            for (TimeDeFutebol time : listaTimesFutebol){
                System.out.println(time.nome + " | " + time.cidade + " | " + time.anoFundacao);
            }
            for (TimeDeBasquete time : listaTimesBasquete){
                System.out.println(time.nome + " | " + time.cidade + " | " + time.anoFundacao);
            }
        } 
        else{
            String nomeTime = lerString("Digite o nome do time que você deseja ter todas informações: ");
            for (TimeDeFutebol time : listaTimesFutebol){
                if ((time.nome).equals(nomeTime)){
                    System.out.println("Nome | Cidade | Técnico | Ano de Fundação | Tamanho do Elenco | Capitão | Aproveitamento em casa");
                    System.out.println(time.nome + " | " + time.cidade + " | " + time.tecnico + " | " + time.anoFundacao + " | " + time.tamanhoElenco + " | "  + time.capitao + " | "  + time.aproveitamentoCasa + "%");
                    break;
                }
            }
            for (TimeDeBasquete time : listaTimesBasquete){
                if ((time.nome).equals(nomeTime)){
                    System.out.println("Nome | Cidade | Técnico | Ano de Fundação | Tamanho do Elenco | Aproveitamento do time em TL | Média de altura dos jogadores");
                    System.out.println(time.nome + " | " + time.cidade + " | " + time.tecnico + " | " + time.anoFundacao + " | " + time.tamanhoElenco + " | "  + time.aproveitamentoTiroLivre + "% | "  + time.mediaAltura);
                    break;
                }
            }
        }
    }
    
    public static int lerInt(String texto){
        Scanner leitor = new Scanner(System.in); 
        System.out.print(texto);
        return leitor.nextInt();
    }
    
    public static String lerString(String texto){
        Scanner leitor = new Scanner(System.in); 
        System.out.print(texto);
        return leitor.next();
    }
    
    public static double lerDouble(String texto){
        Scanner leitor = new Scanner(System.in);
        System.out.print(texto);
        return leitor.nextDouble();
    }
}
