package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;


    @RequestMapping("/findAll")
    public List<Carousel> findAll(){
        System.out.println("---------------------------------------------");
        return  carouselService.findAll();
    }

    @RequestMapping("/addCar")
    public void addCarousel(Carousel car,MultipartFile addFileAlb, HttpServletRequest request){
        System.out.println("=================================================================");
        //获取需要下载的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/frequencyS");
        //获取名称
        String filename = addFileAlb.getOriginalFilename();

        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        try {
            addFileAlb.transferTo(new File(realPath,filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = UUID.randomUUID().toString();
        car.setId(id);
        car.setState(1);
        car.setPathImg(filename);
        car.setDescription("你真帅");
        car.setCreatetime(new Date());
        carouselService.addCar(car);
    }


    @RequestMapping("/xiaZai")
    public void xiaZai(HttpServletRequest request, String url, HttpServletResponse response) throws IOException {
        //根据文件名，到文件储存位置加载到一个文件
        String realPath = request.getSession().getServletContext().getRealPath("/frequencyS");
        File file = new File(realPath+"/"+url);
        //byte[] bytes = FileUtils.readFileToByteArray(file);
        response.setHeader("content-disposition", "attachment;filename="+url);
        ServletOutputStream out=response.getOutputStream();
      //  out.write(bytes);
        out.flush();
    }
}
