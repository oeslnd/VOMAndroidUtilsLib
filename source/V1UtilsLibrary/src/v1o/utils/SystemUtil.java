package v1o.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.widget.Toast;

/**
 * 系统处理
 * 
 * -------------------属性-------------------
 * 第1类：屏幕尺寸
 * 第2类：sd卡相关
 * 第3类：关闭程序相关
 * -------------------属性-------------------
 * 
 * ===================主方法=================
 * 主方法1：保存屏幕尺寸
 * 主方法2：休眠功能
 * 主方法3：退出程序
 * 主方法4：按两次退出程序
 * ===================主方法=================
 * @author v1onway
 */
public class SystemUtil {
	
	//-------------------属性-------------------
	//第1类：屏幕尺寸
	public static int screenWidth = -1;
	public static int screenHeight = -1;
	
	//第2类：sd卡相关
	public static boolean sdcardState = Environment.getExternalStorageState()
			.equals(Environment.MEDIA_MOUNTED);
	
	//第3类：亮度相关
	public static int origBrightnessInt = -1;
	
	//第4类：关闭程序相关
	public static long preTime = -1;
	//-------------------属性-------------------
	
	
	//===================主方法=================
	//主方法1：保存屏幕尺寸
	public static void saveScreenSize(Activity activity) {
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);

		screenWidth = dm.widthPixels;
		screenHeight = dm.heightPixels;
	}
			
	//主方法2：休眠功能
	public static void sleepvd(long timeLong) {
		try {
			Thread.sleep(timeLong);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//主方法3：退出程序
	public static void exitApp(Activity activity) {
		activity.finish();

		Intent intent = new Intent(Intent.ACTION_MAIN);  
        intent.addCategory(Intent.CATEGORY_HOME);  
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
        activity.startActivity(intent);  

        android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	//主方法4：按两次退出程序
	public static void twoTimesExitApp(Activity activity) {
		long currentTime = System.currentTimeMillis();  
        // 如果时间间隔大于2秒, 不处理退出，并更新时间  
        if ((currentTime - preTime) > 2000) {  
            // 显示消息  
            Toast.makeText(activity, "再按一次退出程序",  
                    Toast.LENGTH_SHORT).show();  

            // 更新时间  
            preTime = currentTime;  
        } 

		//如果时间间隔2秒内，则处理操作后，关闭
		else {
        	//----可加一些处理程序------
        	/**
        	if(MoreActivity.nightModeIsOpen) {
     			MoreActivity.closeNightMode();
     		}
     		*/
        	exitApp(activity);
        }
	}
	//===================主方法=================
}
