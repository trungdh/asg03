package trung.lab;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Date date = new Date(12,22,2014);
        System.out.println( "Hello World!" + date.toString());
		for(int i = 0; i< 10 ; i++)
		{
			date.nextDay();
			date.toString();
			System.out.println(date);
		}
    }
}
