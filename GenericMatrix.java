package ge;

import java.util.Arrays;

public class GenericMatrix<T> {
	public int rows;
    public int columns;
    public Object data[][];
             
    public GenericMatrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
         
        @SuppressWarnings("unchecked") T[][] array = (T[][])new Object[rows][columns];   
        data = array;  
    }

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
    
    

}
