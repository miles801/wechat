package com.miles.wechat.impl;

import com.miles.cache.CacheContainer;
import com.miles.wechat.api.MultiMediaService;
import com.miles.wechat.api.MultiMediaType;
import com.miles.wechat.api.WeChatUrl;
import com.miles.wechat.core.CacheAccessToken;
import com.miles.wechat.core.RequestWrapper;
import com.miles.wechat.core.WeChatContext;
import com.miles.wechat.entity.UploadInfo;
import com.miles.wechat.utils.GsonHelper;
import com.miles.wechat.utils.SimpleRequest;
import com.miles.wechat.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;

/**
 * @author miles
 * @datetime 2014/5/6 16:30
 */
public class MultiMediaServiceImpl implements MultiMediaService {

    @Override
    @SuppressWarnings("unchecked")
    public UploadInfo upload(File file, MultiMediaType type) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("上传附件到微信服务器时,附件不存在!");
        }
        ContentBody body = new FileBody(file);
        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntity.addPart("file", body);
        String url = RequestWrapper.getUrl(WeChatUrl.UPLOAD, new Serializable[]{type.getValue()});
        String result = SimpleRequest.doPost(url, multipartEntity);
        return GsonHelper.fromJson(result, UploadInfo.class);
    }

    @Override
    public File download(String mediaId, String directory) {
        if (StringUtils.isEmpty(mediaId)) {
            throw new IllegalArgumentException("从微信服务器下载附件时,没有指定附件的ID!");
        }
        File file = null;
        if (!StringUtils.isEmpty(directory)) {
            File foo = new File(directory);
            foo.mkdirs();
        }
        if (StringUtils.isEmpty(directory)) {
            directory = System.getProperty("java.io.tmpdir");
        }
        String url = RequestWrapper.getUrl(WeChatUrl.DOWNLOAD, mediaId);
        try {
            //请求获得附件
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            if (SimpleRequest.proxy != null) {
                httpClient.getParams().setParameter("http.route.default-proxy", SimpleRequest.proxy);
            }
            HttpResponse response = httpClient.execute(httpget);
            int status = response.getStatusLine().getStatusCode();
            if (status == 200) {
                Header content = response.getFirstHeader("Content-disposition");
                if (content == null || StringUtils.isEmpty(content.getValue())) {
                    throw new RuntimeException("没有获得附件信息!");
                }
                //获得附件名称
                String disposition = content.getValue();
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    String fileName = disposition.substring(index + "filename=".length() + 1, disposition.length() - 1);
                    file = new File(directory + fileName);
                }
                //将附件写入到临时目录
                InputStream input = response.getEntity().getContent();
                FileUtils.copyInputStreamToFile(input, file);
            }
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public String mediaUrl(String mediaId) {
        return RequestWrapper.getUrl(WeChatUrl.DOWNLOAD, mediaId);
    }

    @Override
    public UploadInfo uploadNews(String newsJson) {
        try {
            HttpEntity entity = new StringEntity(newsJson, "application/json", "utf-8");
            String accessToken = (String) CacheContainer.getInstance().getCachedData(CacheAccessToken.class)
                    .get(WeChatContext.get());
            String url = RequestWrapper.getUrl(WeChatUrl.UPLOAD_NEWS, accessToken);
            String result = SimpleRequest.doPost(url, entity);
            return GsonHelper.fromJson(result, UploadInfo.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UploadInfo uploadVideo(String videoJson) {
        try {
            HttpEntity entity = new StringEntity(videoJson, "application/json", "utf-8");
            String accessToken = (String) CacheContainer.getInstance().getCachedData(CacheAccessToken.class)
                    .get(WeChatContext.get());
            String url = RequestWrapper.getUrl(WeChatUrl.UPLOAD_VIDEO, accessToken);
            String result = SimpleRequest.doPost(url, entity);
            return GsonHelper.fromJson(result, UploadInfo.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
