package com.hatester.helpers;

import java.io.File;

public class SystemHelper {
    //Lấy ra đường dẫn từ ổ đĩa tới source code hiện tại của mình  ---   E:\BT_Locator_TrainingAutoTest
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
