/*
 * An XML document type.
 * Localname: login
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.LoginDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc.impl;
/**
 * A document containing one login(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public class LoginDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.LoginDocument
{
    
    public LoginDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOGIN$0 = 
        new javax.xml.namespace.QName("http://pfc.simple.ws", "login");
    
    
    /**
     * Gets the "login" element
     */
    public ws.simple.pfc.LoginDocument.Login getLogin()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginDocument.Login target = null;
            target = (ws.simple.pfc.LoginDocument.Login)get_store().find_element_user(LOGIN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "login" element
     */
    public void setLogin(ws.simple.pfc.LoginDocument.Login login)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginDocument.Login target = null;
            target = (ws.simple.pfc.LoginDocument.Login)get_store().find_element_user(LOGIN$0, 0);
            if (target == null)
            {
                target = (ws.simple.pfc.LoginDocument.Login)get_store().add_element_user(LOGIN$0);
            }
            target.set(login);
        }
    }
    
    /**
     * Appends and returns a new empty "login" element
     */
    public ws.simple.pfc.LoginDocument.Login addNewLogin()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.LoginDocument.Login target = null;
            target = (ws.simple.pfc.LoginDocument.Login)get_store().add_element_user(LOGIN$0);
            return target;
        }
    }
    /**
     * An XML login(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public static class LoginImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.LoginDocument.Login
    {
        
        public LoginImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName LICENSE$0 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "License");
        private static final javax.xml.namespace.QName LOGINTIME$2 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "loginTime");
        
        
        /**
         * Gets the "License" element
         */
        public java.lang.String getLicense()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "License" element
         */
        public ws.simple.pfc.LoginDocument.Login.License xgetLicense()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.LoginDocument.Login.License target = null;
                target = (ws.simple.pfc.LoginDocument.Login.License)get_store().find_element_user(LICENSE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "License" element
         */
        public void setLicense(java.lang.String license)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LICENSE$0);
                }
                target.setStringValue(license);
            }
        }
        
        /**
         * Sets (as xml) the "License" element
         */
        public void xsetLicense(ws.simple.pfc.LoginDocument.Login.License license)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.LoginDocument.Login.License target = null;
                target = (ws.simple.pfc.LoginDocument.Login.License)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    target = (ws.simple.pfc.LoginDocument.Login.License)get_store().add_element_user(LICENSE$0);
                }
                target.set(license);
            }
        }
        
        /**
         * Gets the "loginTime" element
         */
        public int getLoginTime()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINTIME$2, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "loginTime" element
         */
        public ws.simple.pfc.LoginDocument.Login.LoginTime xgetLoginTime()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.LoginDocument.Login.LoginTime target = null;
                target = (ws.simple.pfc.LoginDocument.Login.LoginTime)get_store().find_element_user(LOGINTIME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "loginTime" element
         */
        public void setLoginTime(int loginTime)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINTIME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOGINTIME$2);
                }
                target.setIntValue(loginTime);
            }
        }
        
        /**
         * Sets (as xml) the "loginTime" element
         */
        public void xsetLoginTime(ws.simple.pfc.LoginDocument.Login.LoginTime loginTime)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.LoginDocument.Login.LoginTime target = null;
                target = (ws.simple.pfc.LoginDocument.Login.LoginTime)get_store().find_element_user(LOGINTIME$2, 0);
                if (target == null)
                {
                    target = (ws.simple.pfc.LoginDocument.Login.LoginTime)get_store().add_element_user(LOGINTIME$2);
                }
                target.set(loginTime);
            }
        }
        /**
         * An XML License(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.LoginDocument$Login$License.
         */
        public static class LicenseImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ws.simple.pfc.LoginDocument.Login.License
        {
            
            public LicenseImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected LicenseImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML loginTime(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.LoginDocument$Login$LoginTime.
         */
        public static class LoginTimeImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements ws.simple.pfc.LoginDocument.Login.LoginTime
        {
            
            public LoginTimeImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected LoginTimeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
