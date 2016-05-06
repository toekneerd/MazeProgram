/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author Tony
 */
public class Point {
    private int row;
    private int col;
    
    public Point(){
        
    }
    
    public Point(int x, int y){
        this.row = x;
        this.col = y;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }
    
    public void setPoint(int row,int col){
        this.row = row;
        this.col = col;
    }
    
}
