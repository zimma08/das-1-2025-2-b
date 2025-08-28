## 31/07

## Abstração:
É o processo de simplificar a complexidade de um sistema, escondendo detalhes de implementação e expondo apenas as funcionalidades essenciais através de uma interface simplificada.
## Complexidade:
A complexidade de uma funcionalidade ou sistema deve estar concentrada em sua implementação, não em seu uso. Ou seja, é aceitável — e muitas vezes inevitável — que a construção de uma abstração seja desafiadora e técnica, mas seu uso por outros desenvolvedores precisa ser simples, intuitivo e previsível. Uma boa abstração esconde a complexidade interna e oferece uma interface clara para quem a utiliza.

# Dica: estudar POO, principalmente na linguagem Java, pois está envolvido em todas as linguagens.

## Ocultamento de informação: 
Esconde atrás de uma API e expondo através de uma interface. Quando voce cria uma classe, você está escondendo informação para poder criar uma interface em que o ser humano consiga interagir.

# Framework: 
Inconsistências técnicas, como o uso de frameworks diferentes (ou versões distintas do mesmo) em partes distintas do sistema, ou a resolução de problemas semelhantes com estruturas de dados diferentes, indicam falta de padronização. Esse tipo de variação aumenta a complexidade desnecessária, dificulta a manutenção e compromete a coesão do código. É fundamental estabelecer e seguir padrões técnicos para garantir consistência e facilitar a evolução do sistema.

## 04/08
Getters e Setters = Encapsular:  proteger informação, como a gente implementa o ocultamento de informação. 

## Coesão
É uma característica que buscamos enquanto estamos programando, toda classe deve ter uma única responsabilidade bem feita, obtendo as seguintes vantagens:
- Facilita implementação de uma classe
- Facilita alocão de um único responsável por manter uma classe
- Facilita o reúso e teste de uma classe

Se usar a coesão de um jeito muito puro, o código não fica bom, não podemos misturar demais mas também não podemos deixar fragmentado. 

## Acoplamento
Acoplamento aceitável e acomplamento ruim;
É a força da conexão entre duas classes. Sempre que a seta for cheia, significa que será uma variável do tipo do outro objeto. Como minimizar o erro do código quando está puxando o outro cara? @AutoWired
- Acoplamento aceitável de uma classe A para B ocorre quando a classe A usa apenas métodos públicos da classe B.
- Acomplamento ruim ocorre quando a classe A realiza um acesso direto a um SQL da classe B.
- Quando as classes A e B compartilham uma variável ou estrutura de dados global. Por exemplo, a classe B altera o valor de uma variável global que a classe A usa no seu código.
- Quando a interface da classe B não é estável. Por exemplo, os métodos públicos de B são renomeados com frequência.

Maximize a coesão das classes e minimize o acoplamento entre elas.

## SOLID
Pensado pelo Robert Martin para as pessoas pararem de escreverem POO de um jeito errado

Princípio da Responsabilidade Única:
- É uma aplicação direta da ideia de coesão, deve existir um único motivo para modificar qualquer classe em um sistema.
  
Princípio da Segregação de Interfaces- Liskov Substitution Principle
-  O princípio define que interfaces têm que ser pequenas, coesas e, mais importante ainda, específicas para cada tipo de cliente. O objetivo é evitar que clientes dependam de interfaces com métodos que eles não vão usar. 
-  Seta da herança: vazada e com a linha cheia.
-  Seta da implementação(interface): é tracejada e a seta vazia.
-  Seta de uso/associação: é completa e cheia

Exemplo: interface para o som e visualização do mouse em diferentes interfaces.
Interfaces tem responsabilidades únicas, ou seja, devem se separar.

Código janelinha: 
package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janelinha extends JFrame {

    private JButton botaozinho;
    private Controlador controlador;
    public Janelinha() {
        setTitle("Janelinha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        controlador = new Controlador();

        botaozinho = new JButton(" Me Clica ");
        botaozinho.addActionListener(controlador);
        botaozinho.addMouseMotionListener(controlador);
        add(botaozinho);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Janelinha();
    }
    
}


# Princípio de Inversão de Dependências
- O princípio recomenda que classes dependam de abstrações (interfaces) em vez de implementações concretas (classes), pois abstrações são mais estáveis. A ideia é inverter as dependências, fazendo com que os clientes dependam de interfaces, e não de implementações.

No springboot usamos o @Autowired em dotnet não temos, então tem que usar o construtor

Exemplo: num código que temos a classe "cliente", o mesmo pode trabalhar com objetos concretos das classes C1 e C2. Portanto, ele não precisa conhecer a classe concreta que está por trás.

# Prefira Composição Herança 
É a forma mais segura na construção de um software

- Herança de classes: envolve reúso de código.
- Herança de interfaces: não envolve reúso do código

  Quando de fato usaremos a herança( seta aberta com a linha cheia)
  Quando os filhos de uma superclasse não tem interação entre eles, ou seja, nunca um vai substituir o outro
   Exemplo: em cima temos "Animal, gato na esquerda e dog na direita"

  # Princípio de Demeter
  Defende a implementação de um método deve invocar apenas os seguintes outros métodos.
  - de sua própria classe (caso 1)
  - de objetos passados como parâmetros (caso 2)
  - de objetos criados pelo próprio método (caso 3)
  - de atributos da classe do método (caso 4)

# Princípio Aberto/Fechado
Uma classe deve estar fechada para modificações e aberta para extensões.

# Aula 28/08

- Estruturas de Arquitetura

- Característica da Arquitetura
De maneira resumida, são os requisitos não funcionais que o sistema precisa terse não tiver eles, talvez não tenha uma funcionalidade real.
Abrir mão de itens de textabilidade, agilidades para ter mais segurança é completamente viável

- Decisões 
Esse é o momento que tomamos a decisão de qual modelo de arquitetura e tecnologia iremos usar no projeto.

- Principio de desing: 
 maior objetivo é evitar acoplamentos
 







