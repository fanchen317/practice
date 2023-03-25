package com.fc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class StringOper {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        String str = "CREATETIME,HEADTIME,SNDR,RCVR,SEQN,DDTM,FFID,AWCD,FLNO,FDATE,GATE,BCTM,DEPT,DEPTNO,DEST,DESTNO," +
                "LSTA_PAX,LSTA_GPXN,LSTA_CPXN,LSTA_EPXN,LSTA_VIPN,LSTA_BAGN,LSTA_RBAGN,LSTA_WCHR,LSTA_AVIHBAGN," +
                "TRTA_PAX,TRTA_GPXN,TRTA_CPXN,TRTA_EPXN,TRTA_VIPN,TRTA_BAGN,TRTA_RBAGN,TRTA_WCHR,TRTA_AVIHBAGN";
        String[] ss = str.split(",");
        for (String s : ss) {
            System.out.println("dwdPut.addColumn(COLUMNFAMILY,Bytes.toBytes(\""+s.toLowerCase()+"\"),Bytes.toBytes("+s.toLowerCase()+"));");
        }
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyy", Locale.ENGLISH);
//        System.out.print(sdf.format(date));
    }
}
