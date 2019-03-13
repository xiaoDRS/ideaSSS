package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

public interface CarouselService {
    public List<Carousel> findAll();
    public void addCar(Carousel carousel);
}
