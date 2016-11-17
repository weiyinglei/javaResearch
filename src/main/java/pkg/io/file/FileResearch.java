package pkg.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 列出目录并排序
 */
public class FileResearch {
    public static void main(String[] args) {
        List<String> featuresTest = getList("D:\\app\\eclipse\\eclipseNeonJavaEETest\\features");
        List<String> pluginsTest = getList("D:\\app\\eclipse\\eclipseNeonJavaEETest\\plugins");
        List<String> features = getList("D:\\app\\eclipse\\eclipseNeonJavaEE\\features");
        List<String> plugins = getList("D:\\app\\eclipse\\eclipseNeonJavaEE\\plugins");

        featuresTest.removeAll(features);
        pluginsTest.removeAll(plugins);

        System.out.println(featuresTest);
        System.out.println(pluginsTest);
        System.out.println(featuresTest.size());
        System.out.println(pluginsTest.size());
    }

    public static List<String> getList(String filePath){
        List<String> fileList = new ArrayList<String>();
        // 获取当前目录
        File path = new File(filePath);// .表示当前目录
        // 文件路径名数组
        String list[] = path.list();

        for (int i = 0; i < list.length; i++) {
            fileList.add(list[i]);
        }

        return fileList;
    }
}