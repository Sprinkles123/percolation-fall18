
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void updateOnOpen(int row, int col) {
		boolean full = false;
		if(row==0) {full=true;}
		if(inBounds(row-1,col)==true &&myGrid[row-1][col] ==FULL) {full=true;}
		if(inBounds(row+1,col)==true &&myGrid[row+1][col] ==FULL) {full=true;}
		if(inBounds(row,col-1)==true &&myGrid[row][col-1] ==FULL) {full=true;}
		if(inBounds(row,col+1)==true &&myGrid[row][col+1] ==FULL) {full=true;}
		//System.out.println("x");
		if(full==true) {
			dfs(row, col);}
	}

}
