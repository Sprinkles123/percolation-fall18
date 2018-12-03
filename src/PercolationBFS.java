/**
 * @author Fritz Thelusca (ft34)
 * 
 * Simulation program for PercolationBFS
 */
import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	/**
	 * Initialize a grid so that all cells are blocked.
	 * 
	 * @param n is the size of the simulated (square) grid
	 */
	public PercolationBFS(int n) {
		super(n);
	}
	
	/**
	 * Private helper method to mark all cells that are open and reachable from
	 * (row,col) using a Queue and a breadth-first-search (BFS) approach
	 * 
	 * @param row is the row coordinate of the cell being checked/marked
	 * @param col is the col coordinate of the cell being checked/marked
	 */
	@Override 
		protected void dfs(int row, int col) {
		      int size = myGrid.length;
		      
			  Queue<Integer> qp = new LinkedList<>();       
		        myGrid[row][col] = FULL;                        
		        qp.add(calc(row,col));
		        
		        while (qp.size() != 0){
		            Integer p = qp.remove();
		            row=p/size;
		            col=p%size;
		            
		    		if(inBounds(row-1,col)==true&&isOpen(row-1,col)==true &&myGrid[row-1][col] !=FULL) {
		    			qp.add(calc(row-1,col)); 
		    			myGrid[row-1][col]=FULL; 
		    		}
		    		
		    		if(inBounds(row+1,col)==true&&isOpen(row+1,col)==true &&myGrid[row+1][col] !=FULL) {
		    			qp.add(calc(row+1,col));
		    			myGrid[row+1][col]=FULL;	
		    		}
		    		
		    		if(inBounds(row,col-1)==true&&isOpen(row,col-1)==true &&myGrid[row][col-1] !=FULL) {
		    			qp.add(calc(row,col-1));
		    			myGrid[row][col-1]=FULL;
		    			}
		    		
		    		if(inBounds(row,col+1)==true&&isOpen(row,col+1)==true &&myGrid[row][col+1] !=FULL) {
		    			qp.add(calc(row,col+1));
		    			myGrid[row][col+1]=FULL;	
		    		}
		            
		     }
	} 
	
	/**
	 * Helper method that calculates the index of a cell given it's row and and col
	 * @param row  is the row coordinate of the cell being checked
	 * @param col is the col coordinate of the cell being checked/marked
	 * @return the index of the cell represented as an int
	 */
		    private int calc(int row, int col){
		    	return (row*myGrid.length)+col;
		    	}
		    }


