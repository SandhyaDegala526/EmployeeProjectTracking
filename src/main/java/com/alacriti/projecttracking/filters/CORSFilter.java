package com.alacriti.projecttracking.filters;


import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {
  public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres) throws IOException {
      cres.getHeaders().add("Access-Control-Allow-Origin", "http://192.168.35.67:4200");
      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
   }

}