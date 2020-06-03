package com.nit.city.service.impl;

import com.nit.city.bean.District;
import com.nit.city.bean.Position;
import com.nit.city.dao.CityMapper;
import com.nit.city.dao.DistrictMapper;
import com.nit.city.dao.PositionMapper;
import com.nit.city.service.CityService;
import com.nit.city.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyc
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Position getOtherInfoByPositionId(Integer positionId) {
        Position position = positionMapper.selectOtherInfoByPositionId(positionId);
        return position;
    }

    @Override
    public Position getPositionByAllInfo(Integer provinceId, Integer cityId, Integer districtId) {
        Position backPosition = positionMapper.selectByAllInfo(provinceId, cityId, districtId);
        return backPosition;
    }

    @Override
    public Integer uploadPosition(Position position) {
        int result = positionMapper.insertSelective(position);
        return result;
    }

    @Override
    public List<Position> getAllPosition() {
        List<Position> positions = positionMapper.selectAllPosition();
        return positions;
    }

    @Override
    public void deletePosition(Integer positionId) {
        positionMapper.deleteByPrimaryKey(positionId);
    }
}
