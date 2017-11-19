
/**
 * ParkingFeeCalculatorSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package ws.simple.pfc;
    /**
     *  ParkingFeeCalculatorSkeleton java skeleton for the axisService
     */
    public class ParkingFeeCalculatorSkeleton{
        
         
        /**
         * Auto generated method signature
         * {&quot;userAttribute&quot;:&quot;&quot;, &quot;ipRegion&quot;:&quot;&quot;,&quot;invokeOp&quot;:&quot;&quot;,&quot;preOp&quot;:&quot;&quot;,&quot;preCT&quot;:&quot;&quot;,&quot;Iteration&quot;:&quot;loginResponse_fail&quot;}
                                     * @param login 
             * @return loginResponse 
         */
        
                 public ws.simple.pfc.LoginResponseDocument login
                  (
                  ws.simple.pfc.LoginDocument login
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#login");
        }
     
         
        /**
         * Auto generated method signature
         * {&quot;userAttribute&quot;:&quot;feeCalculate.License == login.License AND feeCalculate.timeout &gt;= login.loginTime&quot;, &quot;ipRegion&quot;:&quot;&quot;,&quot;invokeOp&quot;:&quot;&quot;,&quot;preOp&quot;:&quot;((login)(loginResponse_Success)(feeCalculate)(feeCalculateResponse_Success))*(login)(loginResponse_Success)&quot;,&quot;preCT&quot;:&quot;&quot;,&quot;Iteration&quot;:&quot;feeCalculateResponse_fail&quot;}
                                     * @param feeCalculate 
             * @return feeCalculateResponse 
         */
        
                 public ws.simple.pfc.FeeCalculateResponseDocument feeCalculate
                  (
                  ws.simple.pfc.FeeCalculateDocument feeCalculate
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#feeCalculate");
        }
     
    }
    