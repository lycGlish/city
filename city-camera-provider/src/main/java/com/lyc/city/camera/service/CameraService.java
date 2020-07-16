package com.lyc.city.camera.service;

import com.lyc.city.bean.Camera;

import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:28
 */
public interface CameraService {

    Integer deleteCameraByCameraId(Integer cameraId);

    List<Camera> getAllCamera();

    Integer uploadCamera(Camera camera);

    Integer updateCameraNameByCameraId(Camera camera);
}
