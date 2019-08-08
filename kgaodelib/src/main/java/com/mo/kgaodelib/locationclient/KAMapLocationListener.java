package com.mo.kgaodelib.locationclient;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.mo.kgaodelib.GdConstant;

/**
 * @ author：mo
 * @ data：2019/8/8:11:32
 * @ 功能：定位回调监听
 * AMapLocationListener接口只有onLocationChanged方法可以实现，用于接收异步返回的定位结果，参数是AMapLocation类型。
 */
public abstract class KAMapLocationListener implements AMapLocationListener {
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                GdConstant.latitude = aMapLocation.getLatitude();
                GdConstant.longitude = aMapLocation.getLongitude();
                GdConstant.CITY = aMapLocation.getCity();
                onLocationChangedSuss(aMapLocation);
            } else {
                onLocationChangedError(aMapLocation, aMapLocation.getErrorCode());
            }
        } else {
            onLocationChangedError(aMapLocation, -1);
        }
    }

    protected abstract void onLocationChangedSuss(AMapLocation aMapLocation);


    protected void onLocationChangedError(AMapLocation aMapLocation, int errorCode) {
        if (errorCode == -1) {
            Log.e("AmapError", "location Error, ErrCode:-1, errInfo:  aMapLocation==null");
        } else {
            Log.e("AmapError", "location Error, ErrCode:" + aMapLocation.getErrorCode() + ", errInfo:" + aMapLocation.getErrorInfo());
        }
    }

    ;
}
