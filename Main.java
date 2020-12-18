package com.lzh;

import com.lzh.installChaincode.*;
import org.hyperledger.fabric.sdk.BlockEvent;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.TransactionRequest;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        FabricManager.installOneStep("operator","operatorgo","C:\\Users\\123\\Desktop\\Me\\operatorgo");
    }
}