package chuibiqun.share_frame_demo_zb666;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Replace {
    //这里会带有类名(全路径名称）
    String clazz();
    //这里带有方法名
    String method();
}
