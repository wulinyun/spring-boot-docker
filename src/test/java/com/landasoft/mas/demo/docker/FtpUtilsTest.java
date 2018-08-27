package com.landasoft.mas.demo.docker;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.landasoft.mas.demo.docker.utils.FtpUtil;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FtpUtilsTest {

	@Test
	public void test1() {
		String ftpHost = "192.168.0.191";
        String ftpUserName = "test";
        String ftpPassword = "test";
        int ftpPort = 21;
        String ftpPath = "colleague/";
        String localPath = "D:\\src\\test.jpg";
        String fileName = "wulinyun.jpg";

        //上传一个文件
        try{
            FileInputStream in=new FileInputStream(new File(localPath));
            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,in);
            System.out.println(test);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e);
        }
	}
	@Test
	public void test2() {
		String ftpHost = "192.168.0.191";
        String ftpUserName = "test";
        String ftpPassword = "test";
        int ftpPort = 21;
        String ftpPath = "colleague/";
        String localPath = "D:\\src\\";
        String fileName = "wulinyun.jpg";
        //下载一个文件
        FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);
	}
	@Test
	public void test3() {
		String ftpHost = "192.168.0.191";
        String ftpUserName = "test";
        String ftpPassword = "test";
        int ftpPort = 21;
        String ftpPath = "colleague/";
        String localPath = "D:\\src\\test.txt";
        String fileName = "test.txt";

        //上传一个文件
        try{
            FileInputStream in=new FileInputStream(new File(localPath));
            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,in);
            System.out.println(test);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e);
        }

        //在FTP服务器上生成一个文件，并将一个字符串写入到该文件中
        try {
            InputStream input = new ByteArrayInputStream("test ftp jyf".getBytes("GBK"));
            boolean flag = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,input);
            System.out.println(flag);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}
}
