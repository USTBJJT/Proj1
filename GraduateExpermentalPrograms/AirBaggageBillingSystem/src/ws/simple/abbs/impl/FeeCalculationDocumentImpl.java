/*
 * An XML document type.
 * Localname: feeCalculation
 * Namespace: http://abbs.simple.ws
 * Java type: ws.simple.abbs.FeeCalculationDocument
 *
 * Automatically generated - do not modify.
 */
package ws.simple.abbs.impl;
/**
 * A document containing one feeCalculation(@http://abbs.simple.ws) element.
 *
 * This is a complex type.
 */
public class FeeCalculationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.FeeCalculationDocument
{
    
    public FeeCalculationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FEECALCULATION$0 = 
        new javax.xml.namespace.QName("http://abbs.simple.ws", "feeCalculation");
    
    
    /**
     * Gets the "feeCalculation" element
     */
    public ws.simple.abbs.FeeCalculationDocument.FeeCalculation getFeeCalculation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationDocument.FeeCalculation target = null;
            target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation)get_store().find_element_user(FEECALCULATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "feeCalculation" element
     */
    public void setFeeCalculation(ws.simple.abbs.FeeCalculationDocument.FeeCalculation feeCalculation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationDocument.FeeCalculation target = null;
            target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation)get_store().find_element_user(FEECALCULATION$0, 0);
            if (target == null)
            {
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation)get_store().add_element_user(FEECALCULATION$0);
            }
            target.set(feeCalculation);
        }
    }
    
    /**
     * Appends and returns a new empty "feeCalculation" element
     */
    public ws.simple.abbs.FeeCalculationDocument.FeeCalculation addNewFeeCalculation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            ws.simple.abbs.FeeCalculationDocument.FeeCalculation target = null;
            target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation)get_store().add_element_user(FEECALCULATION$0);
            return target;
        }
    }
    /**
     * An XML feeCalculation(@http://abbs.simple.ws).
     *
     * This is a complex type.
     */
    public static class FeeCalculationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ws.simple.abbs.FeeCalculationDocument.FeeCalculation
    {
        
        public FeeCalculationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CHOOSEAIRCLASS$0 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "chooseAirClass");
        private static final javax.xml.namespace.QName CHOOSEAREA$2 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "chooseArea");
        private static final javax.xml.namespace.QName ISSTUDENT$4 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "isStudent");
        private static final javax.xml.namespace.QName LUGGAGE$6 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "luggage");
        private static final javax.xml.namespace.QName ECONOMICFEE$8 = 
            new javax.xml.namespace.QName("http://abbs.simple.ws", "economicfee");
        
        
        /**
         * Gets the "chooseAirClass" element
         */
        public int getChooseAirClass()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHOOSEAIRCLASS$0, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "chooseAirClass" element
         */
        public ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass xgetChooseAirClass()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass)get_store().find_element_user(CHOOSEAIRCLASS$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "chooseAirClass" element
         */
        public void setChooseAirClass(int chooseAirClass)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHOOSEAIRCLASS$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CHOOSEAIRCLASS$0);
                }
                target.setIntValue(chooseAirClass);
            }
        }
        
        /**
         * Sets (as xml) the "chooseAirClass" element
         */
        public void xsetChooseAirClass(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass chooseAirClass)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass)get_store().find_element_user(CHOOSEAIRCLASS$0, 0);
                if (target == null)
                {
                    target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass)get_store().add_element_user(CHOOSEAIRCLASS$0);
                }
                target.set(chooseAirClass);
            }
        }
        
        /**
         * Gets the "chooseArea" element
         */
        public int getChooseArea()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHOOSEAREA$2, 0);
                if (target == null)
                {
                    return 0;
                }
                return target.getIntValue();
            }
        }
        
        /**
         * Gets (as xml) the "chooseArea" element
         */
        public ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea xgetChooseArea()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea)get_store().find_element_user(CHOOSEAREA$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "chooseArea" element
         */
        public void setChooseArea(int chooseArea)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CHOOSEAREA$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CHOOSEAREA$2);
                }
                target.setIntValue(chooseArea);
            }
        }
        
        /**
         * Sets (as xml) the "chooseArea" element
         */
        public void xsetChooseArea(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea chooseArea)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea)get_store().find_element_user(CHOOSEAREA$2, 0);
                if (target == null)
                {
                    target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea)get_store().add_element_user(CHOOSEAREA$2);
                }
                target.set(chooseArea);
            }
        }
        
        /**
         * Gets the "isStudent" element
         */
        public boolean getIsStudent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSTUDENT$4, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "isStudent" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetIsStudent()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ISSTUDENT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "isStudent" element
         */
        public void setIsStudent(boolean isStudent)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ISSTUDENT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ISSTUDENT$4);
                }
                target.setBooleanValue(isStudent);
            }
        }
        
        /**
         * Sets (as xml) the "isStudent" element
         */
        public void xsetIsStudent(org.apache.xmlbeans.XmlBoolean isStudent)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(ISSTUDENT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(ISSTUDENT$4);
                }
                target.set(isStudent);
            }
        }
        
        /**
         * Gets the "luggage" element
         */
        public double getLuggage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LUGGAGE$6, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "luggage" element
         */
        public ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage xgetLuggage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage)get_store().find_element_user(LUGGAGE$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "luggage" element
         */
        public void setLuggage(double luggage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LUGGAGE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LUGGAGE$6);
                }
                target.setDoubleValue(luggage);
            }
        }
        
        /**
         * Sets (as xml) the "luggage" element
         */
        public void xsetLuggage(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage luggage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage)get_store().find_element_user(LUGGAGE$6, 0);
                if (target == null)
                {
                    target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage)get_store().add_element_user(LUGGAGE$6);
                }
                target.set(luggage);
            }
        }
        
        /**
         * Gets the "economicfee" element
         */
        public double getEconomicfee()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ECONOMICFEE$8, 0);
                if (target == null)
                {
                    return 0.0;
                }
                return target.getDoubleValue();
            }
        }
        
        /**
         * Gets (as xml) the "economicfee" element
         */
        public ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee xgetEconomicfee()
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee)get_store().find_element_user(ECONOMICFEE$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "economicfee" element
         */
        public void setEconomicfee(double economicfee)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ECONOMICFEE$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ECONOMICFEE$8);
                }
                target.setDoubleValue(economicfee);
            }
        }
        
        /**
         * Sets (as xml) the "economicfee" element
         */
        public void xsetEconomicfee(ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee economicfee)
        {
            synchronized (monitor())
            {
                check_orphaned();
                ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee target = null;
                target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee)get_store().find_element_user(ECONOMICFEE$8, 0);
                if (target == null)
                {
                    target = (ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee)get_store().add_element_user(ECONOMICFEE$8);
                }
                target.set(economicfee);
            }
        }
        /**
         * An XML chooseAirClass(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$ChooseAirClass.
         */
        public static class ChooseAirClassImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseAirClass
        {
            
            public ChooseAirClassImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected ChooseAirClassImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML chooseArea(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$ChooseArea.
         */
        public static class ChooseAreaImpl extends org.apache.xmlbeans.impl.values.JavaIntHolderEx implements ws.simple.abbs.FeeCalculationDocument.FeeCalculation.ChooseArea
        {
            
            public ChooseAreaImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected ChooseAreaImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML luggage(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$Luggage.
         */
        public static class LuggageImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Luggage
        {
            
            public LuggageImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected LuggageImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
        /**
         * An XML economicfee(@http://abbs.simple.ws).
         *
         * This is an atomic type that is a restriction of ws.simple.abbs.FeeCalculationDocument$FeeCalculation$Economicfee.
         */
        public static class EconomicfeeImpl extends org.apache.xmlbeans.impl.values.JavaDoubleHolderEx implements ws.simple.abbs.FeeCalculationDocument.FeeCalculation.Economicfee
        {
            
            public EconomicfeeImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType, false);
            }
            
            protected EconomicfeeImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
            {
                super(sType, b);
            }
        }
    }
}
