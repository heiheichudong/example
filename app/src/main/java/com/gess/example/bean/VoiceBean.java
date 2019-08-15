package com.gess.example.bean;

public class VoiceBean {

    /**
     * voiceId : 51410af8e70740e2a48b2cbe9c6e36f2
     * path : 2019/7/20/15/51410af8e70740e2a48b2cbe9c6e36f2.mp3
     * timeLength : 12
     * ipfsHash : null
     * ipfshost : null
     */

    private String voiceId;
    private String path;
    private int timeLength;
    private String ipfsHash;
    private String ipfshost;

    public String getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(String voiceId) {
        this.voiceId = voiceId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public String getIpfsHash() {
        return ipfsHash;
    }

    public void setIpfsHash(String ipfsHash) {
        this.ipfsHash = ipfsHash;
    }

    public String getIpfshost() {
        return ipfshost;
    }

    public void setIpfshost(String ipfshost) {
        this.ipfshost = ipfshost;
    }
}
