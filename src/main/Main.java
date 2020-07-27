package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1.Register here");
		System.out.println("2.Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		//objects
		RegisterPojo registerpojo = new RegisterPojo();
		RegisterDAO registerdao = new RegisterDAO();
		LoginPojo loginpojo = new LoginPojo();
		LoginDAO logindao = new LoginDAO();
		
		switch(x)
		{
		case 1 :
			System.out.println("Enter the First name");
			String firstname = br.readLine();
			System.out.println("Enter the Last name");
			String lastname = br.readLine();
			System.out.println("Enter the User name");
			String username = br.readLine();
			System.out.println("Enter the Password");
			String password = br.readLine();
			System.out.println("Enter the Email");
			String email = br.readLine();
			//calling to set the values whatever we get from user
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(lastname);
			registerpojo.setUsername(username);
			registerpojo.setPassword(password);
			registerpojo.setEmail(email);
			
			registerdao.addUser(registerpojo);
			break;
		case 2:
			System.out.println("Enter the User name");
			String name = br.readLine();
			System.out.println("Enter the Password");
			String pass = br.readLine();
			loginpojo.setUsername(name);
			loginpojo.setPassword(pass);
			if(logindao.validate(loginpojo) == true) {
				Luck luck = new Luck();
				luck.display();
			}
			else {
				System.out.println("Incorrect username or password");
			}
			break;
		}
	}

}
