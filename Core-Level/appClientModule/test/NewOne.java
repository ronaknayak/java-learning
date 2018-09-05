package test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewOne {

	public static void main(String[] args) throws ParseException {
		
		BigDecimal num =  new BigDecimal(400);
		
		System.out.println(num.divide(new BigDecimal(2)));
		Calendar calendar = Calendar.getInstance();
		int day = calendar.getActualMaximum(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String startDate = format.format(new Date());
		String endDate = day + "-" + month + "-" + year;

		System.out.println(startDate + "  " + endDate);

		// Calendar c = Calendar.getInstance();
		calendar.setTime(format.parse(endDate));
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.MONTH, 2);
		startDate = format.format(calendar.getTime());
		System.out.println(startDate);

		calendar.add(Calendar.MONTH, 10);
		endDate = format.format(calendar.getTime());
		System.out.println(endDate);

		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		Calendar ca = Calendar.getInstance();
		ca.setTime(f.parse(startDate));
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DATE, -1);
		// System.out.println(f.format(ca.getTime()));

		Date[] dates = buildDate();
		System.out.println(dates[0] + "----" + dates[1]);
	}

	public static Date[] buildDate() {
		int nextMonth = (15 - 13);
		Date[] membershipRenewaldates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		int day = calendar.getActualMaximum(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String startDate = format.format(new Date());
		String endDate = day + "-" + month + "-" + year;

		try {
			calendar.setTime(format.parse(endDate));
			calendar.add(Calendar.DATE, 1);
			calendar.add(Calendar.MONTH, nextMonth);
			startDate = format.format(calendar.getTime());
			membershipRenewaldates[0] = format.parse(startDate);

			calendar.add(Calendar.MONTH, 10);
			endDate = format.format(calendar.getTime());
			membershipRenewaldates[1] = format.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return membershipRenewaldates;
	}
}