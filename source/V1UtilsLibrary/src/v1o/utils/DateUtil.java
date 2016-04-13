package v1o.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.text.format.Time;

/**
 * 日期常用
 * 
 * -------------------属性-------------------
 * 第1类：一系列时间
 * 第2类：日期格式字符串
 * -------------------属性-------------------
 * 
 * 
 * ===================主方法=================
 * 方法1：获取日期对象， getDate()
 * 方法2：生成一系列时间， ctime()
 * 方法3：获取日期字符串， getDateString()
 * 方法4：获取日期字符串， getDateString(String formatStr)
 * ===================主方法=================
 * @author v1onway
 */
public class DateUtil {
	//-------------------属性-------------------
	//第1类：一系列时间
	//分别是年月日
	public static int year = -1;
	public static int month = -1;
	public static int day = -1;
	
	//第2类：日期格式字符串
	//分别是精确到天和精确到秒
	public final static String FORMATE_DAY = "yyyy年MM月dd日";
	public final static String FORMATE_SECONDS = "yyyy年MM月dd日-HH时mm分ss秒";
	//-------------------属性-------------------
	
	
	
	//===================主方法=================
	//方法1：获取日期对象
	public static Date getDate() {
		return new Date();
	}
	
	//方法2：生成一系列时间
	public static void ctime() {
		Time ctime = new Time();
		ctime.setToNow();
		year = ctime.year;
		month = ctime.month + 1;
		day = ctime.monthDay;
	}

	//方法3：获取日期字符串，格式默认到秒
	public static String getDateString() {
		return getDateString(FORMATE_SECONDS);
	}

	//方法4：获取日期字符串，传递格式字符串参数
	public static String getDateString(String formatStr) {
		Date date = getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr, 
				Locale.getDefault());
		return dateFormat.format(date);
	}
	//===================主方法=================
}