package com.mo.kgaodelib;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;

/*
 * 作者：M
 * 日期：2019/5/7
 * 作用：高德导航工具类
 * */

public class GdUtil {

    /**
     * 跳高德导航（跳进的是高德的h5导航页面）
     *
     * @param context      上下文
     * @param endlatitude  终点纬度
     * @param endlongitude 终点经度
     * @param callback     回调，可null
     */
    public static void startAMapNavigational(Context context, double endlatitude, double endlongitude, INaviInfoCallback callback) {
        startAMapNavigational(context, 0, 0, endlatitude, endlongitude, callback);
    }

    /**
     * 跳高德导航（跳进的是高德的h5导航页面）
     *
     * @param context        上下文
     * @param startlatitude  起点纬度   传0以下默认当前纬度
     * @param startlongitude 起点经度   传0以下默认当前经度
     * @param endlatitude    终点纬度
     * @param endlongitude   终点经度
     * @param callback       回调
     */
    public static void startAMapNavigational(Context context, double startlatitude, double startlongitude, double endlatitude, double endlongitude, INaviInfoCallback callback) {
        //传入起点经纬度
        com.amap.api.maps.model.LatLng startLatLng = new com.amap.api.maps.model.LatLng(
                startlatitude <= 0 ? GdConstant.latitude : startlatitude
                , startlongitude <= 0 ? GdConstant.longitude : startlongitude);
        //传入终点经纬度
        com.amap.api.maps.model.LatLng endLatLng = new com.amap.api.maps.model.LatLng(endlatitude, endlongitude);
        //起点
        Poi start = new Poi("起点", startLatLng, "");
        //终点
        Poi end = new Poi("终点", endLatLng, "");
        AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER, AmapPageType.NAVI);
        amapNaviParams.setUseInnerVoice(true);
        AmapNaviPage.getInstance().showRouteActivity(context, amapNaviParams, callback);
    }




}
