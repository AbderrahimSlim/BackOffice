package com.massconnections.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {							//Respecte le Design Pattern Singleton

	private static ServiceLocator instance;
	private Map<String, Object> cache;
	private Context ctx;
	private ServiceLocator(){							//Constructeur privé
		cache = new HashMap<String, Object>();
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ServiceLocator getInstance(){		//Méthode static pour récupérer une seule instance
		if (instance == null)
			instance = new ServiceLocator();
		return instance;
	}
	
	public synchronized Object getProxy(String jndi){				//Synchronised: Pour remédier au appel concurrent
		Object remoteObject = null;
		if (cache.get(jndi) != null){
			return cache.get(jndi);
		}
		else {
			try {
				remoteObject = ctx.lookup(jndi);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cache.put(jndi, remoteObject);
		}
		return remoteObject;
	}

}
