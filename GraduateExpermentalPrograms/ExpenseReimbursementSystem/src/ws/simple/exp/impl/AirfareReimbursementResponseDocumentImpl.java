/*
 * An XML document type.
 * Localname: airfareReimbursementResponse
 * Namespace: http://exp.simple.ws
 * Java type: ws.simple.exp.AirfareReimbursementResponseDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.exp.impl;
/**
 * A document containing one airfareReimbursementResponse(@http://exp.simple.ws) element.
 *
 * This is a complex type.
 */
public class AirfareReimbursementResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.AirfareReimbursementResponseDocument
{
    
    public AirfareReimbursementResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AIRFAREREIMBURSEMENTRESPONSE$0 = 
        new javax.xml.namespace.QName("http://exp.simple.ws", "airfareReimbursementResponse");
    
    
    /**
     * Gets the "airfareReimbursementResponse" element
     */
    public ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse getAirfareReimbursementResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse target = null;
            target = (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse)get_store().find_element_user(AIRFAREREIMBURSEMENTRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "airfareReimbursementResponse" element
     */
    public void setAirfareReimbursementResponse(ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse airfareReimbursementResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse target = null;
            target = (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse)get_store().find_element_user(AIRFAREREIMBURSEMENTRESPONSE$0, 0);
            if (target == null)
            {
                target = (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse)get_store().add_element_user(AIRFAREREIMBURSEMENTRESPONSE$0);
            }
            target.set(airfareReimbursementResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "airfareReimbursementResponse" element
     */
    public ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse addNewAirfareReimbursementResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse target = null;
            target = (ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse)get_store().add_element_user(AIRFAREREIMBURSEMENTRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML airfareReimbursementResponse(@http://exp.simple.ws).
     *
     * This is a complex type.
     */
    public static class AirfareReimbursementResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.exp.AirfareReimbursementResponseDocument.AirfareReimbursementResponse
    {
        
        public AirfareReimbursementResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName AIRFAREREIMBURSEMENTRETURN$0 = 
            new javax.xml.namespace.QName("http://exp.simple.ws", "airfareReimbursementReturn");
        
        
        /**
         * Gets the "airfareReimbursementReturn" element
         */
        public double getAirfareReimbursementReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AIRFAREREIMBURSEMENTRETURN$0, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "airfareReimbursementReturn" element
         */
        public org.apache.xmlbeans.XmlDouble xgetAirfareReimbursementReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(AIRFAREREIMBURSEMENTRETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "airfareReimbursementReturn" element
         */
        public void setAirfareReimbursementReturn(double airfareReimbursementReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AIRFAREREIMBURSEMENTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AIRFAREREIMBURSEMENTRETURN$0);
                }
                target.setDoubleValue(airfareReimbursementReturn);
            }
        }
        
        /**
         * Sets (as xml) the "airfareReimbursementReturn" element
         */
        public void xsetAirfareReimbursementReturn(org.apache.xmlbeans.XmlDouble airfareReimbursementReturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDouble target = null;
                target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(AIRFAREREIMBURSEMENTRETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(AIRFAREREIMBURSEMENTRETURN$0);
                }
                target.set(airfareReimbursementReturn);
            }
        }
    }
}
