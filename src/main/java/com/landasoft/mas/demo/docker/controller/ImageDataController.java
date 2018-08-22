package com.landasoft.mas.demo.docker.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.landasoft.mas.demo.docker.mapper.UserAnnotationMapper;
import com.landasoft.mas.demo.docker.mapper.UserOriginImageMapper;
import com.landasoft.mas.demo.docker.model.vo.UserOriginImage;
import com.landasoft.mas.demo.docker.service.api.UserOriginImageService;
import com.landasoft.mas.demo.docker.utils.FtpUtil;
import com.landasoft.mas.demo.docker.utils.ResultUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传图片信息到公有云控制器
 * @author wulinyun
 * 2018年7月23日下午4:53:51
 */
@RestController
@RequestMapping(value="/rest/image")
public class ImageDataController extends BaseController {
	/**
	 * 注入用户原始图片服务
	 */
	@Autowired
	private UserOriginImageService userOriginImageService;
	/**
	 * 查询某个用户的原始人脸数据
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping(value="/listImageDatas")
	public ResultUtils listImageDatas(
			@RequestParam(value="userId",required=false)String userId,
			HttpServletRequest request) {
		Date date = new Date();
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(date));
		List<UserOriginImage> userAnnotaionImages = this.userOriginImageService.findUserOriginImageByUserId(userId);
		return new ResultUtils(userAnnotaionImages);
		
	}
	@RequestMapping(value="/upload",method= {RequestMethod.POST,RequestMethod.GET})  
    @ResponseBody  
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException{  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        System.out.println(path);
        String fileName = file.getOriginalFilename();//获取到上传文件的名字
        String ftpHost = "192.168.0.191";
        String ftpUserName = "test";
        String ftpPassword = "test";
        int ftpPort = 21;
        String ftpPath = "colleague/";
        //上传一个文件
        try{
            InputStream in=file.getInputStream();
            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,in);
            System.out.println(test);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e);
        }
        
        //System.out.println(file.getName()+"2222");获取到file
        //file.getSize();获取到上传文件的大小
        //File dir = new File(path,fileName);
        //System.out.println(file.getSize());
       // if(!dir.exists()){  
       //     dir.mkdirs();  
       // }  
        //MultipartFile自带的解析方法  
        //file.transferTo(dir);  
        return "colleague/"+fileName;  
    }  
   
}
