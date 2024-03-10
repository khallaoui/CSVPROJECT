package CSVMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Classe;
import entity.Student;


public class CSVMain {

    static Map<Integer, Student> studentsByIdMap = new HashMap<>();
    static Map<String, Student> studentsByname = new HashMap<>();
    static Map<String, List<Student>> classNameByNameMap = new HashMap<>();
    static Map<String, List<Classe>> classesNameByStudentNameMap = new HashMap<>();

    
    public static void main(String[] args) {
        String studentFile = "students.csv";
        String classFile = "students_classes.csv";

        System.out.println("Read and display students:");
        readStudentfile(studentFile);

        System.err.println();
        readClassfile(classFile);
        
        System.err.println();

        String stdname = "Name3";
        readClassfile3(classFile, stdname);
    }



    public static void readClassfile3(String classFile, String stdname) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(classFile));
            String line;

            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";"); // Assuming tab-separated values

                if (fields.length >= 2) {
                    int studentId = Integer.parseInt(fields[0]);
                    Classe classe =new Classe();
                    classe.setName(fields[1]);

                    if (studentsByIdMap.containsKey(studentId)) {
                        Student student = studentsByIdMap.get(studentId);
                        studentsByname.put(student.getName(), student);

                        // Add the classes to the list of classes for this student
                        classesNameByStudentNameMap
                                .computeIfAbsent(student.getName(), k -> new ArrayList<>())
                                .add(classe);
                    }
                }
            }

            System.out.println("Classes for student " + stdname + ":");
            System.err.println();

            List<Classe> classesForStudent = classesNameByStudentNameMap.get(stdname);
            if (classesForStudent != null) {
                for (Classe classe : classesForStudent) {
                    System.out.println("Class Name: " + classe.getName());
                }
            } 
            
            else {
                System.out.println("No classes found for student " + stdname);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	
	
	
//222222222222222222222222222222222222222222222222222222222222222222	
	
	public static void readClassfile(String Classfile) {
	    BufferedReader reader = null;

	    try {
	        reader = new BufferedReader(new FileReader(Classfile));
	        String line;

	        reader.readLine(); // Skip header

	        while ((line = reader.readLine()) != null) {
	            String[] fields = line.split(";");

	            if (fields.length >= 2) {
	                Classe classe = new Classe();
	                Student student = studentsByIdMap.get(Integer.valueOf(fields[0]));

	                if (student != null) {
	                    classe.setName(fields[1]);

	                    // Add the student to the list of students for this class
	                    classNameByNameMap
	                            .computeIfAbsent(classe.getName(), k -> new ArrayList<>())
	                            .add(student);
	                }
	            }
	        }

	        // Display classes and associated students
	        System.out.println("Classes and associated students:");
	        System.err.println();

	        for (Map.Entry<String, List<Student>> entry : classNameByNameMap.entrySet()) {
	            System.err.println();
	            System.out.println("Class Name: " + entry.getKey());

	            System.out.println("Students:");
	            System.err.println();

	            for (Student student : entry.getValue()) {
	                System.out.println("  ID: " + student.getId() + ", Name: " + student.getName());
	            }
	        }

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (reader != null) {
	                reader.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	

//11111111111111111111111111111111111111111111111111111111111111111111
	
	public static void readStudentfile(String Studentfile) {
		 BufferedReader reader = null;

	        try {
	            String line = "";
	            reader = new BufferedReader(new FileReader(Studentfile));

	            // Skip header
	            reader.readLine();

	            while ((line = reader.readLine()) != null) {
	                String[] fields = line.split(";");

	                if (fields.length > 0) {
	                    Student student = new Student();
	                    student.setId(Integer.parseInt(fields[0]));
	                    student.setName(fields[1]);
	                    studentsByIdMap.put(student.getId(), student);
	                    studentsByname.put(student.getName(), student);
	                }
	            }
	            
	            
		        System.out.println("Students:");
		        for (Map.Entry<Integer, Student> entry : studentsByIdMap.entrySet()) {
		            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getName());

		        }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (reader != null) {
	                    reader.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }


	    }

