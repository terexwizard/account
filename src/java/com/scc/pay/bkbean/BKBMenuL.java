/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.scc.pay.bkbean;

import com.scc.f1.appsec.menu.BKBMenu;
import com.scc.f1.appsec.menu.MenuItem;
import com.scc.f1.backingbean.BKBUser;
import com.scc.f1.dbutil.DBUtils;
import com.scc.f1.dbutil.QueryXML;
import com.scc.f1.dbutil.QueryXMLData;
import com.scc.f1.util.SecurityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import com.scc.f1.util.Utils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.MenuModel;
//import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author xtra
 * @version 1.00.00
 * 29/03/2556  21:55:09
 */

@ManagedBean
@SessionScoped
public class BKBMenuL extends BKBMenu{

    private String menucode;
    private String menupath; 
    private String menusys;
    private String menunames;
    private MenuModel menumodel;

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenupath() {
        return menupath;
    }

    public void setMenupath(String menupath) {
        this.menupath = menupath;
    }

    public String getMenusys() {
        return menusys;
    }

    public void setMenusys(String menusys) {
        this.menusys = menusys;
    }

    public String getMenunames() {
        return menunames;
    }

    public void setMenunames(String menunames) {
        this.menunames = menunames;
    }
    
    public MenuModel getMenumodel() {
        return menumodel;
    }

    public void setMenumodel(MenuModel menumodel) {
        this.menumodel = menumodel;
    }
    
    
    public BKBMenuL() {
        
        setShowphase(true);
        setShowdebug(false);
//        logger.debug("construct");
        
    }

    
    
    @Override
    public void goEmptyPage() {
        //super.goEmptyPage(); //To change body of generated methods, choose Tools | Templates.
        
        this.checkoutLog();
        
    }

    
    
    
    @Override
    public void redirect(MenuItem node) {
        
        logger.debug("go r 1.03 :"+node.getMenucode()+", "+node.getMenusys()+", "+node.getMenupath()+", "+node.getMenuname()+", prev :"+getPrevpath());
        
        
          String targetapp = "/accountapp/";
          
          
          //logger.debug("go path  a:"+nsys +"::"+targetapp);
          setPrevpath(targetapp);
          
          FacesContext fc = FacesContext.getCurrentInstance();
            
            try {
                
                
                String r    = createURL(targetapp, node);
                
                logger.debug("re :"+r);
             //fc.getExternalContext().redirect(r);
                
//                this.setPage(node.getMenucode());
//                this.setPt(targetapp+node.getMenupath());
//                this.setSp(fc.getExternalContext().getRequestContextPath());
//                this.setSk(hss.getId());
//                this.setSpt(port);
                this.setRe(r);
                
                //RequestContext.getCurrentInstance().execute("test()");
                
                // not go 
                // use menu update
//                fc.getExternalContext().redirect("menu.xhtml");
                
            } catch (Exception ex) {
                logger.error(ex.getMessage(),ex);
            }finally{
                
            }
        
        
    }

    @Override
    public String createRedirectURL(MenuItem node) {
        
        
        logger.debug("go ru 1.03 :"+node.getMenucode()+", "+node.getMenusys()+", "+node.getMenupath()+", "+node.getMenuname()+", prev :"+getPrevpath());
        
//        String r = "";
        
        String targetapp = "/accountapp/";

            
            String r    = createURL(targetapp, node);
        
            return r;
        
    }

    @Override
    public void logout(ActionEvent aev) {
        
        String ctpath   = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        
        logoutSession();
        redirectPage(ctpath+"/index.xhtml");
        
//        if(getMenutemplate().equals("T01")){
////            super.logout(aev); 
//            
//            logoutSession();
//            
//            redirectPage(ctpath+"/index.xhtml");
//            
////            redirectPage(ctpath+"/viewelogout.xhtml");
//            
//        }else{
//        
//            logoutSession();
//            
//            redirectPage(ctpath+"/indexreg.xhtml");
//            
//        }
        
        FacesContext.getCurrentInstance().responseComplete();
        
//        if(getMenutemplate().equals("T01")){
//            super.logout(aev); 
//            
//        }else{
//        
//            logoutSession();
//            
//            String ctpath   = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
//            
//            redirectPage(ctpath+"/indexreg.xhtml");
//            
//        }
        
        
        
            
    }

    @Override
    protected void beforeApplyRequestValues() {
        
    }

    @Override
    protected void beforeRenderResponse() {
        
        //createMenubar
//        if(this.getRoot() == null){ 
//            createMenubar();
//        }
        
        // must call super for create menu
        super.beforeRenderResponse(); //To change body of generated methods, choose Tools | Templates.
        
        
        String viewid   = FacesContext.getCurrentInstance().getViewRoot().getViewId();
                
        if(viewid.equals("/app/main.xhtml")){
            
            bnheader    = SecurityUtil.createRedirectKey("/app/mainheader.xhtml");
            bnmenu      = SecurityUtil.createRedirectKey("/app/menu.xhtml");
            bnmain      = SecurityUtil.createRedirectKey("/app/main.xhtml");
            bnimage     = SecurityUtil.createRedirectKey("/app/imagei/imagemain.xhtml");
            
        }
        
    }
    
    
    public void resetMenuCall(){
        
        this.setRe("");
        FacesContext.getCurrentInstance().renderResponse();
    }

