package com.fc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestFile {
    public static String audioFileName = "audio.mp3";
    public static String videoFileName = "video.mp4";
    public static void main(String[] args) {
        File file = new File("/Users/fanchen/Movies/b站学习视频/SpringCloud从小白到精通教程-黑马程序员的副本");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (!".DS_Store".equals(file1.getName())){
                File[] filesArray = file1.listFiles();
                for (File file2 : filesArray) {
                    if ("80".equals(file2.getName()) || "80" == file2.getName()){
                        File[] fileList = file2.listFiles();
                        for (File file3 : fileList) {
                            System.out.println(file3.getName());
                            if ("audio.m4s".equals(file3.getName())){
                                String path = file3.getPath();
                                String fileName = path.substring(0,path.lastIndexOf("/")+1);
                                String moveFileName = fileName.substring(0,fileName.lastIndexOf("/", 70)+1);
                                String newFileName = fileName + audioFileName;
                                File newFile = new File(newFileName);
                                file3.renameTo(newFile);

                                //移动文件到上层目录
                                try {

                                    FileInputStream fis = new FileInputStream(newFile);//创建输入流对象
                                    String newMoveFile = moveFileName + audioFileName;
                                    FileOutputStream fos = new FileOutputStream(newMoveFile); //创建输出流对象
                                    byte datas[] = new byte[1024*8];//创建搬运工具
                                    int len = 0;//创建长度
                                    while((len = fis.read(datas))!=-1)//循环读取数据
                                    {
                                        fos.write(datas,0,len);
                                    }
                                    fis.close();//释放资源
                                    fis.close();//释放资源

                                }catch (Exception e){
                                    e.printStackTrace();
                                }

                                System.out.println(moveFileName);
                            } else if ("video.m4s".equals(file3.getName())){
                                String path = file3.getPath();
                                String fileName = path.substring(0,path.lastIndexOf("/")+1);
                                String moveFileName = fileName.substring(0,fileName.lastIndexOf("/", 70)+1);
                                String newFileName = fileName + videoFileName;
                                File newFile = new File(newFileName);
                                file3.renameTo(newFile);
                                //移动文件到上层目录
                                try {

                                    FileInputStream fis = new FileInputStream(newFile);//创建输入流对象
                                    String newMoveFile = moveFileName + videoFileName;
                                    FileOutputStream fos = new FileOutputStream(newMoveFile); //创建输出流对象
                                    byte datas[] = new byte[1024*8];//创建搬运工具
                                    int len = 0;//创建长度
                                    while((len = fis.read(datas))!=-1)//循环读取数据
                                    {
                                        fos.write(datas,0,len);
                                    }
                                    fis.close();//释放资源
                                    fis.close();//释放资源

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                System.out.println(newFileName);
                            } else if ("index.json".equals(file3.getName())){
                                file3.delete();
                            }
                        }
                    } else if ("danmaku.xml".equals(file2.getName())){
                        file2.delete();
                    } else if ("entry.json".equals(file2.getName())){
                        file2.delete();
                    }
                }
            }
            
        }
        for (File file1 : files) {
            if (!".DS_Store".equals(file1.getName())){
                File[] filesArray = file1.listFiles();
                for (File file2 : filesArray) {
                    if ("80".equals(file2.getName()) || "80" == file2.getName()){
                        File[] fileList = file2.listFiles();
                        for (File file3 : fileList) {
                            file3.delete();
                        }
                        file2.delete();
                    }
                }
            }
        }
    }
}
