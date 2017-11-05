package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Status;
import com.meuempregado.service.StatusService;


@ManagedBean(name = "statusManagedBean")
@SessionScoped

public class StatusManagedBean implements Serializable {
	
	private static final long serialVersionUID = -4211750794309016710L;
	
	private Status Status;
	private List<Status> listStatus;
	private StatusService service;
	
	public StatusManagedBean() throws ClassNotFoundException, IOException {
		Status = new Status(0, "");
		service = new StatusService();
		listStatus = service.listAll();
	}

	public Status getStatus() {
		return Status;
	}

	public void setStatus(Status Status) {
		this.Status = Status;
	}

	public List<Status> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<Status> listStatus) {
		this.listStatus = listStatus;
	}

}
