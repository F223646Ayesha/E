import java.util.Scanner;

import javax.swing.JFrame;
class Product
{
	protected String name;
	protected double price;
	protected boolean availability;
	public Product(String name, double price, boolean availability)
	{
		this.name = name;
		this.price = price;
		this.availability=availability;
	}
	void purchase()
	{
		availability=false;
		System.out.println("Product is purchased\n");
	}
	void returnProduct()
	{

		availability=true;
		System.out.println("Product is returned\n");
	
	}
	void diplayProductDetails()
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Availability: "+ availability);
	}
	boolean isAvailable()
	{
		return availability;
		}
	}

class Electronics extends Product
{

	public Electronics(String name, double price, boolean availability) {
		super(name, price, availability);
	}
	@Override
	void purchase()
	{
		availability=false;
		System.out.println("Electronics Product is purchased");
	}
	@Override
	void returnProduct()
	{

		availability=true;
		System.out.println("Product is returned");
	
	}
}

class Clothing extends Product
{

	public Clothing(String name, double price, boolean availability) {
		super(name, price, availability);
	}
	@Override
	void purchase()
	{
		availability=false;
		System.out.println("Clothing Product is purchased");
	}
	@Override
	void returnProduct()
	{

		availability=true;
		System.out.println("Product is returned");
	
	}
	}
public class basic{
public static void main(String[] args) {
	char c;
	Scanner scanner =new Scanner(System.in);
	System.out.println("Select Which Product Do You Want(Enter E for electronics & C for Clothing): \n");
	c = scanner.next().charAt(0);
	if (c=='E'||c=='e') {
		Product p = new Electronics("Tablet",2000,true);
		if(p.isAvailable())
		  p.purchase();
        p.diplayProductDetails();
        p.returnProduct();
        p.diplayProductDetails();
		
	} else if (c=='C'||c=='c') {
		Product p = new Clothing("Coat",2000,true);
		if(p.isAvailable())
		  p.purchase();
        p.diplayProductDetails();
        p.returnProduct();
        p.diplayProductDetails();

	}
 }

}
