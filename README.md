This program will find out if there is a solution to a given maze, and 
return the solution if there is one. 


Input follows the form:
-------
Number_of_mazes

Rows Columns 

Start_x Start_y End_x End_y

Maze 


Example Input: 
--
1

3 3

1 1 3 3

. . .

. . *

. . .

- .'s are valid moves 
- *'s are invalid moves 



****
Output is whether or not there is a solution to the maze, as well as 
the solution if there is one
****

Example Output:
-----
Maze #1: Solution Found

\* * * * *

\* a . . *

\* b . * *

\* c d e *

\* * * * *

***
To test the program, copy and paste the contents of mazeTest.txt into the 
program and watch as it solves the mazes!
***

INCLUDED CLASSES     
-------

MazeSolver.java
- This class is the main function of the program, where the input is parsed, 
the maze is created, and the proper output is given based on if the maze was
solved or not

Maze.java
- This class contains the Maze object and related methods. It contains the 
method to solve the maze, as well as some helper methods 

Point.java
- This class is used to represent each point in the maze, as well as functions
related to them 

