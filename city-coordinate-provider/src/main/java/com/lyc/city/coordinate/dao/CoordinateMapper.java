package com.lyc.city.coordinate.dao;

import com.lyc.city.bean.Coordinate;
import org.apache.ibatis.annotations.Param;

/**
 * @author lyc
 * @date 2020/7/9 10:41
 */
public interface CoordinateMapper {

    Integer insertCoordinateWithoutId(Coordinate coordinate);

    Coordinate selectByImageLatitudeAndImageLongitude(@Param("longitude") String longitude,@Param("latitude") String latitude);
}
