package testPackage.general;
import java.util.*;

/**
 * Created by bajmd on 09/12/18.
 */
public class AmazonForeandBack {

    class ForeBackGround {
        private int foreGround;
        private int backGround;
        private int usage;
        public ForeBackGround (int foreGround, int backGround, int foreUsage, int backUsage) {
            this.foreGround = foreGround;
            this.backGround = backGround;
            this.usage = foreUsage + backUsage;
        }

    }

    List<List<Integer>> optimalUtilization (int deviceCapacity,
                                            List<List<Integer>> foreGroundAppList,
                                            List<List<Integer>> backGroundAppList) {
        PriorityQueue<ForeBackGround> usageQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (List<Integer> foreList : foreGroundAppList) {
            for (List<Integer> backList : backGroundAppList) {
                usageQueue.offer(new ForeBackGround(foreList.get(0), backList.get(0), foreList.get(1), backList.get(1)));
            }
        }

        List<List<Integer>> optimalProcessList = new ArrayList<>();
        ForeBackGround prevProcess = null;

        while (!usageQueue.isEmpty()) {
            ForeBackGround currProcess = usageQueue.poll();
            if (currProcess.usage <= deviceCapacity) {
                if (optimalProcessList.isEmpty()) {
                    List <Integer> processList = new ArrayList<>();
                    processList.add(currProcess.foreGround);
                    processList.add(currProcess.backGround);
                    optimalProcessList.add(processList);
                    prevProcess = currProcess;
                }
                else if (prevProcess.usage == currProcess.usage) {
                    List <Integer> processList = new ArrayList<>();
                    processList.add(currProcess.foreGround);
                    processList.add(currProcess.backGround);
                    optimalProcessList.add(processList);
                    prevProcess = currProcess;
                }
                else
                    return optimalProcessList;
            }
        }
        return optimalProcessList;
    }
}
