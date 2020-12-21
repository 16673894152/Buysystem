package com.lzr.control;

import com.lzr.utils.FileUpLoadUtil;
import com.lzr.vo.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传控制器
 */
@RestController
public class FileUpLoadController {


    /**
     * 文件上传
     * @param file 文件对象
     * @param dir 选填 文件在resource文件夹的子路径位置
     * @param request 请求对象
     * @return 消息对象, 包含是否成功, 如果成功, 消息中将包含文件访问路径
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    @CrossOrigin
    public Message upload(@RequestParam("file") MultipartFile file,
                          String dir,
                          HttpServletRequest request) {
        try {
            String fileName = FileUpLoadUtil.upload(file,request,dir);
            return new Message(true,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Message(false,"文件上传失败, 请检查原因!");
    }

}
