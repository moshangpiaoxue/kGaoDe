package com.mo.kgaodelib;

import android.content.Context;
import android.view.View;

import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.AmapPageType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

/*
 * 作者：M
 * 日期：2019/5/7
 * 作用：高德导航工具类
 * */

public class GdUtil {

    /**
     * 高德导航
     * 传入终点经纬度
     * 原先是传 NearBuildBeans.DataBean commentData
     * 为了方便封出去库的时候就传这个 double endlatiude,double endlongitude
     */
    public static void startAMapNavigational(Context context, double endlatiude, double endlongitude) {
        //传入起点经纬度
        com.amap.api.maps.model.LatLng startLatLng = new com.amap.api.maps.model.LatLng(GdConstant.latitude, GdConstant.longitude);
        //传入终点经纬度
        com.amap.api.maps.model.LatLng endLatLng = new com.amap.api.maps.model.LatLng(endlatiude, endlongitude);
        //起点
        Poi start = new Poi("起点", startLatLng, "");
        //终点
        Poi end = new Poi("终点", endLatLng, "");
        AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER, AmapPageType.NAVI);
        amapNaviParams.setUseInnerVoice(true);
        AmapNaviPage.getInstance().showRouteActivity(context, amapNaviParams, new INaviInfoCallback() {
            @Override
            public void onInitNaviFailure() {
            }

            @Override
            public void onGetNavigationText(String s) {
            }

            @Override
            public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
            }

            @Override
            public void onArriveDestination(boolean b) {
            }

            @Override
            public void onStartNavi(int i) {
            }

            @Override
            public void onCalculateRouteSuccess(int[] ints) {
            }

            @Override
            public void onCalculateRouteFailure(int i) {
            }

            @Override
            public void onStopSpeaking() {
            }

            @Override
            public void onReCalculateRoute(int i) {
            }

            @Override
            public void onExitPage(int i) {
            }

            @Override
            public void onStrategyChanged(int i) {
            }

            @Override
            public View getCustomNaviBottomView() {
                return null;
            }

            @Override
            public View getCustomNaviView() {
                return null;
            }

            @Override
            public void onArrivedWayPoint(int i) {
            }

            @Override
            public void onMapTypeChanged(int i) {

            }
        });
    }

}
