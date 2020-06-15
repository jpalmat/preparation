package hackerRank.TimeConversion;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

public class TimeConversion {

	public static void main(String[] args) {
		System.out.println(timeConversion("07:05:45PM"));
	}

	static String timeConversion(String s) {
		// Format of the date defined in the input String
		DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
		// Desired format: 24 hour format: Change the pattern as per the need
		DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		String output = null;
		try {
			// Converting the input String to Date
			date = df.parse(s);
			// Changing the format of date and storing it in String
			output = outputformat.format(date);
			// Displaying the date
			return output;
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return null;
	}
}
