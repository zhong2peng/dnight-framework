import java.io.File;

/**
 * @author ZHONGPENG769
 * @date 2019/6/27
 */
public class FileRename {
    public static void main(String[] args) {
        String pathName = "/Users/zhongpeng/Desktop/git/github/dnight-framework/dnight-leetcode";
        File path = new File(pathName);

        File[] files = path.listFiles();
        renameFile(files);
    }

    public static void renameFile(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                renameFile(f.listFiles());
            }
        }

        for (File f : files) {
            String name = f.getName();
            name = name.replaceFirst("【","[0");
            name = name.replace("【", "[");
            name = name.replaceAll("】", "]");
            name = name.replaceAll("（","(");
            name = name.replaceAll("）", ")");
            System.out.println(name);
            f.renameTo(new File(f.getParent() + "/" + name));
        }
    }
}
