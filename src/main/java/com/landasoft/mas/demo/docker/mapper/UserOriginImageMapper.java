package com.landasoft.mas.demo.docker.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.landasoft.mas.demo.docker.model.vo.UserOriginImage;

import java.util.List;

/**
 * 用户信息操作mapper接口
 * @author wulinyun
 * @version 2017年9月8日下午1:29:46
 */
@Mapper
public interface UserOriginImageMapper {
	/**
	 * 查询某个用户的人脸图片
	 * @param userId 用户id
	 * @return
	 */
	public List<UserOriginImage> findUserOriginImageInfo(@Param("userId")String userId);
	
	/**
	 * 插入某个用户的人脸图片
	 * @param userOriginImage 
	 * @return
	 */
	public int insertUserOriginImageInfo(UserOriginImage userOriginImage);
	
	/**
	 * 更新某个用户的人脸图片
	 * @param userOriginImage
	 * @return
	 */
	public int updateUserOriginImageInfo(UserOriginImage userOriginImage);
}
