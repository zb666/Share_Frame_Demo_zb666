package chuibiqun.share_frame_demo_zb666;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import dalvik.system.DexFile;

public class DexManager {

//    static {
//        System.loadLibrary("dexmanager");
//    }

    private Context context;

    public DexManager(Context context) {
        this.context = context;
    }

    public void loadFile(File file) {
        try {
            DexFile dexFile = DexFile.loadDex(file.getAbsolutePath(),
                    new File(context.getCacheDir(), "opt").getAbsolutePath(),
                    Context.MODE_PRIVATE);
            Enumeration<String> entry = dexFile.entries();
            while (entry.hasMoreElements()) {
                //dex 文件下有多个class文件，但是这里是补丁包，就一个文件
                String className = entry.nextElement();
                Class realClass = dexFile.loadClass(className, context.getClassLoader());
                if (realClass!=null){
                    fixClass(realClass);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void fixClass(Class realClass) {
        Method[] methods = realClass.getMethods();

        for (Method rightMethod : methods) {
            Replace annotation = rightMethod.getAnnotation(Replace.class);
            if (annotation == null){
                continue;
            }
            String wrongClassPathName = annotation.clazz();
            String wrongMethodName = annotation.method();

            try {
                Class<?> tClass = Class.forName(wrongClassPathName);
                //根据路径找寻到了类中的某个方法
                Method wrongMethod = tClass.getDeclaredMethod(wrongMethodName, rightMethod.getParameterTypes());
                replaceMehod(wrongMethod,rightMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public native void replaceMehod(Method wrongMethod, Method rightMethod);
}
