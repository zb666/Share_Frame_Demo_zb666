package chuibiqun.share_frame_demo_zb666.fix;

import android.content.Context;
import android.widget.Toast;

import chuibiqun.share_frame_demo_zb666.Replace;

/**
 * public class Caclutor {

 public void test(Context context) {
 throw new RuntimeException("出异常了");
 }
 }
 */
public class Caclutor {

    @Replace(clazz = "chuibiqun.share_frame_demo_zb666",method = "test")
    public void test(Context context){
        Toast.makeText(context.getApplicationContext(),"修复完成",Toast.LENGTH_LONG).show();
    }

}
