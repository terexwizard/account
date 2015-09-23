/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scc.pay.bkbean;

//import com.scc.f1.backingbean.BKBUser;

import com.scc.f1.appsec.menu.BKBLoginSA;
import com.scc.f1.backingbean.BKBUser;
import com.scc.f1.backingbean.BKBUtil;
import com.scc.f1.business.IBusinessBase;
import com.scc.f1.dbutil.QueryXMLData;
import com.scc.f1.util.FaceUtil;
//import com.scc.f1.util.MessageUtil;
import com.scc.f1.util.SecurityUtil;
import com.scc.f1.util.Utils;
//import com.scc.f1.util.Utils;
//import com.scc.dbd.efiling.AppConstant;
import com.scc.pay.backingbean.BKBUserData;
import com.scc.app.business.AppBusinessFactory;
//import com.scc.nstda.rdconline.pki.TrustedRootManager;
//import com.scc.nstda.rdconline.sign.DocxSigner;
//import com.scc.nstda.rdconline.utils.CertificateUtil;

//import com.scc.nstda.rdconline.sign.DocxSigner;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputtext.InputText;


/**
 *
 * @author xtra
 * @version 1.00.00
 * 23/07/2555  16:14:04
 */

@ManagedBean
@ViewScoped
public class BKBLogin extends BKBLoginSA {

    
//    private DocxSigner docx;
    private String securecode  = "";
    
    private String dataforsign    = "rdc";
    private String signrefid    = "";
    
    
//    private Map<String, String> hmrtk   = new HashMap<String, String>();
    private String tk   = "";
    
    
    
    public String getSecurecode() {
        return securecode;
    }

    public void setSecurecode(String securecode) {
        this.securecode = securecode;
    }

    public String getDataforsign() {
        return dataforsign;
    }

    public void setDataforsign(String dataforsign) {
        this.dataforsign = dataforsign;
    }

    public String getSignrefid() {
        return signrefid;
    }

    public void setSignrefid(String signrefid) {
        this.signrefid = signrefid;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

//    public boolean isUserLock() {
//        return userLock;
//    }
//
//    public void setUserLock(boolean userLock) {
//        this.userLock = userLock;
//    }

    
    

    public List getNewslist() {
//        if(newslist ==  null){
//            querynews();
//        }
//        return newslist;
        
        return QueryXMLData.queryCacheData("query_news");
        
    }

    public void setNewslist(List newslist) {
//        this.newslist = newslist;
    }

    
    
    
    
    
    public BKBLogin() {
        
        setShowphase(true);
        
        setAutoconvertthai(true);
//        setAutoconvertthaidebug(true);
        
    }
    
    
    @Override
    protected void processCommand(String mode) {
//        throw new UnsupportedOperationException("Not supported yet.");
        
        
    }

    @Override
    protected String doGoQuery() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return "";
    }

