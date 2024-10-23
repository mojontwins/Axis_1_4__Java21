package javax.xml.rpc.server;

import javax.xml.rpc.handler.*;
import java.security.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

public interface ServletEndpointContext
{
    MessageContext getMessageContext();
    
    Principal getUserPrincipal();
    
    HttpSession getHttpSession();
    
    ServletContext getServletContext();
    
    boolean isUserInRole(final String p0);
}
