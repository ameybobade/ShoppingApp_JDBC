import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
		do
		{
			System.out.println("--------Welcome--------------");
			System.out.println("1.Admin\n2.Customer\n3.Exit");
			ch=sc.nextInt();
			
		
			switch(ch)
			{
				case 1:
					AdminMain ad = new AdminMain();
					ad.main(null);
					break;
					
				case 2:
					CustomerMain cust = new CustomerMain();
					cust.main(null);
					break;
					
				case 3:
					System.out.println("-----------Good Bye!!------------");
					System.exit(0);
					break;
			}
			System.out.println("Do you want to go to the home page?");
			
		}while(sc.next().equals("yes"));
		

	}

}
