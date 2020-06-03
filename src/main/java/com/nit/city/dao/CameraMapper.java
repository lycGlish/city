package com.nit.city.dao;

import com.nit.city.bean.Camera;
import com.nit.city.bean.CameraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CameraMapper {
    long countByExample(CameraExample example);

    int deleteByExample(CameraExample example);

    int deleteByPrimaryKey(Integer cameraId);

    int insert(Camera record);

    int insertSelective(Camera record);

    List<Camera> selectAll();

    List<Camera> selectByExample(CameraExample example);

    Camera selectByPrimaryKey(Integer cameraId);

    int updateByExampleSelective(@Param("record") Camera record, @Param("example") CameraExample example);

    int updateByExample(@Param("record") Camera record, @Param("example") CameraExample example);

    int updateByPrimaryKeySelective(Camera record);

    int updateByPrimaryKey(Camera record);
}