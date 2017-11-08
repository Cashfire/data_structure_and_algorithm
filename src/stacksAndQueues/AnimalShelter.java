package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

	public static void main(String[] args) {
		Dog dog1 = new Dog("VeryOld");
		Cat cat1 = new Cat("littleOld");
		Dog dog2 = new Dog("young");
		AnimalQueue aq = new AnimalQueue();
		aq.enqueue(dog1);
		aq.enqueue(cat1);
		aq.enqueue(dog2);
		Animal rt = aq.dequeueAny();
		System.out.println(rt.name);
		rt = aq.dequeueDogs();
		System.out.println(rt.name);
	}

}

abstract class Animal{
	private int order;
	protected String name;
	public Animal(String str){ name = str;}
	public void setOrder(int ord){order = ord;}
	public int getOrder(){return order;}
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
}
class Dog extends Animal{ 
	public Dog(String n){ super(n);}	
}

class Cat extends Animal{
	public Cat(String n){ super(n);}	
}

class AnimalQueue{
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog) dogs.add((Dog) a);
		else if(a instanceof Cat) cats.add((Cat) a);
	}
	
	public Animal dequeueAny(){
		if(dogs.size()==0){return dequeueCats();}
		else if(cats.size()==0){return dequeueDogs();}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)){return dequeueDogs();}
		else{return dequeueCats();}
	}
	
	public Dog dequeueDogs(){
		return dogs.remove();
	}
	
	public Cat dequeueCats(){
		return cats.remove();
	}
}
