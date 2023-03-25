package com.fc;

import com.fc.entity.ListNode;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        //测试能否交换数值
        //SortAlgorithm.QuickSwap(new int[]{1, 2, 3, 4, 5},1,2);
        //测试选择排序能否使用
        //SortAlgorithm.selectionSort(new int[]{3, 4, 2, 3, 1});
        //Solution.findNumberIn2DArray(new int[][]{},0);
        //System.out.println(Solution.replaceSpace("     "));
        //System.out.println(Solution.fib(3));
        //System.out.println(Solution.numWays(100));
//        System.out.println(Solution2.cuttingRope(10));
//        int n = 2;
//        System.out.println(n &= n -1);
//        System.out.println(Solution2.hammingWeight(11));

//        System.out.println(Solution2.isMatch("aab", "c*a*b"));


        String str = "@Result(name = \"queryTrader_1\", type = \"json\", params = { \"root\", \"listVo\" }),\n" +
                "\t       @Result(name = \"queryConsumerList\", type = \"json\", params = { \"root\", \"comsumerList\" }), \n" +
                "\t       @Result(name = \"comsumerService\", type = \"json\", params = { \"root\", \"trades\" }), \n" +
                "\t       @Result(name = \"providerService\", type = \"json\", params = { \"root\", \"services\" }), \n" +
                "\t       @Result(name = \"queryProviderService\", type = \"json\", params = { \"root\", \"serviceVo\" }),\n" +
                "\t       @Result(name = \"consumerService\", type = \"json\", params = { \"root\", \"services\" }),\n" +
                "\t       @Result(name = \"comsumerServiceCount\", type = \"json\", params = { \"root\", \"dealResult\" }), \n" +
                "\t       @Result(name = \"providerServiceComsumer\", type = \"json\", params = { \"root\", \"trades\" }), \n" +
                "\t       @Result(name = \"findServiceConsumerProvider\", type = \"json\", params = { \"root\", \"trades\" }), \n" +
                "\t       @Result(name = \"queryTrader\", type = \"json\", params = { \"root\", \"trades\" }), \n" +
                "\t       @Result(name = \"queryMoreService\", location = \"serviceView/serviceTop/moreServiceList_list.jsp\"),\n" +
                "\t       @Result(name = \"queryProviderMoreSer\", location = \"serviceView/serviceTop/moreServiceList_list.jsp\"), \n" +
                "\t       @Result(name = \"toQualityMonitor\", location = \"countQuery/qualityMonitor.jsp\"), \n" +
                "\t       @Result(name = \"toRealtimeControl\", location = \"realMonitor/realMonitor.jsp\")";
        String[] split = str.split("@Result");
        List<String> strs = new ArrayList<>();
        List<Result> results = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < split.length; i++) {
            int len = split[i].trim().length();

            if (i != split.length - 1) {
                String substring = split[i].substring(1, len - 2);
                strs.add(substring);
            } else {
                String substring = split[i].substring(1, len - 1);
                strs.add(substring);
            }
        }
        for (String s : strs) {
//            System.out.println(s);
            if (s.contains("location")) {
                String[] ss = s.split(",");
                Result result = new Result();
                for (String s1 : ss) {
                    if (s1.contains("name")) {
                        String[] split1 = s1.trim().split("\"");
                        result.setName(split1[1]);
                    }
                    if (s1.contains("location")) {
                        String[] split1 = s1.trim().split("\"");
                        result.setLocation(split1[1]);
                    }
                }
                results.add(result);
            }
            if (s.contains("params")) {
                Result result = new Result();
                String[] ss = s.split("params");
                for (String s1 : ss) {
                    if (!s1.contains("name") && !s1.contains("type")) {
                        String[] split1 = s1.trim().split("\"");
                        result.setKey(split1[1]);
                        result.setValue(split1[3]);
                    } else {
                        if (s1.contains("}")) {
                            String[] split1 = s1.trim().split("\"");
                            result.setType(split1[5]);
                            result.setKey(split1[1]);
                            result.setValue(split1[3]);
                        } else {
                            if (s1.contains("type")) {
                                String[] split1 = s1.trim().split("\"");
                                result.setName(split1[1]);
                                result.setType(split1[3]);
                            } else {
                                String[] split1 = s1.trim().split("\"");
                                result.setName(split1[1]);
                            }

                        }
                    }
                }
                results.add(result);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (Result result : results) {
            if (result.getLocation() == null) {
                sb.append("<result name=\"" + result.getName() + "\" type=\"" + result.getType() + "\">\n<param name=\"" + result.getKey() + "\">" + result.getValue() + "</param>\n</result>");
            } else {
                sb.append("<result name=\"" + result.getName() + "\">\n" + result.getLocation() + "\n</result>");
            }
//            System.out.println(result.toString());
        }
        System.out.println(sb.toString());
    }



}
