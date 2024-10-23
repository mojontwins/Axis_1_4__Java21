package javax.xml.rpc.encoding;

import javax.xml.namespace.*;

public interface TypeMapping
{
    String[] getSupportedEncodings();
    
    void setSupportedEncodings(final String[] p0);
    
    boolean isRegistered(final Class<?> p0, final QName p1);
    
    void register(final Class<?> p0, final QName p1, final SerializerFactory p2, final DeserializerFactory p3);
    
    SerializerFactory getSerializer(final Class<?> p0, final QName p1);
    
    DeserializerFactory getDeserializer(final Class<?> p0, final QName p1);
    
    void removeSerializer(final Class<?> p0, final QName p1);
    
    void removeDeserializer(final Class<?> p0, final QName p1);
}
