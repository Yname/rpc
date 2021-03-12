package com.rpc.myrpc.RpcClient.NettyServer.dynamic;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileLoadImpl implements FileLoad {

    private static String pathName;


    void getFileName() throws FileNotFoundException {
        File file = new File(pathName);
        FileInputStream fileInputStream = new FileInputStream(file);
    }


    @Override
    public boolean isNotEmptyFile() {
        return false;
    }

    @Override
    public boolean isNewFile() {
        return false;
    }
}
