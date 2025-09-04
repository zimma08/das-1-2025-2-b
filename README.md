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

 # Aula 01/09

 #Expectativas de um arquiteto

 - Tomar decisões de arquitetura 
 - Analisar continuamente com arquitetura
 - Manter-se atualizado com as últimas tendências
 - Assegurar a conformidade com as decisões
 - Exposição e experiência diversificadas
 - Ter conhecimento sobre o domínio do negócio
 - Ter habilidades interpessoais
 - Entender e lidar bem com questões políticas
  
O primeiro segredo para a eficiência e o sucesso na função de arquiteto de software depende de compreender e praticar cada uma dessas expectativas. 

#Tomar Decisões de Arquitetura 

Um arquiteto de software deve orientar, e não impor, as escolhas tecnológicas das equipes. Em vez de decidir por um framework específico (como React.js), ele deve indicar direções arquiteturais (como usar um framework reativo), permitindo que a equipe escolha a melhor opção. A linha entre decisão técnica e arquitetural pode ser sutil. Às vezes, é necessário especificar uma tecnologia para manter atributos como escalabilidade ou desempenho — e, nesse contexto, isso ainda é uma decisão arquitetural válida. O equilíbrio entre orientar e decidir é fundamental, e o Capítulo 19 trata exatamente dessas decisões de arquitetura.

#Analisar Continuamente a Arquitetura

Um arquiteto deve monitorar continuamente a arquitetura e o ambiente tecnológico para garantir sua viabilidade diante das mudanças no negócio e tecnologia. Ignorar essa prática causa decadência estrutural e reduz a agilidade no desenvolvimento, testes e lançamentos. Assim, o arquiteto mantém a arquitetura robusta e alinhada às necessidades atuais.

#Manter-se atualizado com as Últimas Tendências 

Um arquiteto deve ficar atualizado com as últimas tendências da tecnologia e do setor. As decisões que um arquiteto toma tendem a ser de longo prazo e difíceis de mudar. Entender e seguir as principais tendências contribui para que ele se prepare para o futuro e tome a decisão certa

#Assegurar a Conformidade com as Decisões

Um arquiteto deve assegurar a conformidade com as decisões de arquitetura e os princípios de design. Isso significa que a camada de apresentação deverá passar por todas as camadas da arquitetura para fazer até o mais simples chamado do banco de dados.

#Exposição e Experiência Diversificadas

Um dos melhores modos de dominar essa expectativa é o arquiteto aumentar sua zona de conforto. Focar apenas uma tecnologia ou plataforma é um porto seguro. Um arquiteto de software eficiente deve ser agressivo ao buscar oportunidades para ter experiência em várias linguagens, plataformas e tecnologias. Uma boa maneira de dominar a expectativa é se concentrar na amplitude técnica, não na profundidade técnica.

#Ter Habilidades Interpessoais
 
- Saber se comunicar com o time, ou seja, dar feedbacks para uma melhoria da equipe e saber também receber feedbacks tanto positivos quanto negativos, mesmo que online.

#Operação DevOps

A integração entre arquitetura e operações ganhou força com o DevOps, que rompeu a visão tradicional de operações separadas do desenvolvimento. Arquiteturas antigas eram complexas, pois precisavam compensar limitações das operações terceirizadas. Com os microsserviços, arquitetos e operações colaboram para simplificar o design, delegando responsabilidades operacionais a quem é especializado nisso, reduzindo a complexidade.

# Aula 04/09 

Diferença entre Arquitetura e Design

Arquitetura:
Foca em aspectos de alto nível do sistema. O arquiteto analisa os requisitos comerciais, define os atributos da arquitetura (como desempenho, segurança, escalabilidade), escolhe padrões e estilos arquiteturais e cria os componentes principais (blocos de construção do sistema). A arquitetura serve como um guia global para o desenvolvimento do sistema.

Design:
Está mais voltado para detalhes específicos dentro dos componentes definidos pela arquitetura. Os desenvolvedores criam diagramas de classes, interfaces de usuário, e implementam e testam o código-fonte. O design lida com a solução detalhada dos problemas técnicos dentro dos limites da arquitetura.

Responsabilidades

Arquiteto:
Define a estrutura geral, padrões, estratégias e componentes principais. Atua na conexão entre os objetivos de negócio e as soluções técnicas.

Desenvolvedor:
Implementa a solução detalhada, cria o código, telas, testes, baseando-se na arquitetura definida.

Em resumo: 

Arquitetura define a estrutura geral do sistema, escolhendo padrões e componentes para atender aos objetivos do negócio. Design cuida dos detalhes dentro dessa estrutura, como a implementação do código e interfaces. Para funcionar bem, arquitetos e desenvolvedores precisam trabalhar juntos, com comunicação constante, evitando que a arquitetura fique isolada do desenvolvimento.

Observações:

A arquitetura e o design devem trabalhar juntos de forma colaborativa e contínua. A arquitetura não deve ser isolada da equipe de desenvolvimento, uma comunicação bidirecional forte entre arquitetos e desenvolvedores é essencial para que o sistema funcione conforme planejado.


Como é a formação do conhecimento de um arquiteto de modelo T?

A formação do conhecimento de um arquiteto de modelo T envolve o desenvolvimento de duas áreas principais: uma base profunda e especializada em arquitetura (o traço vertical do “T”) e um conhecimento amplo e integrado em outras disciplinas relacionadas (o traço horizontal do “T”).

O traço vertical representa a expertise técnica e aprofundada em áreas específicas da arquitetura, como padrões arquiteturais, tecnologias, segurança, desempenho e modelagem de sistemas. Já o traço horizontal corresponde ao entendimento geral sobre outras áreas que impactam o sistema, como negócios, desenvolvimento, infraestrutura, experiência do usuário e operações.

Essa combinação permite que o arquiteto tenha uma visão abrangente e consiga se comunicar e colaborar efetivamente com diferentes equipes, além de aplicar seu conhecimento especializado para criar soluções arquiteturais alinhadas aos objetivos técnicos e comerciais. Em resumo, o arquiteto de modelo T é aquele que domina profundamente sua área, mas também tem um bom entendimento transversal para integrar conhecimentos e trabalhar de forma colaborativa.

Resumidamente, a formação do conhecimento de um arquiteto de modelo T combina uma profunda especialização técnica em arquitetura de sistemas com um amplo entendimento de outras áreas relacionadas, como negócios, desenvolvimento, infraestrutura e experiência do usuário. Essa abordagem permite que o arquiteto tenha expertise detalhada em sua área, enquanto mantém uma visão integrada e transversal, facilitando a comunicação e colaboração eficaz entre diferentes equipes para criar soluções alinhadas tanto aos objetivos técnicos quanto comerciais.















