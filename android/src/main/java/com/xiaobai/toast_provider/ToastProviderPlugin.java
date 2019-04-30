package com.xiaobai.toast_provider;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/** ToastProviderPlugin */
public class ToastProviderPlugin implements MethodChannel.MethodCallHandler {
  private static final String TAG = "ToastProviderPlugin";
  private Activity activity;
  /** Plugin registration. */
  public ToastProviderPlugin(Activity activity){
    this.activity =activity ;
  }
  public static void registerWith(PluginRegistry.Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "toast_provider");
    channel.setMethodCallHandler(new ToastProviderPlugin(registrar.activity()));
  }
  @Override
  public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
    String message = methodCall.argument("message");
    if(message == null){
      result.error(TAG, "错误：message参数错误", null);
      return;
    }
    if(methodCall.method.equals("showShortToast")){
      showToast(activity, message, Toast.LENGTH_SHORT);
      result.success(null);
    }else if(methodCall.method.equals("showLongToast")){
      result.success(null);
    } else if(methodCall.method.equals("showToast")){
      int duration =  methodCall.argument("duration");
      showToast(activity, message, duration);
      result.success(null);
    }else{
      result.notImplemented();
    }

  }
  private void showToast(Context context, String message , int duration){
    Toast.makeText(context, message, duration).show();
  }
}
