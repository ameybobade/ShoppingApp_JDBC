import java.util.Scanner;

public class AdminMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("---------Welcome Admin--------------");
			
			
			System.out.println("1.Add Product\n2.Update Product\n3.Delete Product\n4.Search \n5.Display All Products\n6.Exit");
			
			int ch = sc.nextInt();
			
			AdminOperations adop = new AdminOperations();
			
				switch(ch)
				{
					case 1:
						adop.Add();
						break;
						
						
					case 2:
						adop.Update();
						break;
						
					case 3:
						adop.Delete();
						break;
						
					case 4:
						adop.Search();
						break;
						
					case 5:
						adop.Display();
						break;
					
					case 6:
						System.exit(0);
								
					
				}
			System.out.println("Do you want to continue?");
			
		}while(sc.next().equals("yes"));
	}

}
