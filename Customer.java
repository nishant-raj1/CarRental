import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Customer {

	public void process() throws IOException {
		int request=0;
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println(" Enter Choice ");
		System.out.println(" 1.  Register");
		System.out.println(" 2.  Login");
		System.out.println(" 3. Exit");
		request= sc.nextInt();
		switch(request)
		{
		case 1: System.out.println("Fill Your Details Here");
			register();
			break;
		case 2: System.out.println("Enter your Credentials");
		login();
		break;
		case 3: System.out.println(" Bye Bye");
		System.exit(0);
		break;
			
		}
	}

	private void login() {
		// TODO Auto-generated method stub
		int flag = 0;
		int p=0;
		try {
		// Input from user-----
		Scanner sc= new Scanner(System.in);
		System.out.println(" Enter  your email ");
		String email= sc.next();
		String confemail;
		//  Reading from the file----------------
		FileReader f2= new FileReader("C:\\Users\\atul.mishra2\\Desktop\\Training\\Register Customer.txt");
		Scanner d1 = new Scanner(f2);
		// String buffer is used to append the data in the file -----------------------
		StringBuffer sb= new StringBuffer();
		        while (d1.hasNextLine()) {  
		            String fd = d1.nextLine();  
		 
		            StringTokenizer st = new StringTokenizer(fd);
		            ///Comparing email to ensure it is present in the userlist or not------------------
		           int a=email.compareTo(st.nextToken());
		           if (a==0){
		           int pc=1;
		           p=1;
		           String confpass=st.nextToken();
		           // Taking password  and comparing it from the corresponding user-----------------------------------
		           while(pc<4  && pc>=0) {
		           System.out.println("enter your password");
		           String pass= sc.next();
		         
		            int b=pass.compareTo(confpass);
		            if (b==0) {
		            // if password gets matched
		            System.out.println(" Login succesfull");
		           break;
		            }
		            // giving option to retry password-----------------------------
		            else {
		            System.out.println(" password wrong "+ (3-pc)+" times left");
		            pc+=1;
		            }
		           //System. exit(0);
		           }
		           }
		         
		           else {
		           flag=1;


		           }
		       
		         
		        }


		        // if no emailid matched -------------------------------------------
		        if(flag==1 && p==0) {
		           System.out.println(" No user found");
		           }
		}catch (Exception e){
		System.out.println("file not created");

		}

		}
		

	

	private void register() throws IOException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		StringBuffer sb= new StringBuffer();
		System.out.println(" enter email");
		String email= sc.next();
		System.out.println(" enter  Password");
		String password= sc.next();
		System.out.println(" Enter Name");
		String Name= sc.next();
		System.out.println(" enter Contact");
		String Contact= sc.next();
		FileReader f2= new FileReader("C:\\Users\\nishant.raj\\Desktop\\Trainig Setup\\day3\\Demo.txt");
		  Scanner d1 = new Scanner(f2);  
		  while (d1.hasNextLine()) {  
              String fd = d1.nextLine();  
              sb=sb.append(fd); 
           //  System.out.println(fd);
          }  
			FileWriter f= new FileWriter("C:\\Users\\nishant.raj\\Desktop\\Trainig Setup\\day3\\Demo.txt");
				  f.write("\n"+sb+"\n\n"+email+"\t "+password+"\t "+Name+" \t"+Contact);
				System.out.println("registration Succesfull ");
				  f.close();
		
	
		
	}

}