    @Override
    public void setInitmain(String initmain) {
        super.setInitmain(initmain); //To change body of generated methods, choose Tools | Templates.
        
//        bnheader    = SecurityUtil.createRedirectKey("/app/mainheader.xhtml");
//        bnmenu      = SecurityUtil.createRedirectKey("/app/menu.xhtml");
//        bnmain      = SecurityUtil.createRedirectKey("/app/main.xhtml");
//        bnimage      = SecurityUtil.createRedirectKey("/app/imagei/imagemain.xhtml");
        
    }
    
    
    //=====================
    //Zone Create Menubar
    //=====================
    private List queryMenuTemplate(){
        String menutp    = getMenutemplate();
        
        logger.debug("template :" +menutp );
        
        HashMap<String , String> qparam = new HashMap<String, String>();
        
        
        
        if(menutp == null || menutp.equals("")){
            
            qparam.put("defaulttemplate", "Y");
            
        }else{
            qparam.put("menutemplate", getMenutemplate());
        }
        
        return QueryXMLData.queryCacheData("query_menu", qparam, menutp);
        
    }
    
    private static HashMap<String, String> queryPrivilege(){
        
        HashMap<String, String> hmpriv  = new HashMap<String, String>();
        HashMap<String, String> hmpara  = new HashMap<String, String>();
        
        BKBUser u     = BKBUser.getCurrentUserObj();
        
        hmpara.put("user", u.getUserid());
        
        String sql  = QueryXML.createSQL("query_privilege", hmpara);

        
        List list   = DBUtils.queryData(sql);
        
        int i = 0;
        for(Object rec : list ){
            HashMap<String, String> r   = (HashMap<String, String>) rec;
         
//            logger.debug(i+" "+r.get("func_code"));
            hmpriv.put(r.get("func_code"), r.get("func_code"));
            
            i++;
        }
        
        return hmpriv;
        
    } 
   public void createMenubar(){
        
       
        HashMap<String, String> hmpriv  = queryPrivilege();
        List list       = queryMenuTemplate();
        
         String mc   = "";
        
        ArrayList<HashMap<String, String>> alist = new ArrayList<HashMap<String, String>>();
        ArrayList<HashMap<String, String>> alistm = new ArrayList<HashMap<String, String>>();
        
        HashMap<String, ArrayList>  hmmenu = new HashMap<String, ArrayList>();
        
        for(Object rec : list ){
            HashMap<String, String> r   = (HashMap<String, String>) rec;
            
            if( mc.equals(r.get("menu_code")) ){
                
                alist.add(r);
                
            }else{
                
                if(!mc.equals("")){
                    hmmenu.put(mc, alist);
                }
                
                alist = new ArrayList<HashMap<String, String>>();
                
                mc  = r.get("menu_code");
                
                alist.add(r);
            }
            
            
        }
        
        if(!mc.equals("")){
            hmmenu.put(mc, alist);
        }
        
        logger.debug("menu size :"+hmmenu.size() );
        
        
            MenuItem mi     = new MenuItem();

            mi.setMenutype("M");
            mi.setMenucode("MAIN01");
            mi.setMenuname("ROOT");


            //root = new DefaultTreeNode("Root", null);
            this.setRoot(new DefaultTreeNode("Root", null));
            menumodel = new DefaultMenuModel();
            
            alistm = hmmenu.get( mi.getMenucode());
            
            for(int m=0; m<alistm.size(); m++){
                
                if(checkMenu(alistm.get(m).get("menu_disp_code"),hmmenu, hmpriv)){
                    //TreeNode menusyscode = new DefaultTreeNode(alistm.get(m).get("menu_tname"), root);
//                    TreeNode menusyscode = new DefaultTreeNode(alistm.get(m).get("menu_tname"), this.getRoot());
//                    genMenuTree(alistm.get(m).get("menu_disp_code"), menusyscode, hmmenu, hmpriv);
                    
                    Submenu submenu = new Submenu();
                    submenu.setLabel(alistm.get(m).get("menu_tname"));
                    submenu.setTransient(true);
                    
                    genMenubar(alistm.get(m).get("menu_disp_code"), submenu, hmmenu, hmpriv,menumodel);
                    
                }
            }
        
    }
    
