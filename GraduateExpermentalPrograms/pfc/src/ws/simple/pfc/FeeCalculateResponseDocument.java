/*
 * An XML document type.
 * Localname: feeCalculateResponse
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.FeeCalculateResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc;


/**
 * A document containing one feeCalculateResponse(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public interface FeeCalculateResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculateResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("feecalculateresponsedbebdoctype");
    
    /**
     * Gets the "feeCalculateResponse" element
     */
    ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse getFeeCalculateResponse();
    
    /**
     * Sets the "feeCalculateResponse" element
     */
    void setFeeCalculateResponse(ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse feeCalculateResponse);
    
    /**
     * Appends and returns a new empty "feeCalculateResponse" element
     */
    ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse addNewFeeCalculateResponse();
    
    /**
     * An XML feeCalculateResponse(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public interface FeeCalculateResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculateResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("feecalculateresponse47e8elemtype");
        
        /**
         * Gets the "feeCalculateReturn" element
         */
        double getFeeCalculateReturn();
        
        /**
         * Gets (as xml) the "feeCalculateReturn" element
         */
        org.apache.xmlbeans.XmlDouble xgetFeeCalculateReturn();
        
        /**
         * Sets the "feeCalculateReturn" element
         */
        void setFeeCalculateReturn(double feeCalculateReturn);
        
        /**
         * Sets (as xml) the "feeCalculateReturn" element
         */
        void xsetFeeCalculateReturn(org.apache.xmlbeans.XmlDouble feeCalculateReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse newInstance() {
              return (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.pfc.FeeCalculateResponseDocument newInstance() {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.FeeCalculateResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.FeeCalculateResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
