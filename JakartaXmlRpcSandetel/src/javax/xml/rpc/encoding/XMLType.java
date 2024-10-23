package javax.xml.rpc.encoding;

import javax.xml.namespace.*;

public class XMLType
{
    public static final QName XSD_STRING;
    public static final QName XSD_FLOAT;
    public static final QName XSD_BOOLEAN;
    public static final QName XSD_DOUBLE;
    public static final QName XSD_INTEGER;
    public static final QName XSD_INT;
    public static final QName XSD_LONG;
    public static final QName XSD_SHORT;
    public static final QName XSD_DECIMAL;
    public static final QName XSD_BASE64;
    public static final QName XSD_HEXBINARY;
    public static final QName XSD_BYTE;
    public static final QName XSD_DATETIME;
    public static final QName XSD_QNAME;
    public static final QName SOAP_STRING;
    public static final QName SOAP_BOOLEAN;
    public static final QName SOAP_DOUBLE;
    public static final QName SOAP_BASE64;
    public static final QName SOAP_FLOAT;
    public static final QName SOAP_INT;
    public static final QName SOAP_LONG;
    public static final QName SOAP_SHORT;
    public static final QName SOAP_BYTE;
    public static final QName SOAP_ARRAY;
    
    static {
        XSD_STRING = new QName("http://www.w3.org/2001/XMLSchema", "string");
        XSD_FLOAT = new QName("http://www.w3.org/2001/XMLSchema", "float");
        XSD_BOOLEAN = new QName("http://www.w3.org/2001/XMLSchema", "boolean");
        XSD_DOUBLE = new QName("http://www.w3.org/2001/XMLSchema", "double");
        XSD_INTEGER = new QName("http://www.w3.org/2001/XMLSchema", "integer");
        XSD_INT = new QName("http://www.w3.org/2001/XMLSchema", "int");
        XSD_LONG = new QName("http://www.w3.org/2001/XMLSchema", "long");
        XSD_SHORT = new QName("http://www.w3.org/2001/XMLSchema", "short");
        XSD_DECIMAL = new QName("http://www.w3.org/2001/XMLSchema", "decimal");
        XSD_BASE64 = new QName("http://www.w3.org/2001/XMLSchema", "base64Binary");
        XSD_HEXBINARY = new QName("http://www.w3.org/2001/XMLSchema", "hexBinary");
        XSD_BYTE = new QName("http://www.w3.org/2001/XMLSchema", "byte");
        XSD_DATETIME = new QName("http://www.w3.org/2001/XMLSchema", "dateTime");
        XSD_QNAME = new QName("http://www.w3.org/2001/XMLSchema", "QName");
        SOAP_STRING = new QName("http://schemas.xmlsoap.org/soap/encoding/", "string");
        SOAP_BOOLEAN = new QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean");
        SOAP_DOUBLE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "double");
        SOAP_BASE64 = new QName("http://schemas.xmlsoap.org/soap/encoding/", "base64");
        SOAP_FLOAT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "float");
        SOAP_INT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "int");
        SOAP_LONG = new QName("http://schemas.xmlsoap.org/soap/encoding/", "long");
        SOAP_SHORT = new QName("http://schemas.xmlsoap.org/soap/encoding/", "short");
        SOAP_BYTE = new QName("http://schemas.xmlsoap.org/soap/encoding/", "byte");
        SOAP_ARRAY = new QName("http://schemas.xmlsoap.org/soap/encoding/", "Array");
    }
}
