# Game of Life https://hyperskill.org/projects/54

## Stage 1
The first program should output a square matrix NxN: there must be N lines with N characters in each line. If there is an alive cell, place the letter ‘O’, otherwise, whitespace.

Input data is two numbers in one line. First is N (N>0): the size of the universe. The second is S: a number that you should use as the seed for your Random object.

## Stage 2
Evolution is controlled by two rules:

A live cell survives if it has two or three live neighbors; otherwise, it dies of boredom (<2) or overpopulation (>3).

A dead cell is reborn if it has exactly three live neighbors.

The program should apply these rules to each cell in order to compute the next generation.

At this stage, you should make several consecutive generations. For this, you have to store the state of the universe in memory.

## Stage 3
Let’s visualize evolution. In the previous stage, we could see only one generation. It would be better if each generation was displayed. But our perception is not as fast as computer’s, so our application should sleep a little after each generation.
