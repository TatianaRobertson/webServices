package src.main.java.com.keysoft.mapper;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SQLIntegrityConstraintViolatonMapper implements ExceptionMapper<SQLIntegrityConstraintViolationException> {

	@Override
	public Response toResponse(SQLIntegrityConstraintViolationException exception) {
		return Response.status(Response.Status.CONFLICT).build();
	}

	
	
}
