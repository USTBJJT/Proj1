/*
 * An XML document type.
 * Localname: login
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.LoginDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc;


/**
 * A document containing one login(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public interface LoginDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LoginDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("login17f5doctype");
    
    /**
     * Gets the "login" element
     */
    ws.simple.pfc.LoginDocument.Login getLogin();
    
    /**
     * Sets the "login" element
     */
    void setLogin(ws.simple.pfc.LoginDocument.Login login);
    
    /**
     * Appends and returns a new empty "login" element
     */
    ws.simple.pfc.LoginDocument.Login addNewLogin();
    
    /**
     * An XML login(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public interface Login extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Login.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("login7e40elemtype");
        
        /**
         * Gets the "License" element
         */
        java.lang.String getLicense();
        
        /**
         * Gets (as xml) the "License" element
         */
        ws.simple.pfc.LoginDocument.Login.License xgetLicense();
        
        /**
         * Sets the "License" element
         */
        void setLicense(java.lang.String license);
        
        /**
         * Sets (as xml) the "License" element
         */
        void xsetLicense(ws.simple.pfc.LoginDocument.Login.License license);
        
        /**
         * Gets the "loginTime" element
         */
        int getLoginTime();
        
        /**
         * Gets (as xml) the "loginTime" element
         */
        ws.simple.pfc.LoginDocument.Login.LoginTime xgetLoginTime();
        
        /**
         * Sets the "loginTime" element
         */
        void setLoginTime(int loginTime);
        
        /**
         * Sets (as xml) the "loginTime" element
         */
        void xsetLoginTime(ws.simple.pfc.LoginDocument.Login.LoginTime loginTime);
        
        /**
         * An XML License(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.LoginDocument$Login$License.
         */
        public interface License extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(License.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("license09d3elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.pfc.LoginDocument.Login.License newValue(java.lang.Object obj) {
                  return (ws.simple.pfc.LoginDocument.Login.License) type.newValue( obj ); }
                
                public static ws.simple.pfc.LoginDocument.Login.License newInstance() {
                  return (ws.simple.pfc.LoginDocument.Login.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.pfc.LoginDocument.Login.License newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.pfc.LoginDocument.Login.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML loginTime(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.LoginDocument$Login$LoginTime.
         */
        public interface LoginTime extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LoginTime.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("logintime633eelemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.pfc.LoginDocument.Login.LoginTime newValue(java.lang.Object obj) {
                  return (ws.simple.pfc.LoginDocument.Login.LoginTime) type.newValue( obj ); }
                
                public static ws.simple.pfc.LoginDocument.Login.LoginTime newInstance() {
                  return (ws.simple.pfc.LoginDocument.Login.LoginTime) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.pfc.LoginDocument.Login.LoginTime newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.pfc.LoginDocument.Login.LoginTime) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.pfc.LoginDocument.Login newInstance() {
              return (ws.simple.pfc.LoginDocument.Login) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.pfc.LoginDocument.Login newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.pfc.LoginDocument.Login) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.pfc.LoginDocument newInstance() {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.pfc.LoginDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.pfc.LoginDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.pfc.LoginDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.pfc.LoginDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.pfc.LoginDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.pfc.LoginDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.LoginDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.LoginDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.LoginDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
