/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author adecar3
 */

public class Maze {
// =================================
// Maze Lab 1
// =================================
// Anthony DeCarlo
// 02/29/2016
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    static int maxRow = 29;
    static int minRow = 0;
    static int maxCol = 19;
    static int minCol = 0;
     public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        
        Scanner console = new Scanner(System.in);
        char[][] maze = new char[30][20];
        maze = readFile("H:\\maze.txt");
        int rowStart = getRowStart();
        int colStart = getColStart();
        while(maze[rowStart][colStart] == '1' || maze[rowStart][colStart] == 'E'){
            System.out.println("Invalid starting point,please try again");
            rowStart = getRowStart();
            colStart = getColStart();      
        }


        
        

        System.out.println();
        maze[rowStart][colStart] = 'S';
        solveMaze(maze,rowStart,colStart);
        printMaze(maze);
        
        

        
    }
    public static void printMaze(char[][] maze){
                for(int row = 0; row < 30; row++)
        {
            System.out.println("");
            for (int col  = 0; col <20; col ++){
                System.out.print(maze[row][col]);    
            }
        }
        System.out.println();
    }
        
        
      
    
    public static char[][] readFile(String file) throws FileNotFoundException{
       char[][] maze = new char[30][20];
       Scanner console = new Scanner(new File(file));
       for(int row = 0; row<30;row++)
       {
           String line = console.next();
           System.out.println(line);
         for(int col=0;col<20;col++){
            maze[row][col] = line.charAt(col);
           }
       }
       
       return maze;
    }
    public static boolean solveMaze(char maze[][],int row,int col){        
        boolean solved = false;
        Point p = new Point(row,col);
        Point cur = null;
        Stack<Point> s = new Stack<Point>();
        s.push(p);
        while(!s.isEmpty() && solved == false){
            cur = s.pop();
            if(maze[cur.getRow()][cur.getCol()] == 'E'){
                solved = true;
                System.out.println("");
                System.out.println("I am free");
            }
                 else{
                    if(isValidUp(maze,cur.getRow(),cur.getCol()) == true)
                        s.push(new Point(cur.getRow()-1, cur.getCol()));
                    if(isValidRight(maze,cur.getRow(),cur.getCol()) == true)
                        s.push(new Point(cur.getRow(),cur.getCol()+1));
                
                    if(isValidDown(maze,cur.getRow(),cur.getCol()) == true)
                        s.push(new Point(cur.getRow()+1,cur.getCol()));
                    
                    if(isValidLeft(maze,cur.getRow(),cur.getCol()) == true)
                        s.push(new Point(cur.getRow(),cur.getCol()-1));
            }
                
                if(maze[cur.getRow()][cur.getCol()] != 'E' && maze[cur.getRow()][cur.getCol()] != 'S')
                    maze[cur.getRow()][cur.getCol()] = '+';
                if(s.isEmpty()){
                    System.out.println();
                    System.out.println("I am trapped");
                }
            }
            return solved;   
        }
       
 
  
    public static boolean isValidUp(char[][] maze,int row, int col){
        boolean isValid = false;
        if (row-1 < minRow)
            isValid = false;
        else if((maze[row-1][col] == '0') ||(maze[row-1][col] == 'E') )
            isValid = true;
        return isValid;
            
    }
        public static boolean isValidRight(char[][] maze,int row, int col){
        boolean isValid = false;
        if (col+1 > maxCol)
            isValid = false;
        else if((maze[row][col+1] == '0') ||(maze[row][col+1] == 'E'))
            isValid = true;
        return isValid;        
    }
       public static boolean isValidDown(char[][] maze,int row, int col){
        boolean isValid = false;
        if (row+1 > maxRow)
            isValid = false;
        else if((maze[row+1][col] == '0') ||(maze[row+1][col] == 'E') )
            isValid = true;
        return isValid;
       }   
       public static boolean isValidLeft(char[][] maze,int row, int col){
        boolean isValid = false;
        if (col-1 < minCol)
            isValid = false;
        else if((maze[row][col-1] == '0') ||(maze[row][col-1] == 'E') )
            isValid = true;
        return isValid;
       }  
       

       public static int getRowStart(){
           boolean flag = false;
           int rowStart = 0;
           System.out.println("Which row would you like to start at(0-29)");
            rowStart = getInt();
            while ((rowStart<minRow) || (rowStart>maxRow)){
                flag = false;
                System.out.println("Enter a valid row to start at(0-29)");
                rowStart = getInt();
            }
           
            return rowStart;
       }
       
       public static int getColStart(){
           boolean flag = false;
           Scanner console = new Scanner(System.in);
           
           System.out.println("Which col would you like to start at(0-19)");
            int colStart = getInt();
            while ((colStart<minRow) || (colStart>maxCol)){
                flag = false;
                System.out.println("Enter a valid col to start at(0-19)");
                colStart = getInt();
            }
            return colStart;
       }
    public static int getInt()
    {
     Scanner inp = new Scanner(System.in);
     int intInp = 0;
     boolean valid;
     do
     {
         if(inp.hasNextInt())
         {
         intInp = inp.nextInt();
         valid = true;
         }
         else
         {
         valid = false;
         inp.next();
         System.out.println("Not a valid integer! Please try again!");     
         }
     }
        while (!valid);
        return intInp;
     }
    }




