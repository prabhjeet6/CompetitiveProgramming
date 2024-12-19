package leetcode.stacks;


import java.util.Stack;

class Solution {
    public static void main(String[] as) {
        System.out.println(simplifyPath("/home/"));// "/home"
        System.out.println(simplifyPath("/home//foo/"));// "/home/foo"
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); // "/home/user/Pictures"
        System.out.println(simplifyPath("/../")); // "/"
        System.out.println(simplifyPath("/.../a/../b/c/../d/./")); // "/.../b/d"
        System.out.println(simplifyPath("/a/./b/../../c/")); // "/c"
        System.out.println(simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
        System.out.println(simplifyPath("/home/of/foo/../../bar/../../is/./here/.")); // "/a/b/c"

    }

    public static String simplifyPath(String path) {
        StringBuilder canonicalPath = new StringBuilder();
        String[] pathsArray = path.split("/");
        Stack<String> unixStack = new Stack<>();
        int parentdirectoryOps = 0;
        for (String subPath : pathsArray) {
            unixStack.push(subPath);
        }
        while (!unixStack.isEmpty()) {
            String top = unixStack.peek();
            if ("".equals(top) || ".".equals(top)) {
                unixStack.pop();
            } else if ("..".equals(top)) {
                while ("..".equals(top)) {
                    parentdirectoryOps++;
                    unixStack.pop();
                    top = unixStack.peek();
                }
                while (!unixStack.isEmpty()&&parentdirectoryOps > 0) {
                    top = unixStack.peek();
                    if (!(".".equals(top)||"".equals(top)||"..".equals(top))) {
                        parentdirectoryOps--;
                    }
                    if("..".equals(top)){
                        parentdirectoryOps++;
                    }
                    unixStack.pop();
                }

            } else {
                canonicalPath = new StringBuilder("/" + unixStack.pop() + canonicalPath);
            }
        }
        String resultant = canonicalPath.toString();
        return resultant.isEmpty() ? "/" : resultant;
    }
}