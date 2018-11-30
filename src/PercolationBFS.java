import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {
	
	public PercolationBFS(int n) {
		super(n);
	}
	 private Integer[][] myIGrid;
	
	/**
	 * Private helper method to mark all cells that are open and reachable from
	 * (row,col).
	 * 
	 * @param row
	 *            is the row coordinate of the cell being checked/marked
	 * @param col
	 *            is the col coordinate of the cell being checked/marked
	 */
	@Override
	protected void dfs(int row, int col) {
		int size = myGrid.length;
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
        Queue<Integer> qp = new LinkedList<>(); 
        if (inBounds(row,col) && !isFull(row,col) && isOpen(row,col)) {
        	myGrid[row][col] = FULL;
            qp.add(myIGrid[row][col]);
        }
        while (qp.size() != 0){ 
            qp.remove();
            for(int k=0; k < rowDelta.length; k++){
            	int val = row*size + col;
                row = val/size + rowDelta[k];
                col += val%size + colDelta[k];
                if (inBounds(row,col) && isOpen(row,col) && !isFull(row,col)){
                	myGrid[row][col] = FULL;
                    qp.add(myIGrid[row][col]);
                }
            }
        } 
    }
	 }
