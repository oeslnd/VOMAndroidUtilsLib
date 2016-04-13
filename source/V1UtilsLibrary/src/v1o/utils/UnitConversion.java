package v1o.utils;

import android.content.Context;

/**
 * 单位换算
 * 
 * 
 * ===================主方法=================
 * 主方法1：dip转化为px
 * 主方法2：px转化为dip
 * ===================主方法=================
 * @author v1onway
 */
public class UnitConversion {

	//===================主方法=================
	//主方法1：dip转化为px
	public static int dip2px(Context context, float dipValueFloat){   
        final float scale = context.getResources().getDisplayMetrics().density;   
        return (int)(dipValueFloat * scale + 0.5f);   
	}  

	
	//主方法2：px转化为dip
	public static int px2dip(Context context, float pxValueFloat){   
        final float scale = context.getResources().getDisplayMetrics().density;   
        return (int)(pxValueFloat / scale + 0.5f);   
	}

	//===================主方法=================
	
}
