# TDE2 - Estrutura de Dados

## Integrantes
- Pedro Pimentel
- Gabriel Tomé
- Vinícius Felde
  
## RA1 - Fila circular e Merge

A fila foi feita usando um array de números inteiros. Ela é circular porque quando chega ao final do array a próxima posição volta a ser a primeira, desde que esteja livre.

Na classe `CircularQueue.java` estão as operações de inserir, remover e verificar se está cheia ou vazia, então consultar o primeiro e o último elemento.

Em `QueueTest.java` está o método `merge`, que junta duas filas já ordenadas em uma terceira fila, também em ordem crescente. Para isso, ele compara os primeiros números e vai retirando o menor. As filas originais ficam vazias depois do Merge.

Saída do exemplo:

```text
Fila A: [12, 35, 52, 64]
Fila B: [5, 15, 23, 55, 75]
Fila R: [5, 12, 15, 23, 35, 52, 55, 64, 75]
```

## RA2 - Árvore binária e código Morse

Usamos uma árvore binária para guardar as letras de A a Z e os números de 0 a 9.

Cada nó pode ter dois filhos, o da esquerda representa o ponto (`.`) e o da direita representa o traço (`-`). Seguindo esses caminhos o programa encontra o caractere correspondente.

Por exemplo, `...` representa a letra **S** e `---` representa a letra **O**.

Os arquivos são:

- `Node.java`: guarda o caractere e as referências para os dois filhos.
- `MorseTree.java`: monta a árvore e tem os métodos para inserir, buscar, codificar, decodificar e mostrar a árvore.
- `MorseTest.java`: executa o menu para testar as opções do programa.

No menu dá para transformar um texto em Morse, converter Morse de volta em texto, visualizar a árvore e procurar um código específico.

Para decodificar uma frase, os códigos das letras são separados por espaços e as palavras por `/`.

Exemplo:

```text
SOS -> ... --- ...
```
