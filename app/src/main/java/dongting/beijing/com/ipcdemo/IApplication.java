package dongting.beijing.com.ipcdemo;

import android.app.Application;

/**
 * 作者:${董婷}
 * 日期:2017/8/3
 * 类的用途:
 * 实现思路:
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate = " + true);
    }
}
