import java.util.*;
import java.util.Scanner;
public class CustomerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Product> prodcart = new LinkedList<Product>();
		do
		{
			System.out.println("---------Welcome Customer--------------");
			
			
			System.out.println("1.Display Products\n2.Buy Products\n3.Cart\n4.Bill\n5.Exit");
			
			int ch = sc.nextInt();
			
			CustomerOperations custop = new CustomerOperations();
			
				switch(ch)
				{
					case 1:
						custop.Display();
						break;
						
						
					case 2:
						prodcart=custop.Buy(prodcart);
						break;
						
					case 3:
						custop.Cart(prodcart);
						break;
						
					case 4:
						prodcart=custop.Bill(prodcart);
						break;
					
					case 5:
						System.exit(0);
								
					
				}
			System.out.println("Do you want to continue?");
			
		}while(sc.next().equals("yes"));
	}

}
