package com.vijay.SportDigitalWorld.Dto;

import java.util.List;

public class SportsApiResponse {

	private String status;
	
    private String msg;
    
    private Object err;
    
    private List<SportsData> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getErr() {
		return err;
	}

	public void setErr(Object err) {
		this.err = err;
	}

	public List<SportsData> getData() {
		return data;
	}

	public void setData(List<SportsData> data) {
		this.data = data;
	}
    
    
}
