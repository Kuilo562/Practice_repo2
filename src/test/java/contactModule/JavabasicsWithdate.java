package contactModule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavabasicsWithdate {
public static void main(String[] args) {
	
	Date dateobj = new Date();
	
	//To capture only date
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String actdate = sim.format(dateobj);
	System.out.println(actdate);
	
	//To capture the date which required
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,30);
    String dataRequires = sim.format(cal.getTime());
    System.out.println(dataRequires);
}
}
