package com.mo.kgaodelib;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;

/**
 * @ author：mo
 * @ data：2019/6/3:9:35
 * @ 功能：地图事件监听
 */
public interface KGaoDeListener {
    void onLocationChanged(AMapLocation aMapLocation);//定位监听

    void setOnMapClickListener(LatLng latLng);//地图点击事件

    void setOnMarkerClickListener(Marker marker);//定义 Marker 点击事件监听
}
