package javax.xml.rpc.encoding;

import java.io.*;
import java.util.*;

public interface DeserializerFactory extends Serializable
{
    Deserializer getDeserializerAs(final String p0);
    
    Iterator<?> getSupportedMechanismTypes();
}
