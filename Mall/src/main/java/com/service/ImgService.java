package com.service;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.ProgressListener;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ImgService {
    public static boolean configImg(HttpServletRequest req, String path, String tmpPath){
        System.out.println("路径：" + path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }

        System.out.println("临时文件路径:"+tmpPath);
        File file1 = new File(tmpPath);
        if (!file1.exists()) {
            file1.mkdir();
        }

        try{
            //通过工厂设置缓冲区
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(1024 * 1024);//缓冲区大小为1M
            diskFileItemFactory.setRepository(file1);

            //2.获取ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            //监听文件上传进度
            servletFileUpload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long pBytesRead, long pContentLength, int pItems) {
                    System.out.println("总大小:" + pContentLength + ",已上传:" + pBytesRead);
                }
            });
            servletFileUpload.setHeaderEncoding("UTF-8");//处理编码
            servletFileUpload.setFileSizeMax(1024L * 1000024 * 10);//设置单个文件的最大值
            servletFileUpload.setSizeMax(1024L * 1020004 * 10);//设置总共能上传文件的大小

            @SuppressWarnings("unchecked")
            List<FileItem> fileItems = servletFileUpload.parseRequest(new ServletRequestContext(req));

            String cname = null;
            int num = -1;
            double price = -1;
            boolean flag = true;
            for (FileItem fileItem:fileItems) {
                System.out.println(fileItem.getName());
                if(fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName() + "  --->  " + fileItem.getString("UTF-8"));
                    if("cname".equals(fileItem.getFieldName())){    //判断表单name
                        cname = fileItem.getString("UTF-8");               //获取val
                        if("null".equals(cname)) flag = false;
                    } else if("price".equals(fileItem.getFieldName())){
                        price = Double.parseDouble(fileItem.getString());
                        if(price == -1) flag = false;
                    } else if("num".equals(fileItem.getFieldName())){
                        num = Integer.parseInt(fileItem.getString());
                        if(num == -1) flag = false;
                    }
                } else {
                    String name = fileItem.getName();
                    if (name == null || name.trim().equals("")) continue;    //文件为空
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream out = new FileOutputStream(path + "/good/" + cname + ".jpeg");
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = in.read(bytes)) > 0) {
                        out.write(bytes, 0, len);
                    }
                    //上传成功关闭流
                    in.close();
                    out.close();
                    //上传成功清理临时文件
                    fileItem.delete();
                }
            }
            if(flag){
                int res = CommodityService.addCommodity(cname,num,price);
                if(res == -1) {
                    File dee = new File(path + "/" + cname + ".jpeg");
                    if(dee.exists()) dee.delete();
                    flag = false;
                }
            } else {
                File dee = new File(path + "/" + cname + ".jpeg");
                if(dee.exists()) dee.delete();
            }
            return flag;
        } catch (Exception e){
            e.printStackTrace();
        }
    return false;
    }
}
