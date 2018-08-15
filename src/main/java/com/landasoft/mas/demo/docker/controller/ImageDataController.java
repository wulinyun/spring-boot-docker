package com.landasoft.mas.demo.docker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.landasoft.mas.demo.docker.mapper.UserAnnotationMapper;
import com.landasoft.mas.demo.docker.mapper.UserOriginImageMapper;
import com.landasoft.mas.demo.docker.model.vo.UserOriginImage;
import com.landasoft.mas.demo.docker.service.api.UserOriginImageService;
import com.landasoft.mas.demo.docker.utils.ResultMapUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
	public ResultMapUtils listImageDatas(
			@RequestParam(value="userId",required=false)String userId,
			HttpServletRequest request) {
		List<UserOriginImage> userAnnotaionImages = this.userOriginImageService.findUserOriginImageByUserId(userId);
		return new ResultMapUtils(userAnnotaionImages);
		
	}
}
