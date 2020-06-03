package com.nit.city.service.impl;

import com.nit.city.bean.Camera;
import com.nit.city.bean.Manager;
import com.nit.city.bean.Message;
import com.nit.city.dao.CameraMapper;
import com.nit.city.dao.ManagerMapper;
import com.nit.city.dao.MessageMapper;
import com.nit.city.dao.UserMapper;
import com.nit.city.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员逻辑层
 * @author lyc
 */
@Service
public class MangerServiceImpl implements ManagerService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private CameraMapper cameraMapper;

    /**
     * 获取所有摄像头
     * @return 返回所有摄像头信息
     */
    @Override
    public List<Camera> getAllCamera() {
        return cameraMapper.selectAll();
    }

    /**
     * 上传摄像头信息
     * @param camera 摄像头信息
     * @return 返回数字判断是否插入数据库
     */
    @Override
    public int uploadCamera(Camera camera) {
        return cameraMapper.insertSelective(camera);
    }

    /**
     * 获取所有消息信息
     * @return 返回所有消息信息
     */
    @Override
    public List<Message> getAllMessage() {
        return messageMapper.selectAllMessage();
    }

    /**
     * 上传消息信息
     * @param message 消息信息
     * @return 返回数字判断是否插入数据库
     */
    @Override
    public int uploadMessage(Message message) {
        return messageMapper.insertSelective(message);
    }

    /**
     * ajax查询email是否可用
     * @param email email
     * @return 返回email
     */
    @Override
    public Manager checkEmail(String email) {
        return managerMapper.selectByEmail(email);
    }

    @Override
    public Manager checkManagerName(String userName){
        return managerMapper.selectByManagerName(userName);
    }

    @Override
    public Manager login(String managerName, String password){
        return managerMapper.selectByManagerNameAndPassword(managerName, password);
    }

    @Override
    public int register(Manager manager) {
        return managerMapper.insertSelective(manager);
    }

    @Override
    public void deleteMessage(Integer messageId) {
        messageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public void deleteCamera(Integer cameraId) {
        cameraMapper.deleteByPrimaryKey(cameraId);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public List<Message> getDangerMessage() {
        return messageMapper.selectDangerMessage();
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public int updateCamera(Camera camera) {
        return cameraMapper.updateByPrimaryKeySelective(camera);
    }
}
