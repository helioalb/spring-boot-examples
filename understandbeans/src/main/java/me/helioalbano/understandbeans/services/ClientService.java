package me.helioalbano.understandbeans.services;

import me.helioalbano.understandbeans.dao.ClientDao;

public interface ClientService {
	public void setName(String name);
	public String getName();
	public void setClientDao(ClientDao clientDao);
	public ClientDao getClientDao();
}