    private void genMenubar(String menu_disp_code,Submenu menu,HashMap<String, ArrayList>  hmmenu, HashMap<String, String> hmpriv,MenuModel menumodel){
        
        ArrayList<HashMap<String, String>> alist = hmmenu.get(menu_disp_code);
        
        if(alist==null){
            
        }else{
             for(int i=0; i< alist.size(); i++){
                HashMap<String, String> r   = alist.get(i);
                
                if(r.get("menu_disp_type").equals("M")){
                    if(checkMenu(r.get("menu_disp_code"),hmmenu, hmpriv)){
                        Submenu submenu = new Submenu();
                        submenu.setLabel(r.get("menu_tname"));
                        submenu.setTransient(true);
                        
                        genMenubar(r.get("menu_disp_code"),submenu,hmmenu, hmpriv,menumodel);
                    }
                }else{
//                    if( hmpriv.get(r.get("menu_disp_code")) != null ){
                        
                      if( hmpriv.get(r.get("menu_disp_code")) != null ){
                        
//                        MenuItem linkmenu = new MenuItem();
//                        linkmenu.setMenucode(r.get("menu_disp_code"));
//                        linkmenu.setMenuname(r.get("func_tname"));
//                        linkmenu.setMenupath(r.get("func_pathadd"));
//                        linkmenu.setMenusys(r.get("func_sys"));
//                        
//                        
//                        
//                        DefaultSubMenu work = new DefaultSubMenu("document");
                          String mmenu_disp_code = r.get("menu_disp_code");
                          String func_tname = r.get("func_tname");
                          String func_pathadd = r.get("func_pathadd");
                          String func_sys = r.get("func_sys");
                          
                        
                        org.primefaces.component.menuitem.MenuItem item = new org.primefaces.component.menuitem.MenuItem();
                            item.setValue(r.get("func_tname"));
                            item.setUrl("#");
                            item.setIcon("ui-icon-extlink");
                            //item.setOnclick("clickMenu('SYSTEM_CONFIG','app/system_config.xhtml','edas','ตั้งค่าระบบ')");
                            item.setOnclick("clickMenu('"+mmenu_disp_code+"','"+func_pathadd+"','"+func_sys+"','"+func_tname+"')");
                            item.setTransient(true);
                            
                            
                        menu.getChildren().add(item);
                        menumodel.addSubmenu(menu);
                    }
                }
                
             }
        }
        
    }
    
     private boolean checkMenu(String menu_disp_code,HashMap<String, ArrayList>  hmmenu, HashMap<String, String> hmpriv){
         
       ArrayList<HashMap<String, String>> alist = hmmenu.get(menu_disp_code);
        
        
       if(alist==null){

       }else{
            for(int i=0; i< alist.size(); i++){
                 HashMap<String, String> r   = alist.get(i);
                 if(r.get("menu_disp_type").equals("M")){
                     
                     if(checkMenu(r.get("menu_disp_code"),hmmenu, hmpriv)){
                         return true;
                     }
                     
                 }else{
                     if( hmpriv.get(r.get("menu_disp_code")) != null){
                         return true;
                     }
                 }
                 
            }
       }     
         
       return false;
     }
    
    public void goPage(){
        System.out.println(">>test"+this.getMenucode()+" / "+ this.getMenupath()+" / "+ this.getMenusys()+" / "+ this.getMenunames());
        redirectFix(this.getMenucode(), this.getMenupath(), this.getMenusys(), this.getMenunames());
    }

    public void redirectFix(String menucode,String menupath,String menusys,String menuname) {
        
          String targetapp = "/cargotrackingapp/";
//          
//          setPrevpath(targetapp);
//          
//          FacesContext fc = FacesContext.getCurrentInstance();
//            
//            try {
//                logger.debug("redirectFix :"+menupath+"/"+menucode);
//
////                
////              String r    = targetapp+"app/pageapp.xhtml?init=ADD"+
////                        "&pt="+targetapp+node.getMenupath()+
////                        "&sp="+fc.getExternalContext().getRequestContextPath()+
////                        "&sk="+hss.getId()+
////                        "&spt="+port;
//                
//                String r    = createURLFix(targetapp, menupath,menucode);
//                
//                logger.debug("re :"+r);
//
//                this.setRe(r);
//                
//            } catch (Exception ex) {
//                logger.error(ex.getMessage(),ex);
//            }finally{
//                
//            }
        
        this.setMenuname(menuname);
                
//        BKBUserData bku     = BKBUserData.getCurrentUserObj();
//        //>>terex 07/11/2556
//        //bku.setUserlevel(LEVEL_SKIP +","+menucode);
//        bku.setUserlevel(LEVEL_SKIP +","+AppConstant.PAGE_REGISTER_NONE_LOGIN);
        
        MenuItem linkmenu = new MenuItem();
           linkmenu.setMenucode(menucode); //BTT010100
           linkmenu.setMenuname(menuname); //จังหวัด
           linkmenu.setMenupath(menupath); //app/btt010100q.xhtml
           linkmenu.setMenusys(menusys);
//        String r = createURLFix(targetapp,linkmenu);
//        
//        this.setRe(r);
           
          redirect(linkmenu);
    }
    //=====================
    //End Zone Create Menubar
    //=====================

}
