/*
 * An XML document type.
 * Localname: totalAmount
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.TotalAmountDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one totalAmount(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface TotalAmountDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TotalAmountDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("totalamount72b2doctype");
    
    /**
     * Gets the "totalAmount" element
     */
    ws.simple.exp.TotalAmountDocument.TotalAmount getTotalAmount();
    
    /**
     * Sets the "totalAmount" element
     */
    void setTotalAmount(ws.simple.exp.TotalAmountDocument.TotalAmount totalAmount);
    
    /**
     * Appends and returns a new empty "totalAmount" element
     */
    ws.simple.exp.TotalAmountDocument.TotalAmount addNewTotalAmount();
    
    /**
     * An XML totalAmount(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface TotalAmount extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TotalAmount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("totalamount648aelemtype");
        
        /**
         * Gets the "tstafflevel" element
         */
        java.lang.String getTstafflevel();
        
        /**
         * Gets (as xml) the "tstafflevel" element
         */
        org.apache.xmlbeans.XmlString xgetTstafflevel();
        
        /**
         * Sets the "tstafflevel" element
         */
        void setTstafflevel(java.lang.String tstafflevel);
        
        /**
         * Sets (as xml) the "tstafflevel" element
         */
        void xsetTstafflevel(org.apache.xmlbeans.XmlString tstafflevel);
        
        /**
         * Gets the "tactualmonthlymileage" element
         */
        double getTactualmonthlymileage();
        
        /**
         * Gets (as xml) the "tactualmonthlymileage" element
         */
        org.apache.xmlbeans.XmlDouble xgetTactualmonthlymileage();
        
        /**
         * Sets the "tactualmonthlymileage" element
         */
        void setTactualmonthlymileage(double tactualmonthlymileage);
        
        /**
         * Sets (as xml) the "tactualmonthlymileage" element
         */
        void xsetTactualmonthlymileage(org.apache.xmlbeans.XmlDouble tactualmonthlymileage);
        
        /**
         * Gets the "tmonthlysalesamount" element
         */
        double getTmonthlysalesamount();
        
        /**
         * Gets (as xml) the "tmonthlysalesamount" element
         */
        org.apache.xmlbeans.XmlDouble xgetTmonthlysalesamount();
        
        /**
         * Sets the "tmonthlysalesamount" element
         */
        void setTmonthlysalesamount(double tmonthlysalesamount);
        
        /**
         * Sets (as xml) the "tmonthlysalesamount" element
         */
        void xsetTmonthlysalesamount(org.apache.xmlbeans.XmlDouble tmonthlysalesamount);
        
        /**
         * Gets the "tairfareamount" element
         */
        double getTairfareamount();
        
        /**
         * Gets (as xml) the "tairfareamount" element
         */
        org.apache.xmlbeans.XmlDouble xgetTairfareamount();
        
        /**
         * Sets the "tairfareamount" element
         */
        void setTairfareamount(double tairfareamount);
        
        /**
         * Sets (as xml) the "tairfareamount" element
         */
        void xsetTairfareamount(org.apache.xmlbeans.XmlDouble tairfareamount);
        
        /**
         * Gets the "totherexpensesamount" element
         */
        double getTotherexpensesamount();
        
        /**
         * Gets (as xml) the "totherexpensesamount" element
         */
        org.apache.xmlbeans.XmlDouble xgetTotherexpensesamount();
        
        /**
         * Sets the "totherexpensesamount" element
         */
        void setTotherexpensesamount(double totherexpensesamount);
        
        /**
         * Sets (as xml) the "totherexpensesamount" element
         */
        void xsetTotherexpensesamount(org.apache.xmlbeans.XmlDouble totherexpensesamount);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.TotalAmountDocument.TotalAmount newInstance() {
              return (ws.simple.exp.TotalAmountDocument.TotalAmount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.TotalAmountDocument.TotalAmount newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.TotalAmountDocument.TotalAmount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.TotalAmountDocument newInstance() {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.TotalAmountDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.TotalAmountDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.TotalAmountDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.TotalAmountDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.TotalAmountDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.TotalAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
