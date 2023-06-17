package student_management_system;

import java.sql.*;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) throws ClassNotFoundException{
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/harini","root","root");
			Statement st=c.createStatement();
			ResultSet r;
			while(true) {
			System.out.println("Enter 0 to exit ");
			System.out.println("Enter 1 to display student details ");
			System.out.println("Enter 2 to insert a record ");
			System.out.println("Enter 3 to delete a record ");
			System.out.println("Enter 4 to update a record ");
			String s1=s.nextLine();
			if(s1.equals("0")) 
				break;
			else if(s1.equals("1")) {
				System.out.println("Enter 1 to display all records , 2 to display particular record");
				String s0=s.nextLine();
				if(s0.equals("1")) {
				r=st.executeQuery("select * from student ");
				while(r.next()) {
					System.out.println("ROLL_NUM : "+r.getInt(1)+" "+"NAME : "+r.getString(2)+" CLASS : "+r.getString(3)+" AGE : "+r.getInt(4)+" PHONE_NO : "+r.getString(5));
				}
				}
				else if(s0.equals("2")) {
					System.out.println("Enter student roll num to display : ");
					String s9=s.nextLine();
					r=st.executeQuery("select * from student where roll_num="+s9);
					while(r.next()) {
						System.out.println("ROLL_NUM : "+r.getInt(1)+" "+"NAME : "+r.getString(2)+" CLASS : "+r.getString(3)+" AGE : "+r.getInt(4)+" PHONE_NO : "+r.getString(5));
					}
				}
				else
					System.out.println("Enter valid input");
			}
			else if(s1.equals("2")) {
				System.out.println("Enter student roll num : ");
				String s2=s.nextLine();
				System.out.println("Enter student name : ");
				String s3=s.nextLine();
				System.out.println("Enter student class : ");
				String s4=s.nextLine();
				System.out.println("Enter student age : ");
				String s5=s.nextLine();
				System.out.println("Enter student phone number : ");
				String s6=s.nextLine();
				st.executeUpdate("insert into student values("+s2+",'"+s3+"','"+s4+"',"+s5+",'"+s6+"')");
				System.out.println("Values inserted successfully !");
			}
			else if(s1.equals("3")) {
				System.out.println("Enter the student roll_num to delete : ");
				String s7=s.nextLine();
				st.executeUpdate("delete from student where roll_num="+s7);
				System.out.println("Record deleted successfully !");
			}
			else if(s1.equals("4")) {
				System.out.println("Enter student roll num to update ");
				String s10=s.nextLine();
				System.out.println("Enter column to update(roll_num,name,class,age,phone_no)");
				String s8=s.nextLine();
				String s9=null;
				if(s8.equals("roll_num")) {
					System.out.println("Enter new roll num :");
					s9=s.nextLine();
					st.executeUpdate("update student set roll_num="+s9+" where roll_num="+s10);
				}
				else if(s8.equals("name")) {
					System.out.println("Enter new name :");
					s9=s.nextLine();
					st.executeUpdate("update student set name='"+s9+"' where roll_num="+s10);
				}
				else if(s8.equals("class")) {
					System.out.println("Enter new class :");
					s9=s.nextLine();
					st.executeUpdate("update student set class='"+s9+"' where roll_num="+s10);
				}
				else if(s8.equals("age")) {
					System.out.println("Enter new age :");
					s9=s.nextLine();
					st.executeUpdate("update student set age="+s9+" where roll_num="+s10);
				}
				else if(s8.equals("phone_no")) {
					System.out.println("Enter new phone no :");
					s9=s.nextLine();
					st.executeUpdate("update student set phone_no='"+s9+"' where roll_num="+s10);
				}
				else
					System.out.println("Enter valid input");
			}
			else
				System.out.println("Enter valid input ");
			}
			s.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
