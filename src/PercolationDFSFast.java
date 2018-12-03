/**
 * @author Fritz Thelusca (ft34)
 * 
 * Simulation program for PercolationDFSFast
 */
public class PercolationDFSFast extends PercolationDFS {
	
	/**
	 * Initialize a grid so that all cells are blocked.
	 * 
	 * @param n is the size of the simulated (square) grid
	 */
	public PercolationDFSFast(int n) {
		super(n);
	}
	
	/**
	 * Private helper method to determine if open cells should be marked  as full 
	 * without clearing all cells.
	 * 
	 * Calls dfs once if the newly open cell should be marked as FULL because it's in 
	 * the top row or because it's adjacent to an already FULL cell.
	 * 
	 * @param row is the row coordinate of the cell being checked/marked
	 * @param col is the col coordinate of the cell being checked/marked
	 */
	@Override
	protected void updateOnOpen(int row, int col) {
		boolean full = false;
		if(row==0) {full=true;}
		if(inBounds(row-1,col)==true &&myGrid[row-1][col] ==FULL) {full=true;}
		if(inBounds(row+1,col)==true &&myGrid[row+1][col] ==FULL) {full=true;}
		if(inBounds(row,col-1)==true &&myGrid[row][col-1] ==FULL) {full=true;}
		if(inBounds(row,col+1)==true &&myGrid[row][col+1] ==FULL) {full=true;}
		if(full==true) {
			dfs(row, col);}
	}

}
