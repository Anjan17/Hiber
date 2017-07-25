
public class Employee {
   private int id;
   private String firstName; 
   private String lastName;   
   private int salary;
   private String address;
   private String extension;

   public Employee() {}
   public Employee(String fname, String lname, int salary, String address,String extension) {
      this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
      this.address = address;
      this.extension = extension;
   }
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   public int getSalary() {
      return salary;
   }
   public void setSalary( int salary ) {
      this.salary = salary;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress( String address ) {
      this.address = address;
   }
   public String getExtension() {
      return extension;
   }
   public void setExtension( String extension ) {
      this.extension = extension;
   }
}
