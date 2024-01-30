package com.westee.goodsservice.service;

import com.westee.common.utils.Utils;
import com.westee.goodsservice.generate.Swiper;
import com.westee.goodsservice.generate.SwiperExample;
import com.westee.goodsservice.generate.SwiperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwiperService {
    private final SwiperMapper swiperMapper;

    @Autowired
    public SwiperService(SwiperMapper swiperMapper) {
        this.swiperMapper = swiperMapper;
    }

    public List<Swiper> getSwiperByType(String type) {
        SwiperExample swiperExample = new SwiperExample();
        SwiperExample.Criteria criteria = swiperExample.createCriteria().andEnabledEqualTo(true);
        if (type != null && !type.isEmpty()) {
            criteria.andSwiperTypeEqualTo(type);
        }
        return swiperMapper.selectByExample(swiperExample);
    }

    public Swiper createSwiper(Swiper swiper) {
        swiper.setCreatedAt(Utils.getNow());
        swiper.setUpdatedAt(Utils.getNow());
        swiperMapper.insert(swiper);
        return swiper;
    }

    public Swiper updateSwiper(Swiper swiper) {
        int id = swiper.getId();
        swiper.setUpdatedAt(Utils.getNow());
        swiperMapper.updateByPrimaryKeySelective(swiper);
        swiper.setId(id);
        return swiper;
    }

    public Swiper deleteSwiper(int goodsId) {
        Swiper swiper = new Swiper();
        swiper.setId(goodsId);
        swiper.setEnabled(false);
        swiper.setUpdatedAt(Utils.getNow());
        swiper.setCreatedAt(Utils.getNow());
        swiperMapper.updateByPrimaryKeySelective(swiper);
        return swiper;
    }

    public enum SwiperType {
        INDEX;

        public String getName() {
            return name().toLowerCase();
        }

        public SwiperType fromType(String status) {
            // 检查status是否在SwiperType中 请帮我补充代码
            for (SwiperType type : SwiperType.values()) {
                if (type.getName().equals(status.toLowerCase())) {
                    return type;
                }
            }
            return null; // or throw an exception, if needed
        }
    }
}
