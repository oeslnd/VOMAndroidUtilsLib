package v1o.utils;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;

/**
 * 亮度管理
 * 
 * -------------------属性-------------------
 * 第1个：原始亮度
 * -------------------属性-------------------
 * 
 * ===================主方法=================
 * 主方法1：保存原始亮度
 * 主方法2：获取当前亮度
 * 主方法3：调节亮度
 * ===================主方法=================
 * @author v1onway
 */
public class BrightnessControl {
	
	//-------------------属性-------------------
	/**
	 * 第1个：原始亮度
	 */
	public static int origBrightnessInt;
	//-------------------属性-------------------
	
	
	//===================主方法=================
	/**
	 * 主方法1：保存原始亮度
	 */
	public static void saveOrigBrightness(Activity activity) {
		origBrightnessInt = getCurrentBrightness(activity); 
	}

	/**
	 * 主方法2：获取当前亮度
	 */
	public static int getCurrentBrightness(Activity activity) {
		int currentBn = Settings.System.getInt(activity.getContentResolver(),  
              Settings.System.SCREEN_BRIGHTNESS, 255);
		return currentBn;
	}
	
	/**
	 * 主方法3：调节亮度
	 */
	public static void adjustBrightness(Context context, int brightnessInt) {
		Activity activity = (Activity) context;
		
		Settings.System.putInt(context.getContentResolver(),  
                Settings.System.SCREEN_BRIGHTNESS, brightnessInt);  
		brightnessInt = Settings.System.getInt(context.getContentResolver(),  
                Settings.System.SCREEN_BRIGHTNESS, -1);  
		
        WindowManager.LayoutParams wl = activity.getWindow().getAttributes();  
        
        float brightnessFloat = (float) brightnessInt / 255;  
        if (brightnessFloat > 0 && brightnessFloat <= 1) {  
            wl.screenBrightness = brightnessFloat;  
        }  
        
        activity.getWindow().setAttributes(wl); 
	}
	//===================主方法=================
}
