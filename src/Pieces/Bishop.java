package Pieces;

import Game.Board;

//import ChessGame.*;

public class Bishop extends Piece{
	
	/**
     * Constructor for Bishop.
     * @param x: the x location
     * @param y: the y location
     * @param color: the color of the piece
     */
	public Bishop(int x, int y, Color color) {
		super(x, y, color);
		type = Type.bishop;
	}
	
	/**
     * Getter for piece type
     * @return return the type of a piece
     */
	public Type getType() {
		return Type.bishop;
	}
	
	/**
     * Check if it is valid to move a bishop piece to specified location.
     * @param board: the current board
     * @param nx : the new x location
     * @param ny : the new y location
     * @return  whether valid
     */
    public boolean isValidMoveType(Board board, int nx, int ny) {
    	
    	if ( (Math.abs(nx-x) == Math.abs(ny-y)) && isNotBlocked(board,nx,ny))
    		return true;
    	else if ((Math.abs(nx-x) != Math.abs(ny-y)))
    		System.out.println("Invalid movement: Bishop can only move diagonally");
    	
    	return false;
    }
    
    /**
     * Check if there is any piece block the way to specified location
     * @param board: the current board
     * @param nx : the new x location
     * @param ny : the new y location
     * @return whether blocked
     */
    public boolean isNotBlocked(Board board, int nx, int ny) {
    	
    	// must move diagonally
    	int dirX = nx > x ? 1 : -1;
    	int dirY = ny > y ? 1 : -1;
    	
    	if (Math.abs(nx-x) == Math.abs(ny-y)){
    		for(int i=1; i<Math.abs(nx-x); i++){
                if(board.isOccupied(x+dirX*i, y+dirY*i)) {
                	System.out.println("Invalid movement: The path is blocked");
                    return false;
                }
            }
    	}
    	
    	return true;
    }


}