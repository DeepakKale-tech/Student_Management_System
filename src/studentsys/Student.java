package studentsys;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Scanner;


public class Student {

	static final String File1 = "students.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			int s;
			Scanner sc = new Scanner(System.in);
			
			do
			{
				System.out.println("Following Menu Operations Can be Performed: ");
				System.out.println("1. Add Student");
				System.out.println("2. View Student");
				System.out.println("3. Update Student");
				System.out.println("4. Delete Student");
				System.out.println("5. Exit");
				System.out.println("Enter Operation key value: ");
				s = sc.nextInt();
				sc.nextLine();
				switch (s) {
				case 1: 
					//add
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(File1,true)) )
					{
						int id;
						String name;
						int age;
						System.out.println("Enter your Id: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter your Name: ");
						name = sc.nextLine();
						System.out.println("Enter your Age: ");
						age = sc.nextInt();
						
						bw.write(id+","+name+","+age);
						bw.newLine();
						break;
					}catch(Exception e)
					{
						System.out.println(e +" Error occured while adding student");
					}
					
				case 2: 
					//read
					try(BufferedReader br = new BufferedReader(new FileReader(File1)))
					{
						System.out.println("ID\tName\tAge");
						System.out.println("----------------------");
						String line;
						while((line = br.readLine()) != null )
						{
							String data[] = line.split(",");
							System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]);
						}
					}catch(Exception e)
					{
						System.out.println(e+" Error Occured while file reading");
					}
					break;
				case 3: 
					//update
					File f1 = new File(File1);
					File temp = new File("temp.txt");
					boolean found = false;
					try(BufferedReader br = new BufferedReader(new FileReader(f1));
						BufferedWriter bw = new BufferedWriter(new FileWriter(temp)))
					{
						 System.out.print("Enter Student ID to update: ");
				            int idup = sc.nextInt();
				            sc.nextLine();

				            String line;

				            while ((line = br.readLine()) != null) {
				                String[] data = line.split(",");
				                int id = Integer.parseInt(data[0]);

				                if (id == idup) {
				                    found = true;
				                    System.out.print("Enter new name: ");
				                    String newName = sc.nextLine();
				                    System.out.print("Enter new age: ");
				                    int newAge = sc.nextInt();
				                    bw.write(id + "," + newName + "," + newAge);
				                } else {
				                    bw.write(line);
				                }
				                bw.newLine();
				            }

				        } catch (Exception e) {
				            System.out.println("Error while updating record.");
				        }

				        if (found) {
				            f1.delete();
				            temp.renameTo(f1);
				            System.out.println("Student updated successfully!");
				        } else {
				            temp.delete();
				            System.out.println("Student ID not found.");
				        }
					break;	
				case 4:
					//delete
					 File f2 = new File(File1);
				        File temp2 = new File("temp.txt");

				        boolean found2 = false;

				        try (
				            BufferedReader br = new BufferedReader(new FileReader(f2));
				            BufferedWriter bw = new BufferedWriter(new FileWriter(temp2))
				        ) {
				            System.out.print("Enter Student ID to delete: ");
				            int idtodel = sc.nextInt();

				            String line;

				            while ((line = br.readLine()) != null) {
				                String[] data = line.split(",");
				                int id = Integer.parseInt(data[0]);

				                if (id == idtodel) {
				                    found2 = true;
				                    continue; // skip record
				                }
				                bw.write(line);
				                bw.newLine();
				            }

				        } catch (Exception e) {
				            System.out.println("Error while deleting record.");
				        }

				        if (found2) {
				            f2.delete();
				            temp2.renameTo(f2);
				            System.out.println("Student deleted successfully!");
				        } else {
				            temp2.delete();
				            System.out.println("Student ID not found.");
				        }
					break;	
				case 5: 
					System.out.println("Exiting program.....");
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + s+"  enter given value from menu");
				}
			}while(s!=5);
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
