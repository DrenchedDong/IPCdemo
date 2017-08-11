package dongting.beijing.com.ipcdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("aidl OnCreate = " + "===");
    }

    @Override
    public IBinder onBind(Intent intent) {
      return new IBind();
    }

    class IBind extends IMyAidlInterface.Stub{
      /*  public  void hehe(){
            System.out.println("hehe = " + "===");
        }*/

        @Override
        public void aidlMethod(int type) throws RemoteException {
            System.out.println("aidlMethod = " + type);
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void user(User user) throws RemoteException {

            System.out.println("哈哈user = " + user);
        }
    }
}
