package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.exception.GgktException;
import com.atguigu.ggkt.model.vod.Video;
import com.atguigu.ggkt.vod.service.VideoService;
import com.atguigu.ggkt.vod.service.VodService;
import com.atguigu.ggkt.vod.utils.ConstantPropertiesUtil;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.netflix.config.DeploymentContext.ContextKey.appId;

@Service
public class VodServiceImpl implements VodService {
    @Autowired
    private VideoService videoService;
    //上传视频
    @Override
    public String uploadVideo(InputStream inputStream, String originalFilename) {
        try {
            VodUploadClient client =
                    new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                            ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            VodUploadRequest request = new VodUploadRequest();
            //视频本地地址
            request.setMediaFilePath("D:\\test2.mp4");
            //指定任务流
            request.setProcedure("LongVideoPreset");
            //调用上传方法，传入接入点地域及上传请求。
            VodUploadResponse response = client.upload("ap-guangzhou", request);
            //返回文件id保存到业务表，用于控制视频播放
            String fileId = response.getFileId();
            System.out.println("Upload FileId = {}"+response.getFileId());
            return fileId;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
      }
      //删除视频
      @Override
      public void removeVideo(String videoSourceId) {
          try{
              // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
              Credential cred =
                      new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID,
                              ConstantPropertiesUtil.ACCESS_KEY_SECRET);
              // 实例化要请求产品的client对象,clientProfile是可选的
              VodClient client = new VodClient(cred, "");
              // 实例化一个请求对象,每个接口都会对应一个request对象
              DeleteMediaRequest req = new DeleteMediaRequest();
              req.setFileId(videoSourceId);
              // 返回的resp是一个DeleteMediaResponse的实例，与请求对象对应
              DeleteMediaResponse resp = client.DeleteMedia(req);
              // 输出json格式的字符串回包
              System.out.println(DeleteMediaResponse.toJsonString(resp));
          } catch (TencentCloudSDKException e) {
              System.out.println(e.toString());
          }
      }

    //点播视频播放接口
    @Override
    public Map<String, Object> getPlayAuth(Long courseId, Long videoId) {
        //根据小节id获取小节对象，获取腾讯云视频id
        Video video = videoService.getById(videoId);
        if(video == null) {
            throw new GgktException(20001,"小节信息不存在");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("videoSourceId",video.getVideoSourceId());
        map.put("appId",appId);
        return map;
    }


}

