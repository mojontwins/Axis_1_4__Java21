package javax.xml.rpc.soap;

import javax.xml.namespace.*;
import javax.xml.soap.*;

public class SOAPFaultException extends RuntimeException
{
    private static final long serialVersionUID = -7224636940495025621L;
	private QName faultcode;
    private String faultstring;
    private String faultactor;
    private Detail detail;
    
    public SOAPFaultException(final QName faultcode, final String faultstring, final String faultactor, final Detail faultdetail) {
        super(faultstring);
        this.faultcode = faultcode;
        this.faultstring = faultstring;
        this.faultactor = faultactor;
        this.detail = faultdetail;
    }
    
    public QName getFaultCode() {
        return this.faultcode;
    }
    
    public String getFaultString() {
        return this.faultstring;
    }
    
    public String getFaultActor() {
        return this.faultactor;
    }
    
    public Detail getDetail() {
        return this.detail;
    }
}
