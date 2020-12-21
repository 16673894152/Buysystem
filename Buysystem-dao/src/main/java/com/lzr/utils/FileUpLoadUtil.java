package com.lzr.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具类
 * @author 李锦程
 */
public class FileUpLoadUtil {

    /**
     * 上传文件到服务器, 文件存储目录: webapp\resource\...
     * @param multipartFile 文件对象
     * @param request 请求对象
     * @param dir 选填 文件在resource文件夹的子路径位置
     * @return 文件路径名称
     */
    public static String upload(MultipartFile multipartFile, HttpServletRequest request, String dir) throws IOException {
        if (dir == null) dir = "";
        else dir += "/";
        String filename = multipartFile.getOriginalFilename();
        if (filename == null) throw new NullPointerException();
        filename = java.util.UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf('.'));
        //获取项目当前运行的路径     上下文对象
        String path = request.getServletContext().getRealPath("/resource/" + dir);
        String path2 = path.substring(0,path.indexOf("Buysystem-web") + 13) + "\\src\\main\\webapp\\resource\\" + dir.replaceAll("/","\\\\");
        File file = new File(path2);
        if (!file.exists()) file.mkdirs();
        //将文件保存到该路径下
        multipartFile.transferTo(new File(path2, filename));
        return "/resource/" + dir + filename;
    }

}
