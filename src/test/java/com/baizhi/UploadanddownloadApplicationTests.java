package com.baizhi;

import com.baizhi.dao.CarouselMapper;
import com.baizhi.entity.Carousel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadanddownloadApplicationTests {
    @Autowired
    private CarouselMapper carouselMapper;
    @Test
    public void contextLoads() {
        List<Carousel> car = carouselMapper.selectAll();
        for (Carousel carousel : car) {
            System.out.println(carousel);
        }
    }

    @Test
    public void testInsert(){
        Carousel car = new Carousel();
        car.setId("1ssss23");
        car.setTitle("emmmm");
        car.setPathImg("1111.jpg");
        car.setState(1);
        car.setDescription("5das64");
        car.setCreatetime(new Date());
        int i = carouselMapper.insert(car);
        System.out.println("添加成功"+i);
    }

}
