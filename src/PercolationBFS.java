import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
		
	}
	@Override 
		protected void dfs(int row, int col) {
			// out of bounds?
			if (! inBounds(row,col)) return;
			
			// full or NOT open, don't process
			//if (isFull(row, col) || !isOpen(row, col))
				//return;
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
		    			System.out.println(calc(row-1,col));
		    		}
		    		if(inBounds(row+1,col)==true&&isOpen(row+1,col)==true &&myGrid[row+1][col] !=FULL) {
		    			qp.add(calc(row+1,col));
		    			myGrid[row+1][col]=FULL;	
		    			System.out.println(calc(row+1,col));
		    		}
		    		if(inBounds(row,col-1)==true&&isOpen(row,col-1)==true &&myGrid[row][col-1] !=FULL) {
		    			qp.add(calc(row,col-1));
		    			myGrid[row][col-1]=FULL;
		    			System.out.println(calc(row,col-1));
		    			}
		    		if(inBounds(row,col+1)==true&&isOpen(row,col+1)==true &&myGrid[row][col+1] !=FULL) {
		    			qp.add(calc(row,col+1));
		    			myGrid[row][col+1]=FULL;	
		    			System.out.println(calc(row,col+1));
		    		}
		            
		            	

		            }}
		        
		    private int calc(int row, int col){
		    	return (row*myGrid.length)+col;
		    }
		    
		    }


