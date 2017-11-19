/*
 * An XML document type.
 * Localname: calculateReimbursementAmount
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.CalculateReimbursementAmountDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one calculateReimbursementAmount(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface CalculateReimbursementAmountDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CalculateReimbursementAmountDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("calculatereimbursementamounta9f2doctype");
    
    /**
     * Gets the "calculateReimbursementAmount" element
     */
    ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount getCalculateReimbursementAmount();
    
    /**
     * Sets the "calculateReimbursementAmount" element
     */
    void setCalculateReimbursementAmount(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount calculateReimbursementAmount);
    
    /**
     * Appends and returns a new empty "calculateReimbursementAmount" element
     */
    ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount addNewCalculateReimbursementAmount();
    
    /**
     * An XML calculateReimbursementAmount(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface CalculateReimbursementAmount extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CalculateReimbursementAmount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("calculatereimbursementamount75f8elemtype");
        
        /**
         * Gets the "stafflevel" element
         */
        ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel.Enum getStafflevel();
        
        /**
         * Gets (as xml) the "stafflevel" element
         */
        ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel xgetStafflevel();
        
        /**
         * Sets the "stafflevel" element
         */
        void setStafflevel(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel.Enum stafflevel);
        
        /**
         * Sets (as xml) the "stafflevel" element
         */
        void xsetStafflevel(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel stafflevel);
        
        /**
         * Gets the "actualmonthlymileage" element
         */
        double getActualmonthlymileage();
        
        /**
         * Gets (as xml) the "actualmonthlymileage" element
         */
        ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage xgetActualmonthlymileage();
        
        /**
         * Sets the "actualmonthlymileage" element
         */
        void setActualmonthlymileage(double actualmonthlymileage);
        
        /**
         * Sets (as xml) the "actualmonthlymileage" element
         */
        void xsetActualmonthlymileage(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage actualmonthlymileage);
        
        /**
         * An XML stafflevel(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.CalculateReimbursementAmountDocument$CalculateReimbursementAmount$Stafflevel.
         */
        public interface Stafflevel extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Stafflevel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("staffleveldeb8elemtype");
            
            org.apache.xmlbeans.StringEnumAbstractBase enumValue();
            void set(org.apache.xmlbeans.StringEnumAbstractBase e);
            
            static final Enum SENIORMANAGER = Enum.forString("seniormanager");
            static final Enum MANAGER = Enum.forString("manager");
            static final Enum SUPERVISOR = Enum.forString("supervisor");
            
            static final int INT_SENIORMANAGER = Enum.INT_SENIORMANAGER;
            static final int INT_MANAGER = Enum.INT_MANAGER;
            static final int INT_SUPERVISOR = Enum.INT_SUPERVISOR;
            
            /**
             * Enumeration value class for ws.simple.exp.CalculateReimbursementAmountDocument$CalculateReimbursementAmount$Stafflevel.
             * These enum values can be used as follows:
             * <pre>
             * enum.toString(); // returns the string value of the enum
             * enum.intValue(); // returns an int value, useful for switches
             * // e.g., case Enum.INT_SENIORMANAGER
             * Enum.forString(s); // returns the enum value for a string
             * Enum.forInt(i); // returns the enum value for an int
             * </pre>
             * Enumeration objects are immutable singleton objects that
             * can be compared using == object equality. They have no
             * public constructor. See the constants defined within this
             * class for all the valid values.
             */
            static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
            {
                /**
                 * Returns the enum value for a string, or null if none.
                 */
                public static Enum forString(java.lang.String s)
                    { return (Enum)table.forString(s); }
                /**
                 * Returns the enum value corresponding to an int, or null if none.
                 */
                public static Enum forInt(int i)
                    { return (Enum)table.forInt(i); }
                
                private Enum(java.lang.String s, int i)
                    { super(s, i); }
                
                static final int INT_SENIORMANAGER = 1;
                static final int INT_MANAGER = 2;
                static final int INT_SUPERVISOR = 3;
                
                public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                    new org.apache.xmlbeans.StringEnumAbstractBase.Table
                (
                    new Enum[]
                    {
                      new Enum("seniormanager", INT_SENIORMANAGER),
                      new Enum("manager", INT_MANAGER),
                      new Enum("supervisor", INT_SUPERVISOR),
                    }
                );
                private static final long serialVersionUID = 1L;
                private java.lang.Object readResolve() { return forInt(intValue()); } 
            }
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel newValue(java.lang.Object obj) {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel) type.newValue( obj ); }
                
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel newInstance() {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML actualmonthlymileage(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.CalculateReimbursementAmountDocument$CalculateReimbursementAmount$Actualmonthlymileage.
         */
        public interface Actualmonthlymileage extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Actualmonthlymileage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("actualmonthlymileagef4d1elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage newValue(java.lang.Object obj) {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage) type.newValue( obj ); }
                
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage newInstance() {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount newInstance() {
              return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.CalculateReimbursementAmountDocument newInstance() {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.CalculateReimbursementAmountDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.CalculateReimbursementAmountDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
