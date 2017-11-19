/*
 * An XML document type.
 * Localname: feeCalculateResponse
 * Namespace: http://pfc.simple.ws
 * Java type: ws.simple.pfc.FeeCalculateResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.pfc.impl;
/**
 * A document containing one feeCalculateResponse(@http://pfc.simple.ws) element.
 *
 * This is a complex type.
 */
public class FeeCalculateResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.FeeCalculateResponseDocument
{
    
    public FeeCalculateResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEECALCULATERESPONSE$0 = 
        new javax.xml.namespace.QName("http://pfc.simple.ws", "feeCalculateResponse");
    
    
    /**
     * Gets the "feeCalculateResponse" element
     */
    public ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse getFeeCalculateResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse target = null;
            target = (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse)get_store().find_element_user(FEECALCULATERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "feeCalculateResponse" element
     */
    public void setFeeCalculateResponse(ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse feeCalculateResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse target = null;
            target = (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse)get_store().find_element_user(FEECALCULATERESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse)get_store().add_element_user(FEECALCULATERESPONSE$0);
            }
            target.set(feeCalculateResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "feeCalculateResponse" element
     */
    public ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse addNewFeeCalculateResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse target = null;
            target = (ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse)get_store().add_element_user(FEECALCULATERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML feeCalculateResponse(@http://pfc.simple.ws).
     *
     * This is a complex type.
     */
    public static class FeeCalculateResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.pfc.FeeCalculateResponseDocument.FeeCalculateResponse
    {
        
        public FeeCalculateResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FEECALCULATERETURN$0 = 
            new javax.xml.namespace.QName("http://pfc.simple.ws", "feeCalculateReturn");
        
        
        /**
         * Gets the "feeCalculateReturn" element
         */
        public double getFeeCalculateReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEECALCULATERETURN$0, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "feeCalculateReturn" element
         */
        public org.apache.xmlbeans.XmlDouble xgetFeeCalculateReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(FEECALCULATERETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "feeCalculateReturn" element
         */
        public void setFeeCalculateReturn(double feeCalculateReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FEECALCULATERETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FEECALCULATERETURN$0);
                }
                target.setDoubleValue(feeCalculateReturn);
            }
        }
        
        /**
         * Sets (as xml) the "feeCalculateReturn" element
         */
        public void xsetFeeCalculateReturn(org.apache.xmlbeans.XmlDouble feeCalculateReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(FEECALCULATERETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(FEECALCULATERETURN$0);
                }
                target.set(feeCalculateReturn);
            }
        }
    }
}
