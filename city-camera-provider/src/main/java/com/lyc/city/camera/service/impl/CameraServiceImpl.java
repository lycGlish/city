package com.lyc.city.camera.service.impl;

import com.lyc.city.bean.Camera;
import com.lyc.city.camera.dao.CameraMapper;
import com.lyc.city.camera.service.CameraService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/15 15:28
 */
@Service
public class CameraServiceImpl implements CameraService {

    @Resource
    private CameraMapper cameraMapper;

    @Override
    public Integer deleteCameraByCameraId(Integer cameraId) {
        return cameraMapper.deleteCameraByCameraId(cameraId);
    }

    @Override
    public List<Camera> getAllCamera() {
        return cameraMapper.selectAllCamera();
    }

    @Override
    public Integer uploadCamera(Camera camera) {
        return cameraMapper.insertCamera(camera);
    }

    @Override
    public Integer updateCameraNameByCameraId(Camera camera) {
        return cameraMapper.updateCameraNameByCameraId(camera);
    }
}
