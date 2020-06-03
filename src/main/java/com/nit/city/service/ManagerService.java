package com.nit.city.service;

import com.nit.city.bean.Camera;
import com.nit.city.bean.Manager;
import com.nit.city.bean.Message;

import java.util.List;

/**
 * @author lyc
 */
public interface ManagerService {

    List<Camera> getAllCamera();

    int uploadCamera(Camera camera);

    List<Message> getAllMessage();

    int uploadMessage(Message message);

    Manager checkEmail(String email);

    Manager checkManagerName(String userName);

    Manager login(String managerName, String password);

    int register(Manager manager);

    void deleteMessage(Integer messageId);

    void deleteCamera(Integer cameraId);

    void deleteUser(Integer userId);

    List<Message> getDangerMessage();

    int updateMessage(Message message);

    int updateCamera(Camera camera);
}
