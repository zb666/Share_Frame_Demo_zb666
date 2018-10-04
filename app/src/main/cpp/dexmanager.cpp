#include <jni.h>

#include <android/log.h>
#include <string>
#include "art_method.h"

#define  LOGE(...) __android_log_print(ANDROID_LOG_ERROR,"JNI",__VA_ARGS__);

extern "C"
//预处理的文本替换
JNIEXPORT void JNICALL
//env java传递到native层面的指针 指针指向的数组当中的首元素地址
//jobject指的是当前c++层面的对象
Java_chuibiqun_share_1frame_1demo_1zb666_DexManager_replaceMehod(JNIEnv *env,
                                                                 jobject instance,
                                                                 jobject wrongMethod,
                                                                 jobject rightMethod) {

    art::mirror::ArtMethod *wrong = reinterpret_cast<art::mirror::ArtMethod *>(env->FromReflectedMethod(
            wrongMethod));
    art::mirror::ArtMethod *right = reinterpret_cast<art::mirror::ArtMethod *>(env->FromReflectedMethod(
            rightMethod));

    //env 就是c++中操作java层的指针

    jclass jClassDexManagwr = env->GetObjectClass(instance);

    wrong->declaring_class_ = right->declaring_class_;
    wrong->dex_cache_resolved_methods_ = right->dex_cache_resolved_methods_;
    wrong->access_flags_ = right->access_flags_;
    wrong->dex_cache_resolved_types_ = right->dex_cache_resolved_types_;
    wrong->dex_code_item_offset_ = right->dex_code_item_offset_;
    wrong->dex_method_index_ = right->dex_method_index_;
    wrong->method_index_ = right->method_index_;

    LOGE("输出文本内容");

}