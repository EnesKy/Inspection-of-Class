package com.fsmvu.inspectionofclass.pi;

/**
 * Created by Liang on 2016/3/7.
 */
public class ReadRFID {

    public static void main(String[] args) throws InterruptedException {

        while (true) {

            RaspRC522 rc522 = new RaspRC522();
            String strUID;
            byte tagid[] = new byte[5];

            rc522.Select_MirareOne(tagid);
            strUID = RFIDConverter.bytesToHex(tagid);
            if (!strUID.toString().equals("0000000000")) {
                System.out.println("Kart okunuyor...");
                System.out.println("Kart değeri : " + strUID.toString());
                Thread.sleep(500);
            }

        }
    }
}
