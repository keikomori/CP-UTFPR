/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author Keiko-PC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Keiko
 */
public class Simulador {

    public static void main(String[] args){
        Scanner teclado = new Scanner (System.in);
        
        // Cria um ArrayList de veiculos
        List<Veiculo> veiculos = new ArrayList();

        String opcao, opcao2;
        do{
            System.out.println("..:: Menu interativo ::..");
            System.out.println("a - Incluir veiculo:"); //conferido
            System.out.println("b - Remover veiculo"); //conferido
            System.out.println("c - Abastecer veiculo"); //conferido
            System.out.println("d - Movimentar Veiculo"); //conferido
            System.out.println("e - Movimentar veiculo por tipo"); //conferido
            System.out.println("f - Imprimir dados de veiculos por tipo"); //conferido
            System.out.println("g - Imprimir pista de corrida"); //conferido
            System.out.println("h - Esvaziar pneus de um veiculo"); //conferido
            System.out.println("i - Calibrar pneus de um veiculo"); //conferido
            System.out.println("j - Sair da aplicacao"); //conferido

            System.out.print("Entre com uma opcao: ");
            opcao = teclado.nextLine() ;
            switch(opcao){
                case "a": // Incluir veiculo
                    System.out.println("Digite a opcao de veiculo que deseja incluir:\n");
                    System.out.println("1 - BICICLETA\n "
                                     + "2 - CARRO POPULAR\n "
                                     + "3 - MOTOCICLETA\n "
                                     + "4 - FERRARI\n");
                    System.out.println("Veiculo: ");
                    opcao2 = teclado.nextLine();
                    // SubMenu para insercao dos tipos de veiculos
                    switch(opcao2){
                        case "1":
                            Bicicleta bike = new Bicicleta();
                            veiculos.add(bike);
                            clearScreen();
                            imprimirVeiculosExistentes(veiculos);
                        break;
                            
                        case "2":
                            CarroPopular car = new CarroPopular();
                            veiculos.add(car);
                            clearScreen();
                            imprimirVeiculosExistentes(veiculos);
                        break;
                        
                        case "3":
                            Motocicleta moto = new Motocicleta();
                            veiculos.add(moto);
                            clearScreen();
                            imprimirVeiculosExistentes(veiculos);
                        break;
                        
                        case "4":
                            Ferrari ferrari = new Ferrari();
                            veiculos.add(ferrari);
                            clearScreen();
                            imprimirVeiculosExistentes(veiculos);
                        break;
                        
                        default:
                            System.out.println("\nOpcao invalida. Tente novamente\n");
                    }
                    break;
                    
                case "b": // Excluir veiculo
                    if(veiculos.isEmpty()){ //verifica se existem veiculos
                        System.out.println("Nao existem veiculos para excluir");
                        break;
                    }
                    imprimirVeiculos(veiculos);
                    System.out.println("Digite o Id do veiculo para excluir");
                    opcao2 = teclado.nextLine();
                    
                    excluirVeiculo(veiculos, opcao2);
                break ;
                
                case "c": // Abastecer veiculo
                    Double litros;
                    imprimirVeiculosExistentes(veiculos);
                    System.out.println("Digite quantos litros deseja abastecer: ");
                    litros = teclado.nextDouble();
                    /**
                     * Na leitura de um numero depois uma String tive problemas
                     * pois ficava armazenado lixo no buffer do teclado, e nao
                     * conseguia identificar a entrada para corrigir este 
                     * problema encontrei a solucao de esvaziar o buffer do 
                     * teclado utilizando o nextLine()
                     */
                    teclado.nextLine(); // Esvazia o buffer do teclado
                    System.out.println("Digite o ID do veiculo: ");
                    opcao2 = teclado.nextLine();
                                             
                    abastecerVeiculo(veiculos, opcao2, litros);
                break;
                
                case "d": // Movimentar veiculo
                    imprimirPistaCorrida(veiculos);
                    System.out.println("Digite o ID do veiculo: ");
                    opcao2 = teclado.nextLine();
                    movimentarVeiculo(veiculos, opcao2);
                    clearScreen();
                    imprimirPistaCorrida(veiculos);
                break;
                
                case "e": // Movimentar o veiculo por tipo
                    imprimirVeiculosExistentes(veiculos);
                    System.out.println("Digite o TIPO do veiculo: ");
                    opcao2 = teclado.nextLine();
                    movimentarVeiculoPorTipo(veiculos, opcao2);
                    clearScreen();
                break;
                
                case "f": // Imprimir dados de veiculo por tipo
                    imprimirVeiculos(veiculos);
                    System.out.println("Digite o ID do veiculo: ");
                    opcao2 = teclado.nextLine();
                    imprimirVeiculoPorTipo(veiculos, opcao2);
                    clearScreen();
                break;
                
                case "g": // Imprimir pista de corrida
                    clearScreen();
                    imprimirPistaCorrida(veiculos);
                break;
                
                case "h": // Esvaziar pneus de um veiculo
                    imprimirVeiculos(veiculos);
                    System.out.println("Digite o ID do veiculo: ");
                    opcao2 = teclado.nextLine();
                    esvaziarPneu(veiculos, opcao2);
                break;
                
                case "i": // Calibrar pneus de um veiculo
                    imprimirVeiculos(veiculos);
                    System.out.println("Digite o ID do veiculo: ");
                    opcao2 = teclado.nextLine();
                    calibrarPneu(veiculos, opcao2);
                break;
                
                case "j": // Sair da aplicacao
                    System.out.println("\nSaindo\n");
                    System.exit(0);
                
                default:
                System.out.println("\nOpcao invalida. Tente novamente\n");
            }
        }while (opcao != null) ;
        
        teclado.close();
    }
    
