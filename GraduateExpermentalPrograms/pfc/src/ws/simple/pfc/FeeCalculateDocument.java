/*
 * An XML document type.
 * Localname: feeCalculate
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.FeeCalculateDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc;


/**
 * A document containing one feeCalculate(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public interface FeeCalculateDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculateDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("feecalculateb4acdoctype");
    
    /**
     * Gets the "feeCalculate" element
     */
    ws.simple.pfc.FeeCalculateDocument.FeeCalculate getFeeCalculate();
    
    /**
     * Sets the "feeCalculate" element
     */
    void setFeeCalculate(ws.simple.pfc.FeeCalculateDocument.FeeCalculate feeCalculate);
    
    /**
     * Appends and returns a new empty "feeCalculate" element
     */
    ws.simple.pfc.FeeCalculateDocument.FeeCalculate addNewFeeCalculate();
    
    /**
     * An XML feeCalculate(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public interface FeeCalculate extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculate.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("feecalculate69c8elemtype");
        
        /**
         * Gets the "License" element
         */
        java.lang.String getLicense();
        
        /**
         * Gets (as xml) the "License" element
         */
        ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License xgetLicense();
        
        /**
         * Sets the "License" element
         */
        void setLicense(java.lang.String license);
        
        /**
         * Sets (as xml) the "License" element
         */
        void xsetLicense(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License license);
        
        /**
         * Gets the "type" element
         */
        int getType();
        
        /**
         * Gets (as xml) the "type" element
         */
        ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type xgetType();
        
        /**
         * Sets the "type" element
         */
        void setType(int type);
        
        /**
         * Sets (as xml) the "type" element
         */
        void xsetType(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type type);
        
        /**
         * Gets the "timeout" element
         */
        int getTimeout();
        
        /**
         * Gets (as xml) the "timeout" element
         */
        ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout xgetTimeout();
        
        /**
         * Sets the "timeout" element
         */
        void setTimeout(int timeout);
        
        /**
         * Sets (as xml) the "timeout" element
         */
        void xsetTimeout(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout timeout);
        
        /**
         * Gets the "dayOfWeek" element
         */
        boolean getDayOfWeek();
        
        /**
         * Gets (as xml) the "dayOfWeek" element
         */
        org.apache.xmlbeans.XmlBoolean xgetDayOfWeek();
        
        /**
         * Sets the "dayOfWeek" element
         */
        void setDayOfWeek(boolean dayOfWeek);
        
        /**
         * Sets (as xml) the "dayOfWeek" element
         */
        void xsetDayOfWeek(org.apache.xmlbeans.XmlBoolean dayOfWeek);
        
        /**
         * Gets the "discountCoupon" element
         */
        boolean getDiscountCoupon();
        
        /**
         * Gets (as xml) the "discountCoupon" element
         */
        org.apache.xmlbeans.XmlBoolean xgetDiscountCoupon();
        
        /**
         * Sets the "discountCoupon" element
         */
        void setDiscountCoupon(boolean discountCoupon);
        
        /**
         * Sets (as xml) the "discountCoupon" element
         */
        void xsetDiscountCoupon(org.apache.xmlbeans.XmlBoolean discountCoupon);
        
        /**
         * An XML License(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$License.
         */
        public interface License extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(License.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("licenseb81belemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License newValue(java.lang.Object obj) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License) type.newValue( obj ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License newInstance() {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML type(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$Type.
         */
        public interface Type extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Type.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("type0a32elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type newValue(java.lang.Object obj) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type) type.newValue( obj ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type newInstance() {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML timeout(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$Timeout.
         */
        public interface Timeout extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Timeout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B2625241ACD6BCCFCB6BDA4716B19FB").resolveHandle("timeout7edbelemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout newValue(java.lang.Object obj) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout) type.newValue( obj ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout newInstance() {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate newInstance() {
              return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.pfc.FeeCalculateDocument.FeeCalculate newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.pfc.FeeCalculateDocument.FeeCalculate) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.pfc.FeeCalculateDocument newInstance() {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.pfc.FeeCalculateDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.pfc.FeeCalculateDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.FeeCalculateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.pfc.FeeCalculateDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.pfc.FeeCalculateDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
