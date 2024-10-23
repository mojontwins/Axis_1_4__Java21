package javax.xml.rpc.handler;

import java.io.*;
import java.util.*;
import javax.xml.namespace.*;

public class HandlerInfo implements Serializable
{
    private static final long serialVersionUID = -6735139577513563610L;
	private Class<?> handlerClass;
    private Map<?, ?> config;
    private Vector<QName> headers;
    
    public HandlerInfo() {
        this.handlerClass = null;
        this.config = new HashMap<Object, Object>();
        this.headers = new Vector<QName>();
    }
    
    public HandlerInfo(final Class<?> handlerClass, final Map<?, ?> config, final QName[] headers) {
        this.handlerClass = handlerClass;
        this.config = config;
        this.headers = new Vector<QName>();
        if (headers != null) {
            for (int i = 0; i < headers.length; ++i) {
                this.headers.add(i, headers[i]);
            }
        }
    }
    
    public void setHandlerClass(final Class<?> handlerClass) {
        this.handlerClass = handlerClass;
    }
    
    public Class<?> getHandlerClass() {
        return this.handlerClass;
    }
    
    public void setHandlerConfig(final Map<?, ?> config) {
        this.config = config;
    }
    
    public Map<?, ?> getHandlerConfig() {
        return this.config;
    }
    
    public void setHeaders(final QName[] headers) {
        this.headers.clear();
        if (headers != null) {
            for (int i = 0; i < headers.length; ++i) {
                this.headers.add(i, headers[i]);
            }
        }
    }
    
    public QName[] getHeaders() {
        if (this.headers.size() == 0) {
            return null;
        }
        final QName[] qns = new QName[this.headers.size()];
        this.headers.copyInto(qns);
        return qns;
    }
}
