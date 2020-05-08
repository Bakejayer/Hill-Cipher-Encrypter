package logic;

public class MatrixOps {
	public static Matrix matrixProduct(Matrix a, Matrix b) {
		
		Matrix A = a, B = b, matProduct = new Matrix(b.getNumRows(), b.getNumColumns());
		int[] products = new int[(b.getNumRows()*b.getNumColumns())], multiplicant, multiplier;
		int counter = 0, total = 0; 
		
		while(counter < products.length) {
			for (int mCB = 0; mCB < B.getNumColumns(); ++mCB) {
				multiplier = B.getColumn(mCB);
				for (int mRA = 0; mRA < A.getNumRows(); ++mRA) {
					multiplicant = A.getRow(mRA);
					for(int mRB = 0, mCA = 0; mRB < multiplier.length; ++mRB, ++mCA) {
						total += (multiplicant[mCA]*multiplier[mRB]);
					}
					products[counter] = total;
					counter++;
					total = 0;
					
				}
			}
		}
		matProduct.setMatrixByColumn(matProduct.getNumRows(), matProduct.getNumColumns(), products);
		
		return matProduct;
	}
	
public static Matrix modulusMatrixProduct(Matrix a, Matrix b, int mod) {
		
		Matrix A = a, B = b, matProduct = new Matrix(b.getNumRows(), b.getNumColumns());
		int[] products = new int[(b.getNumRows()*b.getNumColumns())], multiplicant, multiplier;
		int counter = 0, total = 0;
		int modValue = mod;
		
		while(counter < products.length) {
			for (int mCB = 0; mCB < B.getNumColumns(); ++mCB) {
				multiplier = B.getColumn(mCB);
				for (int mRA = 0; mRA < A.getNumRows(); ++mRA) {
					multiplicant = A.getRow(mRA);
					for(int mRB = 0, mCA = 0; mRB < multiplier.length; ++mRB, ++mCA) {
						total += (multiplicant[mCA]*multiplier[mRB]);
					}
					products[counter] = (total % modValue);
					counter++;
					total = 0;
					
				}
			}
		}
		matProduct.setMatrixByColumn(matProduct.getNumRows(), matProduct.getNumColumns(), products);
		
		return matProduct;
	}
}
