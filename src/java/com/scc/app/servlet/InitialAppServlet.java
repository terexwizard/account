/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scc.app.servlet;


//import com.scc.dbd.regcom.dbutil.QueryXML;
//import com.scc.dbd.regcom.dbutil.RdbXML;

import com.scc.f1.AppConfig;
import com.scc.f1.Constant;
import com.scc.f1.util.Utils;
import com.scc.pay.AppConstant;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;


/**
 *
 * @author Administrator
 */
//,urlPatterns="/Initial"
//@WebServlet (name="Initial"  ,loadOnStartup=0 )
public class InitialAppServlet extends com.scc.f1.servlet.InitialAppServlet {
    
   
    @Override
    protected void readAndSetConfig(HashMap<String, String> hm) {
//        throw new UnsupportedOperationException("Not supported yet.");
        
        Constant.PACKAGE_BUSINESS   = "com.scc.pay.business";
        
        AppConstant.EAS_SERVER                  = AppConfig.get("eas_server");
        
        AppConstant.EAS_SERVER_PORT             = convertToInt(AppConfig.get("eas_server_port"));
        AppConstant.EAS_SERVER_TRANSFER_PORT    = convertToInt(AppConfig.get("eas_server_transfer_port"));
        AppConstant.EAS_SERVER_BEAN_PORT        = convertToInt(AppConfig.get("eas_server_bean_port"));
        
        
        AppConstant.PAGE_REGISTER_NONE_LOGIN                = AppConfig.get("page_register_none_login");
        AppConstant.PAGE_REGISTER_AFTER_LOGIN               = AppConfig.get("page_register_after_login");
    }

    @Override
    protected void initOther(HashMap<String, String> hm) {
//        throw new UnsupportedOperationException("Not supported yet.");
        
        logger.info("Charset : "+Charset.defaultCharset().name());
        
        String txt      = "ระบบ";
       
        InputStreamReader ir    = new InputStreamReader(System.in);
        
        logger.info("In Encoding : " +ir.getEncoding());
        
        
        logger.info("file.encoding : "+ System.getProperty( "file.encoding" ));
        
        logger.info("OurStream encoding : "+ new OutputStreamWriter( System.out ).getEncoding());
        
        
        
        byte [] bArray = {'w','a'};        
        InputStream is = new ByteArrayInputStream(bArray);        
        InputStreamReader reader = new InputStreamReader(is);        
        String defaultCharacterEncoding = reader.getEncoding();

        logger.info("Reader Encoding :"+defaultCharacterEncoding);
        
        
        logger.debug("session :"+Constant.SECURITY_SESSION_TYPE +"/"+Constant.SECURITY_SESSION_ISSINGLE);
                
        
    }
    
    private int convertToInt(String num){
        
        if(Utils.isEmpty(num)){
            return 0;
        }else{
            try{
                        
                int iout    = Integer.valueOf(num);
                
                return iout;

            }catch(Exception ex){
                return -1;
            }
        }
        
    }


    
}
