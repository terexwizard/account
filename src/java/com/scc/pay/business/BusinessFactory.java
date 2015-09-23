/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scc.pay.business;


import com.scc.f1.Constant;
import com.scc.f1.business.BusinessFactoryb;
import com.scc.f1.business.IBusinessBase;


/**
 *
 * @author Administrator
 * @version 1.00.4
 */
public final class BusinessFactory {
    
    public static IBusinessBase getBusiness(String name){
        
        return BusinessFactoryb.getBusiness(name,Constant.PACKAGE_BUSINESS);
    }

}
