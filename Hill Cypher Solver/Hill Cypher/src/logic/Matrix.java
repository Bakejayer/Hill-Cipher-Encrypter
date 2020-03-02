package logic;

public class Matrix {
	
	private int[][] matrix;
	private int rows, columns;
	
	//creates and instantiates a new matrix
	public Matrix(int n, int m, int[] nums, String setBy) {
		this.rows = n;
		this.columns = m;
		
		if(setBy.equals("rows")){
			this.setMatrixByRow(rows, columns, nums);
		}
		
		if(setBy.equals("columns")) {
			this.setMatrixByColumn(rows, columns, nums);
		}
		
	}
	
	public Matrix(int n, int m) {
		this.rows = n;
		this.columns = m;
		this.matrix = new int[n][m];
	}
	public Matrix() {
		
	}
	
	public int getNumRows() {
		return this.rows;
	}
	
	public int getNumColumns() {
		return this.columns;
	}
	
	public int[] getRow(int rowIndex) {
		return this.matrix[rowIndex];
	}
	
	public int[] getColumn(int columnIndex) {
		int[] column = new int[this.rows];
		
		for(int i = 0; i < this.matrix.length; ++i) {
			column[i] = this.matrix[i][columnIndex];
		}
		
		return column;
	}
	
	public void setMatrixByRow(int n, int m, int[] nums) {
		this.rows = n;
		this.columns = m;
		int inputCounter = 0;
		int[] input = nums;
		this.matrix = new int[this.rows][this.columns];
		for(int i = 0; i < this.rows; ++i) {
			for(int j = 0; j < this.columns; ++j) {
				this.matrix[i][j] = input[inputCounter++];
				
			}
			
		}
	}
	
	public void setMatrixByColumn(int n, int m, int[] nums) {
		this.rows = n;
		this.columns = m;
		int inputCounter = 0;
		int[] input = nums;
		this.matrix = new int[this.rows][this.columns];
		for(int i = 0; i < this.columns; ++i) {
			for(int j = 0; j < this.rows; ++j) {
				this.matrix[j][i] = input[inputCounter++];
				
			}
			
		}
	}
	
	public void displayRow(int rowIndex) {
		int[] row = this.getRow(rowIndex);
		System.out.print("[");
		for(double x: row) {
			System.out.print(x + " ");
		}
		System.out.print("]\n");
		System.out.println();
	}
	
	public void displayColumn(int columnIndex) {
		int[] column = this.getColumn(columnIndex);
		for(double x: column) {
			System.out.println("[" + x + "]");
		}
		System.out.println();
		
	}
	
	public void DisplayMatrix(){
		int[] row;
		for(int i = 0; i < this.matrix.length; ++i) {
			row = this.getRow(i);
			System.out.print("[");
			for(int x: row) {
				System.out.print(x + " ");
				if(x < 10) {
					System.out.print(" ");
				}
			}
			System.out.print("] \n");
		}
		System.out.println();
	}
	
	public void setElement(int n, int m, int element) {
		this.matrix[n][m] = element;
	}

}
