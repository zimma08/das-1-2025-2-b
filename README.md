# das-1-2025-2-b

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





