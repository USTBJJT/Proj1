/*
 * An XML document type.
 * Localname: calculateReimbursementAmountResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.CalculateReimbursementAmountResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one calculateReimbursementAmountResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface CalculateReimbursementAmountResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CalculateReimbursementAmountResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("calculatereimbursementamountresponse1b31doctype");
    
    /**
     * Gets the "calculateReimbursementAmountResponse" element
     */
    ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse getCalculateReimbursementAmountResponse();
    
    /**
     * Sets the "calculateReimbursementAmountResponse" element
     */
    void setCalculateReimbursementAmountResponse(ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse calculateReimbursementAmountResponse);
    
    /**
     * Appends and returns a new empty "calculateReimbursementAmountResponse" element
     */
    ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse addNewCalculateReimbursementAmountResponse();
    
    /**
     * An XML calculateReimbursementAmountResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface CalculateReimbursementAmountResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CalculateReimbursementAmountResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("calculatereimbursementamountresponsea818elemtype");
        
        /**
         * Gets the "calculateReimbursementAmountReturn" element
         */
        double getCalculateReimbursementAmountReturn();
        
        /**
         * Gets (as xml) the "calculateReimbursementAmountReturn" element
         */
        org.apache.xmlbeans.XmlDouble xgetCalculateReimbursementAmountReturn();
        
        /**
         * Sets the "calculateReimbursementAmountReturn" element
         */
        void setCalculateReimbursementAmountReturn(double calculateReimbursementAmountReturn);
        
        /**
         * Sets (as xml) the "calculateReimbursementAmountReturn" element
         */
        void xsetCalculateReimbursementAmountReturn(org.apache.xmlbeans.XmlDouble calculateReimbursementAmountReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse newInstance() {
              return (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument newInstance() {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.CalculateReimbursementAmountResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.CalculateReimbursementAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
