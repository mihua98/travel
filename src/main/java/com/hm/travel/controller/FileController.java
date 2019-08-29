package com.hm.travel.controller;

import com.hm.travel.pojo.FileUpLoad;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * 文件控制类
 *
 * @author: xiaomikasa
 * @date: 2019/8/29
 */
@Controller
public class FileController {

    /**
     * 文件上传
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpLoad")
    @ResponseBody
    public FileUpLoad fileUpLoad(HttpServletRequest request, @RequestParam("editormd-image-file") MultipartFile upload) throws Exception {
        if (upload.isEmpty()) {
            FileUpLoad fileUpLoad = new FileUpLoad();
            fileUpLoad.setSuccess(0);
            fileUpLoad.setMessage("上传失败!");
            return fileUpLoad;
        }
        //获取项目路径
        File rootdir = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!rootdir.exists()) {
            rootdir = new File("");
        }
        //获取上传的资源文件路径
        File path = new File(rootdir.getAbsolutePath(), "src/main/resources/static/upload/");
        if (!path.exists()) {
            path.mkdirs();
        }
        //获取字节码文件路径
        File targetPath = new File(rootdir.getAbsolutePath(), "target/classes/static/upload/");
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }

        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //完成文件上传,到字节码文件路径下
        File out = new File(targetPath, filename);
        upload.transferTo(out);

        //文件复制到资源文件路径下
        try (FileOutputStream os = new FileOutputStream(new File(path, filename))) {
            FileSystemResource resource = new FileSystemResource(out);
            FileCopyUtils.copy(resource.getInputStream(), os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建markdown图片上传所需的对象
        FileUpLoad fileUpLoad = new FileUpLoad();
        fileUpLoad.setSuccess(1);
        fileUpLoad.setMessage("上传成功!");
        fileUpLoad.setUrl("/upload/" + filename);
        return fileUpLoad;
    }
}
