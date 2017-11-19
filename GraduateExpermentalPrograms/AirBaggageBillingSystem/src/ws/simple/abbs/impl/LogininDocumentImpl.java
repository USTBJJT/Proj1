/*
 * An XML document type.
 * Localname: loginin
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.LogininDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs.impl;
/**
 * A document containing one loginin(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public class LogininDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.LogininDocument
{
    
    public LogininDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOGININ$0 = 
        new javax.xml.namespace.QName("http://abbs.simple.ws", "loginin");
    
    
    /**
     * Gets the "loginin" element
     */
    public ws.simple.abbs.LogininDocument.Loginin getLoginin()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininDocument.Loginin target = null;
            target = (ws.simple.abbs.LogininDocument.Loginin)get_store().find_element_user(LOGININ$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "loginin" element
     */
    public void setLoginin(ws.simple.abbs.LogininDocument.Loginin loginin)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininDocument.Loginin target = null;
            target = (ws.simple.abbs.LogininDocument.Loginin)get_store().find_element_user(LOGININ$0, 0);
            if (target == null)
            {
                target = (ws.simple.abbs.LogininDocument.Loginin)get_store().add_element_user(LOGININ$0);
            }
            target.set(loginin);
        }
    }
    
    /**
     * Appends and returns a new empty "loginin" element
     */
    public ws.simple.abbs.LogininDocument.Loginin addNewLoginin()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.LogininDocument.Loginin target = null;
            target = (ws.simple.abbs.LogininDocument.Loginin)get_store().add_element_user(LOGININ$0);
            return target;
        }
    }
    /**
     * An XML loginin(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public static class LogininImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.LogininDocument.Loginin
    {
        
        public LogininImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "name");
        
        
        /**
         * Gets the "name" element
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" element
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "name" element
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" element
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
                }
                target.set(name);
            }
        }
    }
}
