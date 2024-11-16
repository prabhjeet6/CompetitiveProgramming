package leetcode.stacks;

//https://leetcode.com/problems/exclusive-time-of-functions/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class LogItem {
    int id;
    String state;
    int timeStamp;

}

class ExclusiveTimeOfFunctions {
    public static void main(String[] a) {
        String[] ls = new String[]{"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        System.out.println(Arrays.toString(exclusiveTime(1, Arrays.asList(ls))));
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        List<LogItem> logItems = new ArrayList<>();
        int max = 0;
        for (String log : logs) {
            LogItem item = new LogItem();
            String[] logString = log.split(":");
            item.id = Integer.parseInt(logString[0]);
            item.state = logString[1];
            item.timeStamp = Integer.parseInt(logString[2]);
            logItems.add(item);
        }
        Stack<LogItem> stack = new Stack<>();
        int[] ans = new int[n];
        int overlap=0;
        for (LogItem logItem : logItems) {
            if ("start".equals(logItem.state)) {
                stack.push(logItem);
            } else {
                //["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
                LogItem prev = stack.pop();
                ans[logItem.id] += logItem.timeStamp - prev.timeStamp + 1 ;
                if (!stack.isEmpty()) {
                    //subtract current method's execution timestamp from next method's(in the call stack)
                    // execution time
                    ans[stack.peek().id] -= (logItem.timeStamp - prev.timeStamp + 1);
                }

            }
        }
        return ans;
    }
}
