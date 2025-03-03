package software.suresh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee implements Comparable<Employee> {
	int age;
	String location;
	int id;

	Employee(int id, String location, int age) {
		this.id = id;
		this.location = location;
		this.age = age;
	}

	@Override
	public int compareTo(Employee o) {
		return this.location.compareTo(o.location);
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", location=" + location + ", id=" + id + "]";
	}
	
	
}

class ComparatorEmployee {

	private int age;
	private String location;
	private int id;

	ComparatorEmployee(int id, String location, int age) {
		this.setId(id);
		this.setLocation(location);
		this.setAge(age);
	}
	
	@Override
	public String toString() {
		return "ComparatorEmployee [age=" + getAge() + ", location=" + getLocation() + ", id=" + getId() + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

class AgeComparator implements java.util.Comparator<ComparatorEmployee> {

	@Override
	public int compare(ComparatorEmployee o1, ComparatorEmployee o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
}

class LocationComparator implements java.util.Comparator<ComparatorEmployee> {

	@Override
	public int compare(ComparatorEmployee o1, ComparatorEmployee o2) {
		return o1.getLocation().compareTo(o2.getLocation());
	}
	
}

public class ComparatorTest {

	public static void main(String[] args) {

		comparableTest();
		
		comparatorTest();
	}

	public static void comparableTest() {
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee(101, "Vijay", 23));
		al.add(new Employee(106, "Ajay", 27));
		al.add(new Employee(105, "Jai", 21));

		Collections.sort(al);
		
		for (Employee employee : al) {
			System.err.println(employee.toString());
		}
	}
	
	public static void comparatorTest() {
		ArrayList<ComparatorEmployee> al = new ArrayList<ComparatorEmployee>();
		al.add(new ComparatorEmployee(101, "Suresh", 35));
		al.add(new ComparatorEmployee(106, "Yash", 3));
		al.add(new ComparatorEmployee(105, "Navya", 31));

		/*Collections.sort(al, new AgeComparator());
		
		for (ComparatorEmployee employee : al) {
			System.err.println(employee.toString());
		}
		
		Collections.sort(al, new LocationComparator());
		
		for (ComparatorEmployee employee : al) {
			System.err.println(employee.toString());
		}*/
		
		
		//java8 comparator
		Comparator<ComparatorEmployee> locationComparator = Comparator.comparing(ComparatorEmployee::getLocation).thenComparing(ComparatorEmployee::getAge);

		al.sort(locationComparator);
		al.forEach(e -> System.out.println(e));;
		//Comparator<ComparatorEmployee> ageComparator = Comparator.(ComparatorEmployee::getLocation);
		
		
	}

}
