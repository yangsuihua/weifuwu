package com.atguigu.ggkt.vod.controller;

import com.atguigu.ggkt.vod.service.FileService;
import com.atguigu.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
//@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public Result upload(
            @RequestParam("file") MultipartFile file) {
        String uploadUrl = fileService.upload(file);
        return Result.ok(uploadUrl).message("文件上传成功");
    }

}
