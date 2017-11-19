/*
 * An XML document type.
 * Localname: totalAmount
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.TotalAmountDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one totalAmount(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class TotalAmountDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.TotalAmountDocument
{
    
    public TotalAmountDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TOTALAMOUNT$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "totalAmount");
    
    
    /**
     * Gets the "totalAmount" element
     */
    public ws.simple.exp.TotalAmountDocument.TotalAmount getTotalAmount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountDocument.TotalAmount target = null;
            target = (ws.simple.exp.TotalAmountDocument.TotalAmount)get_store().find_element_user(TOTALAMOUNT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "totalAmount" element
     */
    public void setTotalAmount(ws.simple.exp.TotalAmountDocument.TotalAmount totalAmount)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountDocument.TotalAmount target = null;
            target = (ws.simple.exp.TotalAmountDocument.TotalAmount)get_store().find_element_user(TOTALAMOUNT$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.TotalAmountDocument.TotalAmount)get_store().add_element_user(TOTALAMOUNT$0);
            }
            target.set(totalAmount);
        }
    }
    
    /**
     * Appends and returns a new empty "totalAmount" element
     */
    public ws.simple.exp.TotalAmountDocument.TotalAmount addNewTotalAmount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountDocument.TotalAmount target = null;
            target = (ws.simple.exp.TotalAmountDocument.TotalAmount)get_store().add_element_user(TOTALAMOUNT$0);
            return target;
        }
    }
    /**
     * An XML totalAmount(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class TotalAmountImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.TotalAmountDocument.TotalAmount
    {
        
        public TotalAmountImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TSTAFFLEVEL$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "tstafflevel");
        private static final javax.xml.namespace.QName TACTUALMONTHLYMILEAGE$2 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "tactualmonthlymileage");
        private static final javax.xml.namespace.QName TMONTHLYSALESAMOUNT$4 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "tmonthlysalesamount");
        private static final javax.xml.namespace.QName TAIRFAREAMOUNT$6 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "tairfareamount");
        private static final javax.xml.namespace.QName TOTHEREXPENSESAMOUNT$8 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "totherexpensesamount");
        
        
        /**
         * Gets the "tstafflevel" element
         */
        public java.lang.String getTstafflevel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TSTAFFLEVEL$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "tstafflevel" element
         */
        public org.apache.xmlbeans.XmlString xgetTstafflevel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TSTAFFLEVEL$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "tstafflevel" element
         */
        public void setTstafflevel(java.lang.String tstafflevel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TSTAFFLEVEL$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TSTAFFLEVEL$0);
                }
                target.setStringValue(tstafflevel);
            }
        }
        
        /**
         * Sets (as xml) the "tstafflevel" element
         */
        public void xsetTstafflevel(org.apache.xmlbeans.XmlString tstafflevel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TSTAFFLEVEL$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TSTAFFLEVEL$0);
                }
                target.set(tstafflevel);
            }
        }
        
        /**
         * Gets the "tactualmonthlymileage" element
         */
        public double getTactualmonthlymileage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "tactualmonthlymileage" element
         */
        public org.apache.xmlbeans.XmlDouble xgetTactualmonthlymileage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TACTUALMONTHLYMILEAGE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "tactualmonthlymileage" element
         */
        public void setTactualmonthlymileage(double tactualmonthlymileage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TACTUALMONTHLYMILEAGE$2);
                }
                target.setDoubleValue(tactualmonthlymileage);
            }
        }
        
        /**
         * Sets (as xml) the "tactualmonthlymileage" element
         */
        public void xsetTactualmonthlymileage(org.apache.xmlbeans.XmlDouble tactualmonthlymileage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(TACTUALMONTHLYMILEAGE$2);
                }
                target.set(tactualmonthlymileage);
            }
        }
        
        /**
         * Gets the "tmonthlysalesamount" element
         */
        public double getTmonthlysalesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TMONTHLYSALESAMOUNT$4, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "tmonthlysalesamount" element
         */
        public org.apache.xmlbeans.XmlDouble xgetTmonthlysalesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TMONTHLYSALESAMOUNT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "tmonthlysalesamount" element
         */
        public void setTmonthlysalesamount(double tmonthlysalesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TMONTHLYSALESAMOUNT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TMONTHLYSALESAMOUNT$4);
                }
                target.setDoubleValue(tmonthlysalesamount);
            }
        }
        
        /**
         * Sets (as xml) the "tmonthlysalesamount" element
         */
        public void xsetTmonthlysalesamount(org.apache.xmlbeans.XmlDouble tmonthlysalesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TMONTHLYSALESAMOUNT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(TMONTHLYSALESAMOUNT$4);
                }
                target.set(tmonthlysalesamount);
            }
        }
        
        /**
         * Gets the "tairfareamount" element
         */
        public double getTairfareamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TAIRFAREAMOUNT$6, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "tairfareamount" element
         */
        public org.apache.xmlbeans.XmlDouble xgetTairfareamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TAIRFAREAMOUNT$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "tairfareamount" element
         */
        public void setTairfareamount(double tairfareamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TAIRFAREAMOUNT$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TAIRFAREAMOUNT$6);
                }
                target.setDoubleValue(tairfareamount);
            }
        }
        
        /**
         * Sets (as xml) the "tairfareamount" element
         */
        public void xsetTairfareamount(org.apache.xmlbeans.XmlDouble tairfareamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TAIRFAREAMOUNT$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(TAIRFAREAMOUNT$6);
                }
                target.set(tairfareamount);
            }
        }
        
        /**
         * Gets the "totherexpensesamount" element
         */
        public double getTotherexpensesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTHEREXPENSESAMOUNT$8, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "totherexpensesamount" element
         */
        public org.apache.xmlbeans.XmlDouble xgetTotherexpensesamount()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TOTHEREXPENSESAMOUNT$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "totherexpensesamount" element
         */
        public void setTotherexpensesamount(double totherexpensesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTHEREXPENSESAMOUNT$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOTHEREXPENSESAMOUNT$8);
                }
                target.setDoubleValue(totherexpensesamount);
            }
        }
        
        /**
         * Sets (as xml) the "totherexpensesamount" element
         */
        public void xsetTotherexpensesamount(org.apache.xmlbeans.XmlDouble totherexpensesamount)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TOTHEREXPENSESAMOUNT$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(TOTHEREXPENSESAMOUNT$8);
                }
                target.set(totherexpensesamount);
            }
        }
    }
}
