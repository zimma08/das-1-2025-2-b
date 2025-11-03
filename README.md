## 31/07

## Abstração:
É o processo de simplificar a complexidade de um sistema, escondendo detalhes de implementação e expondo apenas as funcionalidades essenciais através de uma interface simplificada.
## Complexidade:
A complexidade de uma funcionalidade ou sistema deve estar concentrada em sua implementação, não em seu uso. Ou seja, é aceitável — e muitas vezes inevitável — que a construção de uma abstração seja desafiadora e técnica, mas seu uso por outros desenvolvedores precisa ser simples, intuitivo e previsível. Uma boa abstração esconde a complexidade interna e oferece uma interface clara para quem a utiliza.

#Dica: estudar POO, principalmente na linguagem Java, pois está envolvido em todas as linguagens.

Princípios de Projeto de Código
São diretrizes que visam criar software de alta qualidade. Eles incluem o princípio da responsabilidade única (SRP), que defende que cada módulo deve ter apenas uma razão para mudar, e o princípio aberto/fechado (OCP), que afirma que entidades de software devem estar abertas para extensão, mas fechadas para modificação.

Padronização de Código
É um conjunto de regras e convenções adotadas por uma equipe para garantir consistência na escrita do código. Isso inclui convenções de nomenclatura, formatação, e documentação. O objetivo é melhorar a legibilidade, a manutenção e a colaboração no projeto.

Ocultamento de Informação
Também conhecido como encapsulamento, é o princípio de esconder os detalhes de implementação de um módulo de outros módulos. Apenas a interface pública é exposta. Isso reduz a dependência entre as partes do código, facilitando alterações e minimizando efeitos colaterais.

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

# Aula 11/08

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
Uma classe deve estar fechada para modificações e aberta para extensões. Isso significa que o comportamento de uma entidade pode ser estendido sem a necessidade de alterar seu código-fonte. Você pode adicionar novas funcionalidades ao sistema, mas sem mudar as classes existentes, o que minimiza o risco de introduzir bugs e de quebrar funcionalidades que já estão funcionando.

# Aula 14/08

#Princípio Liskov 

-Regra: se uma classe B herda de uma classe A, a classe B deve poder ser usada no lugar da classe A sem quebrar nada no programa.
-Exemplo: se tenho uma função que aceita um Quadrado, e Retângulo herda de Quadrado, essa função deve aceitar um Retângulo sem dar erro.
-O objetivo é garantir que a herança seja usada de forma correta e que o código continue consistente.
-Ajuda a evitar surpresas e bugs estranhos quando trabalhamos com subclasses.

O Princípio de Substituição de Liskov garante que objetos de uma subclasse podem substituir objetos de sua classe-mãe sem causar erros, mantendo o comportamento do programa consistente. Ele assegura o uso correto da herança para criar um código mais robusto e previsível.

# Aula 21/08 

"Aula usada para implementação do Design Pattern: Observer"

Vantagens: A principal vantagem é o baixo acoplamento. O Assunto e o Observador operam de forma independente, tornando o código mais flexível.
Desvantagens: A implementação pode ter problemas de gerenciamento de memória se os Observadores não forem removidos corretamente. A ordem de notificação dos Observadores também não é garantida por padrão.
Variante Comum: A notificação pode ser "push" (envia dados para o Observador) ou "pull" (o Observador busca os dados do Assunto).

# Aula 25/08

Implementação do Padrão Observer
O padrão Observer é implementado com dois papéis principais: Assunto e Observador.

Observador: Crie uma interface com um método de atualização (update()). Todas as classes que precisam ser notificadas devem implementar essa interface.
Assunto: Crie uma classe que mantém uma lista de Observadores. Ela deve ter métodos para adicionar (attach), remover (detach) e notificar (notify) os observadores. Quando seu estado muda, o Assunto percorre a lista e chama o update() de cada Observador.


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

#Domínio do Negócio 

O Domínio do Negócio é a área de conhecimento e as regras do mundo real que um software precisa modelar. Compreendê-lo é essencial para criar soluções que realmente atendam às necessidades do cliente.

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

# Aula 08/09

Arquitetura é feita de trade-offs — não existe resposta certa, só a melhor decisão para o contexto. Por isso, "depende" é sempre a resposta mais honesta.

No exemplo de um sistema de leilão, o serviço que envia lances pode se comunicar com os demais por tópicos (publish/subscribe) ou por filas (ponto a ponto).

