package com.mo.kgaodelib.locationclient;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * @ author：mo
 * @ data：2019/8/8:11:22
 * @ 功能：地图定位客户端工具类
 */
public class AMapLocationClientUtil {
    private AMapLocationClient mLocationClient;

    public AMapLocationClientUtil(Context mContext) {
        mLocationClient = new AMapLocationClient(mContext);
    }

    /**
     * 设置定位监听
     */
    public AMapLocationClient setLocationListener(AMapLocationListener locationListener) {
        mLocationClient.setLocationListener(locationListener);
        return mLocationClient;
    }

    /**
     * 设置定位参数
     */
    public AMapLocationClient setLocationOption(AMapLocationClientOption option) {
        mLocationClient.setLocationOption(option);
        return mLocationClient;
//        //初始化定位参数
//        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
//        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //设置是否返回地址信息（默认返回地址信息）
//        mLocationOption.setNeedAddress(true);
//        //设置是否只定位一次,默认为false
//        mLocationOption.setOnceLocation(false);
//        //设置是否强制刷新WIFI，默认为强制刷新
//        mLocationOption.setWifiActiveScan(true);
//        //设置是否允许模拟位置,默认为false，不允许模拟位置
//        mLocationOption.setMockEnable(false);
//        //设置定位间隔,单位毫秒,默认为2000ms
//        mLocationOption.setInterval(2000);
//        //给定位客户端对象设置定位参数
//        mLocationClient.setLocationOption(mLocationOption);
    }

    /**
     * 开始定位
     */
    public AMapLocationClient startLocation() {
        mLocationClient.startLocation();
        return mLocationClient;
    }
}
