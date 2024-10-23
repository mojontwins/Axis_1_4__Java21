package javax.xml.soap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.activation.DataHandler;

public abstract class SOAPMessage
{
    public static final String CHARACTER_SET_ENCODING = "jakarta.xml.soap.character-set-encoding";
    public static final String WRITE_XML_DECLARATION = "jakarta.xml.soap.write-xml-declaration";
    
    public abstract void setContentDescription(final String p0);
    
    public abstract String getContentDescription();
    
    public abstract SOAPPart getSOAPPart();
    
    public SOAPBody getSOAPBody() throws SOAPException {
        throw new UnsupportedOperationException("getSOAPBody must be overridden by all subclasses of SOAPMessage");
    }
    
    public SOAPHeader getSOAPHeader() throws SOAPException {
        throw new UnsupportedOperationException("getSOAPHeader must be overridden by all subclasses of SOAPMessage");
    }
    
    public abstract void removeAllAttachments();
    
    public abstract int countAttachments();
    
    public abstract Iterator<AttachmentPart> getAttachments();
    
    public abstract Iterator<AttachmentPart> getAttachments(final MimeHeaders p0);
    
    public abstract void removeAttachments(final MimeHeaders p0);
    
    public abstract AttachmentPart getAttachment(final SOAPElement p0) throws SOAPException;
    
    public abstract void addAttachmentPart(final AttachmentPart p0);
    
    public abstract AttachmentPart createAttachmentPart();
    
    public AttachmentPart createAttachmentPart(final DataHandler dataHandler) {
        final AttachmentPart attachment = this.createAttachmentPart();
        attachment.setDataHandler(dataHandler);
        return attachment;
    }
    
    public abstract MimeHeaders getMimeHeaders();
    
    public AttachmentPart createAttachmentPart(final Object content, final String contentType) {
        final AttachmentPart attachment = this.createAttachmentPart();
        attachment.setContent(content, contentType);
        return attachment;
    }
    
    public abstract void saveChanges() throws SOAPException;
    
    public abstract boolean saveRequired();
    
    public abstract void writeTo(final OutputStream p0) throws SOAPException, IOException;
    
    public void setProperty(final String property, final Object value) throws SOAPException {
        throw new UnsupportedOperationException("setProperty must be overridden by all subclasses of SOAPMessage");
    }
    
    public Object getProperty(final String property) throws SOAPException {
        throw new UnsupportedOperationException("getProperty must be overridden by all subclasses of SOAPMessage");
    }
}
