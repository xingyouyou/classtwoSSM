package com.bdqn.controller;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @ClassName UploadController
 * @Description: TODO 上传控制器
 * @Author: xqj
 * @Date: 2019/9/10 9:10
 * @Version v1.0
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private static Logger log = Logger.getLogger(UploadController.class);

    /**
     * description: TODO 显示上传文件页面
     * create time: 2019/9/7 14:37
     * [multi]
     * @return java.lang.String
     */
//    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    @GetMapping(value = "/index")
    public String showUploadPage(@RequestParam(value = "multi", required = false) Boolean multi) {
        if (multi != null && multi) {
            return "course_admin/multifile";
        }
        return "course_admin/file";
    }

    /**
     * @Description:处理单文件上传
     * @param: [file]
     * @return: java.lang.String
     * @Date: 2019/07/12 9:29
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            log.debug(file.getOriginalFilename());
            log.debug(file.getName());
            log.debug(file.getBytes());
            log.debug(file.getSize());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("H:\\temp\\test\\", System.currentTimeMillis() + file.getOriginalFilename()));
        }
        return "course_admin/success";
    }

    /**
     * @Description: TODO 处理多文件上传
     * @param: [multiRequest]
     * @return: java.lang.String
     * @Date: 2019/07/12 9:30
     */
//    @RequestMapping(value = "/doUpload2", method = RequestMethod.POST)
    @PostMapping(value = "/doUpload2")
    public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException {
        Iterator<String> filesNames = multiRequest.getFileNames();
        while (filesNames.hasNext()) {
            String fileName = filesNames.next();
            MultipartFile file = multiRequest.getFile(fileName);
            if (!file.isEmpty()) {
                log.debug(file.getOriginalFilename());
                log.debug(file.getName());
                log.debug(file.getBytes());
                log.debug(file.getSize());
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("H:\\temp\\test\\", System.currentTimeMillis() + file.getOriginalFilename()));
            }

        }

        return "course_admin/success";
    }
}