    private static void imprimirVeiculos(List<Veiculo> veiculos){
        veiculos.forEach(f -> System.out.println("|" + f.getId()));
    }
    private static void imprimirVeiculosExistentes(List<Veiculo> veiculos){
        System.out.println("Veiculos inseridos:");
        veiculos.forEach(f -> System.out.println(f.getId()));
    }
    
    private static void imprimirVeiculoPorTipo(List<Veiculo> veiculos, String tipo){
        veiculos.forEach(f -> {
            if(f.getId().toLowerCase().contains(tipo.toLowerCase())){
                System.out.println(f.toString());
            };
        });
    }
    
    private static void excluirVeiculo(List<Veiculo> veiculos, String id){
        for(Veiculo v: veiculos){//Percorre a lista de veiculos
            if(v.getId().toLowerCase().equals(id.toLowerCase())){//Compara o ID passado com os objetos da lista
                veiculos.remove(v);//remove o objeto da lista
                break;//sai do loop para nao estourar excessao
            }
        }
        
    }

    private static void movimentarVeiculoPorTipo(List<Veiculo> veiculos, String tipo){
        veiculos.forEach(f -> {
            if(f.getId().toLowerCase().contains(tipo.toLowerCase())){
                f.mover();
            };
        });
    }
    
     private static void movimentarVeiculo(List<Veiculo> veiculos, String id){
        veiculos.forEach(f -> {
            if(f.getId().toLowerCase().equals(id.toLowerCase())){
                f.mover();
            };
        });
    }
     
    private static void abastecerVeiculo(List<Veiculo> veiculos, String id, Double litros){
        List<VeiculoMotorizado> vm = new ArrayList();//Criado um array list vazio
       for(Object obj : veiculos){//percorrer o Objeto veiculos passado por parametro
           if(obj instanceof VeiculoMotorizado){//Entra no if se o objeto for do tipo VeiculoMotorizado
               vm.add((VeiculoMotorizado) obj);//Faz um typecast para VeiculoMotorizado e adiciona o objeto no array list 
           }
       }
       for(VeiculoMotorizado v: vm){//Percorre o array list, que so tem objeto do tipo VeiculoMotorizado
           if(id.toLowerCase().equals(v.getId().toLowerCase())){//Verifica se o Id do objeto e o mesmo passado na funcao
               if(litros>0){
                    v.abastecer(litros);//Seta a quantidade de combustivel passada
               }
               
           }
       }  
//       List<VeiculoMotorizado> vmm = veiculos.stream()
//               .filter(v -> v instanceof VeiculoMotorizado)
//               .map(v -> (VeiculoMotorizado) v)
//               .collect(Collectors.toList());
//       
        
    }
    
    private static void esvaziarPneu(List<Veiculo> veiculos, String id){
        veiculos.forEach(f -> {
            if(f.getId().toLowerCase().equals(id.toLowerCase())){
                f.calibrarPneus(Boolean.FALSE);
            }
        });
//        AS LINHAS ACIMAS SAO IDENTICAS A ESSAS ABAIXO
//        for(Veiculo v: veiculos){
//            if(v.getId().toLowerCase().equals(id.toLowerCase())){
//                v.calibrarPneus(Boolean.FALSE); //Boolean.FALSE === false
//            }
//        }
    }
    
    private static void calibrarPneu(List<Veiculo> veiculos, String id){
        veiculos.forEach(f -> {
            if(f.getId().toLowerCase().equals(id.toLowerCase())){
                f.calibrarPneus(Boolean.TRUE);
            }
        });
    }
    
    private static void imprimirPistaCorrida(List<Veiculo> veiculos){
        veiculos.stream().forEach(f -> System.out.println(f.imprimirTragetoria()));
    }
    
    //limpa a tela
    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
