package me.helioalbano.understandbeans.services;

import me.helioalbano.understandbeans.dao.ClientDao;

public class ClientServiceImpl implements ClientService {

	private String name;
	private ClientDao clientDao;
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public ClientDao getClientDao() {
		return this.clientDao;
	}
}
