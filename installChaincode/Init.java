package com.lzh.installChaincode;

import com.lzh.po.Fabric;
import com.lzh.po.LocalUser;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.Orderer;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Init {
    /**
     * 初始化org1peer1
     * @param name
     * @return
     * @throws Exception
     */
    public static Fabric initOrg1(String name) throws Exception{
        //创建User实例
        String keyFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\priv_sk";
        String certFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\cert.pem";
        LocalUser user = new LocalUser("Admin","org1MSP",keyFile,certFile);

        HFClient client = HFClient.createNewInstance();
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(user);
//        System.out.println("finish client");

        //创建通道实例
        Properties peerProp = new Properties();
        ///root/fabric/scripts/fabric-samples/test-network/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/tls/
        peerProp.put("pemBytes", Files.readAllBytes(Paths.get("C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\tls-0-0-0-0-7052.pem")));
        peerProp.setProperty("sslProvider", "openSSL");
        peerProp.setProperty("negotiationType", "TLS");

        Channel channel = client.newChannel(name);
        Peer peer1 = client.newPeer("p1o1","grpcs://peer1-org1.com:7501",peerProp);
        channel.addPeer(peer1);

        Orderer orderer1 = client.newOrderer("or1o0","grpcs://orderer1-org0.com:8050",peerProp);
        channel.addOrderer(orderer1);
        channel.initialize();
        return new Fabric(client,channel);
    }

    /**
     * 初始化org2peer1
     * @param name
     * @return
     * @throws Exception
     */
    public static Fabric initOrg2(String name) throws Exception{
        //创建User实例
        String keyFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\Org2_sk";
        String certFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\Org2_cert.pem";
        LocalUser user = new LocalUser("Admin","org2MSP",keyFile,certFile);

        HFClient client = HFClient.createNewInstance();
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(user);
//        System.out.println("finish client");

        //创建通道实例
        Properties peerProp = new Properties();
        peerProp.put("pemBytes", Files.readAllBytes(Paths.get("C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\tls-0-0-0-0-7052.pem")));
        peerProp.setProperty("sslProvider", "openSSL");
        peerProp.setProperty("negotiationType", "TLS");

        Channel channel = client.newChannel(name);

        Peer peer2 = client.newPeer("p1o2","grpcs://peer1-org2.com:7551",peerProp);
        channel.addPeer(peer2);

        Orderer orderer1 = client.newOrderer("or1o0","grpcs://orderer1-org0.com:8050",peerProp);
        channel.addOrderer(orderer1);

        channel.initialize();
//        System.out.println("finish channel");
        return new Fabric(client,channel);
    }

    /**
     * 初始化org3peer1
     * @param name
     * @return
     * @throws Exception
     */
    public static Fabric initOrg3(String name) throws Exception{
        //创建User实例
        String keyFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\Org3_sk";
        String certFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\Org3_cert.pem";
        LocalUser user = new LocalUser("Admin","org3MSP",keyFile,certFile);

        HFClient client = HFClient.createNewInstance();
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(user);
//        System.out.println("finish client");

        //创建通道实例
        Properties peerProp = new Properties();
        peerProp.put("pemBytes", Files.readAllBytes(Paths.get("C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\tls-0-0-0-0-7052.pem")));
        peerProp.setProperty("sslProvider", "openSSL");
        peerProp.setProperty("negotiationType", "TLS");

        Channel channel = client.newChannel(name);

        Peer peer3 = client.newPeer("p1o3","grpcs://peer1-org3.com:7601",peerProp);
        channel.addPeer(peer3);

        Orderer orderer1 = client.newOrderer("or1o0","grpcs://orderer1-org0.com:8050",peerProp);
        channel.addOrderer(orderer1);

        channel.initialize();
//        System.out.println("finish channel");
        return new Fabric(client,channel);
    }

    /**
     * 初始化org1peer1，org2peer1，org3peer1
     * @param name
     * @return
     * @throws Exception
     */
    public static Fabric initOrgs(String name) throws Exception{
        //创建User实例
        String keyFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\priv_sk";
        String certFile = "C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\cert.pem";
        LocalUser user = new LocalUser("Admin","org1MSP",keyFile,certFile);

        HFClient client = HFClient.createNewInstance();
        client.setCryptoSuite(CryptoSuite.Factory.getCryptoSuite());
        client.setUserContext(user);
//        System.out.println("finish client");

        //创建通道实例
        Properties peerProp = new Properties();
        peerProp.put("pemBytes", Files.readAllBytes(Paths.get("C:\\Users\\123\\Desktop\\Me\\fabricTest\\src\\main\\rKey\\tls-0-0-0-0-7052.pem")));
        peerProp.setProperty("sslProvider", "openSSL");
        peerProp.setProperty("negotiationType", "TLS");

        Channel channel = client.newChannel(name);

        Peer peer1 = client.newPeer("p1o1","grpcs://peer1-org1.com:7501",peerProp);
        Peer peer2 = client.newPeer("p1o2","grpcs://peer1-org2.com:7551",peerProp);
        Peer peer3 = client.newPeer("p1o3","grpcs://peer1-org3.com:7601",peerProp);
        channel.addPeer(peer1);
        channel.addPeer(peer2);
        channel.addPeer(peer3);

        Orderer orderer1 = client.newOrderer("or1o0","grpcs://orderer1-org0.com:8050",peerProp);
        channel.addOrderer(orderer1);

        channel.initialize();
//        System.out.println("finish channel");
        return new Fabric(client,channel);
    }
}
