package alvintest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 001620 on 2014/9/20.
 */
public class FileTest {
    /**
     * @param path 查询文件路径
     * @return Map Boolean->true:文件夹；false：非文件夹，String：文件名/文件夹名
     */
    public static List<FileModel> queryAllFileName(String path) {

        // 查询路径
        File filePath = new File(path);
        // 路径不存在
        if (!filePath.exists()) {
            return null;
        }
        List<FileModel> fileModelList = new ArrayList<FileModel>();
        // 路径不是文件夹
        if (!filePath.isDirectory()) {
            FileModel file = new FileModel(false, path);
            fileModelList.add(file);
            return fileModelList;
        }
        // 取得路劲下文件名或文件夹名
        String[] fileNames = filePath.list();
        for (int i = 0; i < fileNames.length; i++) {
            // 判断是否为文件夹
            if ((new File(path + fileNames[i])).isDirectory()) {
                fileModelList.add(new FileModel(true, fileNames[i]));
            } else {
                fileModelList.add(new FileModel(false, fileNames[i]));
            }
        }
        return fileModelList;
    }

    public static void main(String[] args) {
        List<FileModel> fileModelList = queryAllFileName("E:\\doc-hw-project\\from_jjp\\poi_amap_csv");
        for (FileModel fileModel : fileModelList) {
            if (!fileModel.isDirectory()) {
                System.out.println(fileModel.getFileNmae());
            }
        }
    }

    static class FileModel {
        // 是否为文件夹
        private boolean isDirectory;

        // 文件名
        private String fileNmae;

        public FileModel(boolean isDirectory, String fileNmae) {
            super();
            this.isDirectory = isDirectory;
            this.fileNmae = fileNmae;
        }

        public boolean isDirectory() {
            return isDirectory;
        }

        public void setDirectory(boolean isDirectory) {
            this.isDirectory = isDirectory;
        }

        public String getFileNmae() {
            return fileNmae;
        }

        public void setFileNmae(String fileNmae) {
            this.fileNmae = fileNmae;
        }
    }
}
