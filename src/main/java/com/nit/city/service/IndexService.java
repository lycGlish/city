package com.nit.city.service;

import com.nit.city.bean.Image;
import com.nit.city.bean.Message;

public interface IndexService {

    int uploadMessage(Message message);

    int uploadImage(Image image);
}
