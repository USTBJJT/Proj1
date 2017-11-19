/*
 * An XML document type.
 * Localname: loginResponse
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.LoginResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc.impl;
/**
 * A document containing one loginResponse(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public class LoginResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.LoginResponseDocument
{
    
    public LoginResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOGINRESPONSE$0 = 
        new javax.xml.namespace.QName("http://pfc.simple.ws", "loginResponse");
    
    
    /**
     * Gets the "loginResponse" element
     */
    public ws.simple.pfc.LoginResponseDocument.LoginResponse getLoginResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginResponseDocument.LoginResponse target = null;
            target = (ws.simple.pfc.LoginResponseDocument.LoginResponse)get_store().find_element_user(LOGINRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "loginResponse" element
     */
    public void setLoginResponse(ws.simple.pfc.LoginResponseDocument.LoginResponse loginResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginResponseDocument.LoginResponse target = null;
            target = (ws.simple.pfc.LoginResponseDocument.LoginResponse)get_store().find_element_user(LOGINRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.pfc.LoginResponseDocument.LoginResponse)get_store().add_element_user(LOGINRESPONSE$0);
            }
            target.set(loginResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "loginResponse" element
     */
    public ws.simple.pfc.LoginResponseDocument.LoginResponse addNewLoginResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginResponseDocument.LoginResponse target = null;
            target = (ws.simple.pfc.LoginResponseDocument.LoginResponse)get_store().add_element_user(LOGINRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML loginResponse(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public static class LoginResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.LoginResponseDocument.LoginResponse
    {
        
        public LoginResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName LOGINRETURN$0 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "loginReturn");
        
        
        /**
         * Gets the "loginReturn" element
         */
        public boolean getLoginReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINRETURN$0, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "loginReturn" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetLoginReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LOGINRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "loginReturn" element
         */
        public void setLoginReturn(boolean loginReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOGINRETURN$0);
                }
                target.setBooleanValue(loginReturn);
            }
        }
        
        /**
         * Sets (as xml) the "loginReturn" element
         */
        public void xsetLoginReturn(org.apache.xmlbeans.XmlBoolean loginReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(LOGINRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(LOGINRETURN$0);
                }
                target.set(loginReturn);
            }
        }
    }
}
