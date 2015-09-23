
$(document).keydown(function (e) { 
    var preventKeyPress; 
    if (e.keyCode == 8) { 
        var d = e.srcElement || e.target; 
        if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA') { 
            var preventPressBasedOnType = false; 
            if (d.attributes["type"]) { 
                var type = d.attributes["type"].value.toLowerCase(); 
                preventPressBasedOnType = (type == "radio" || type == "checkbox" || type == "submit" || type == "button"); 
            } 
            preventKeyPress = d.readOnly || d.disabled || preventPressBasedOnType; 
        } 
        else 
            preventKeyPress = true; 
    } 
    else 
        preventKeyPress = false; 
 
    if (preventKeyPress) 
        e.preventDefault(); 
}); 

 $(document).ready(function(){
       $(".num").keydown(function(e)
       {
           if (e.shiftKey)
               e.preventDefault();
           else
           {
               var nKeyCode = e.keyCode;
               //Ignore Backspace and Tab keys
               if (nKeyCode == 8 || nKeyCode == 9)
                   return;
               if (nKeyCode < 95)
               {
                   if (nKeyCode < 48 || nKeyCode > 57)
                       e.preventDefault();
               }
               else
               {
                   if (nKeyCode < 96 || nKeyCode > 105)
                   e.preventDefault();
               }
           }
       });
});

function num(e) {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        var oElement = window.event.srcElement;
        /*
        if (!window.event.shiftKey && !window.event.ctrlKey && !window.event.altKey) {
            if ((key_code > 47 && key_code < 58) ||
                (key_code > 95 && key_code < 106)) {

                if (key_code > 95)
                     key_code -= (95-47);
                oElement.value = oElement.value;
            } else if(key_code == 8) {
                oElement.value = oElement.value;
            } else if(key_code != 9) {
                event.returnValue = false;
            }
        }*/
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9;
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which;
        
        //event.keyCode == 8   // backspace
        //event.keyCode == 46  // delete
        //event.keyCode == 9  // tab
        //(event.keyCode >= 48 && event.keyCode <= 57)     // numbers on keyboard
        //(event.keyCode >= 96 && event.keyCode <= 105))   // number on keypad
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9;
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}

function numc(e) {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9;          
        if( !lb_check_integer ){
            event.returnValue = false;
        }
        
        if(key_code == 188){
            event.srcElement.value += ",";
        }
    }else{
        key_code = e.which;
        
        //event.keyCode == 8   // backspace
        //event.keyCode == 46  // delete
        //event.keyCode == 9  // tab
        //event.keyCode == 188  // comma
        //(event.keyCode >= 48 && event.keyCode <= 57)     // numbers on keyboard
        //(event.keyCode >= 96 && event.keyCode <= 105))   // number on keypad
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9 || key_code == 188;
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }
        
    }
}

function numd(e) {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9 || key_code == 110 || key_code == 190
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which;
        //event.keyCode == 8   // backspace
        //event.keyCode == 46  // delete
        //event.keyCode == 9  // tab
        //event.keyCode == 110 , 190  // dot
        //(event.keyCode >= 48 && event.keyCode <= 57)     // numbers on keyboard
        //(event.keyCode >= 96 && event.keyCode <= 105))   // number on keypad
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) ||(key_code >= 96 && key_code <= 105) ||
                            key_code == 8 || key_code == 46 || key_code == 9 || key_code == 110 || key_code == 190;
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}

PrimeFaces.locales ['th'] = {
    closeText: '\u0E1B\u0E34\u0E14',
    prevText: '\u0E22\u0E49\u0E2D\u0E19\u0E01\u0E25\u0E31\u0E1A',
    nextText: '\u0E16\u0E31\u0E14\u0E44\u0E1B',
    monthNames: ['\u0E21\u0E01\u0E23\u0E32\u0E04\u0E21', 
        '\u0E01\u0E38\u0E21\u0E20\u0E32\u0E1E\u0E31\u0E19\u0E18\u0E4C', 
        '\u0E21\u0E35\u0E19\u0E32\u0E04\u0E21', 
        '\u0E40\u0E21\u0E29\u0E32\u0E22\u0E19', 
        '\u0E1E\u0E24\u0E29\u0E20\u0E32\u0E04\u0E21', 
        '\u0E21\u0E34\u0E16\u0E38\u0E19\u0E32\u0E22\u0E19', 
        '\u0E01\u0E23\u0E01\u0E0E\u0E32\u0E04\u0E21', 
        '\u0E2A\u0E34\u0E07\u0E2B\u0E32\u0E04\u0E21', 
        '\u0E01\u0E31\u0E19\u0E22\u0E32\u0E22\u0E19', 
        '\u0E15\u0E38\u0E25\u0E32\u0E04\u0E21', 
        '\u0E1E\u0E24\u0E28\u0E08\u0E34\u0E01\u0E32\u0E22\u0E19', 
        '\u0E18\u0E31\u0E19\u0E27\u0E32\u0E04\u0E21' ],
    monthNamesShort: ['\u0E21.\u0E04.', '\u0E01.\u0E1E.', '\u0E21\u0E35.\u0E04.', 
        '\u0E40\u0E21.\u0E22.', '\u0E1E.\u0E04.', '\u0E21\u0E34.\u0E22.', 
        '\u0E01.\u0E04.', '\u0E2A.\u0E04.','\u0E01.\u0E22.', 
        '\u0E15.\u0E04.', '\u0E1E.\u0E22.', '\u0E18.\u0E04.' ],
    dayNames: ['\u0E2D\u0E32\u0E17\u0E34\u0E15\u0E22\u0E4C', '\u0E08\u0E31\u0E19\u0E17\u0E23\u0E4C', 
        '\u0E2D\u0E31\u0E07\u0E04\u0E32\u0E23', '\u0E1E\u0E38\u0E18', 
        '\u0E1E\u0E24\u0E2B\u0E31\u0E2A\u0E1A\u0E14\u0E35', '\u0E28\u0E38\u0E01\u0E23\u0E4C', 
        '\u0E40\u0E2A\u0E32\u0E23\u0E4C'],
    dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Tue', 'Fri', 'Sat'],
    dayNamesMin: ['\u0E2D\u0E32.', '\u0E08.', '\u0E2D.', '\u0E1E.', '\u0E1E\u0E24.', '\u0E28.', '\u0E2A.'],
    weekHeader: 'Week',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Only Time',
    timeText: 'Time',
    hourText: 'Time',
    minuteText: 'Minute',
    secondText: 'Second',
    currentText: 'Current Date',
    ampm: false,
    month: 'Month',
    week: 'week',
    day: 'Day',
    allDayText: 'All Day'
    
    
};


