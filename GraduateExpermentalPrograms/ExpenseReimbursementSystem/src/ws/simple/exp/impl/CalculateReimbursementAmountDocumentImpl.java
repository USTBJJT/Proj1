/*
 * An XML document type.
 * Localname: calculateReimbursementAmount
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.CalculateReimbursementAmountDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one calculateReimbursementAmount(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class CalculateReimbursementAmountDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.CalculateReimbursementAmountDocument
{
    
    public CalculateReimbursementAmountDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CALCULATEREIMBURSEMENTAMOUNT$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "calculateReimbursementAmount");
    
    
    /**
     * Gets the "calculateReimbursementAmount" element
     */
    public ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount getCalculateReimbursementAmount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "calculateReimbursementAmount" element
     */
    public void setCalculateReimbursementAmount(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount calculateReimbursementAmount)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNT$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNT$0);
            }
            target.set(calculateReimbursementAmount);
        }
    }
    
    /**
     * Appends and returns a new empty "calculateReimbursementAmount" element
     */
    public ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount addNewCalculateReimbursementAmount()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNT$0);
            return target;
        }
    }
    /**
     * An XML calculateReimbursementAmount(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class CalculateReimbursementAmountImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount
    {
        
        public CalculateReimbursementAmountImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName STAFFLEVEL$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "stafflevel");
        private static final javax.xml.namespace.QName ACTUALMONTHLYMILEAGE$2 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "actualmonthlymileage");
        
        
        /**
         * Gets the "stafflevel" element
         */
        public ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel.Enum getStafflevel()
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
                return (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "stafflevel" element
         */
        public ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel xgetStafflevel()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel target = null;
                target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel)get_store().find_element_user(STAFFLEVEL$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "stafflevel" element
         */
        public void setStafflevel(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel.Enum stafflevel)
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
        public void xsetStafflevel(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel stafflevel)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel target = null;
                target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel)get_store().find_element_user(STAFFLEVEL$0, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel)get_store().add_element_user(STAFFLEVEL$0);
                }
                target.set(stafflevel);
            }
        }
        
        /**
         * Gets the "actualmonthlymileage" element
         */
        public double getActualmonthlymileage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "actualmonthlymileage" element
         */
        public ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage xgetActualmonthlymileage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage target = null;
                target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage)get_store().find_element_user(ACTUALMONTHLYMILEAGE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "actualmonthlymileage" element
         */
        public void setActualmonthlymileage(double actualmonthlymileage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ACTUALMONTHLYMILEAGE$2);
                }
                target.setDoubleValue(actualmonthlymileage);
            }
        }
        
        /**
         * Sets (as xml) the "actualmonthlymileage" element
         */
        public void xsetActualmonthlymileage(ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage actualmonthlymileage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage target = null;
                target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage)get_store().find_element_user(ACTUALMONTHLYMILEAGE$2, 0);
                if (target == null)
                {
                    target = (ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage)get_store().add_element_user(ACTUALMONTHLYMILEAGE$2);
                }
                target.set(actualmonthlymileage);
            }
        }
        /**
         * An XML stafflevel(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.CalculateReimbursementAmountDocument$CalculateReimbursementAmount$Stafflevel.
         */
        public static class StafflevelImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Stafflevel
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
         * An XML actualmonthlymileage(@http://exp.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.exp.CalculateReimbursementAmountDocument$CalculateReimbursementAmount$Actualmonthlymileage.
         */
        public static class ActualmonthlymileageImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.exp.CalculateReimbursementAmountDocument.CalculateReimbursementAmount.Actualmonthlymileage
        {
            
            public ActualmonthlymileageImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected ActualmonthlymileageImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
