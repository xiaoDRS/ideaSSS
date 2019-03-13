package com.baizhi.service;

import com.baizhi.dao.CarouselMapper;
import com.baizhi.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED)//事务是必须的
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    public CarouselMapper carouselMapper;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS) //支持事务
    public List<Carousel> findAll() {
        return carouselMapper.selectAll();
    }

    @Override
    public void addCar(Carousel carousel) {
        carouselMapper.insert(carousel);
    }
}
