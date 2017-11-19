/*
 * An XML document type.
 * Localname: feeCalculationResponse
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.FeeCalculationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs;


/**
 * A document containing one feeCalculationResponse(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public interface FeeCalculationResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculationResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("feecalculationresponse4cebdoctype");
    
    /**
     * Gets the "feeCalculationResponse" element
     */
    ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse getFeeCalculationResponse();
    
    /**
     * Sets the "feeCalculationResponse" element
     */
    void setFeeCalculationResponse(ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse feeCalculationResponse);
    
    /**
     * Appends and returns a new empty "feeCalculationResponse" element
     */
    ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse addNewFeeCalculationResponse();
    
    /**
     * An XML feeCalculationResponse(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public interface FeeCalculationResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculationResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("feecalculationresponse098belemtype");
        
        /**
         * Gets the "feeCalculationReturn" element
         */
        double getFeeCalculationReturn();
        
        /**
         * Gets (as xml) the "feeCalculationReturn" element
         */
        org.apache.xmlbeans.XmlDouble xgetFeeCalculationReturn();
        
        /**
         * Sets the "feeCalculationReturn" element
         */
        void setFeeCalculationReturn(double feeCalculationReturn);
        
        /**
         * Sets (as xml) the "feeCalculationReturn" element
         */
        void xsetFeeCalculationReturn(org.apache.xmlbeans.XmlDouble feeCalculationReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse newInstance() {
              return (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.abbs.FeeCalculationResponseDocument newInstance() {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.abbs.FeeCalculationResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.abbs.FeeCalculationResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
