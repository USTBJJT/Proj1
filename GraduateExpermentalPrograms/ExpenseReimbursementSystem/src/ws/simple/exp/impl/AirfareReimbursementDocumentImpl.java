/*
 * An XML document type.
 * Localname: airfareReimbursement
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.AirfareReimbursementDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one airfareReimbursement(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class AirfareReimbursementDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.AirfareReimbursementDocument
{
    
    public AirfareReimbursementDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AIRFAREREIMBURSEMENT$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "airfareReimbursement");
    
    
    /**
     * Gets the "airfareReimbursement" element
     */
    public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement getAirfareReimbursement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement target = null;
            target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement)get_store().find_element_user(AIRFAREREIMBURSEMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "airfareReimbursement" element
     */
    public void setAirfareReimbursement(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement airfareReimbursement)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement target = null;
            target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement)get_store().find_element_user(AIRFAREREIMBURSEMENT$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement)get_store().add_element_user(AIRFAREREIMBURSEMENT$0);
            }
            target.set(airfareReimbursement);
        }
    }
    
    /**
     * Appends and returns a new empty "airfareReimbursement" element
     */
    public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement addNewAirfareReimbursement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement target = null;
            target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement)get_store().add_element_user(AIRFAREREIMBURSEMENT$0);
            return target;
        }
    }
    /**
     * An XML airfareReimbursement(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class AirfareReimbursementImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement
    {
        
        public AirfareReimbursementImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName STAFFLEVEL$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "stafflevel");
        private static final javax.xml.namespace.QName MONTHLYSALESAMOUNT$2 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "monthlysalesamount");
        private static final javax.xml.namespace.QName AIRFAREAMOUNT$4 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "airfareamount");
        private static final javax.xml.namespace.QName OTHEREXPENSESAMOUNT$6 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "otherexpensesamount");
        
        
        /**
         * Gets the "stafflevel" element
         */
        public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel.Enum getStafflevel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAFFLEVEL$0, 0);
                if (target == null)
                {
                    return null;
                }
                return (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "stafflevel" element
         */
        public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel xgetStafflevel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel)get_store().find_element_user(STAFFLEVEL$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "stafflevel" element
         */
        public void setStafflevel(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel.Enum stafflevel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STAFFLEVEL$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STAFFLEVEL$0);
                }
                target.setEnumValue(stafflevel);
            }
        }
        
        /**
         * Sets (as xml) the "stafflevel" element
         */
        public void xsetStafflevel(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel stafflevel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel)get_store().find_element_user(STAFFLEVEL$0, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel)get_store().add_element_user(STAFFLEVEL$0);
                }
                target.set(stafflevel);
            }
        }
        
        /**
         * Gets the "monthlysalesamount" element
         */
        public double getMonthlysalesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONTHLYSALESAMOUNT$2, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "monthlysalesamount" element
         */
        public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount xgetMonthlysalesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount)get_store().find_element_user(MONTHLYSALESAMOUNT$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "monthlysalesamount" element
         */
        public void setMonthlysalesamount(double monthlysalesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MONTHLYSALESAMOUNT$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MONTHLYSALESAMOUNT$2);
                }
                target.setDoubleValue(monthlysalesamount);
            }
        }
        
        /**
         * Sets (as xml) the "monthlysalesamount" element
         */
        public void xsetMonthlysalesamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount monthlysalesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount)get_store().find_element_user(MONTHLYSALESAMOUNT$2, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount)get_store().add_element_user(MONTHLYSALESAMOUNT$2);
                }
                target.set(monthlysalesamount);
            }
        }
        
        /**
         * Gets the "airfareamount" element
         */
        public double getAirfareamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AIRFAREAMOUNT$4, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "airfareamount" element
         */
        public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount xgetAirfareamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount)get_store().find_element_user(AIRFAREAMOUNT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "airfareamount" element
         */
        public void setAirfareamount(double airfareamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AIRFAREAMOUNT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AIRFAREAMOUNT$4);
                }
                target.setDoubleValue(airfareamount);
            }
        }
        
        /**
         * Sets (as xml) the "airfareamount" element
         */
        public void xsetAirfareamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount airfareamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount)get_store().find_element_user(AIRFAREAMOUNT$4, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount)get_store().add_element_user(AIRFAREAMOUNT$4);
                }
                target.set(airfareamount);
            }
        }
        
        /**
         * Gets the "otherexpensesamount" element
         */
        public double getOtherexpensesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OTHEREXPENSESAMOUNT$6, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "otherexpensesamount" element
         */
        public ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount xgetOtherexpensesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount)get_store().find_element_user(OTHEREXPENSESAMOUNT$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "otherexpensesamount" element
         */
        public void setOtherexpensesamount(double otherexpensesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OTHEREXPENSESAMOUNT$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OTHEREXPENSESAMOUNT$6);
                }
                target.setDoubleValue(otherexpensesamount);
            }
        }
        
        /**
         * Sets (as xml) the "otherexpensesamount" element
         */
        public void xsetOtherexpensesamount(ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount otherexpensesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount target = null;
                target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount)get_store().find_element_user(OTHEREXPENSESAMOUNT$6, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount)get_store().add_element_user(OTHEREXPENSESAMOUNT$6);
                }
                target.set(otherexpensesamount);
            }
        }
        /**
         * An XML stafflevel(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Stafflevel.
         */
        public static class StafflevelImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Stafflevel
        {
            
            public StafflevelImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected StafflevelImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML monthlysalesamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Monthlysalesamount.
         */
        public static class MonthlysalesamountImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Monthlysalesamount
        {
            
            public MonthlysalesamountImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected MonthlysalesamountImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML airfareamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Airfareamount.
         */
        public static class AirfareamountImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Airfareamount
        {
            
            public AirfareamountImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected AirfareamountImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML otherexpensesamount(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.AirfareReimbursementDocument$AirfareReimbursement$Otherexpensesamount.
         */
        public static class OtherexpensesamountImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.exp.AirfareReimbursementDocument.AirfareReimbursement.Otherexpensesamount
        {
            
            public OtherexpensesamountImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected OtherexpensesamountImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
