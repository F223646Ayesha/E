import javax.swing.*;
import java.awt.*;


class framee{
	
	public int divide(int a, int b)
	{
		int result = 0;
		try {
				result = a/b;
		} catch (ArithmeticException e) {
			System.out.println("Denominator Cannot be Zero Not" + e.getMessage());
		}
		return result;
		}
}
public class trial{
	public static void main(String[] args) {
		framee f =new framee();
		int result = f.divide(3, 1);
		System.out.println("Result:" + result);
		result =f.divide(3, 0);
		System.out.println("Result:" + result);
	}
	

}
