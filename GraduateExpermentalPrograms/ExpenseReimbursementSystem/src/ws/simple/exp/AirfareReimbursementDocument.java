/*
 * An XML document type.
 * Localname: airfareReimbursement
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.AirfareReimbursementDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp;


/**
 * A document containing one airfareReimbursement(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public interface AirfareReimbursementDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AirfareReimbursementDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("airfarereimbursemente97cdoctype");
    
    /**
     * Gets the "airfareReimbursement" element
     */
    ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement getAirfareReimbursement();
    
    /**
     * Sets the "airfareReimbursement" element
     */
    void setAirfareReimbursement(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement airfareReimbursement);
    
    /**
     * Appends and returns a new empty "airfareReimbursement" element
     */
    ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement addNewAirfareReimbursement();
    
    /**
     * An XML airfareReimbursement(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public interface AirfareReimbursement extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AirfareReimbursement.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("airfarereimbursement8fb8elemtype");
        
        /**
         * Gets the "stafflevel" element
         */
        ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel.Enum getStafflevel();
        
        /**
         * Gets (as xml) the "stafflevel" element
         */
        ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel xgetStafflevel();
        
        /**
         * Sets the "stafflevel" element
         */
        void setStafflevel(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel.Enum stafflevel);
        
        /**
         * Sets (as xml) the "stafflevel" element
         */
        void xsetStafflevel(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel stafflevel);
        
        /**
         * Gets the "monthlysalesamount" element
         */
        double getMonthlysalesamount();
        
        /**
         * Gets (as xml) the "monthlysalesamount" element
         */
        ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount xgetMonthlysalesamount();
        
        /**
         * Sets the "monthlysalesamount" element
         */
        void setMonthlysalesamount(double monthlysalesamount);
        
        /**
         * Sets (as xml) the "monthlysalesamount" element
         */
        void xsetMonthlysalesamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount monthlysalesamount);
        
        /**
         * Gets the "airfareamount" element
         */
        double getAirfareamount();
        
        /**
         * Gets (as xml) the "airfareamount" element
         */
        ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount xgetAirfareamount();
        
        /**
         * Sets the "airfareamount" element
         */
        void setAirfareamount(double airfareamount);
        
        /**
         * Sets (as xml) the "airfareamount" element
         */
        void xsetAirfareamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount airfareamount);
        
        /**
         * Gets the "otherexpensesamount" element
         */
        double getOtherexpensesamount();
        
        /**
         * Gets (as xml) the "otherexpensesamount" element
         */
        ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount xgetOtherexpensesamount();
        
        /**
         * Sets the "otherexpensesamount" element
         */
        void setOtherexpensesamount(double otherexpensesamount);
        
        /**
         * Sets (as xml) the "otherexpensesamount" element
         */
        void xsetOtherexpensesamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount otherexpensesamount);
        
        /**
         * An XML stafflevel(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Stafflevel.
         */
        public interface Stafflevel extends org.apache.xmlbeans.XmlString
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Stafflevel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("stafflevel7878elemtype");
            
            org.apache.xmlbeans.StringEnumAbstractBase enumValue();
            void set(org.apache.xmlbeans.StringEnumAbstractBase e);
            
            static final Enum SENIORMANAGER = Enum.forString("seniormanager");
            static final Enum MANAGER = Enum.forString("manager");
            static final Enum SUPERVISOR = Enum.forString("supervisor");
            
            static final int INT_SENIORMANAGER = Enum.INT_SENIORMANAGER;
            static final int INT_MANAGER = Enum.INT_MANAGER;
            static final int INT_SUPERVISOR = Enum.INT_SUPERVISOR;
            
            /**
             * Enumeration value class for ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Stafflevel.
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
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel newValue(java.lang.Object obj) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel) type.newValue( obj ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel newInstance() {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML monthlysalesamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Monthlysalesamount.
         */
        public interface Monthlysalesamount extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Monthlysalesamount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("monthlysalesamount0a05elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount newValue(java.lang.Object obj) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount) type.newValue( obj ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount newInstance() {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML airfareamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Airfareamount.
         */
        public interface Airfareamount extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Airfareamount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("airfareamountb4fcelemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount newValue(java.lang.Object obj) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount) type.newValue( obj ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount newInstance() {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML otherexpensesamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Otherexpensesamount.
         */
        public interface Otherexpensesamount extends org.apache.xmlbeans.XmlDouble
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Otherexpensesamount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7C63D0A169DC56E072CF6663C2B22D75").resolveHandle("otherexpensesamount9ea9elemtype");
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount newValue(java.lang.Object obj) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount) type.newValue( obj ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount newInstance() {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement newInstance() {
              return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static ws.simple.exp.AirfareReimbursementDocument newInstance() {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static ws.simple.exp.AirfareReimbursementDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.AirfareReimbursementDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static ws.simple.exp.AirfareReimbursementDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (ws.simple.exp.AirfareReimbursementDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
