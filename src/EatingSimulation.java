interface Eatable
{
   void eats();
   void eatsMeat();
}
abstract class Animal implements Eatable
{
	private String name;
	public Animal(String name)
	{
	   this.name=name;
	}
	String getName()
    {
	   return name;
     }
	
}
class Lion extends Animal
{

	public Lion(String name) {
		super(name);
	}

	@Override
	public void eats() {
		
		System.out.println("Simba the Lion is hunting and eating prey.");
	}

	@Override
	public void eatsMeat() {
		System.out.println("Simba the Lion eats raw meat.");
		
	}}
class Tiger extends Animal
{

	public Tiger(String name) {
		super(name);
		
	}

	@Override
	public void eats() {
		
		System.out.println("Tony the Tiger is also hunting and eating prey.");
	}

	@Override
	public void eatsMeat() {
		System.out.println("Tony the Tiger eats raw meat.");
		
	}
}

class Human implements Eatable
{

	@Override
	public void eats() {
		System.out.println("Alice the Human is enjoying a meal.");
	}

	@Override
	public void eatsMeat() {
		System.out.println("Alice the Human eats cooked meat.");
	}
	
}


public class EatingSimulation {
    static Eatable[] array = new Eatable[3];
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			if(i==0)
			{
				array[i] = new Lion("Simba");
				array[i].eats();
                array[i].eatsMeat();
			}
			else if(i==1)
			{
				array[i] = new Tiger("Tony");
				array[i].eats();
                array[i].eatsMeat();
			}
			else
			{
				array[i] = new Human();
				array[i].eats();
                array[i].eatsMeat();
			}
		}
	}
   
}
