
public class PercolationUF implements IPercolate{

boolean myGrid[][];
int myOpenCount=0;
IUnionFind myFinder= new QuickUWPC();
private final int VTOP;
private final int VBOTTOM;
	
PercolationUF(int size, IUnionFind finder){
	myGrid=new boolean [size][size];
	myFinder.initialize(size*size+2);
	VBOTTOM=size*size +1;
	VTOP=size*size;	
}

	@Override
	public void open(int row, int col) {
		// TODO Auto-generated method stub
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

	@Override
	public boolean isOpen(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col] == true;
	}

	@Override
	public boolean isFull(int row, int col) {
		// TODO Auto-generated method stub
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if(myFinder.connected(calc(row,col),VTOP)) {return true;}
		return false;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return myOpenCount;
	}
    public int calc(int row, int col){
    	return (row*myGrid.length)+col;
    }
	private boolean inBounds(int row, int col) {
		// TODO Auto-generated method stub
			if (row < 0 || row >= myGrid.length) return false;
			if (col < 0 || col >= myGrid[0].length) return false;
			return true;
	}
	private void updateOnOpen(int row, int col) {
		// TODO Auto-generated method stub
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