A abordagem por tópico é mais extensível e desacoplada: basta publicar uma vez e qualquer novo serviço pode assinar, sem modificar o emissor. Porém, ela tem desvantagens como menor segurança, contratos homogêneos entre serviços e dificuldade de monitoramento individual. 1 to any.

Já a abordagem por fila é mais segura e flexível em termos de contratos — cada consumidor tem sua fila e pode escalar de forma independente. Mas exige mais acoplamento, pois o emissor precisa conhecer cada destino.

No fim, não existe uma escolha certa. A decisão correta depende das necessidades do sistema, do time, da tecnologia e do momento do projeto.

Vantagem da fila padrão mantém uma ordem e contém um armazenamento, diferentemente do tópico (alguns guardam) mas na origem quem guarda é a fila, justamente por ela guardar a sequencia das coisas que chegaram. Na fila é de 1 para 1.

Basicamente a fila funciona como uma “linha de atendimento”: cada mensagem vai para um único consumidor, tipo quem chega primeiro pega a vez. Isso ajuda a distribuir o trabalho, porque várias pessoas (consumidores) vão pegando mensagens diferentes para processar, sem ninguém duplicar o esforço.

Já o tópico é como um megafone, onde você fala uma coisa e todo mundo que estiver ouvindo recebe ao mesmo tempo. Ou seja, uma mensagem enviada no tópico é entregue para todos os serviços que estão “assinando” aquele assunto. É ótimo quando você quer que várias partes do sistema saibam de um evento ao mesmo tempo.

 Resumindo: fila é mensagem pra um consumidor só, tópico é mensagem pra todo mundo que está “escutando”.

# Aula 15/08 e 18/09

Implementação do Publisher e Subscriber(tópico)

A implementação do padrão Pub/Sub é uma evolução do padrão Observer, introduzindo um intermediário que desacopla completamente o publicador do assinante.

O Corretor (Broker/Event Bus): É o componente central. Ele mantém um registro dos tópicos e quais assinantes estão interessados em cada um. Pode ser implementado como uma classe que gerencia um Map onde a chave é o nome do tópico e o valor é a lista de assinantes.

Assinante (Subscriber): Para receber mensagens, ele se registra no Corretor, especificando o tópico de interesse. Ele não tem conhecimento de quem publicará as mensagens.

Publicador (Publisher): Para enviar mensagens, ele se conecta ao Corretor e publica uma mensagem para um tópico específico. Ele não sabe quem, ou quantos, assinantes irão receber a mensagem.

Essa arquitetura elimina a dependência direta entre publicadores e assinantes, resultando em um sistema muito mais flexível, escalável e fácil de manter.

# Aula 06/10

Introdução

Quando uma empresa quer criar um software para resolver algum problema, ela define o que o sistema deve fazer — esses são os chamados requisitos funcionais.

Mas além disso, existem outros requisitos que não definem exatamente o que o sistema faz, mas como ele deve funcionar para dar certo. Essas são as características da arquitetura.

#Por que não chamar de “requisitos não funcionais”?

Muita gente chama essas características de “não funcionais” e acaba parecendo que são menos importantes. Mas isso não é verdade. Na verdade, essas características são essenciais para o sucesso do sistema.

Por isso, quem trabalha com arquitetura de software prefere chamar de “características da arquitetura” — para mostrar que elas são tão importantes quanto as funcionalidades.

#O que faz uma característica ser da arquitetura?

Para ser considerada uma característica da arquitetura, ela precisa:

- Não estar diretamente ligada ao problema que o sistema resolve, ou seja, não fala do que o sistema faz, mas de como ele deve funcionar (exemplo: segurança, desempenho, escalabilidade).

- Exigir uma decisão arquitetural — ou seja, a equipe precisa pensar na estrutura e no design para atender essa característica.

- Ser realmente importante para o sucesso do sistema, porque colocar muita coisa acaba complicando o projeto.

#Algumas características estão ali, mesmo que ninguém fale

Tem características que nem aparecem nos requisitos, mas são super importantes — como segurança, disponibilidade e confiabilidade. Por isso, o arquiteto tem que estar sempre de olho nessas “características invisíveis”, mesmo que o cliente não peça explicitamente.

#É sempre preciso fazer escolhas e abrir mão de alguma coisa

Quando você melhora uma característica, outra pode ser prejudicada. Por exemplo, aumentar a segurança pode deixar o sistema mais lento. Ou melhorar a escalabilidade pode complicar a manutenção.

