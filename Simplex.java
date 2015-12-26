import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Simplex 
{
	public static void main(String ...args)
	{
		Scanner sc = new Scanner(System.in);
		int n=0;
		try{
			n= sc.nextInt();
		}
		catch(InputMismatchException ex)
		{
			System.out.println("Invalid number!!!");
			System.exit(1);
		}
		
		BigDecimal mem[][] = new BigDecimal[n+2][];
		for(int i=0; i<=n+1; i++){
			mem[i] = new BigDecimal[i+1];
			mem[i][0] = new BigDecimal(1);
			mem[i][i] = new BigDecimal(1);
		}
		
		for(int i=1; i<=n+1; i++){
			int j = 0;
			while(j+1 < mem[i-1].length){
				mem[i][j+1] = new BigDecimal(0);
				mem[i][j+1] = mem[i-1][j].add(mem[i-1][j+1]);
				j++;
			}
		}
		
		for(int i=1; i<mem[n+1].length; i++)
			System.out.print(mem[n+1][i]+" ");
		
	}
}
