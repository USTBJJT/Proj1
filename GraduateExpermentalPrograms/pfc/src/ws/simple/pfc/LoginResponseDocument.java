/*
 * An XML document type.
 * Localname: loginResponse
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.LoginResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc;


/**
 * A document containing one loginResponse(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public interface LoginResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LoginResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("loginresponsee634doctype");
    
    /**
     * Gets the "loginResponse" element
     */
    ws.simple.pfc.LoginResponseDocument.LoginResponse getLoginResponse();
    
    /**
     * Sets the "loginResponse" element
     */
    void setLoginResponse(ws.simple.pfc.LoginResponseDocument.LoginResponse loginResponse);
    
    /**
     * Appends and returns a new empty "loginResponse" element
     */
    ws.simple.pfc.LoginResponseDocument.LoginResponse addNewLoginResponse();
    
    /**
     * An XML loginResponse(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public interface LoginResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LoginResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("loginresponse72beelemtype");
        
        /**
         * Gets the "loginReturn" element
         */
        boolean getLoginReturn();
        
        /**
         * Gets (as xml) the "loginReturn" element
         */
        org.apache.xmlbeans.XmlBoolean xgetLoginReturn();
        
        /**
         * Sets the "loginReturn" element
         */
        void setLoginReturn(boolean loginReturn);
        
        /**
         * Sets (as xml) the "loginReturn" element
         */
        void xsetLoginReturn(org.apache.xmlbeans.XmlBoolean loginReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.pfc.LoginResponseDocument.LoginResponse newInstance() {
              return (ws.simple.pfc.LoginResponseDocument.LoginResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.pfc.LoginResponseDocument.LoginResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.pfc.LoginResponseDocument.LoginResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.pfc.LoginResponseDocument newInstance() {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.pfc.LoginResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.pfc.LoginResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.LoginResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.LoginResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.LoginResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
