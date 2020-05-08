package logic;

public class CypherOps {
	
	public static String encryptMessage(String message) {
		int[] keyNums1 = {0, 11, 15, 7, 0, 1, 4, 19, 0};
		Matrix messageMat = CypherOps.messageToMatrix(message), key = new Matrix(3, 3, keyNums1, "rows");
		messageMat = MatrixOps.modulusMatrixProduct(key, messageMat, 26);
		return CypherOps.matrixToString(messageMat);
	}
	
	public static String decryptMessage(String message) {
		int[] invKeyNums1 = {3, 7, 1, 24, 4, 19, 5, 4, 19};
		Matrix messageMat = CypherOps.messageToMatrix(message), invKey = new Matrix(3, 3, invKeyNums1, "rows");
		messageMat = MatrixOps.modulusMatrixProduct(invKey, messageMat, 26);
		return CypherOps.matrixToString(messageMat);
	}
	
	public static Matrix messageToMatrix(String message) {
		Matrix messageMatrix = new Matrix();
		String messageString = message;
		int [] matrixValues;
		
		matrixValues = stringToNums(message);
		messageMatrix.setMatrixByColumn(3, (matrixValues.length/3), matrixValues);
		
		return messageMatrix;
	}
	
	private static String stripString(String inMessage) {
		String inMess = inMessage;
		String outMessage = "";
		char charac;
		int letNum;
		for(int i = 0; i < inMess.length(); ++i) {
			charac = inMess.charAt(i);
			letNum = CypherOps.letterToNum(charac);
			if(letNum > 25) {
				continue;
			}
			else {
				outMessage += charac;
			}
		}
		return outMessage;
	}
	
	private static int[] stringToNums(String inMessage) {
		String inMess = stripString(inMessage);
		char charac;
		int letNum;
		int[] outArray;
		
		if(inMess.length() % 3 == 0) {
			outArray = new int[(inMess.length())];
		}
		else {
			outArray = new int[((inMess.length()) + (3-(inMess.length() % 3)))];
		}
		
		for(int i = 0; i < inMess.length(); ++i) {
			charac = inMess.charAt(i);
			letNum = CypherOps.letterToNum(charac);
			outArray[i] = letNum;
		}
		
		for(int j = (inMess.length()); j < (outArray.length); ++j) {
			outArray[j] = 25;
		}
		
		return outArray;
	}
	
	private static String matrixToString(Matrix mat) {
		String letterList = "";
		Matrix mesMat = mat;
		int[] column;
		for(int i = 0; i < mesMat.getNumColumns(); ++i) {
			column = mesMat.getColumn(i);
			for(int j: column) {
				letterList += CypherOps.numToLetter(j);
			}
		}
		return letterList;
	}
	private static int letterToNum(char letter) {
		switch(letter) {
		case('A'):
		case('a'):
			return 0;
		case('B'):
		case('b'):
			return 1;
		case('C'):
		case('c'):
			return 2;
		case('D'):
		case('d'):
			return 3;
		case('E'):
		case('e'):
			return 4;
		case('F'):
		case('f'):
			return 5;
		case('G'):
		case('g'):
			return 6;
		case('H'):
		case('h'):
			return 7;
		case('I'):
		case('i'):
			return 8;
		case('J'):
		case('j'):
			return 9;
		case('K'):
		case('k'):
			return 10;
		case('L'):
		case('l'):
			return 11;
		case('M'):
		case('m'):
			return 12;
		case('N'):
		case('n'):
			return 13;
		case('O'):
		case('o'):
			return 14;
		case('P'):
		case('p'):
			return 15;
		case('Q'):
		case('q'):
			return 16;
		case('R'):
		case('r'):
			return 17;
		case('S'):
		case('s'):
			return 18;
		case('T'):
		case('t'):
			return 19;
		case('U'):
		case('u'):
			return 20;
		case('V'):
		case('v'):
			return 21;
		case('W'):
		case('w'):
			return 22;
		case('X'):
		case('x'):
			return 23;
		case('Y'):
		case('y'):
			return 24;
		case('Z'):
		case('z'):
			return 25;
		default:
			return 26;
		}
	}
	private static char numToLetter(int num) {
		switch(num) {
		case(0):
			return 'A';
		case(1):
			return 'B';
		case(2):
			return 'C';
		case(3):
			return 'D';
		case(4):
			return 'E';
		case(5):
			return 'F';
		case(6):
			return 'G';
		case(7):
			return 'H';
		case(8):
			return 'I';
		case(9):
			return 'J';
		case(10):
			return 'K';
		case(11):
			return 'L';
		case(12):
			return 'M';
		case(13):
			return 'N';
		case(14):
			return 'O';
		case(15):
			return 'P';
		case(16):
			return 'Q';
		case(17):
			return 'R';
		case(18):
			return 'S';
		case(19):
			return 'T';
		case(20):
			return 'U';
		case(21):
			return 'V';
		case(22):
			return 'W';
		case(23):
			return 'X';
		case(24):
			return 'Y';
		case(25):
			return 'Z';
		default:
			return '?';
		}
	}
}
