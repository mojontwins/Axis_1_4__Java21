package javax.xml.rpc.handler;

import java.io.*;
import javax.xml.namespace.*;
import java.util.*;

public interface HandlerRegistry extends Serializable
{
    List<?> getHandlerChain(final QName p0);
    
    void setHandlerChain(final QName p0, final List<?> p1);
}
