package com.coco.demo.hadooprpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyProtocol extends VersionedProtocol {
    public String println(String t);
}
