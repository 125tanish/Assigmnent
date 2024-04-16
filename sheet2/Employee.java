package sheet2;
import java.util.*;
import java.util.stream.Collectors;
public class Employee {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearofjoining;
	double salary;
	Employee(int id,String name,int age,String gender,String department,int yearofjoining,double salary)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.department=department;
		this.yearofjoining=yearofjoining;
		this.salary=salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearofjoining() {
		return yearofjoining;
	}
	public void setYearofjoining(int yearofjoining) {
		this.yearofjoining = yearofjoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
   public static void main(String gg[])
   {
	   long m,f;
	   List<Employee> employeeList=new ArrayList<Employee>();
	   employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	   employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	   employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	   employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	   employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	   employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	   employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	   employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	   employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	   employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	   employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	   employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	   employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	   employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	   employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	   employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	   employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	   //for(Employee e:employeeList)
	   //{
		   //System.out.println(e.id+","+e.name+","+e.age+","+e.gender+","+e.department+","+e.yearofjoining+","+e.salary);
		   //if(e.gender.contains("Male"))
			   //m++;
		   //else
			   //f++;
	   //} 
	   
	   //1. start
		   m=employeeList.stream()
				   .filter(e->e.getGender().equalsIgnoreCase("Male"))
				   .count();
		   f=employeeList.stream()
				   .filter(e->e.getGender().equalsIgnoreCase("Female"))
				   .count();
	   System.out.println("number of male="+m);
	   System.out.println("number of female="+f);
	   //end
	   
	   //2.start
	   employeeList.stream()
			   .map(d->d.getDepartment())
			   .distinct()
			   .forEach(d1->System.out.println(d1));
	   //end
	   
	   //3 start 
	   
	   double avgmale=employeeList.stream()
			   .filter(e->e.getGender().equalsIgnoreCase("Male"))
			   .mapToInt(e->e.getAge()).average().orElse(0);
	   
	   double avgfemale=employeeList.stream()
			   .filter(e->e.getGender().equalsIgnoreCase("Female"))
			   .mapToInt(e->e.getAge()).average().orElse(0);
	   System.out.printf("Average age of male :%.2f \n" ,avgmale);
	   System.out.printf("Average age of female: %.2f\n",avgfemale);
	   
	   //end
	   
	   //4.start
	  Object comparator;
	Employee highestSalary=employeeList.stream().max(Comparator.comparing(e->e.getSalary())).orElse(null);
	System.out.println(highestSalary.id+","+highestSalary.name+","+highestSalary.age+","+highestSalary.gender+","+highestSalary.department+","+highestSalary.yearofjoining+","+highestSalary.salary);
	
	//end
	
	//5.start
	Object collectors;
	List<String> ename=employeeList.stream().filter(e->e.getYearofjoining()>2015).map(e->e.getName()).collect(Collectors.toList());
	System.out.println(ename);
	//end
	
	//6.start
	Map<String,Long> mp=employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
	mp.forEach((department,count)->System.out.println(department+"="+count));
	//end
	
	//7.start
	Map<String,Double> m1=employeeList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())));
	//System.out.println(m1);
	m1.forEach((department,avgsalary)->System.out.println(department+"="+avgsalary));
	
	//end
	Optional<Employee> mpd=employeeList.stream()
			                             .filter(e->e.getGender().equalsIgnoreCase("Male"))
			                             .filter(e->e.getDepartment().equals("Product Development"))
			                             .min(Comparator.comparingInt(e->e.getAge()));
	 mpd.ifPresent(e->System.out.println(e.id+","+e.name+","+e.age+","+e.gender+","+e.department+","+e.yearofjoining+","+e.salary));
	 long a=employeeList.stream()
			 .filter(e->e.getDepartment().equals("Sales And Marketing"))
			 .filter(e->e.getGender().equalsIgnoreCase("Male"))
			 .count();
	 long b=employeeList.stream()
			 .filter(e->e.getDepartment().equals("Sales And Marketing"))
			 .filter(e->e.getGender().equalsIgnoreCase("Female"))
			 .count();
	 System.out.println("number of male in sales and marketing="+a);
	 System.out.println("number of female in sales and marketing="+b);
	 
	  Map<String, Double> hm=employeeList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getSalary())));
	  hm.forEach((gender,avg)->System.out.println(gender+"="+avg));
	  
	  double avg=employeeList.stream()
			  .mapToDouble(e->e.getSalary())
			  .average().orElse(0);
	  
	  double sumsal=employeeList.stream()
			  .mapToDouble(e->e.getSalary())
			  .sum();
	  
	  System.out.printf("average salary of whole organization=%.2f\n",avg);
	  System.out.printf("sum of salary of whole organization=%.2f\n",sumsal);
	  
	  List<Employee> less=employeeList.stream()
			  .filter(e->e.getAge()<=25)
			  .collect(Collectors.toList());
	  System.out.println("employee whose age is less than 25 or equal");
	  for(Employee e:less)
	  {
		  System.out.println(e.id+","+e.name+","+e.age+","+e.gender+","+e.department+","+e.yearofjoining+","+e.salary);
	  }
	  
	  List<Employee> greater=employeeList.stream()
			  .filter(e->e.getAge()>25)
			  .collect(Collectors.toList());
	  
	  System.out.println("employee whose age is greater than 25");
	  for(Employee e:greater)
	  {
		  System.out.println(e.id+","+e.name+","+e.age+","+e.gender+","+e.department+","+e.yearofjoining+","+e.salary);
	  }
	  Employee oldest=employeeList.stream().min(Comparator.comparingInt(e->e.getYearofjoining())).orElse(null);
	  System.out.println("oldest employee is");
	  
	  if(oldest!=null)
	  {
		  System.out.println("age="+oldest.age+" "+"department="+oldest.department);
	  }
  }
}
