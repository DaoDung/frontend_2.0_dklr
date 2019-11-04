package com.fds.vr.controler;

import com.fds.vr.model.VRVehicleTypeCertificateBeanParam;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author trungnt
 *
 */
@Path("/vehicle/")
public interface VRVehicleManagement {
	@GET
	@Path("/certificate/year")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findReportRepositoryYear(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext, @BeanParam VRVehicleTypeCertificateBeanParam query);

	@GET
	@Path("/certificate/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findReportRepository(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext, @PathParam("year") Integer year,
			@BeanParam VRVehicleTypeCertificateBeanParam query, String advancesearchParams);

	@GET
	@Path("/certificate")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getVRCOPReportRepository(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext, @DefaultValue(" ") @QueryParam("mtcore") long mtCore,
			@DefaultValue(" ") @QueryParam("copreportno") String COPReportNo);
}