    @Override
    protected String doGoInsert() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return "";
    }

    @Override
    protected void toDB() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void toScreen() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
     public String logonact(){
         
         logger.debug(">>>>>>>>>>>>>>>>>");
         
         return "";
     }
    
    public String logon(){
        
//    public String logon(ActionEvent aev){
        
//        uiuserid    = uiuserid.toUpperCase();
    
//        logger.debug(aev.getComponent().getClientId());
        
        logger.debug("u :" +uiuserid );
//                +"/"+uiuserpassword);
        
//        if(uiuserid.equals(uiuserpassword.toUpperCase())){
        if(uiuserid.equals(uiuserpassword)){
            
            addErrorMessage("uiuserid", "กรุณาตั้งรหัสผ่านใหม่", "กรุณาตั้งรหัสผ่านใหม่");
            
            return "";
        }
        
        //============================================
        //Verify Digital Signature
        
         if(!verifyDSIG()){
             
             return "";
             
         }
        
        
        
//        BKBUser bku     = BKBUtil.lookupCdiBean("bKBUser");
        
//        BKBUser bku     = BKBUser.getCurrentUserObj();
        BKBUserData bku     = BKBUserData.getCurrentUserObj();
        
//        BKBMenuL    bkm     = BKBUtil.lookupCdiBean("bKBMenuL");
//        
//        logger.debug("1.BU => "+bku+" / "+bkm);
//        bku.setUserid(uiuserid);
//        bku.setUserlevel("9999");
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

//        logger.debug("request : "+ facesContext.getExternalContext().getRequest() );
        
        
        HashMap<String, Object> logondata = new HashMap<String, Object>();
        
        logondata.put("user", bku);
        logondata.put("uiuserid", uiuserid);
        logondata.put("uiuserpassword", uiuserpassword);
        
        logondata.put("usersession", session);
        
        String ip     = FaceUtil.getClientIPformContext("", 100);
        String ag     = FaceUtil.getClientAgentformContext(100);
        
        logondata.put("sessionip", ip);
        logondata.put("sessionagent", ag);
        
        IBusinessBase ib = AppBusinessFactory.getBusiness("BzLogon");
            
            
        ib.process(logondata);

        genMessage(ib);
        
//        logger.debug("2.BU => "+bku);

        logger.debug(">>"+bku.getUserid()+" / "+bku.getUsername() +" , cn="+bku.getUserproperties().getUsercn()  );
        
        if(ib.isOk()){
            
//            BKBMenu menu    = BKBUtil.lookupCdiBean("bKBMenuL");
//                    
//            menu.setUser(bku);
//            menu.setUserid(bku.getUserid());
//
//            menu.checkLogon();
//            
//            menu.setMenutemplate("T01");
            
        }else{
            
//            addErrorMessage("uiuserid", "กรุณาตรวจสอบรหัสผู้ใช้ และ รหัสผ่าน", "กรุณาตรวจสอบรหัสผู้ใช้ และ รหัสผ่าน");
            
//            String ctpath   = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
//            redirectPage(ctpath+"/viewemsg.xhtml");
            
            checkUserLock(logondata);
            
            return "";
        }
        
        
//        logger.debug("req :"+ FacesContext.getCurrentInstance().getExternalContext().getRequest());
        
        
        //=================================
        
//        String cn   = Utils.NVL(bku.getUserproperties().getUsercn());
//               
//        if( cn.equals("") ){
//        
//            gotoMain();
//            
////            try {
////                //redirectPage("app/main.xhtml");
////                String ctpath   = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
////
////                FacesContext.getCurrentInstance().getExternalContext().redirect(ctpath+"/app/main.xhtml");
////            } catch (IOException ex) {
////    //            Logger.getLogger(BKBLogin.class.getName()).log(Level.SEVERE, null, ex);
////
////                logger.error(ex.getMessage(), ex);
////    //            ex.printStackTrace();
////            }
//        
//        }else{
//            
//            // sign something
//            
//            //getDocx().createSecuCode();
//            
//
//            redirectPage("indexp.xhtml");
//        
//        }
        
        
        //===========
//        if(verifyDSIG()){
//            
////            this.createUserSSK();
            
            
            //=====================
            
            BKBMenuL menu    = BKBUtil.lookupCdiBean("bKBMenuL");
//                BKBMenu menu    = BKBUtil.lookupCdiBean("bKBMenuL");

            menu.setUser(bku);
            menu.setUserid(bku.getUserid());

            menu.checkLogon();

            menu.setMenutemplate("T01");

            menu.setUsertoken("");
            
            menu.setRoot(null);
            menu.setRe("");
            
            logger.debug(">>>>>>>>>>>>>>>>>>> 1 "+uiuserid);
            
            checkLoginSession();
            
            gotoMain();
            
            return null;
            
//            return "app/main.xhtml?faces-redirect=true";
            
//            
//        }else{
//                        
//        }
        
    }
    
    private void checkUserLock(HashMap<String, Object> logondata){
        
//        Object islock   = logondata.get(KEY_USER_LOCK);
        String lock     = Utils.NVL(logondata.get(KEY_USER_LOCK));

//        logger.debug( islock +">>"+lock  );

        if(lock.equals("true")){
            userLock    = true;
        }
        
        
    }
    
    
    
    public void changePassword(ActionEvent ev){
        
        
        uicuserid           = "";
        uicuserpassword1    = "";
        uicuserpassword2    = "";
        uicuserpassword3    = "";
        
//        redirectPage("changepassword.xhtml", "", false);
        redirectPage("changepassword.xhtml");
        
    }
    
    public void changePasswordOk(ActionEvent ev){
        
//        uicuserid    = uicuserid.toUpperCase();
        
        if( !uicuserpassword2.equals(uicuserpassword3)){
            
            addErrorMessage("uicuserid", "รหัสผ่านใหม่และยืนยันไม่ตรงกัน", "รหัสผ่านใหม่ไม่ตรงกัน");
            
            return ;
        }
        
        if(uicuserpassword1.equals(uicuserpassword2)){
            
            addErrorMessage("uicuserid", "รหัสผ่านเดิมและรหัสผ่านใหม่ตรงกัน <br/>กรุณาเปลี่ยนรหัสผ่านใหม่", "รหัสผ่านเดิมและรหัสผ่านใหม่ตรงกัน");
            
            return ;
        }
        
//        int vp  = com.scc.nstda.rdconline.utils.FaceUtil.validatePasswordStrenge(uicuserpassword2);
//        if( vp != 0 ){
//             String msgcode     = com.scc.nstda.rdconline.utils.FaceUtil.getValidatePasswordErrorCode(vp);
//             String msg         = MessageUtil.getMessage(msgcode);
//             
//             addErrorMessage("uicuserid", msg, msg );
//            
//             return ;
//        }
        
        
        
        IBusinessBase ib = AppBusinessFactory.getBusiness("BzChangePassword");
            
            
        ib.process(this);

//        genMessage(ib);

        
        if(ib.isOk()){
            
            addInfoMessage(null, "เปลี่ยนรหัสผ่านเรียบร้อย", "เปลี่ยนรหัสผ่านเรียบร้อย");
            
            
            
        }else{
            
            addErrorMessage("uiuserid", "กรุณาตรวจสอบรหัสผู้ใช้ และ รหัสผ่าน", "กรุณาตรวจสอบรหัสผู้ใช้ และ รหัสผ่าน");
            
            //return ;
        }
        
        
        
    }
    
    public void changePasswordCancel(ActionEvent ev){
        
        uiuserid        = "";
        uiuserpassword  = "";
        
//        redirectPage("index.xhtml","",false);
        
        redirectPage("index.xhtml");
        
    }

    
    @Override
    protected void beforeRenderResponse() {
        
        
        if( !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest() ){
            
        
        }
            
        tk  = SecurityUtil.createSecureRandom(32);
        
    }
    
    
    public void logonsign(ActionEvent aev){
        
    }
    
    
    public void logono(ActionEvent aev){
        
        logger.debug("sign false" );
        
        addErrorMessage(null,"ใบรับรองไม่ถูกต้อง", "ใบรับรองไม่ถูกต้อง");

        redirectPage("index.xhtml","", false);
        
    }
    
    
    
    public void changeUser(AjaxBehaviorEvent abe){
        //terex 16/08/2558
//        String  userid  = (String)((InputText) abe.getComponent()).getValue();
//        
//        logger.debug("user : "+userid+" // "+uiuserid);
//        
//        setCkey( "" );
//        setTpkey( "" );
//        
//        HashMap<String, Object> logondata = new HashMap<String, Object>();
//        
//        
//        logondata.put("uiuserid", userid);
//        
//        
//        IBusinessBase ib = AppBusinessFactory.getBusiness("BzLogonSearchKey");
//            
//            
//        ib.process(logondata);
//
//        genMessage(ib);
//
//        
//        if(ib.isOk()){
//            
//            setCkey( (String)logondata.get("ckey") );
//            setTpkey( (String)logondata.get("tpkey") );
//        
//        }else{
//            
//            checkUserLock(logondata);
//            
//        }
        
        
        
    }
    
    private boolean verifyDSIG(){
        
        boolean isok    = true;
        
        
        
        return isok;
        
    }

   
    
    @Override
    protected void gotoMain() {
        //super.gotoMain(); //To change body of generated methods, choose Tools | Templates.
        
        try{
            String ctpath   = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();

//            redirectPage(ctpath+"/app/main.xhtml", "", false);
            
//            redirectPage(ctpath+"/app/main.xhtml");
            
            redirectPage("app/main.xhtml");
            
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
//            ex.printStackTrace();
        }
    }
    
    
    public void goForgotPasswordPage(ActionEvent ae){
        
        logger.debug("goForgotPasswordPage");
        
        BKBUser u   = BKBUtil.lookupCdiBean("bKBUser");
      
        
        String  mill    = String.valueOf(Utils.getcurTimeInMillis());
        mill            = mill.substring(mill.length()-6);
                
        Random rd   = new Random();
        int ran     = rd.nextInt( Short.MAX_VALUE );
        String sran = String.valueOf(ran);
        sran        = sran.substring(sran.length()-2);
        
        u.setUserid("fgpwdu"+mill+sran);
        u.setUsername("");
        
        
        redirectPage("forgotpassword.xhtml");
        
    }
    
    
    
    public void goLoginRegisterPage(ActionEvent ae){
        
        logger.debug("goLoginRegisterPage");
        
        String url  = "indexreg.xhtml";
        
        redirectPage(url);
        
    }

    
    
    
    
}