Ser arquiteto é como pilotar um helicóptero: cada ajuste afeta várias coisas, e o segredo está em encontrar o equilíbrio.

Por isso, não existe “a arquitetura perfeita”, mas sim a que melhor se encaixa na situação da empresa.

E, claro, é muito mais inteligente ir ajustando a arquitetura ao longo do tempo do que tentar adivinhar tudo logo no começo.

#Tipos de características da arquitetura

Dividios em três grupos principais:

1. Características operacionais: relacionadas ao comportamento do sistema em funcionamento, como desempenho, escalabilidade, disponibilidade e capacidade de recuperação.

2. Características estruturais: relacionadas à organização interna do software, como modularidade, facilidade de manutenção, portabilidade e facilidade para atualizar.

3. Características que cruzam tudo: que impactam o sistema todo, como segurança, privacidade, usabilidade, autenticação, acessibilidade e conformidade com leis.

Exemplo:

Uma empresa usava uma expressão para lembrar que o sistema precisava ser muito robusto: “E se a Itália desaparecesse?”. Eles queriam garantir que o sistema continuasse funcionando mesmo em situações críticas, como se “perdessem a Itália”.

Isso mostra que, dependendo do negócio, a arquitetura precisa considerar características muito específicas.

Outro ponto:

Muita confusão acontece porque termos parecidos são usados de jeitos diferentes. Por isso, é importante que toda a equipe tenha um entendimento comum das palavras que estão usando, para evitar mal-entendidos.

Dicas do ChatGPT:

Foque nas poucas características que realmente importam. Tentar fazer tudo ao mesmo tempo só complica.

Não tente construir um sistema que atenda a todos os problemas do mundo. Foque no que é importante para o momento.

Vá melhorando a arquitetura ao longo do tempo, com ajustes e aprendizados.

Registre as escolhas que você fez e por que abriu mão de outras opções.

Memorizar segundo o ChatGPT:

“Não funcional não quer dizer que seja menos importante.”

“Uma boa arquitetura é aquela que sabe equilibrar os diferentes objetivos.”

“Melhor fazer o que dá pra fazer bem agora e ir ajustando depois.”

# Aula 09/10

Padrão Circuit Breaker 
O que é:
Padrão para aumentar resiliência em sistemas distribuídos.

Evita chamadas repetidas a serviços instáveis ou fora do ar.

Age como um disjuntor elétrico: corta chamadas quando percebe falhas recorrentes e permite retomar quando o serviço se recupera.

Estados do Circuit Breaker
Closed (Fechado)
Tudo normal. As chamadas passam.
Monitora falhas → se passar do limite, vai para Open.

Open (Aberto)

