package ge;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuadrantUtil<T> {
	
	private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

   // char[][] data;
	public int rows;
    public int columns;
    public Object data[][];

    //public ArrayQuadrantUtil(char[][] data) {
    	 public ArrayQuadrantUtil(int rows , int columns) {
       // this.data = data;
    		 this.rows = rows;
    	        this.columns = columns;
    	         
    	        @SuppressWarnings("unchecked") T[][] array = (T[][])new Object[rows][columns];   
    	        data = array; 
    }

    public Generic1DArray<?> getQuadrantValues(GenericMatrix<?> c, int row, int column) {
    	int arrLen = (c.data.length/2)*(c.data[0].length/2);
    	//char[] result = new char[arrLen];
    	Generic1DArray<?> result = new Generic1DArray(arrLen);
    	if((row>=0 && row<c.data.length/2) && (column>=0 && column<c.data[0].length/2))
    	{
    		result = quadrant(c,arrLen,0,0,c.data.length/2,c.data[0].length/2);
    	}
    	else if((row>=0 && row<c.data.length/2) && (column>=c.data[0].length/2 && column<c.data[0].length))
    	{
    		result = quadrant(c,arrLen,0,c.data[0].length/2,c.data.length/2,c.data[0].length);
    	}
    	else if((row>=c.data.length/2 && row<c.data.length) && (column>=0 && column<c.data[0].length/2))
    	{
    		result = quadrant(c,arrLen,c.data.length/2,0,c.data.length,c.data[0].length/2);
    	}
    	else
    	{
    		result = quadrant(c,arrLen,c.data.length/2,c.data[0].length/2,c.data.length,c.data[0].length);
    	}
        return result;
    }
    
    private Generic1DArray<?> quadrant(GenericMatrix<?> c, int arrLen, int x, int y, int k, int l) {
    	//char[] r = new char[arrLen]; 
    	Generic1DArray<?> r = new Generic1DArray(arrLen);
    	int val = 0;
    	for(int i = x;i<k;i++)
		{
			for(int j = y;j<l;j++)
			{
				r.arrData[val] = c.data[i][j];
				val++;
			}
		}
		return r;
	}

	public Generic1DArray<?> getRowValues(GenericMatrix<?> c, int row)
    {
    	//char[] r = new char[data[0].length];
		Generic1DArray<?> r = new Generic1DArray(c.data[0].length);
    	for(int i = 0;i<data[0].length;i++)
    	{
    		r.arrData[i] = c.data[row][i];
    	}
    	return r;
    }
    
    public Generic1DArray<?> getColValues(GenericMatrix<?> c, int col)
    {
    	//char[] c = new char[data[0].length];
    	Generic1DArray<?> c1 = new Generic1DArray(c.data[0].length);
    	for(int i = 0;i<data.length;i++)
    	{
    		c1.arrData[i]= c.data[i][col];
    	}
    	return c1;
    }
    
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int row = s.nextInt();
    	int col = s.nextInt();
    	if((row%2!=0 || col%2!=0))
    	{
    		System.out.println("Invalid Array");
    		return;
    	}
    	//char data[][] = new char[row][col];
    	GenericMatrix<?> C = new GenericMatrix(row,col);
    	int a = 97;
    	for(int i = 0;i<row;i++)
    	{
    		for(int j = 0;j<col;j++)
    		{
    			C.data[i][j] = (char)a;
				a++;
    		}
    	}
    	ArrayQuadrantUtil arr = new ArrayQuadrantUtil(row,col);
    	
    	//To get the values of matrix corresponding to row number
    	System.out.println("Enter row number");
    	int rowNum = s.nextInt();
    	//char[] rowVal = arr.getRowValues(rowNum);
    	Generic1DArray<?> rowVal = new Generic1DArray(C.data[0].length);
    	rowVal = arr.getRowValues(C,rowNum);
    	System.out.println(rowVal);
    	
    	//To get the values of matrix corresponding to col number
    	System.out.println("Enter col number");
    	int colNum = s.nextInt();
    	//char[] colVal = arr.getColValues(colNum);
    	Generic1DArray<?> colVal = new Generic1DArray(C.data.length);
    	colVal = arr.getColValues(C,colNum);
    	System.out.println(colVal);
    	
    	//To get quadrant values
    	System.out.println("Enter the x as well as y coordinate of the point whose quadrant is to be returned");
    	int x = s.nextInt();
    	int y = s.nextInt();
    	//char[] quad = arr.getQuadrantValues(x, y); 
    	Generic1DArray<?> quad = new Generic1DArray((C.data.length/2)*(C.data[0].length/2));
    	quad = arr.getQuadrantValues(C,x, y); 
    	System.out.println(quad);
    	
    	
	}

}
