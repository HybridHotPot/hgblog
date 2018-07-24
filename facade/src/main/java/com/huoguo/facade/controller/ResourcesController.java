package com.huoguo.facade.controller;

import com.huoguo.util.MyApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 响应客户端请求图片，视频之类
 */
@Controller
public class ResourcesController {

    @RequestMapping(value = "/getPicture")
    public void getPicture(String url, HttpServletResponse response){
        response.setContentType("image/jpg");
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        int len=0;
        byte[] bytes=new byte[1024];
        url=MyApplication.localResourcePre+url;
        try {
            bis=new BufferedInputStream(new FileInputStream(url));
            bos=new BufferedOutputStream(response.getOutputStream());
            while ((len=bis.read(bytes))!=-1)
                bos.write(bytes,0,len);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(bis,bos);
        }
    }

    private void close(InputStream is, OutputStream os) {
        try {
            if(is!=null)
                is.close();
            if(os!=null)
                os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
