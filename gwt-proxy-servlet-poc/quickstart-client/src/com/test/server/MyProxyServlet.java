package com.test.server;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;

import com.woonoz.proxy.servlet.ProxyServlet;

public class MyProxyServlet extends ProxyServlet
{

	@Override
	public void init() throws ServletException
	{
		try
		{
			// init(new URL("http://127.0.0.1:8080/quickstart-server/quickstart"), 200);
			init(new URL("http://10.1.64.18:8080/quickstart-server/quickstart"), 200);
		}
		catch (IOException e)
		{
			throw new ServletException(e);
		}
	}
}