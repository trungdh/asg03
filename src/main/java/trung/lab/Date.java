package trung.lab;
// Fig. 8.7: Date.java 
// Date class declaration.

public class Date 
{
   private int month; // 1-12
   private int day;   // 1-31 based on month
   private int year;  // any year

   // constructor: call checkMonth to confirm proper value for month; 
   // call checkDay to confirm proper value for day
   public Date( int theMonth, int theDay, int theYear )
   {
      month = checkMonth( theMonth ); // validate month
      year = checkYear(theYear); // could validate year
      day = checkDay( theDay ); // validate day

      System.out.printf( 
         "Date object constructor for date %s\n", this );
   } // end Date constructor

   // utility method to confirm proper month value
   private int checkYear(int testYear)
   {
		if(testYear/1000 >0 && testYear/1000 <= 9) // khong cho phep nam nhap qua 4 chu so
			return testYear;
		else
		{
			System.out.printf("Invalid year (%d) set to 1", testYear);
			return 1;
		}
   }
   private int checkMonth( int testMonth )
   {
      if ( testMonth > 0 && testMonth <= 12 ) // validate month
         return testMonth;
      else // month is invalid 
      { 
         System.out.printf( 
            "Invalid month (%d) set to 1.", testMonth );
         return 1; // maintain object in consistent state
      } // end else
   } // end method checkMonth

   // utility method to confirm proper day value based on month and year
   private int checkDay( int testDay )
   {
      int daysPerMonth[] = 
         { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
   
      // check if day in range for month
      if ( testDay > 0 && testDay <= daysPerMonth[ month ] )
         return testDay;
   
      // check for leap year
      if ( month == 2 && testDay == 29 && ( year % 400 == 0 || 
           ( year % 4 == 0 && year % 100 != 0 ) ) )
         return testDay;
   
      System.out.printf( "Invalid day (%d) set to 1.", testDay );
      return 1;  // maintain object in consistent state
   } // end method checkDay
   
   // return a String of the form month/day/year
   public String toString()
   { 
      return String.format( "%d/%d/%d", month, day, year ); 
   } // end method toString
   public Date nextDay()
   {
		this.day = this.day + 1;
		if(this.month ==1 || this.month ==3 || this.month ==5 || this.month ==7 || this.month == 8 || this.month == 10 || this.month ==12 && this.day >31)
		{
			this.month = this.month +1;
			this.day-=31;
			if(this.month >12)
			{
				this.month = 1;
				this.year = this.year +1;
			}
		}
		else if(this.month ==2 && this.day>28)
		{
			this.month = this.month +1;
			this.day-=28;
			if(this.month >12)
			{
				this.month = 1;
				this.year = this.year +1;
			}
		}
		else if(this.month ==4 || this.month ==6 || this.month ==9 || this.month ==11 && this.day>30)
		{
			this.month = this.month +1;
			this.day -=30;
			if(this.month >12)
			{
				this.month = 1;
				this.year = this.year +1;
			}
		}
		return this;
   }
} // end class Date


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/