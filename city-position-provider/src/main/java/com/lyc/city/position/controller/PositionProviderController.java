package com.lyc.city.position.controller;

import com.lyc.city.bean.Position;
import com.lyc.city.position.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lyc
 * @date 2020/7/9 10:07
 */
@RestController
@Slf4j
@CrossOrigin
public class PositionProviderController {

    @Resource
    private PositionService positionService;

    @GetMapping("/deletePositionByPositionId")
    public void deletePositionByPositionId(@RequestParam("positionId") Integer positionId){
        Integer result = positionService.deletePositionByPositionId(positionId);
        if(result!=0){
            log.error("删除position成功！");
        }else {
            log.error("删除position失败！");
        }
    }

    @GetMapping("/getAllPosition")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/getOtherInfoByPositionId")
    public Position getOtherInfoByPositionId(Integer positionId) {
        return positionService.getOtherInfoByPositionId(positionId);
    }

    @GetMapping("/getPositionByAllInfo")
    public Position getPositionByAllInfo(Integer province, Integer city, Integer district) {
        return positionService.getPositionByAllInfo(province, city, district);
    }

    @PostMapping("/uploadPosition")
    public Integer uploadPosition(@RequestBody Position position) {
        return positionService.uploadPosition(position);
    }
}
