/*
 * An XML document type.
 * Localname: totalAmountResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.TotalAmountResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one totalAmountResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class TotalAmountResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.TotalAmountResponseDocument
{
    
    public TotalAmountResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TOTALAMOUNTRESPONSE$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "totalAmountResponse");
    
    
    /**
     * Gets the "totalAmountResponse" element
     */
    public ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse getTotalAmountResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse target = null;
            target = (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse)get_store().find_element_user(TOTALAMOUNTRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "totalAmountResponse" element
     */
    public void setTotalAmountResponse(ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse totalAmountResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse target = null;
            target = (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse)get_store().find_element_user(TOTALAMOUNTRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse)get_store().add_element_user(TOTALAMOUNTRESPONSE$0);
            }
            target.set(totalAmountResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "totalAmountResponse" element
     */
    public ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse addNewTotalAmountResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse target = null;
            target = (ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse)get_store().add_element_user(TOTALAMOUNTRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML totalAmountResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class TotalAmountResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.TotalAmountResponseDocument.TotalAmountResponse
    {
        
        public TotalAmountResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TOTALAMOUNTRETURN$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "totalAmountReturn");
        
        
        /**
         * Gets the "totalAmountReturn" element
         */
        public double getTotalAmountReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "totalAmountReturn" element
         */
        public org.apache.xmlbeans.XmlDouble xgetTotalAmountReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TOTALAMOUNTRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "totalAmountReturn" element
         */
        public void setTotalAmountReturn(double totalAmountReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOTALAMOUNTRETURN$0);
                }
                target.setDoubleValue(totalAmountReturn);
            }
        }
        
        /**
         * Sets (as xml) the "totalAmountReturn" element
         */
        public void xsetTotalAmountReturn(org.apache.xmlbeans.XmlDouble totalAmountReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(TOTALAMOUNTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(TOTALAMOUNTRETURN$0);
                }
                target.set(totalAmountReturn);
            }
        }
    }
}
