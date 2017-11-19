/*
 * An XML document type.
 * Localname: feeCalculationResponse
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.FeeCalculationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs.impl;
/**
 * A document containing one feeCalculationResponse(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public class FeeCalculationResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.FeeCalculationResponseDocument
{
    
    public FeeCalculationResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEECALCULATIONRESPONSE$0 = 
        new javax.xml.namespace.QName("http://abbs.simple.ws", "feeCalculationResponse");
    
    
    /**
     * Gets the "feeCalculationResponse" element
     */
    public ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse getFeeCalculationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse target = null;
            target = (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse)get_store().find_element_user(FEECALCULATIONRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "feeCalculationResponse" element
     */
    public void setFeeCalculationResponse(ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse feeCalculationResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse target = null;
            target = (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse)get_store().find_element_user(FEECALCULATIONRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse)get_store().add_element_user(FEECALCULATIONRESPONSE$0);
            }
            target.set(feeCalculationResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "feeCalculationResponse" element
     */
    public ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse addNewFeeCalculationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse target = null;
            target = (ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse)get_store().add_element_user(FEECALCULATIONRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML feeCalculationResponse(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public static class FeeCalculationResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.FeeCalculationResponseDocument.FeeCalculationResponse
    {
        
        public FeeCalculationResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FEECALCULATIONRETURN$0 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "feeCalculationReturn");
        
        
        /**
         * Gets the "feeCalculationReturn" element
         */
        public double getFeeCalculationReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEECALCULATIONRETURN$0, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "feeCalculationReturn" element
         */
        public org.apache.xmlbeans.XmlDouble xgetFeeCalculationReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(FEECALCULATIONRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "feeCalculationReturn" element
         */
        public void setFeeCalculationReturn(double feeCalculationReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEECALCULATIONRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEECALCULATIONRETURN$0);
                }
                target.setDoubleValue(feeCalculationReturn);
            }
        }
        
        /**
         * Sets (as xml) the "feeCalculationReturn" element
         */
        public void xsetFeeCalculationReturn(org.apache.xmlbeans.XmlDouble feeCalculationReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(FEECALCULATIONRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(FEECALCULATIONRETURN$0);
                }
                target.set(feeCalculationReturn);
            }
        }
    }
}
