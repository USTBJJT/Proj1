/*
 * An XML document type.
 * Localname: feeCalculate
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.FeeCalculateDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc.impl;
/**
 * A document containing one feeCalculate(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public class FeeCalculateDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.FeeCalculateDocument
{
    
    public FeeCalculateDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEECALCULATE$0 = 
        new javax.xml.namespace.QName("http://pfc.simple.ws", "feeCalculate");
    
    
    /**
     * Gets the "feeCalculate" element
     */
    public ws.simple.pfc.FeeCalculateDocument.FeeCalculate getFeeCalculate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateDocument.FeeCalculate target = null;
            target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate)get_store().find_element_user(FEECALCULATE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "feeCalculate" element
     */
    public void setFeeCalculate(ws.simple.pfc.FeeCalculateDocument.FeeCalculate feeCalculate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateDocument.FeeCalculate target = null;
            target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate)get_store().find_element_user(FEECALCULATE$0, 0);
            if (target == null)
            {
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate)get_store().add_element_user(FEECALCULATE$0);
            }
            target.set(feeCalculate);
        }
    }
    
    /**
     * Appends and returns a new empty "feeCalculate" element
     */
    public ws.simple.pfc.FeeCalculateDocument.FeeCalculate addNewFeeCalculate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateDocument.FeeCalculate target = null;
            target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate)get_store().add_element_user(FEECALCULATE$0);
            return target;
        }
    }
    /**
     * An XML feeCalculate(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public static class FeeCalculateImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.FeeCalculateDocument.FeeCalculate
    {
        
        public FeeCalculateImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName LICENSE$0 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "License");
        private static final javax.xml.namespace.QName TYPE$2 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "type");
        private static final javax.xml.namespace.QName TIMEOUT$4 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "timeout");
        private static final javax.xml.namespace.QName DAYOFWEEK$6 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "dayOfWeek");
        private static final javax.xml.namespace.QName DISCOUNTCOUPON$8 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "discountCoupon");
        
        
        /**
         * Gets the "License" element
         */
        public java.lang.String getLicense()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "License" element
         */
        public ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License xgetLicense()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License)get_store().find_element_user(LICENSE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "License" element
         */
        public void setLicense(java.lang.String license)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LICENSE$0);
                }
                target.setStringValue(license);
            }
        }
        
        /**
         * Sets (as xml) the "License" element
         */
        public void xsetLicense(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License license)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License)get_store().find_element_user(LICENSE$0, 0);
                if (target == null)
                {
                    target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License)get_store().add_element_user(LICENSE$0);
                }
                target.set(license);
            }
        }
        
        /**
         * Gets the "type" element
         */
        public int getType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$2, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "type" element
         */
        public ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type xgetType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type)get_store().find_element_user(TYPE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "type" element
         */
        public void setType(int type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TYPE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TYPE$2);
                }
                target.setIntValue(type);
            }
        }
        
        /**
         * Sets (as xml) the "type" element
         */
        public void xsetType(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type)get_store().find_element_user(TYPE$2, 0);
                if (target == null)
                {
                    target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type)get_store().add_element_user(TYPE$2);
                }
                target.set(type);
            }
        }
        
        /**
         * Gets the "timeout" element
         */
        public int getTimeout()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMEOUT$4, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "timeout" element
         */
        public ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout xgetTimeout()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout)get_store().find_element_user(TIMEOUT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "timeout" element
         */
        public void setTimeout(int timeout)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIMEOUT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIMEOUT$4);
                }
                target.setIntValue(timeout);
            }
        }
        
        /**
         * Sets (as xml) the "timeout" element
         */
        public void xsetTimeout(ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout timeout)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout target = null;
                target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout)get_store().find_element_user(TIMEOUT$4, 0);
                if (target == null)
                {
                    target = (ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout)get_store().add_element_user(TIMEOUT$4);
                }
                target.set(timeout);
            }
        }
        
        /**
         * Gets the "dayOfWeek" element
         */
        public boolean getDayOfWeek()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DAYOFWEEK$6, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "dayOfWeek" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetDayOfWeek()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(DAYOFWEEK$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "dayOfWeek" element
         */
        public void setDayOfWeek(boolean dayOfWeek)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DAYOFWEEK$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DAYOFWEEK$6);
                }
                target.setBooleanValue(dayOfWeek);
            }
        }
        
        /**
         * Sets (as xml) the "dayOfWeek" element
         */
        public void xsetDayOfWeek(org.apache.xmlbeans.XmlBoolean dayOfWeek)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(DAYOFWEEK$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(DAYOFWEEK$6);
                }
                target.set(dayOfWeek);
            }
        }
        
        /**
         * Gets the "discountCoupon" element
         */
        public boolean getDiscountCoupon()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISCOUNTCOUPON$8, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "discountCoupon" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetDiscountCoupon()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(DISCOUNTCOUPON$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "discountCoupon" element
         */
        public void setDiscountCoupon(boolean discountCoupon)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISCOUNTCOUPON$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DISCOUNTCOUPON$8);
                }
                target.setBooleanValue(discountCoupon);
            }
        }
        
        /**
         * Sets (as xml) the "discountCoupon" element
         */
        public void xsetDiscountCoupon(org.apache.xmlbeans.XmlBoolean discountCoupon)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(DISCOUNTCOUPON$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(DISCOUNTCOUPON$8);
                }
                target.set(discountCoupon);
            }
        }
        /**
         * An XML License(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$License.
         */
        public static class LicenseImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements ws.simple.pfc.FeeCalculateDocument.FeeCalculate.License
        {
            
            public LicenseImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected LicenseImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML type(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$Type.
         */
        public static class TypeImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Type
        {
            
            public TypeImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected TypeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML timeout(@http://pfc.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.pfc.FeeCalculateDocument$FeeCalculate$Timeout.
         */
        public static class TimeoutImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements ws.simple.pfc.FeeCalculateDocument.FeeCalculate.Timeout
        {
            
            public TimeoutImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected TimeoutImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