Bloqueia chamadas imediatamente.
Evita sobrecarga e falhas em cascata.
Espera um tempo (time-out) e muda para Half-Open.
Half-Open (Meio-Aberto
Libera algumas chamadas de teste.
Se der certo, volta pra Closed.
Se falhar, volta pra Open e recomeça o time-out.

Quando usar?

Prevenir falhas em cascata.

Proteger serviços de alta latência ou com falhas intermitentes.

Manter estabilidade quando há picos de uso.

Em ambientes distribuídos com serviços remotos.

Quando não usar?

Acesso a recursos locais (ex: memória).

Sistema já tem tratamento de falhas adequado (ex: filas com DLQ).

Retry simples já resolve o problema.

Esperar o reset pode causar atraso inaceitável.

Diferença: Retry x Circuit Breaker

Retry: tenta de novo esperando que funcione (falha transitória).

Circuit Breaker: não tenta se sabe que vai falhar (falha persistente).

Pode usar os dois juntos, com cuidado para respeitar o estado do disjuntor.

Considerações importantes

Exceções: aplicação deve saber lidar com falha vinda do disjuntor.

Tipos de falha: pode ajustar o comportamento com base no erro (ex: timeout vs. serviço indisponível).

Monitoramento: usar logs e alertas (ex: Azure Monitor).

Pings/Health Checks: testar se o serviço voltou (ver padrão Health Endpoint Monitoring).

Override manual: permitir admin resetar ou forçar o disjuntor.

Concorrência: deve funcionar bem com várias instâncias simultâneas.

Time-out correto: cuidado com serviços externos que demoram demais.


Resumão:
Circuit Breaker é essencial em sistemas resilientes. Ele previne falhas em cascata, melhora a performance durante falhas e permite que os sistemas se recuperem de forma segura e eficiente.

#Definição das características arquitetuais 

Como falado na aula anterior, as características arquiteturais definem os atributos essenciais que orientam o design e o comportamento de um sistema, como desempenho, escalabilidade, segurança, confiabilidade e manutenibilidade. Elas estabelecem critérios que influenciam as decisões técnicas e a estrutura geral da aplicação, garantindo que ela atenda aos requisitos funcionais e não funcionais esperados, além de suportar mudanças e evoluções futuras.

# Aula 13/10

#Padrão CQRS
O padrão CQRS separa as operações de leitura (queries) das operações de escrita (commands) em modelos distintos, permitindo que cada um seja otimizado independentemente para melhorar desempenho, escalabilidade e segurança. Enquanto a arquitetura tradicional usa um único modelo para CRUD, o CQRS reconhece que leitura e escrita têm requisitos diferentes, evitando problemas como contenção de bloqueios, desempenho degradado e complexidade excessiva.

No CQRS, os comandos representam ações de negócios específicas e alteram dados, geralmente com validações e lógica de domínio complexa, podendo ser processados de forma síncrona ou assíncrona. As consultas, por outro lado, são simples e retornam dados otimizados para leitura, sem lógica de negócio.

Existem duas abordagens principais para implementar CQRS: usando o mesmo banco de dados para leitura e escrita com lógica separada, ou usando bancos distintos, o que exige mecanismos para manter a sincronização entre eles, frequentemente via eventos.

Os principais benefícios incluem escalabilidade independente para leitura e escrita, modelos otimizados para cada função, melhor segurança e separação clara de responsabilidades. No entanto, CQRS pode aumentar a complexidade do sistema, exigir tratamento especial para consistência eventual e desafios com mensagens assíncronas.

CQRS é recomendado para sistemas com alta concorrência, interfaces baseadas em tarefas, lógica complexa de domínio, necessidade de escalabilidade e equipes de desenvolvimento separadas. Para domínios simples e operações CRUD básicas, pode ser um exagero.

Combinar CQRS com Event Sourcing potencializa seus benefícios, armazenando o estado do sistema como eventos que alimentam as visões de leitura, facilitando auditoria, reprocessamento e escalabilidade.

#Estilos e Padrões 

Os estilos de arquitetura são formas conhecidas de organizar sistemas de software, com nomes que ajudam arquitetos a se entenderem rapidamente. Por exemplo, quando alguém fala em uma arquitetura em camadas, já entende a estrutura e os prós e contras envolvidos. Entre os padrões fundamentais, a ideia de separar o sistema em camadas é antiga e muito utilizada.

Um problema comum na arquitetura é o chamado antipadrão "Grande Bola de Lama", que é quando o sistema está totalmente bagunçado, com código mal estruturado e difícil de manter, geralmente por falta de planejamento ou controle.

A arquitetura cliente/servidor é um dos estilos mais tradicionais, separando o sistema em front-end (cliente) e back-end (servidor). Isso evoluiu do modelo desktop + banco de dados para a web, com navegador e servidor web, e depois para arquiteturas mais complexas com três camadas, onde se separa banco de dados, lógica de aplicação e interface do usuário, melhorando manutenção e escalabilidade.

Arquiteturas podem ser monolíticas, com todo código junto, ou distribuídas, com partes separadas conectadas pela rede, como nos microsserviços. As arquiteturas distribuídas são mais poderosas, mas trazem desafios de complexidade.

Ao projetar uma arquitetura, é importante entender que melhorar uma característica, como segurança, pode afetar negativamente outra, como desempenho. Por isso, a arquitetura é sempre um exercício de equilíbrio, e deve ser pensada para permitir mudanças e melhorias ao longo do tempo, evitando tentar acertar tudo de primeira.

# Aula 16/10

O Retry Pattern no Azure permite que aplicações lidem com falhas transitórias ao se comunicar com serviços ou recursos em nuvem, repetindo automaticamente operações que falharam. Isso aumenta a estabilidade e resiliência da aplicação, já que falhas como perda momentânea de rede, indisponibilidade temporária ou timeouts geralmente se resolvem sozinhas.

A ideia central é tentar novamente a operação após uma falha, usando estratégias como: cancelar, tentar imediatamente ou tentar após atraso, possivelmente com aumentos progressivos no tempo entre tentativas. O padrão deve respeitar idempotência, tipo de exceção e consistência de transações.

Boas práticas incluem:

Testar o código de retry para diferentes cenários de falha.

Logar falhas, mas registrar erros reais apenas se todas as tentativas falharem.

Ajustar o número de tentativas e atrasos conforme a criticidade da operação.

Evitar retries desnecessários que sobrecarreguem o serviço.

Usar frameworks como Polly (.NET) ou Resilience4j (Java) quando possível.

O padrão é útil para falhas curtas e transitórias, mas não substitui soluções de escalabilidade nem lida bem com falhas longas, que podem ser tratadas com o Circuit Breaker Pattern. Ele contribui principalmente para a confiabilidade de workloads distribuídos na nuvem.

# Aula 20/10
 Introdução:

A arquitetura em camadas (ou n-tier) é basicamente um jeito de organizar o sistema em partes diferentes, cada uma com sua função. É bem comum e usada há muito tempo porque é simples, fácil de entender e combina com a forma que as equipes de desenvolvimento costumam trabalhar.

Em sistemas pequenos, dá pra usar só algumas camadas. Já em sistemas maiores, é normal ter mais camadas pra deixar tudo mais organizado.

Função de cada camada:

Apresentação: é a parte que o usuário vê e interage (a interface).

Negócio: onde ficam as regras do sistema e o processamento dos dados.

Persistência: responsável por conversar com o banco de dados.

Banco de dados: onde as informações são realmente guardadas.

A ideia principal é deixar cada parte isolada, sem uma depender diretamente da outra. Assim, se for preciso mudar algo (tipo trocar JSF por React), o resto do sistema continua funcionando de boa.

Tipos de camadas:

Camadas fechadas: só falam com a camada de baixo — mais organizadas e fáceis de manter.

Camadas abertas: permitem acesso direto entre partes, mas perdem um pouco da organização.
# Aula 23/10

Essa arquitetura é barata, simples e boa pra começar um projeto pequeno. Cada parte tem sua responsabilidade e isso ajuda a deixar o código mais limpo e fácil de entender.

Importante tomar cuidado com um problema chamado "sinkhole", que acontece quando os dados passam por várias camadas sem fazer nada de útil (só pra cumprir tabela). Isso deixa o sistema mais pesado sem motivo.

Quando o sistema cresce, a arquitetura em camadas pode começar a dar trabalho pra manter e testar. Pequenas mudanças podem acabar afetando várias partes do código. Além disso, ela não escala tão bem e pode ficar mais lenta em sistemas grandes.

Se uma camada falhar, tudo pode parar junto, o que torna a aplicação menos confiável em projetos críticos.

Por isso, em sistemas maiores, pode ser melhor usar algo mais moderno e modular, como microserviços ou arquitetura hexagonal, que dão mais liberdade e são mais fáceis de escalar.

# Aula 27/10 e 30/10
- Código

# Aula 03/11 e 06/11

Arquitetura Microkernel (ou de Plug-ins)

A arquitetura microkernel divide o sistema em um núcleo central (com funções essenciais) e plug-ins (que estendem ou personalizam o sistema). Essa separação traz flexibilidade, facilidade de manutenção, testabilidade e expansão, pois novos recursos podem ser adicionados sem alterar o núcleo.

Os plug-ins são autônomos e independentes, comunicando-se com o núcleo de forma direta (ponto a ponto) ou, em sistemas mais complexos, por acesso remoto, o que aumenta o desacoplamento e a escalabilidade, mas também a complexidade e o risco de falhas.

Podem ser carregados em tempo de compilação (menos flexíveis) ou em tempo de execução (mais dinâmicos, via OSGi, Jigsaw, Prism). São implementados como bibliotecas compartilhadas (JAR, DLL, etc.) e registrados em um catálogo de plug-ins, que guarda informações como nome, contrato e protocolo.

A comunicação entre o núcleo e os plug-ins é definida por contratos (interfaces, XML, JSON), e adaptadores podem ajustar plug-ins de terceiros sem modificar o núcleo.

Softwares como Eclipse, Jira, Jenkins, Chrome e Firefox usam essa arquitetura. Ela é especialmente útil em sistemas empresariais personalizados, como seguros e sistemas fiscais.

Pontos fortes: modularidade, extensibilidade, manutenção simples, boa testabilidade e performance.
Pontos fracos: escalabilidade limitada, menor tolerância a falhas e gargalo no núcleo central.

Ideal para: sistemas com alta customização e evolução contínua.
🚫 Menos indicada para: sistemas distribuídos que exigem alta escalabilidade e resiliência.
















/