function isEmpty(element){
    if (element){
       //alert("true "+element . value);
       if (element . value == ""          ||
            element . value == 0           ||
            element . value == "0"         ||
            element . value == null        ||
            element . value == "NULL"      ||
            element . value == undefined   ||
            element . value == false){
            return "";   
        }else{
            return element . value;    
        }
       
    } else{
       //alert("false");
       return "";
    }
}

function autoClickRow(css,row){
        var x = '.'+css+' .ui-datatable-data tr';
        if(jQuery(x).find('#isOk').eq(row).text()== 'Y'){
            jQuery(x).find('span.ui-icon-pencil').eq(row).each(function(){jQuery(this).click()});
        }
}

function clickRow(css,row){
      var x = '.'+css+' .ui-datatable-data tr';
      jQuery(x).find('span.ui-icon-pencil').eq(row).each(function(){jQuery(this).click()});
}

function clickLastRow(css){
      var x = '.'+css+' .ui-datatable-data tr';
      jQuery(x).last().find('span.ui-icon-pencil').each(function(){jQuery(this).click()});
}

function handleComplete(idbtn){
   document.getElementById("form1:"+idbtn).click();
}

function thai(e) {//  onkeypress="thai(event);"   >> สระและสระพยัญชนะไทย
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        //alert(window.event.keyCode);
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) || 
                           key_code == 8 || key_code == 9 ;
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which; 
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) || 
                           key_code == 8 || key_code == 9 ;
        
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}
 
function thaieng(e) {//onkeypress="thaieng(event);"   >> สระและพยัญชนะ ไทย-อังกฤษ
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        //event.keyCode == 32   // spacebar
        key_code = window.event.keyCode; 
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) ||
                           ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122) ||
                           key_code == 8 || key_code == 9 || key_code == 32 ;
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which; 
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) ||
                           ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122)||
                           key_code == 8 || key_code == 9 || key_code == 32 ;
        
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}

function thaiengdot(e) {//onkeypress="thaieng(event);"   >> สระและพยัญชนะ ไทย-อังกฤษ
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        //event.keyCode == 32   // spacebar
        //event.keyCode == 110 , 190  // dot
        key_code = window.event.keyCode; 
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) ||
                           ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122) ||
                           key_code == 8 || key_code == 9 || key_code == 32 || key_code == 110 || key_code == 190 || key_code == 46;
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which; 
        lb_check_integer = ( key_code >= 3585 && key_code <= 3662) ||
                           ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122)||
                           key_code == 8 || key_code == 9 || key_code == 32 || key_code == 110 || key_code == 190 || key_code == 46;
        
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}
 
function eng(e) {////onkeypress="thaieng(event);"   >> สระแลพยัญชนะ อังกฤษ
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        //alert(window.event.keyCode);
        lb_check_integer = ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122) ||
                            key_code == 8 || key_code == 9 ;
        if( !lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which; 
        lb_check_integer = ( key_code >= 65 && key_code <= 90) ||
                           ( key_code >= 97 && key_code <= 122)||
                             key_code == 8 || key_code == 9 ;
        
        if( !lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
    
}

function popupclosecancel(){
    window.returnValue = false;
    window.close();
}
function popupcloseok(){
    window.returnValue = true;
    window.close();
}

function numn(e) {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE" );
    var chrome = ua.indexOf ( "Chrome" );
    var key_code;
    var lb_check_integer;

    //(event.keyCode >= 48 && event.keyCode <= 57)     // numbers on keyboard
    //(event.keyCode >= 96 && event.keyCode <= 105))   // number on keypad
    if(msie > 0 || chrome > 0){
        
        key_code = window.event.keyCode;
        var oElement = window.event.srcElement;
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) 
                          ||(key_code >= 96 && key_code <= 105) 
                          ||(key_code >= 3664 && key_code <= 3673);
        if( lb_check_integer ){
            event.returnValue = false;
        }
    }else{
        key_code = e.which;
         
        
        lb_check_integer = ( key_code >= 48 && key_code <= 57) 
                          ||(key_code >= 96 && key_code <= 105)
                          ||(key_code >= 3664 && key_code <= 3673);
        if( lb_check_integer ){
                   
            e.cancelBubble = true;
            e.preventDefault();
            e.stopPropagation(); 
            e.stopImmediatePropagation();
        }

    }
}

function cursorpg(){
    $("body").css("cursor", "progress");
}

function cursorwait(){
    $("body").css("cursor", "wait");
}

function cursordefault(){
    $("body").css("cursor", "default");
}