package dongting.beijing.com.ipcdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends Activity {

     ServiceConnection serviceConnection;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
               /* try {
                    MyService.IBind iBind = (MyService.IBind)service;
                    iBind.aidlMethod(1);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                // iBind.hehe();*/
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startService(new Intent(MainActivity.this,MyService.class));
               // bindService(new Intent(MainActivity.this,MyService.class),serviceConnection, Service.BIND_AUTO_CREATE);

               // localBroadcastManager.sendBroadcast(new Intent("dongting.beijing.com.ipcdemo.MainActivity"));
              /*
              系统广播

              sendBroadcast(new Intent(MainActivity.this,MyReceiver2.class));
                sendBroadcast(new Intent("dongting.beijing.com.ipcdemo.MainActivity"));*/
            }
        });

        //startService(new Intent(MainActivity.this,MyService.class));

       /*
        动态注册

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println("localReceiver = " + context);
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("dongting.beijing.com.ipcdemo.MainActivity");

        localBroadcastManager.registerReceiver(receiver,intentFilter);*/

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future =  executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

Thread.sleep(500);
                return "111";
            }
        });

        while(!future.isDone()){
            System.out.println("ing = " + "===");
        }
        System.out.println("future = " + future);
    }
}
