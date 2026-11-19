# Respostas — Sistema de Reserva de Laboratorio

Nome completo: _______Rafael Revelli_______________________________  RA: ______________

> Preencha **todos** os campos. Campo vazio é campo não avaliado.
> Não apague os títulos nem os rótulos em negrito: a correção procura por eles.

---

# Etapa 1 — Diagnóstico

## Problema 1 — a conversão do inventario patrimonial

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
a conversão dos dados do inventário está duplicada nas classes CatalogoEquipamentos e RelatorioAcervo. Isso faz com que cada classe interprete os dados de uma maneira diferente, causando inconsistências. Quando o sistema cresce, qualquer alteração no formato exige mudanças em vários lugares, aumentando a possibilidade de erros

**Princípio SOLID violado:**
Princípio da Responsabilidade Única (SRP), pois as classes possuem responsabilidades de consulta e conversão dos dados.


**Classes afetadas (pelo nome):**


**Que outra dependência indevida essas classes têm em relação ao
inventario patrimonial, e por que ela é um problema:**
As duas classes dependem diretamente da implementação concreta InventarioLegadoWS. Isso gera alto acoplamento, dificultando a substituição do serviço e a realização de testes.


## Problema 2 — o ciclo de vida de Reserva

**Em que consiste o problema, e o que acontece quando o sistema cresce:**
as regras de transição da reserva estão espalhadas em condicionais nos métodos retirar(), devolver() e cancelar(). Quando novos estados forem adicionados, será necessário modificar vários métodos, tornando o código mais complexo e difícil de mante


**Princípio SOLID violado:**
Princípio Aberto/Fechado (OCP), pois a classe precisa ser modificada sempre que novas regras ou estados forem adicionados.


**Classes afetadas (pelo nome):**

Reserva.

---

# Etapa 4 — Justificativa

## Padrão aplicado ao Problema 1

**O problema que ele resolve (descreva antes de nomear o padrão):**
o problema é a duplicação da conversão dos dados do inventário e a dependência direta das classes em relação ao serviço legado. A solução centraliza a conversão em uma classe e permite que outras classes utilizem uma interface, sem conhecer a implementação do serviço externo.

**Nome do padrão:**
adapter 

**Alternativa descartada e por que ela não resolveria por completo:**
Alterar o serviço legado não seria uma boa solução, pois ele pertence a outra equipe e não temos controle sobre seu código. Além disso, modificar o serviço não resolveria necessariamente a duplicação da conversão nem o acoplamento das classes consumidoras.

## Padrão aplicado ao Problema 2

**O problema que ele resolve (descreva antes de nomear o padrão):**
O problema é que as regras de mudança de
estado estão espalhadas em condicionais dentro da classe Reserva. A solução separa cada estado em uma classe própria, permitindo que cada fase controle suas operações permitidas e suas transições.

**Nome do padrão:**
state

**Alternativa descartada e por que ela não resolveria por completo:**
Utilizar um enum no lugar da String melhoraria a segurança dos valores e evitaria erros de digitação, mas não resolveria a distribuição das regras de transição. Os condicionais continuariam concentrados nos métodos da classe Reserva.