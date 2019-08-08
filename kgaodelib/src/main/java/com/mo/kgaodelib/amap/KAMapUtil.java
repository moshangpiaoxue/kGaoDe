package com.mo.kgaodelib.amap;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;

/**
 * @ author：mo
 * @ data：2019/8/8:13:49
 * @ 功能： AMap  地图工具类
 */
public class KAMapUtil {
    private AMap aMap;

    public KAMapUtil(MapView mapView) {
        this.aMap = mapView.getMap();
        setUiSettings(aMap.getUiSettings());
    }

    /**
     * 显示定位层并且可以触发定位,默认是flase
     */
    public KAMapUtil setMyLocationEnabled(boolean isShowLocation) {
        aMap.setMyLocationEnabled(isShowLocation);
        return this;

    }

    /**
     * 设置UI设置
     */
    public void setUiSettings(UiSettings uiSettings) {
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setRotateGesturesEnabled(false);//旋转手势
        uiSettings.setZoomControlsEnabled(false);//缩放手势
    }

    /**
     * 设置地图点击事件
     */
    public KAMapUtil setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) {
        aMap.setOnMapClickListener(onMapClickListener);
        return this;

    }

    /**
     * 设置地图上的标记的点击事件
     */
    public KAMapUtil setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) {
        aMap.setOnMarkerClickListener(onMarkerClickListener);
        return this;

    }

    public AMap getMap() {
        return aMap;
    }
}
