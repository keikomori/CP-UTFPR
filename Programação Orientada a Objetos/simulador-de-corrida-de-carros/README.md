# :oncoming_automobile: Simulador de Corrida de Carros

Um simulador de corrida de veículos irá controlar veículos do tipo bicicleta, motocicleta, carro popular e Ferrari através de seu centro de comandos. Os veículos estarão competindo no estilo corrida.
Cada veículo criado possuirá uma identiﬁcação única (que deverá ser gerada automaticamente), uma quantidade de rodas e uma quantidade de combustível (para aqueles que possuem motor).
Os veículos motorizados devem ser abastecidos e consomem combustível à medida que se deslocam. Eles apenas se movimentam se há combustível suﬁciente para tal e se os pneus das rodas estiverem calibrados. Assume-se que para mover um traço, a motocicleta gasta 0,5 litro, o carro polular gasta um litro e a ferrari gasta 1,5 litros de combustível. O veículo não deve se movimentar se ele não possuir a quantidade de combustível suﬁciente e se seus pneus não estiverem calibrados.
Os veículos se movem sempre na horizontal da esquerda para direita de acordo com suas respectivas quantidades de traços (unidade de movimento):

* bicicleta: de um em um traço,
* motocicleta: de três em três traços,
* carro popular: de cinco em cinco traços,
* ferrari: de dez em dez traços.

### :scroll: Requisitos do aplicativo

* Menu iterativo que permita ao usuário simular uma **Corrida de Carros**.
* Deve ser possível incluir até 20 veículos.

1. Incluir veículo – Solicitar o tipo do veículo (B, M, C, F). Gerar um id automático para o veículo criado e assumir que os pneus estão vazios. – Para os veículos motorizados, considerar que estão sem combustível. 
2. Remover um veículo (deve-se informar o identiﬁcador do veículo)
3. Abastecer veículo (deve-se informar o identiﬁcador do veículo e a quantidade de combustível em litros) 
4. Movimentar veículo (deve-se informar o identiﬁcador do veículo)
5. Movimentar veículos por tipo (deve-se informar o tipo de veículo e movimentar todos os veículos daquele tipo) 
6. Imprimir dados de veículos por tipo (deve-se informar o tipo de veículo e imprimir os dados de todos os veículos daquele tipo) 
7. Imprimir pista de corrida (imprime na ordem em que estão no array os veículos com seus respectivos traços percorridos, como mostra o exemplo abaixo: 

* O identiﬁcador do veículo na pista de corrida será composto pela sua sigla (B para bicicleta, M para motocicleta, C para carro popular e F para ferrari) concatenado com o id do veículo

|F1 

|B2 

|C3 

|M4 

|B5

|----------F1 

|-B2 

|-----C3 

|---M4 

|-B5

8. Esvaziar pneus de um veículo 
9. Calibrar pneus de um veículo 
10. Sair da aplicação


### :page_with_curl: Detalhamento de itens avaliados atendidos

- [x] Respeitar o princípio do encapsulamento de dados
- [x] Usar modificadores de acesso adequados (private e public)
- [x] Criar getters e setters que forem necessários
- [x] Fazer sobrecarga de pelo menos um método
- [x] Ter pelo menos um atributo **final**
- [x] Fazer uso da palavra reservada **this**
- [x] Ter pelo menos um atributo **static**
- [x] Criar associação de classes (Agregação ou Composição)
- [x] Fazer uso de classe abstrata
- [x] Fazer uso do conceito de herança e polimorfismo
- [x] Não utilizar o modificador **protected**
- [x] O aplicativo não deve travar em tempo de execução
- [x] Seguir o diagrama UML

### :desktop_computer: Desenvolvedor:
* Tatiany Keiko Mori
