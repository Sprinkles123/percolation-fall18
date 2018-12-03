/**
 * @author Fritz Thelusca (ft34)
 * 
 * Simulation program for PercolationUF
 */
public class PercolationUF implements IPercolate{

boolean myGrid[][];
int myOpenCount=0;
IUnionFind myFinder= new QuickUWPC();
private final int VTOP;
private final int VBOTTOM;

/**
 * Constructs an grid and UnionFind object and initializes VTOP and VBOTTOM
 *  @param size is the size of the simulated (square) grid
 * @param finder is the UnionFind object
 * @throws new Exception if the index is out of Bounds
 *@return true if VTOP is connected to cell, false otherwise
 */	
PercolationUF(int size, IUnionFind finder){
	myGrid=new boolean [size][size];
	myFinder.initialize(size*size+2);
	VBOTTOM=size*size +1;
	VTOP=size*size;	
}
/**
 * Helper method to open a cell,increment the open count and update the cell
 * @param row is the row coordinate of the cell being checked/marked
 * @param col is the col coordinate of the cell being checked/marked
 * @throws new Exception if the index is out of Bounds
 *
 */
	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (myGrid[row][col] == true)
			return;
		myOpenCount += 1;
		myGrid[row][col] = true;	
		updateOnOpen(row,col);

	}
	
	/**
	 * Helper method to determine if cell is open
	 * @param row is the row coordinate of the cell being checked/marked
	 * @param col is the col coordinate of the cell being checked/marked
	 * @throws new Exception if the index is out of Bounds
	 *@return true if cell is open, false otherwise
	 */
	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col] == true;
	}

	/**
	 * Helper method to determine if open cells should be marked  as full 
	 * @param row is the row coordinate of the cell being checked/marked
	 * @param col is the col coordinate of the cell being checked/marked
	 * @throws new Exception if the index is out of Bounds
	 *@return true if VTOP is connected to cell, false otherwise
	 */
	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if(myFinder.connected(calc(row,col),VTOP)) {return true;}
		return false;
	}
	
	/**
	 *Helper method to determine if the grid percolates 
	 * @return true if VTOP is connected to VBOTTOM, false otherwise
	 */
	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}
	
	/**
	 *Helper method to determine the number of open cells 
	 * @return myOpenCount returns the number of open cells
	 */
	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	/**
	 * Helper method that calculates the index of a cell given it's row and and col
	 * @param row  is the row coordinate of the cell being checked
	 * @param col is the col coordinate of the cell being checked/marked
	 * @return the index of the cell represented as an int
	 */
    public int calc(int row, int col){
    	return (row*myGrid.length)+col;
    }
    
	/**
	 * Determine if (row,col) is valid for given grid
	 * @param row specifies row
	 * @param col specifies column
	 * @return true if (row,col) on grid, false otherwise
	 */
	private boolean inBounds(int row, int col) {
			if (row < 0 || row >= myGrid.length) return false;
			if (col < 0 || col >= myGrid[0].length) return false;
			return true;
	}
	
	/**
	 * Private helper method to determine if open cells should be marked  as full 
	 * by checking if the cell is connect to VTOP
	 * @param row is the row coordinate of the cell being checked/marked
	 * @param col is the col coordinate of the cell being checked/marked
	 * @throws new Exception if the index is out of Bounds
	 */
	private void updateOnOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (row == 0){myFinder.union(VTOP,calc(row,col));}
		if (row == myGrid.length-1){myFinder.union(VBOTTOM,calc(row,col));} 

		if(inBounds(row-1,col)==true &&myGrid[row-1][col] ==true) {myFinder.union(calc(row-1,col),calc(row,col));}
		if(inBounds(row+1,col)==true &&myGrid[row+1][col] ==true) {myFinder.union(calc(row+1,col),calc(row,col));}
		if(inBounds(row,col-1)==true &&myGrid[row][col-1] ==true) {myFinder.union(calc(row,col-1),calc(row,col));}
		if(inBounds(row,col+1)==true &&myGrid[row][col+1] ==true) {myFinder.union(calc(row,col+1),calc(row,col));}
	}

}
