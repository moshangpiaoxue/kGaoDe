package com.mo.kgaodelib;

import android.app.Activity;
import android.widget.Toast;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;

/**
 * @ author：mo
 * @ data：2019/8/8:9:57
 * @ 功能： 路线规划工具类
 */
public class RouteSearchUtil {

    /**
     * 开始 搜索路径规划方案
     */
    /**
     * @param mActivity    上下文
     * @param mRouteSearch 路线规划控制器
     * @param mode         驾车模式
     * @param mEndPoint    终点坐标
     */
    public static void searchRouteResult(Activity mActivity, RouteSearch mRouteSearch, int mode, LatLonPoint mEndPoint) {
        searchRouteResult(mActivity,mRouteSearch,mode,null,mEndPoint);
    }

    public static void searchRouteResult(Activity mActivity, RouteSearch mRouteSearch, int mode, LatLonPoint mStartPoint1, LatLonPoint mEndPoint) {
        LatLonPoint mStartPoint = mStartPoint1 == null ? new LatLonPoint(GdConstant.latitude, GdConstant.longitude) : mStartPoint1;//起点，39.942295,116.335891
        if (mStartPoint == null) {
            Toast.makeText(mActivity, "定位中，稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEndPoint == null) {
            Toast.makeText(mActivity, "定位中，终点未设置", Toast.LENGTH_SHORT).show();
        }
        final RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(mStartPoint, mEndPoint);
        // 第一个参数表示路径规划的起点和终点，第二个参数表示驾车模式，第三个参数表示途经点，第四个参数表示避让区域，第五个参数表示避让道路
        RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, mode, null, null, "");
        // 异步路径规划驾车模式查询
        mRouteSearch.calculateDriveRouteAsyn(query);
    }

}
