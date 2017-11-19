/*
 * An XML document type.
 * Localname: feeCalculation
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.FeeCalculationDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs;


/**
 * A document containing one feeCalculation(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public interface FeeCalculationDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("feecalculation9f4adoctype");
    
    /**
     * Gets the "feeCalculation" element
     */
    ws.simple.abbs.FeeCalculationDocument.FeeCalculation getFeeCalculation();
    
    /**
     * Sets the "feeCalculation" element
     */
    void setFeeCalculation(ws.simple.abbs.FeeCalculationDocument.FeeCalculation feeCalculation);
    
    /**
     * Appends and returns a new empty "feeCalculation" element
     */
    ws.simple.abbs.FeeCalculationDocument.FeeCalculation addNewFeeCalculation();
    
    /**
     * An XML feeCalculation(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public interface FeeCalculation extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FeeCalculation.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("feecalculationa46belemtype");
        
        /**
         * Gets the "chooseAirClass" element
         */
        int getChooseAirClass();
        
        /**
         * Gets (as xml) the "chooseAirClass" element
         */
        ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass xgetChooseAirClass();
        
        /**
         * Sets the "chooseAirClass" element
         */
        void setChooseAirClass(int chooseAirClass);
        
        /**
         * Sets (as xml) the "chooseAirClass" element
         */
        void xsetChooseAirClass(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass chooseAirClass);
        
        /**
         * Gets the "chooseArea" element
         */
        int getChooseArea();
        
        /**
         * Gets (as xml) the "chooseArea" element
         */
        ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea xgetChooseArea();
        
        /**
         * Sets the "chooseArea" element
         */
        void setChooseArea(int chooseArea);
        
        /**
         * Sets (as xml) the "chooseArea" element
         */
        void xsetChooseArea(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea chooseArea);
        
        /**
         * Gets the "isStudent" element
         */
        boolean getIsStudent();
        
        /**
         * Gets (as xml) the "isStudent" element
         */
        org.apache.xmlbeans.XmlBoolean xgetIsStudent();
        
        /**
         * Sets the "isStudent" element
         */
        void setIsStudent(boolean isStudent);
        
        /**
         * Sets (as xml) the "isStudent" element
         */
        void xsetIsStudent(org.apache.xmlbeans.XmlBoolean isStudent);
        
        /**
         * Gets the "luggage" element
         */
        double getLuggage();
        
        /**
         * Gets (as xml) the "luggage" element
         */
        ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage xgetLuggage();
        
        /**
         * Sets the "luggage" element
         */
        void setLuggage(double luggage);
        
        /**
         * Sets (as xml) the "luggage" element
         */
        void xsetLuggage(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage luggage);
        
        /**
         * Gets the "economicfee" element
         */
        double getEconomicfee();
        
        /**
         * Gets (as xml) the "economicfee" element
         */
        ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee xgetEconomicfee();
        
        /**
         * Sets the "economicfee" element
         */
        void setEconomicfee(double economicfee);
        
        /**
         * Sets (as xml) the "economicfee" element
         */
        void xsetEconomicfee(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee economicfee);
        
        /**
         * An XML chooseAirClass(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$ChooseAirClass.
         */
        public interface ChooseAirClass extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChooseAirClass.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("chooseairclass3d8celemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass newValue(java.lang.Object obj) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass) type.newValue( obj ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass newInstance() {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML chooseArea(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$ChooseArea.
         */
        public interface ChooseArea extends org.apache.xmlbeans.XmlInt
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ChooseArea.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("choosearea864belemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea newValue(java.lang.Object obj) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea) type.newValue( obj ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea newInstance() {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML luggage(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$Luggage.
         */
        public interface Luggage extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Luggage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("luggageb30delemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage newValue(java.lang.Object obj) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage) type.newValue( obj ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage newInstance() {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML economicfee(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$Economicfee.
         */
        public interface Economicfee extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Economicfee.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s387256D24339AC6AFBB876B2ADB4B64B").resolveHandle("economicfee5d48elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee newValue(java.lang.Object obj) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee) type.newValue( obj ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee newInstance() {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation newInstance() {
              return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.abbs.FeeCalculationDocument.FeeCalculation newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.abbs.FeeCalculationDocument.FeeCalculation) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.abbs.FeeCalculationDocument newInstance() {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.abbs.FeeCalculationDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.abbs.FeeCalculationDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.abbs.FeeCalculationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.abbs.FeeCalculationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.abbs.FeeCalculationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
