package com.mo.kgaodelib.amap;

import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.MyLocationStyle;

/**
 * @ author：mo
 * @ data：2019/8/8:13:49
 * @ 功能： AMap  地图工具类
 */
public class KAMapUtil {
    protected AMap aMap;

    public KAMapUtil(MapView mapView) {
        this.aMap = mapView.getMap();
        setUiSettings(aMap.getUiSettings());
//        setLocationStyle();
    }

    public void setLocationStyle() {
        // 是否显示定位按钮
        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle.showMyLocation(true);
        // 默认模式，连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动，1秒1次定位
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }

    /**
     * 设置定位的监听
     */
    public KAMapUtil setLocationSource(LocationSource locationSource) {
        aMap.setLocationSource(locationSource);
        return this;

    }


//    /**
//     * 显示定位层并且可以触发定位,默认是flase
//     */
//    public KAMapUtil setMyLocationEnabled(boolean isShowLocation) {
//        aMap.setMyLocationEnabled(isShowLocation);
//        return this;
//
//    }

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
