Projeto desenvolvido como parte da avaliação da disciplina de Física na Universidade Estadual do Paraná (UNESPAR).

Este projeto é uma aplicação Java com interface gráfica (Swing) que permite analisar o movimento de um corpo com base em intervalos de tempo e velocidade constante após um período de repouso. A ferramenta calcula a velocidade média e a aceleração média em um determinado intervalo, utilizando conceitos fundamentais da cinemática.

Funcionalidades:
Interface gráfica simples e intuitiva.

Permite a entrada de:

Tempo inicial e final em que o corpo esteve parado (em minutos).

Velocidade constante durante o movimento (em m/s).

Tempo inicial e final do intervalo de análise (em minutos).

Cálculo automático de:

Velocidade média no intervalo especificado.

Aceleração média durante o intervalo.

Resultados exibidos de forma clara e organizada.

Tratamento de entradas inválidas com mensagens de erro informativas.

Lógica de Cálculo:
A lógica do programa considera que o corpo permanece parado durante um intervalo inicial, e após esse período passa a se mover com velocidade constante. As fórmulas utilizadas envolvem:

Cálculo da posição com base no tempo de movimento:
𝑥 = v * (t - tParado_Fim) se t > tParado_Fim, caso contrário 𝑥 = 0

Cálculo da velocidade média:

𝑣média = Δ𝑥/Δ𝑡

Cálculo da aceleração média:
𝑎média = 𝑣fim − 𝑣incio/Δ𝑡
 
Não são considerados efeitos como resistência do ar, e assume-se aceleração constante apenas para o cálculo da média.

Tecnologias Utilizadas:
Java (versão 8 ou superior)

Swing (API para criação de interfaces gráficas)
