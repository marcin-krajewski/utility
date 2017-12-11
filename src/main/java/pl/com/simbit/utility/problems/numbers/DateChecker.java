package pl.com.simbit.utility.problems.numbers;

public class DateChecker {

	public enum DayOfWeek {
		SUN, MON, TUE, WED, THU, FRI, SAT
	};

	public enum Month {
		JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

		private int val;

		private Month(int val) {
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		public Month getMonthForVal(int val) {
			for (Month m : this.values()) {
				if (m.getVal() == val) {
					return m;
				}
			}
			return null;
		}
	};

	public static DayOfWeek checkWhichDayWasDate(int day, Month month, int year) {
		int yearVal = getCenturiesValue(year);
		int last2ofYear = year % 100;
		int floorLast2ofYearDiv4 = (int) Math.floor((double) last2ofYear / 4.0);
		int monthVal = getMonthsValue(month, isLeapYear(year));
		int value = day + yearVal + last2ofYear + floorLast2ofYearDiv4 + monthVal;
		return getDayValue(value % 7);
	}

	private static boolean isLeapYear(int year) {
		if (year % 100 == 0 && year % 400 != 0) {
			return false;
		}
		return year % 4 == 0;
	}

	private static Integer getCenturiesValue(int year) {
		if (year < 1700 || year >= 2700) {
			return null;
		} else if (year < 1800) {
			return 4;
		} else if (year < 1900) {
			return 2;
		} else if (year < 2000) {
			return 0;
		} else if (year < 2100) {
			return 6;
		} else if (year < 2200) {
			return 4;
		} else if (year < 2300) {
			return 2;
		} else if (year < 2400) {
			return 0;
		} else if (year < 2500) {
			return 6;
		} else if (year < 2600) {
			return 4;
		}
		return 2;
	}

	private static Integer getMonthsValue(Month month, boolean leapYear) {
		switch (month) {
		case JAN:
			if (leapYear) {
				return 6;
			} else {
				return 0;
			}
		case FEB:
			if (leapYear) {
				return 2;
			} else {
				return 3;
			}
		case MAR:
			return 3;
		case APR:
			return 6;
		case MAY:
			return 1;
		case JUN:
			return 4;
		case JUL:
			return 6;
		case AUG:
			return 2;
		case SEP:
			return 5;
		case OCT:
			return 0;
		case NOV:
			return 3;
		case DEC:
			return 5;
		default:
			return null;
		}
	}

	private static Integer getDayValue(DayOfWeek day) {
		switch (day) {
		case SUN:
			return 0;
		case MON:
			return 1;
		case TUE:
			return 2;
		case WED:
			return 3;
		case THU:
			return 4;
		case FRI:
			return 5;
		case SAT:
			return 6;
		default:
			return null;
		}
	}

	private static DayOfWeek getDayValue(int day) {
		switch (day) {
		case 0:
			return DayOfWeek.SUN;
		case 1:
			return DayOfWeek.MON;
		case 2:
			return DayOfWeek.TUE;
		case 3:
			return DayOfWeek.WED;
		case 4:
			return DayOfWeek.THU;
		case 5:
			return DayOfWeek.FRI;
		case 6:
			return DayOfWeek.SAT;
		default:
			return null;
		}
	}

}
