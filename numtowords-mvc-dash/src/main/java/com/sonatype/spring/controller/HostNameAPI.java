package com.sonatype.spring.controller;

public class HostNameAPI {

	String hostName;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
    public String toString(){
        return hostName;
    }
}
