/*
 * An XML document type.
 * Localname: airfareReimbursementResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.AirfareReimbursementResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one airfareReimbursementResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface AirfareReimbursementResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AirfareReimbursementResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("airfarereimbursementresponse30bbdoctype");
    
    /**
     * Gets the "airfareReimbursementResponse" element
     */
    ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse getAirfareReimbursementResponse();
    
    /**
     * Sets the "airfareReimbursementResponse" element
     */
    void setAirfareReimbursementResponse(ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse airfareReimbursementResponse);
    
    /**
     * Appends and returns a new empty "airfareReimbursementResponse" element
     */
    ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse addNewAirfareReimbursementResponse();
    
    /**
     * An XML airfareReimbursementResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface AirfareReimbursementResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AirfareReimbursementResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("airfarereimbursementresponsedcd8elemtype");
        
        /**
         * Gets the "airfareReimbursementReturn" element
         */
        double getAirfareReimbursementReturn();
        
        /**
         * Gets (as xml) the "airfareReimbursementReturn" element
         */
        org.apache.xmlbeans.XmlDouble xgetAirfareReimbursementReturn();
        
        /**
         * Sets the "airfareReimbursementReturn" element
         */
        void setAirfareReimbursementReturn(double airfareReimbursementReturn);
        
        /**
         * Sets (as xml) the "airfareReimbursementReturn" element
         */
        void xsetAirfareReimbursementReturn(org.apache.xmlbeans.XmlDouble airfareReimbursementReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse newInstance() {
              return (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.AirfareReimbursementResponseDocument newInstance() {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.AirfareReimbursementResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.AirfareReimbursementResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
