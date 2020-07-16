package com.lyc.city.position.service.impl;

import com.lyc.city.bean.Position;
import com.lyc.city.position.dao.PositionMapper;
import com.lyc.city.position.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:25
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public Position getOtherInfoByPositionId(Integer positionId) {
        return positionMapper.selectOtherInfoByPositionId(positionId);
    }

    @Override
    public Position getPositionByAllInfo(Integer province, Integer city, Integer district) {
        return positionMapper.selectByAllInfo(province, city, district);
    }

    @Override
    public Integer uploadPosition(Position position) {
        return positionMapper.insertPosition(position);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.selectAllPosition();
    }

    @Override
    public Integer deletePositionByPositionId(Integer positionId) {
        return positionMapper.deletePositionByPositionId(positionId);
    }
}
