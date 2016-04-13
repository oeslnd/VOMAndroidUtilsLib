package v1o.utils;

/**
 * 日期解析
 * 
 * -------------------属性-------------------
 * 第1类：月份集合
 * 第2类：解析的日期字符串
 * -------------------属性-------------------
 * 
 * 
 * ===================主方法=================
 * 主方法1：日期增加解析， dateAddAnAl(int addDayCountInt)
 * ===================主方法=================
 * 
 * 
 * -------------------次方法-------------------
 * 次方法1：确定日期结果， confirmDate(int allDayCountInt)
 * 次方法2：获取月份天数， getMonthDayCount(int cMonthInt)
 * 次方法3：日期格式加0， formatAddZero(int modValueInt)
 * 次方法4：检查值是否存在数组中， checkExistArray(int valueInt, int[] resArray)
 * -------------------次方法-------------------
 * @author v1onway
 */
public class DateAnal {
	
	//-------------------属性-------------------
	//第一类：月份集合
	//一年中有31和30的月份集合
	public final static int[] thirtyOneDaysMonthArray = { 1, 3, 5, 7, 8, 10, 12 };
	public final static int[] thirtyDaysMonthArray = { 4, 6, 9, 11 };
	
	//第二类：解析的日期字符串
	private static String dateResultString = null;
	//-------------------属性-------------------


	//===================方法=================
	//主方法1：日期增加解析
	public static String dateAddAnAl(int addDayCountInt) {
		//第一步：创建一个时间系列
		DateUtil. ctime();

		//第二步：确定日期
		confirmDate(DateUtil.day + addDayCountInt);
		return dateResultString;
	}
	//===================方法=================
	
	
	//-------------------次方法-------------------
	//次方法1：确定日期结果
	private static void confirmDate(int allDayCountInt)  {
		//第一步：获取该月的天数
		int currentMonthDayCountInt = getMonthDayCount(DateUtil.month);

		//第二步：根据月天数递归确定出最后日期
		if(allDayCountInt > currentMonthDayCountInt) {
				if(DateUtil.month == 12) {
					DateUtil.month = 1;
					DateUtil.year += 1;
				} else {
					DateUtil.month += 1;
				}
				
				allDayCountInt = allDayCountInt - currentMonthDayCountInt;
				confirmDate(allDayCountInt);
		} else {
				dateResultString = DateUtil.year + "年" + 
			                       formatAddZero(DateUtil.month) + "月"+ 
						           formatAddZero(allDayCountInt) + "日";
				return;
		} 
	}
	
	//次方法2：获取月份天数
	private static int getMonthDayCount(int cMonthInt) {
		int monthDayCount = -1;	

		//第一步：确定如果是2月的日期天数
		if (cMonthInt == 2) {
				// 闰年
				if ((DateUtil.year % 4 == 0) && (DateUtil.year % 100 != 0)) {
					monthDayCount = 29;
				} else {
					monthDayCount = 28;
				}
		}

		//第二步：确定如果不是2月的日期天数
		else {
			// 如果是有31天的月份
			if (checkExistArray (thirtyOneDaysMonthArray, cMonthInt)) {
				monthDayCount = 31;
			}

			// 如果是有30天的月份
			if (checkExistArray (thirtyDaysMonthArray, cMonthInt)) {
				monthDayCount = 30;
			}
		}
		
		return monthDayCount;
	}
	
	//次方法3：日期格式加0
	private static String formatAddZero(int modValueInt) {
		if (modValueInt <= 9) {
			return "0" + modValueInt;
		}
		return "" + modValueInt;
	}

	//次方法：检查值是否存在
	private static boolean checkExistArray(int[] resArray, int valueInt)  {
		for(int i=0; i<resArray.length;i++) {
			if(resArray[i] == valueInt) {
				return true;
			}
		}
		return false;
	}
	//-------------------次方法-------------------
	
}
