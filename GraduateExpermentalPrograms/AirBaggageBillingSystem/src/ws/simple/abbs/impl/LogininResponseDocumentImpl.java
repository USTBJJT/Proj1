/*
 * An XML document type.
 * Localname: logininResponse
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.LogininResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs.impl;
/**
 * A document containing one logininResponse(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public class LogininResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.LogininResponseDocument
{
    
    public LogininResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOGININRESPONSE$0 = 
        new javax.xml.namespace.QName("http://abbs.simple.ws", "logininResponse");
    
    
    /**
     * Gets the "logininResponse" element
     */
    public ws.simple.abbs.LogininResponseDocument.LogininResponse getLogininResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininResponseDocument.LogininResponse target = null;
            target = (ws.simple.abbs.LogininResponseDocument.LogininResponse)get_store().find_element_user(LOGININRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "logininResponse" element
     */
    public void setLogininResponse(ws.simple.abbs.LogininResponseDocument.LogininResponse logininResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininResponseDocument.LogininResponse target = null;
            target = (ws.simple.abbs.LogininResponseDocument.LogininResponse)get_store().find_element_user(LOGININRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.abbs.LogininResponseDocument.LogininResponse)get_store().add_element_user(LOGININRESPONSE$0);
            }
            target.set(logininResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "logininResponse" element
     */
    public ws.simple.abbs.LogininResponseDocument.LogininResponse addNewLogininResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininResponseDocument.LogininResponse target = null;
            target = (ws.simple.abbs.LogininResponseDocument.LogininResponse)get_store().add_element_user(LOGININRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML logininResponse(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public static class LogininResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.LogininResponseDocument.LogininResponse
    {
        
        public LogininResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName LOGININRETURN$0 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "logininReturn");
        
        
        /**
         * Gets the "logininReturn" element
         */
        public boolean getLogininReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGININRETURN$0, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "logininReturn" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetLogininReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LOGININRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "logininReturn" element
         */
        public void setLogininReturn(boolean logininReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGININRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOGININRETURN$0);
                }
                target.setBooleanValue(logininReturn);
            }
        }
        
        /**
         * Sets (as xml) the "logininReturn" element
         */
        public void xsetLogininReturn(org.apache.xmlbeans.XmlBoolean logininReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LOGININRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(LOGININRETURN$0);
                }
                target.set(logininReturn);
            }
        }
    }
}
