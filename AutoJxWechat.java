package com.example.administrator.autojxweichat;

import android.graphics.Rect;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.*;

//import android.support.test.uiautomator.UiDevice;
//import android.support.test.uiautomator.UiObject;
//import android.support.test.uiautomator.UiObject2;
//import android.support.test.uiautomator.UiObjectNotFoundException;
//import android.support.test.uiautomator.UiScrollable;
//import android.support.test.uiautomator.UiSelector;
//import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static android.R.attr.id;
import static android.support.test.uiautomator.By.text;
import static java.lang.Thread.sleep;
//TODO
public class AutoJxWechat {
    static final int LAUNCH_TIMEOUT = 5000;
    private UiDevice mUiDevice;
    private UiObject2 MMapp;
    private UiSelector elementSelector = new UiSelector();
    static String neirong = ",时间过得真快，马上又到年底了。2017就要结束了。";
    static String TAG = "ceshiwei";

    @Before
    public void startMMApp() throws IOException {
        mUiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        mUiDevice.pressHome();
//
//        MMapp = mUiDevice.findObject(text("微信"));
//        MMapp.clickAndWait(Until.newWindow(), LAUNCH_TIMEOUT);

    }

    @Test
    public void setContacts() throws UiObjectNotFoundException, InterruptedException {
        //click add icon
        //UiObject addIcon = mUiDevice.findObject(elementSelector.text("通讯录"));
        //addIcon.click();
        int width = mUiDevice.getDisplayWidth();
        int height = mUiDevice.getDisplayHeight();
        //UiScrollable listView = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        UiScrollable listView = new UiScrollable(new UiSelector().scrollable(true));
//        listView.flingToBeginning(50);
//        listView.setMaxSearchSwipes(200);
//
//        listView.setSwipeDeadZonePercentage(listView.getSwipeDeadZonePercentage());
//        listView.scrollIntoView(new UiSelector().textContains("梦女孩"));
        int nIndex = 0;
        sleep(1000);
        //listView = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        while (true) {

            try {
                UiScrollable listView3 = new UiScrollable(new UiSelector().scrollable(true).className("android.widget.ListView").resourceId("com.tencent.mm:id/i9"));
                Log.d(TAG, "listView3");
//                int nIndex1 = listView3.getChildCount() - 1;
                UiSelector listView4 = new UiSelector().clickable(true).className("android.widget.LinearLayout");
                Log.d(TAG, "listView4");
                // UiSelector listView4 = new UiSelector().clickable(true);
               // Log.d(TAG, Integer.toString(nIndex1));
                for (nIndex = 0; nIndex < 7; nIndex++) {

                    UiObject contact = listView3.getChildByInstance(listView4, nIndex);

                    contact.waitForExists(6000);
                    String mz =  contact.getChild(new UiSelector().resourceId("com.tencent.mm:id/ir")).getText();
                    if (mz.contains("84") || mz.contains("自考") || mz.contains("83") || mz.contains("82") || mz.contains("离") || mz.contains("鹊")) {
                        continue;
                    }
                    contact.click();
                    UiObject nicheng = mUiDevice.findObject(new UiSelector().textContains("昵称"));
                    //UiObject mingzi = mUiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/nm"));

                    Log.d(TAG, mz);

                    String nc = "你好";

                    Log.d(TAG, Integer.toString(nIndex));

                    if (nicheng.exists()) {
                        nc = nicheng.getText();
                        nc = nc.substring(3, (nc.length() < 10 ? nc.length() : 10));
                    } else  {
                        nc = mz;
                        nc = nc.substring(0, (nc.length() < 4 ? nc.length() : 4));
                    }
                    Log.d(TAG, nc);
                    sleep(2000);
                    // UiObject contactsend = mUiDevice.findObject(new UiSelector().text("发消息"));
                    UiObject contactsend = mUiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/akw"));
                    if (contactsend.waitForExists(5000)) {
                        contactsend.click();
                    }
                    UiObject sendtext = mUiDevice.findObject(new UiSelector().className("android.widget.EditText"));
                    UiObject yuyin = mUiDevice.findObject(new UiSelector().textContains("按住 说话"));
                    if (yuyin.exists()) {
                        mUiDevice.findObject(new UiSelector().resourceId("com.tencent.mm:id/a5c")).click();

                    }
                    sendtext.waitForExists(2000);
                    if (sendtext.exists()) {
                        Log.d(TAG, "sendtext.exists()");

                        if (false&& !mUiDevice.findObject(new UiSelector().textContains(neirong)).exists() && !mUiDevice.findObject(new UiSelector().textContains("开启了朋友")).exists()) {
                            sendtext.setText(nc+neirong);
                            UiObject sendtext1 = mUiDevice.findObject(new UiSelector().text("发送"));
                            sendtext1.waitForExists(5000);
                            sendtext1.click();

                        }


                        boolean verification1 = mUiDevice.findObject(new UiSelector().textContains("发送朋友验证")).exists();
                        boolean verification2 = mUiDevice.findObject(new UiSelector().textContains("拒收")).exists();

                        if (verification2) {
                            UiObject back = mUiDevice.findObject(new UiSelector().descriptionContains("聊天信息"));
                            back.clickAndWaitForNewWindow();

                            UiObject contac = listView.getChildByInstance(new UiSelector().clickable(true).className("android.widget.RelativeLayout"), 0);
                            contac.clickAndWaitForNewWindow();


                            UiObject cont1 = mUiDevice.findObject(new UiSelector().descriptionContains("更多"));
                            cont1.clickAndWaitForNewWindow();


                            UiObject cont2 = mUiDevice.findObject(new UiSelector().text("删除"));
                            cont2.clickAndWaitForNewWindow();

                            UiObject cont3 = mUiDevice.findObject(new UiSelector().text("删除"));
                            cont3.clickAndWaitForNewWindow();

                            UiObject cont4 = mUiDevice.findObject(new UiSelector().text("通讯录"));
                            cont4.click();
                        }
                        if (verification1) {

                            UiObject yanzhen = mUiDevice.findObject(new UiSelector().textContains("发送朋友验证"));
                            Rect viewRect = yanzhen.getBounds();//获取Rect对象，Rect里面就有我们需要的坐标
                            int x = viewRect.right;    //这是的X坐标
                            int y = viewRect.bottom;    //这是的Y坐标
//
                            UiObject shenqing = mUiDevice.findObject(new UiSelector().textContains("验证申请"));
                            while (!shenqing.exists()) {
                                mUiDevice.click(x - 100, y - 50);   //稍微缩进点，点击坐标
                                x = x - 100;
                                sleep(1000);
                                Log.d(TAG, Integer.toString(x));
                                if (x < 100) {
                                    break;
                                }
                            }
                            sleep(1000);
                            UiObject sendtext3 = mUiDevice.findObject(new UiSelector().className("android.widget.EditText"));
                            UiObject queding = mUiDevice.findObject(new UiSelector().text("确定"));
                            if (queding.exists()) {
                                sendtext3.setText(nc + "，佳缘好友，无兴趣请忽略");
                                Log.d(TAG, "sendtext3.setText(nc + \"，还是单身吗？\");");
                                queding.clickAndWaitForNewWindow();
                            }


                        }


                        UiObject back1 = mUiDevice.findObject(new UiSelector().descriptionContains("返回"));
                        back1.click();

                        UiObject cont = mUiDevice.findObject(new UiSelector().text("通讯录"));
                        cont.click();
                        Log.d(TAG, "返回通讯录.click()");


                    }
                }


                mUiDevice.swipe(width / 2, height / 8 * 7, width / 2, height / 8 * 1, 100);

                sleep(300);
                UiObject contactNum = mUiDevice.findObject(new UiSelector().textContains("位联系人"));
                if (contactNum.exists()) {
                    break;
                }
            } catch (UiObjectNotFoundException e) {
                UiObject cont2 = mUiDevice.findObject(new UiSelector().text("发现"));

                if (cont2.exists()) {
                    cont2.click();
                    UiObject cont3 = mUiDevice.findObject(new UiSelector().text("通讯录"));
                    cont3.click();
                    mUiDevice.swipe(width / 2, height / 8 * 4, width / 2, height / 8 * 1, 100);
                } else {
                    mUiDevice.pressBack();

                    if (cont2.exists()) {
                        cont2.click();
                        UiObject cont3 = mUiDevice.findObject(new UiSelector().text("通讯录"));
                        cont3.click();
                        mUiDevice.swipe(width / 2, height / 8 * 4, width / 2, height / 8 * 1, 100);
                    }
                }


            }
        }
    }
}




