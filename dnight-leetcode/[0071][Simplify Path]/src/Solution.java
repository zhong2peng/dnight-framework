import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/12
 */
public class Solution {

    /**
     * Given an absolute path for a file (Unix-style), simplify it. Or in other words,
     * convert it to the canonical path.
     * <p>
     * In a UNIX-style file system, a period . refers to the current directory.
     * Furthermore, a double period .. moves the directory up a level.
     * For more information, see: Absolute path vs relative path in Linux/Unix
     * <p>
     * Note that the returned canonical path must always begin with a slash /,
     * and there must be only a single slash / between two directory names.
     * The last directory name (if it exists) must not end with a trailing /.
     * Also, the canonical path must be the shortest string representing the absolute path.
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        List<String> result = new ArrayList<>();
        for (String part : ss) {
            if (".".equals(part)) {
                continue;
            } else if ("..".equals(part)) {
                if (result.size() > 0) {
                    result.remove(result.size() - 1);
                }
            } else if (!"".equals(part.trim())) {
                result.add(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String part : result) {
            sb.append("/").append(part);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
