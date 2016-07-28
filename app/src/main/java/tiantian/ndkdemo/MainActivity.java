package tiantian.ndkdemo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.spotify.jni.JavaStringTest;
import com.spotify.jni.MyJNICenter;

public class MainActivity extends AppCompatActivity
{
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        context=getApplicationContext();
        setContentView(R.layout.layoutmain);
        Button button = (Button) findViewById(R.id.triggerButton);
        if (button != null)
        {
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    try
                    {
                        boolean result=new MyJNICenter().checkIMSI("460004282212600");
                        result=new MyJNICenter().checkIMSI("460004282212600");
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    static
    {
        System.loadLibrary("hello_jni");
    }

    public static String getStory()
    {
        return "love story";
    }

    public static String getIMSI()
    {
        TelephonyManager telephonyManager=(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSubscriberId();
    }
}
