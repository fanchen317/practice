package com.fc.sync;

/**
 * @Author fanchen
 * @Date 2022/6/6 17:56
 */
public class User {
    // 柜子
    private Cabinet cabinet;

    // 存储的数字
    private int storeNumber;

    public User(Cabinet cabinet, int storeNumber) {
        this.cabinet = cabinet;
        this.storeNumber = storeNumber;

    }

    // 表示使用柜子
    public void useCabinet() {
        cabinet.setStoreNumber(storeNumber);
    }
}
