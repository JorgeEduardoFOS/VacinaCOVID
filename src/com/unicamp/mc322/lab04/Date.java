package com.unicamp.mc322.lab04;
//import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;

public class Date {
	private LocalDate birthDate;
	//Calendar data = Calendar.getInstance();
	Date(int year, int month, int dayOfMonth) {
		birthDate = LocalDate.of(year, month, dayOfMonth);
	}
	public int getAge() {
		LocalDate now = LocalDate.now();
		Period age = Period.between(birthDate, now);
		return age.getYears();
	}

}
