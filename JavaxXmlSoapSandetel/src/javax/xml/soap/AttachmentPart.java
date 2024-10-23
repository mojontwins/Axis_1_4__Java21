package javax.xml.soap;

import java.io.InputStream;
import java.util.Iterator;

import javax.activation.DataHandler;

public abstract class AttachmentPart
{
    public abstract int getSize() throws SOAPException;
    
    public abstract void clearContent();
    
    public abstract Object getContent() throws SOAPException;
    
    public abstract InputStream getRawContent() throws SOAPException;
    
    public abstract byte[] getRawContentBytes() throws SOAPException;
    
    public abstract InputStream getBase64Content() throws SOAPException;
    
    public abstract void setContent(final Object p0, final String p1);
    
    public abstract void setRawContent(final InputStream p0, final String p1) throws SOAPException;
    
    public abstract void setRawContentBytes(final byte[] p0, final int p1, final int p2, final String p3) throws SOAPException;
    
    public abstract void setBase64Content(final InputStream p0, final String p1) throws SOAPException;
    
    public abstract DataHandler getDataHandler() throws SOAPException;
    
    public abstract void setDataHandler(final DataHandler p0);
    
    public String getContentId() {
        final String[] values = this.getMimeHeader("Content-ID");
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
    
    public String getContentLocation() {
        final String[] values = this.getMimeHeader("Content-Location");
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
    
    public String getContentType() {
        final String[] values = this.getMimeHeader("Content-Type");
        if (values != null && values.length > 0) {
            return values[0];
        }
        return null;
    }
    
    public void setContentId(final String contentId) {
        this.setMimeHeader("Content-ID", contentId);
    }
    
    public void setContentLocation(final String contentLocation) {
        this.setMimeHeader("Content-Location", contentLocation);
    }
    
    public void setContentType(final String contentType) {
        this.setMimeHeader("Content-Type", contentType);
    }
    
    public abstract void removeMimeHeader(final String p0);
    
    public abstract void removeAllMimeHeaders();
    
    public abstract String[] getMimeHeader(final String p0);
    
    public abstract void setMimeHeader(final String p0, final String p1);
    
    public abstract void addMimeHeader(final String p0, final String p1);
    
    public abstract Iterator<MimeHeader> getAllMimeHeaders();
    
    public abstract Iterator<MimeHeader> getMatchingMimeHeaders(final String[] p0);
    
    public abstract Iterator<MimeHeader> getNonMatchingMimeHeaders(final String[] p0);
}
