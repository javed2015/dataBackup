package com.zeptoh.lync.rest;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.zeptoh.lynk.common.CommonDaoImpl;
import com.zeptoh.lynk.model.SelectedContent;
import com.zeptoh.lynk.service.URLServiceImpl;

//http://localhost:8080/LynkBeta/Token/7kr0k2u3tj25fhsdrtnrnljct1
//http://www.factualnote.com/Token/7kr0k2u3tj25fhsdrtnrnljct1
@Path("/")
public class restPage {

	private URLServiceImpl urlService = new URLServiceImpl();

	@GET
	@Path("/{param}")
	@Produces({ MediaType.TEXT_HTML })
	public String printMessage(@PathParam("param") String token,
			@Context HttpServletRequest httpRequest) throws IOException {

		URL url = new URL(httpRequest.getRequestURL().toString());
		String lynkUrl;
		if (url.getHost().contains("localhost")) {
			lynkUrl = url.getProtocol() + "://" + url.getHost() + ":"
					+ url.getPort() + "/LynkBeta";
		} else {
			lynkUrl = url.getProtocol() + "://" + url.getHost();
		}
		CommonDaoImpl documentDAO = new CommonDaoImpl();
		SelectedContent lynk = documentDAO.retrieveLynk(token);
		return urlService.getResponse(lynk.getUrl(), "load", lynk, lynkUrl);
	}

}