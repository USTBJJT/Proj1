/*
 * An XML document type.
 * Localname: calculateReimbursementAmountResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.CalculateReimbursementAmountResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one calculateReimbursementAmountResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class CalculateReimbursementAmountResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.CalculateReimbursementAmountResponseDocument
{
    
    public CalculateReimbursementAmountResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CALCULATEREIMBURSEMENTAMOUNTRESPONSE$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "calculateReimbursementAmountResponse");
    
    
    /**
     * Gets the "calculateReimbursementAmountResponse" element
     */
    public ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse getCalculateReimbursementAmountResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "calculateReimbursementAmountResponse" element
     */
    public void setCalculateReimbursementAmountResponse(ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse calculateReimbursementAmountResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNTRESPONSE$0);
            }
            target.set(calculateReimbursementAmountResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "calculateReimbursementAmountResponse" element
     */
    public ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse addNewCalculateReimbursementAmountResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse target = null;
            target = (ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNTRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML calculateReimbursementAmountResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class CalculateReimbursementAmountResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.CalculateReimbursementAmountResponseDocument.CalculateReimbursementAmountResponse
    {
        
        public CalculateReimbursementAmountResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CALCULATEREIMBURSEMENTAMOUNTRETURN$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "calculateReimbursementAmountReturn");
        
        
        /**
         * Gets the "calculateReimbursementAmountReturn" element
         */
        public double getCalculateReimbursementAmountReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "calculateReimbursementAmountReturn" element
         */
        public org.apache.xmlbeans.XmlDouble xgetCalculateReimbursementAmountReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "calculateReimbursementAmountReturn" element
         */
        public void setCalculateReimbursementAmountReturn(double calculateReimbursementAmountReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0);
                }
                target.setDoubleValue(calculateReimbursementAmountReturn);
            }
        }
        
        /**
         * Sets (as xml) the "calculateReimbursementAmountReturn" element
         */
        public void xsetCalculateReimbursementAmountReturn(org.apache.xmlbeans.XmlDouble calculateReimbursementAmountReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(CALCULATEREIMBURSEMENTAMOUNTRETURN$0);
                }
                target.set(calculateReimbursementAmountReturn);
            }
        }
    }
}
