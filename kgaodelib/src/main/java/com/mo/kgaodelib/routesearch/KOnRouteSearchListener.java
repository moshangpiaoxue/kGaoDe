package com.mo.kgaodelib.routesearch;

import android.app.Activity;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.mo.kgaodelib.util.DrivingARouteAOverlay;

/**
 * @ author：mo
 * @ data：2019/8/8:10:28
 * @ 功能：路线规划监听
 */
public abstract class KOnRouteSearchListener implements RouteSearch.OnRouteSearchListener {
    private Activity mActivity;
    private AMap agMap;

    public KOnRouteSearchListener(Activity mActivity, AMap agMap) {
        this.mActivity = mActivity;
        this.agMap = agMap;
    }

    /**
     * 乘车规划
     */
    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    /**
     * 驾驶规划
     */
    @Override
    public void onDriveRouteSearched(DriveRouteResult result, int errorCode) {
        //驾驶规划的路线
        DrivingARouteAOverlay drivingARouteOverlay = null;
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    final DrivePath drivePath = result.getPaths().get(0);
                    if (drivePath == null) {
                        return;
                    }
                    drivingARouteOverlay = new DrivingARouteAOverlay(
                            mActivity, agMap, drivePath,
                            result.getStartPos(),
                            result.getTargetPos(), null, 0);
                    drivingARouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
                    drivingARouteOverlay.setIsColorfulline(false);//是否用颜色展示交通拥堵情况，默认true
                    drivingARouteOverlay.removeFromMap();
                    drivingARouteOverlay.addToMap(0);
                    drivingARouteOverlay.zoomToSpan();

                } else if (result != null && result.getPaths() == null) {
                    Toast.makeText(mActivity, "定位中，终点未no_result设置", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(mActivity, "定位中，终点未no_result设置", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(mActivity, "errorCode", Toast.LENGTH_SHORT).show();
        }
        onDriveRouteSearched(result, errorCode, drivingARouteOverlay);
    }

    /**
     * 驾驶规划
     * @param result    规划结果
     * @param errorCode 错误码
     * @param drivingARouteOverlay  规划的路线
     */
    protected abstract void onDriveRouteSearched(DriveRouteResult result, int errorCode, DrivingARouteAOverlay drivingARouteOverlay);

    /**
     * 步行规划
     */
    @Override
    public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {

    }

    /**
     * 骑行规划
     */
    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }
}
