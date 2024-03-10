package entity;

public class Student {
	 private int id;
	 private String Name;
	 
	 public int getId() {
		  return id;
		 }
		 public void setId(int id) {
		  this.id = id;
		 }
		 public String getName() {
			 
		  return Name;
		 }
		 public void setName(String Name) {
		  this.Name = Name;
		 }

		    public String setidAndReturnName(int studentId) {
		        this.id = studentId;
		        return this.Name;
		    }

}
