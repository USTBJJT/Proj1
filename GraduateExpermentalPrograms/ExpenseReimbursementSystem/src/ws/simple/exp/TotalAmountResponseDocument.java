/*
 * An XML document type.
 * Localname: totalAmountResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.TotalAmountResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one totalAmountResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface TotalAmountResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TotalAmountResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("totalamountresponse23f1doctype");
    
    /**
     * Gets the "totalAmountResponse" element
     */
    ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse getTotalAmountResponse();
    
    /**
     * Sets the "totalAmountResponse" element
     */
    void setTotalAmountResponse(ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse totalAmountResponse);
    
    /**
     * Appends and returns a new empty "totalAmountResponse" element
     */
    ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse addNewTotalAmountResponse();
    
    /**
     * An XML totalAmountResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface TotalAmountResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TotalAmountResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("totalamountresponse16c8elemtype");
        
        /**
         * Gets the "totalAmountReturn" element
         */
        double getTotalAmountReturn();
        
        /**
         * Gets (as xml) the "totalAmountReturn" element
         */
        org.apache.xmlbeans.XmlDouble xgetTotalAmountReturn();
        
        /**
         * Sets the "totalAmountReturn" element
         */
        void setTotalAmountReturn(double totalAmountReturn);
        
        /**
         * Sets (as xml) the "totalAmountReturn" element
         */
        void xsetTotalAmountReturn(org.apache.xmlbeans.XmlDouble totalAmountReturn);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse newInstance() {
              return (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.TotalAmountResponseDocument newInstance() {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.TotalAmountResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.TotalAmountResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.TotalAmountResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.TotalAmountResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
