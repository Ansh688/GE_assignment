package ge;

import java.util.Arrays;

public class Generic1DArray<T> {
	public Object arrData[];
	public int length;
	
	public Generic1DArray(int length){
        @SuppressWarnings("unchecked") T[] array = (T[])new Object[length];   
        this.arrData = array;  
    }

	@Override
	public String toString() {
		return Arrays.toString(arrData);
	}
	
	

}
