// This is mutant program.
// Author : ysma

package ustb.edu.cn.rmb;


import javax.swing.*;


public class MoneyTranslation
{

    public java.lang.String rmbtostring( java.lang.String money )
    {
        double inputnum;
        double maxnum = 999999999999.99;
        int zeroCount;
        int i;
        int p;
        int quotient;
        int modulus;
        java.lang.String d;
        java.lang.String[] digits = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        java.lang.String[] radices = { "", "拾", "佰", "仟" };
        java.lang.String[] bigRadices = { "", "万", "亿" };
        java.lang.String[] decimals = { "角", "分" };
        java.lang.String integral = "";
        java.lang.String decimal = "";
        java.lang.String output = "";
        try {
            inputnum = Double.parseDouble( money );
        } catch ( java.lang.Exception e ) {
        }
        {
            int temp = money.indexOf( "." );
            if (temp != -1 && temp >= 0) {
                integral = money.substring( 0, temp );
                decimal = money.substring( temp + 1 );
                if (decimal.length() > 2) {
                    if (Integer.parseInt( decimal.substring( 2, 3 ) ) < 5) {
                        decimal = decimal.substring( 0, 2 );
                    } else {
                        if (decimal.substring( 0, 1 ).equals( "0" ) == false && decimal.substring( 0, 1 ).equals( "9" ) == false || decimal.substring( 0, 1 ).equals( "0" ) && decimal.substring( 1, 2 ).equals( "9" )) {
                            decimal = Integer.toString( Integer.parseInt( decimal.substring( 0, 2 ) ) + 1 );
                        } else {
                            if (decimal.substring( 0, 1 ).equals( "0" )) {
                                decimal = "0" + Integer.toString( Integer.parseInt( decimal.substring( 0, 2 ) ) + 1 );
                            } else {
                                if (decimal.substring( 0, 1 ).equals( "9" ) && decimal.substring( 1, 2 ).equals( "9" )) {
                                    decimal = "0";
                                    integral = Long.toString( Long.parseLong( integral ) + 1 );
                                }
                            }
                        }
                    }
                }
            } else {
                integral = money;
                decimal = "";
            }
            if (Long.parseLong( integral ) > 0) {
                zeroCount = 0;
                for (i = 0; i < integral.length(); i++) {
                    p = integral.length() - i - 1;
                    d = integral.substring( i, i + 1 );
                    quotient = p / 4;
                    modulus = p % 4;
                    if (d.equals( "0" )) {
                        zeroCount++;
                    } else {
                        if (zeroCount > 0) {
                            output += digits[0];
                        }
                        zeroCount = 0;
                        output += digits[Integer.parseInt( d )] + radices[modulus];
                    }
                    if (modulus == 0 && zeroCount < 4) {
                        output += bigRadices[quotient];
                    }
                }
                output += "元";
            }
            if (decimal != "") {
                for (i = 0; i < decimal.length(); i++) {
                    d = decimal.substring( i, i + 1 );
                    if (d.equals( "0" ) == false) {
                        output += digits[Integer.parseInt( d )] + decimals[i];
                    }
                }
            }
            if (output.equals( "" )) {
                output = "零元";
            }
            if ("".equals( decimal )) {
                output += "";
            }
        }
        return output;
    }

}
