package com.lyc.city.camera.dao;

import com.lyc.city.bean.Camera;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:29
 */
@Mapper
public interface CameraMapper {

    Integer deleteCameraByCameraId(Integer cameraId);

    List<Camera> selectAllCamera();

    Integer insertCamera(Camera camera);

    Integer updateCameraNameByCameraId(Camera camera);
}
