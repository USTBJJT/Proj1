var Monkey=Monkey||{};void function(P){var b=window,D=document,x=encodeURIComponent,r=Math,L=parseInt;if(!document.body.getBoundingClientRect){return}var p=[{getPage:function(){var i;String(D.location).replace(/http:\/\/baike\.baidu\.com\/view\/(\d+)\.htm/i,function(Z,aa){i="view-"+aa});return i},postUrl:"http://nsclick.baidu.com/u.gif",product:103,hid:2254,reports:{click:1,refer:1,staytime:1,pv:1}}],F,V=0;while(F=p[V++]){if(F.page=F.getPage()){break}}if(!F){return}var K=[["mousedown","d"],["scroll","s",b],["resize","e",b],["beforeunload","z",b],["unload","z",b],["focusout","o"],["blur","o",b],["focusin","i"],["focus","i",b]],T,f=(b.ALog&&ALog.t&&ALog.t.st)||new Date,s=(b.ALog&&ALog.sid)||(+new Date).toString(36)+(+Math.random().toFixed(8).substr(2)).toString(36),R=0,g=0,d=0,h=0,l,Q=false,N=0,C=0;var J,q={},I={},A="alog-alias",E="alog-action",k="alog-group",a="alog-param";function t(){if(J){return}J={};"AdivBliCaDulEdlFddGspanHtableIbodyJtrKsectionLtdMolNpOarticlePdtQformRimgSh3TinputUasideViWbXthYemZfont".replace(/([A-Z])([a-z]+)/g,function(aa,i,Z){J[J[i]=Z]=i})}function y(ab,aa,ac,Z){if(!ab){return""}var i=(/^[^u]/.test(typeof ab.getAttribute)&&ab.getAttribute(aa))||"";if("#"==i){i="[id]"}else{if("."==i){i="[class]"}}i.replace(/\[([\w-_]+)\]/,function(ae,ad){i=ab.getAttribute(ad)});Z&&(Z.target=ab);return i||(ac&&y(ab.parentNode,aa,1,Z))||""}function m(ab,i,ae){ae&&t();i=i||D.body;if(!ab||ab==i){return""}if(ab.nodeType!=1||/html/i.test(ab.tagName)){return ab.tagName||""}var aa=y(ab,A),ad=1,ac=ab.previousSibling,Z=ab.nodeName.toLowerCase();while(ac){ad+=ac.nodeName==ab.nodeName;ac=ac.previousSibling}aa=(ae&&J[Z]||Z)+(ad<2?"":ad)+(aa&&"("+aa+")");return ab.parentNode==i?aa:m(ab.parentNode,i,ae)+(/^[A-Z]/.test(aa)?"":"-")+aa}function H(Z,i){return m(Z,i,1)}function B(Z,i){return y(Z,E,true,i)}function o(i){return y(i,k,true)}function e(i){return y(i,a)}function U(ab){if(!ab){return}var i=["ts="+X().toString(36)],aa,ac=new Image,Z="alog_img_"+s+(+new Date).toString(36);for(aa in q){if(q[aa]){i.push(aa+"="+x(q[aa]))}}for(aa in ab){if(ab[aa]){i.push(aa+"="+x(ab[aa]))}}v("report",{const_data:q,event_data:ab});i=F.postUrl+"?"+i.join("&");b[Z]=ac;ac.onload=ac.onerror=ac.onabort=function(){b[Z]=ac=ac.onload=ac.onerror=ac.onabort=null};ac.src=i}function M(i,Z){if(!i){return}v("action",{cmd:"action",ac:i,param:Z});U({cmd:"action",ac:i,param:Z})}function w(i,Z){i&&(q[i]=Z)}function z(i,Z){if(!i||typeof Z!="function"){return}I[i]=I[i]||[];I[i].unshift(Z)}function v(ac,ab){var aa=I[ac];if(!aa){return}var Z=aa.length;while(Z--){aa[Z](ab,ac)}}function O(Z,ac){var ab=Z.getBoundingClientRect(),i=S(Z);function aa(ae,ad){return String(+Math.min(r.max(ae/ad,0),1).toFixed(ad<36?1:(ad<351?2:3))).replace(/^0\./g,".")}return[aa(ac[0]-ab.left,i[0]),aa(ac[1]-ab.top,i[1])]}function S(i){var Z=i.getBoundingClientRect();return[L(Z.right-Z.left),L(Z.bottom-Z.top)]}function u(){var Z=S(D.documentElement),i=S(D.body);return[r.max(Z[0],i[0],b.innerWidth||0,D.documentElement.scrollWidth||0),r.max(Z[1],i[1],b.innerHeight||0,D.documentElement.scrollHeight||0)]}function c(){return[r.max(D.documentElement.scrollLeft||0,D.body.scrollLeft||0,(D.defaultView&&D.defaultView.pageXOffset)||0),r.max(D.documentElement.scrollTop||0,D.body.scrollTop||0,(D.defaultView&&D.defaultView.pageYOffset)||0),b.innerWidth||D.documentElement.clientWidth||D.body.clientWidth||0,b.innerHeight||D.documentElement.clientHeight||D.body.clientHeight||0]}function Y(i,Z,aa){if(!i){return}if(i.addEventListener){i.addEventListener(Z,aa,false)}else{if(i.attachEvent){i.attachEvent("on"+Z,aa)}}}function X(){return new Date-f}function W(i){while(i){if(/^(a|button)$/i.test(i.tagName)){return i}i=i.parentNode}}function j(){switch(F.reports.refer){case 1:case true:return D.referrer;case 2:var i=D.referrer;if(!i){return}var Z="";i.replace(/(^\w+:\/\/)?([^\/]+)/,function(ab,aa){Z=aa});if(D.location.host==Z){return D.referrer}return Z}}q={pid:F.pid||241,sid:s,hid:F.hid,page:F.page,ver:5,p:F.product,px:b.screen.width+"*"+b.screen.height,ref:j()};function G(ah,ae){var af=ae.target||ae.srcElement;switch(ah){case"d":if(!af){return}R++;var ag={},Z=W(af),ac=B(af,ag),i="",aj="";if(Z){if(/^a$/i.test(Z.tagName)){if(F.reports.click){i=Z.getAttribute("href",2);if(/^javascript|#/i.test(i)){i=""}}g++}else{d++}if(F.reports.click){aj=Z.innerHTML.replace(/<[^>]*>/g,"")}}else{if(/input/i.test(af.tagName)&&/button|radio|checkbox|submit/i.test(af.type)){Z=af;d++;aj=af.value}}if(/img/i.test(af.tagName)){h++;aj=af.alt||af.title||af.src}if(!Z&&!ac){break}var ad=H(af),ai=o(af),ab=e(ag.target),aa=O(af,[ae.clientX,ae.clientY]);if(F.reports.click){U({xp:ad,g:ai,ac:ac,ep:aa,param:ab,u:String(i).substr(0,200),txt:String(aj).substr(0,30)})}break;case"o":l=X();Q=true;break;case"i":N+=X()-l;l=X();Q=false;break;case"s":case"e":n=c();C=r.max(n[1]+n[3],C);break;case"z":v("close");Q&&(N+=X()-l);F.reports.staytime&&U({cmd:"close",tc:R,lc:g,bc:d,pc:h,pd:C,ft:(X()-N).toString(36),ps:u().join("*")});break}}for(V=0;T=K[V++];){Y(T[2]||D,T[0],(function(i){return function(aa){if(!f){return}G(i,aa);if(i=="z"){f=0;var Z=new Date;while(new Date-Z<100){}return}}})(T[1]))}l=X();var n=c();C=r.max(n[1]+n[3],C);F.reports.pv&&U({cmd:"open",ps:u().join("*")});(function(){var af=35,aa=0,Z=0,ad=0,ac=[["mousedown","d"]];z("close",function(){w("spd",r.ceil(C/af));w("tac",aa);w("inc",Z);w("cic",ad)});for(var ab=0;T=ac[ab++];){Y(T[2]||D,T[0],(function(i){return function(ah){ag(i,ah)}})(T[1]))}function ag(am,al){var ai=al.target||al.srcElement;switch(am){case"d":if(!ai){return}var an=W(ai),ak=ae(ai);if(!ak){return}if(an||/input/i.test(ai.tagName)&&/button|radio|checkbox|submit/i.test(ai.type)||/img/i.test(ai.tagName)){H(ai).indexOf(J.table)!=-1&&aa++;if(an){var i=an.href||"",aq=b.location.pathname,aj=aq.match(/\/view\/(\d+)\.htm/i),ao=aj&&aj[1],ap=i.match(/\/view\/(\d+)\.htm/i),ah=ap&&ap[1];ah&&ao&&ao!=ah&&Z++}if(/img/i.test(ai.tagName)){ad++}}break}}function ae(ah){while(ah){var i=ah.className;if(i&&i.indexOf("main-body")!=-1){return true}ah=ah.parentNode}return false}})()}(Monkey);var Hunter=Hunter||{};Hunter.userConfig = Hunter.userConfig || [];Hunter.userConfig.push({hid:(function(){var c,d,e,a={qq:[16413,16414],"%u767E%u5EA6%u5F71%u97F3":[16416,16418],"%u795E%u5E99%u9003%u4EA12":[16417,16420],"%u9177%u72D7%u97F3%u4E50":[16415,16419]},b=document.getElementById("word");return b&&(c=escape(b.value.toLowerCase()),d=a[c]||null,d&&(e=d[0],document.getElementById("appDownloadLemmaWrap")&&(e=d[1]))),e})()});Hunter.userConfig.push({hid:(function(){var c,d,e,a={"%u5BD2%u6218":[null,16445,16444],"%u5931%u604B33%u5929":[null,16442,16449],"x%u5973%u7279%u5DE5":[null,16446,16447],"%u767E%u5E74%u9057%u4EA7":[null,16443,16448]},b=document.getElementById("word");return b&&(c=escape(b.value.toLowerCase()),d=a[c]||null,d&&(e=d[0],document.getElementById("shipinLemmaInContent")&&(e=d[1]),document.getElementById("shipinLemmaWrap")&&(e=d[2]))),e})()});Hunter.userConfig.push({hid:(function(){var g,h,i,a={"baike\\.baidu\\.com\\/edit\\/\\d+\\?isnew=1":16454},b=document.location,c=b.hostname,d=b.port,e=b.pathname,f=b.search;if(""!==d&&(d=":"+d),h=c+d+e+f,"baike.baidu.com"===c){for(var j in a)i=RegExp(j),i.test(h)&&(g=a[j]);return g}})()});void function(){window.Hunter=window.Hunter||{};var i="toString",q="getBoundingClientRect",r="activeElement",S="previousSibling",a="nodeName",n="innerWidth",B="innerHeight",y="documentElement",P={grid:7,pid:240,hid:(function(){if(Hunter.userConfig){for(var ao=0,ap=Hunter.userConfig.length;ao<ap;ao++){if(Hunter.userConfig[ao].hid){au=Hunter.userConfig[ao].hid}}}if(!au){function p(av){return String(av).replace(/\.html?(\?|$)/,"$1").replace(/\?.*/,"").toLowerCase()}var w=document.location,aq={},d={"baike.baidu.com":{"\/vbaike\/detail?itemId=2442":"73552","\/item\/%E7%99%BE%E5%BA%A6%E7%99%BE%E7%A7%91%E5%8D%81%E5%A4%A7%E7%83%AD%E8%AF%8D%E2%80%94%E2%80%942015%C2%B710":"73553","\/link?url=qA3LarQ4vmTpCUIQJUktVBSu-vAtqYkaTaTx-sN4ODEeVi8J3C0lNjC4TonNWtBz08KGP4adNGG4dtcyFsZgRmQ31ab-IoE9isMb6Is4HgO":"73554","\/subview\/11274184\/16514912.htm?fr=dramarank":"73555","\/item\/%E4%BB%96%E6%9D%A5%E4%BA%86%EF%BC%8C%E8%AF%B7%E9%97%AD%E7%9C%BC\/17211206?fr=dramarank":"73556","\/vbaike\/detail?itemId=2443":"73557","\/vbaike\/detail?itemId=2585":"73569","\/vbaike\/detail?itemId=2587":"73570","\/vbaike\/detail?itemId=2561":"73571","\/view\/9575505.htm":"73572","\/item\/OPPO%20R7":"73573","\/view\/181969.htm":"73574","\/view\/4535369.htm":"73575","\/view\/5866105.htm":"73576","\/subview\/657562\/10210554.htm":"73577","\/vbaike\/detail?itemId=3414":"73591","\/vbaike\/detail?itemId=3970":"73604","\/vbaike\/detail?itemId=4039":"73617"}},ar,at,au;d=d[w.hostname.toLowerCase()];if(!d){return}w.search.toLowerCase().replace(/([^?&#]+)=([^?&#]*)/g,function(aw,av,ax){aq[av]=ax});w=p(w.pathname);for(ar in d){at=w==p(ar);at&&/\?/.test(ar)&&ar.toLowerCase().replace(/([^?&#]+)=([^?&#]*)/g,function(aw,av,ax){if(aq[av]!=ax.replace(/[^\x00-\xff]/g,function(ay){return encodeURI(ay)}).toLowerCase()){at=0}});if(at){au=d[ar]}}}if(Hunter.ratio&&typeof(Hunter.ratio[au])!="undifined"){if(Math.random()>Hunter.ratio[au]){return}}return au})(),logPath:"http://nsclick.baidu.com/u.gif"},v={},aj,ag=[],ab=window,am=document,G=am.body,E=am[y],l=am.defaultView,M=Math.max,k=encodeURIComponent,al=100,j,N,H,t,I,u=ab.screen.width+"*"+ab.screen.height,R,C,x,h=110,z=2060,D=1000*60*30,m,f,s,o,r,c,ad=[["mousemove","m"],["mousedown","d"],["contextmenu","r"],["mouseup","u"],["click","c"],["dblclick","l"],["keydown","k"],["mousewheel","w"],["DOMMouseScroll","w",ab],["scroll","s",ab],["resize","e",ab],["beforeunload","z",ab],["unload","z",ab],["focusout","o"],["blur","o",ab],["focusin","i"],["focus","i",ab]],ac,g=/gecko/i.test(navigator.userAgent),W,U;function K(ap,w,p,d,ao){ap=am.getElementsByTagName(am.all?"object":"embed");for(w=0;d=ap[w++];){if(!d[c]){d[c]=1;for(p=0;(ao=ad[p])&&p<7;p++){V(d,ao[0],(function(aq){return function(ar){aa(aq,ar)}})(ao[1]))}}}}function X(aq,d,ap,ao,p,au,w){aq=document.getElementsByTagName("iframe");for(ap=0;ap<aq.length;ap++){w=aq[ap];try{var at=String(w.src).replace(/^\w+:\/\/([^\/]+).*$|.*/,"$1");if((!at||at==document.location.hostname)&&!w.contentWindow[c]){w.contentWindow[c]=1;au=w.contentWindow.document;for(ao=0;(p=ad[ao])&&ao<7;ao++){V(au,p[0],(function(av,ax,aw){return function(ay){if(g){if("d"==av){U=b(ay)}if("u"==av){U=0}}aa.call({path:ax,doc:aw,flag:c},av,ay)}})(p[1],A(w),au))}}}catch(ar){}}}function V(p,d,w){if(!p){return}if(p.addEventListener){p.addEventListener(d,w,false)}else{p.attachEvent&&p.attachEvent("on"+d,w)}ag.push([p,d,w])}function Y(w,d,ap,ao){if(!w){return}try{if(w.removeEventListener){w.removeEventListener(d,ap,false)}else{w.detachEvent&&w.detachEvent("on"+d,ap)}w[c]=ao}catch(p){}}function b(d){return d.which||d.button&&(d.button&1?1:(d.button&2?3:(d.button&4?2:0)))}function Q(d){while(d=ag.pop()){Y(d[0],d[1],d[2])}}function an(){return new Date-j}function ak(w,p,d){w=w.slice();w[1]=w[1][i](36);if(/[mlducwrkfh]/.test(w[0])){for(d=2;d<w.length;d++){if((""+w[d]).length>1){if(w[d]===s[d]){w[d]="^"}else{s[d]=w[d]}}}}p=w.join("*").replace(/\*0\b/g,"*").replace(/^(.)\*|\*+$/g,"$1")+"!";t+=p.length;if(t>z){ai({data:k(N.join("")+(P.group?"@@"+H.join(""):""))});t=h;N=[];H=[]}N.push(p)}function aa(aq,ao,au,ap,d,p,ar,av,w){ap=an();if(o){clearTimeout(o[0]);if(ap-o[2]>50){o[1]()}else{o=0}}var at=/^u/.test(typeof am[r])?0:am[r];if(at!=r){ak(["f",ap,A(at)]);r=at}if(aq==="j"){ak([aq,ap].concat(d));return}if(!ao){ak([aq,ap])}if(ap>D){J();return}if("i"==aq&&null!==o){return}w=ao.target||ao.srcElement;while(w&&w.nodeType!=1){w=w.parentNode}if(f[0]==w){au=f[1]}else{if(this.flag==c&&this.doc){au=this.path+"/"+A(w,this.doc)}else{au=A(w)}}f=[w,au];d=[aq,ap,au];if(/[mw]/.test(aq)){if(m[0]==aq&&ap-m[1]<al&&m[2]==d[2]){return}m=d.slice(0,3)}if(w&&!w[c]&&/select/i.test(w.tagName)){w[c]=1;V(w,"change",function(aw){aa("h",aw)})}if("o"==aq){o&&clearTimeout(o[0]);o=function(){o=null;d[2]=+(Math.min(ab.screenTop||0,ab.screenY||0)<-22932);ak(d)};o=[setTimeout(o,1000),o,ap]}else{if(/[se]/.test(aq)){p=e();d[3]=p[[0,2][+(aq=="e")]];d[2]=p[[1,3][+(aq=="e")]]}else{if("i"==aq){d[2]=""}else{if(w){if(/[mlducwr]/.test(aq)){ar=af(w,[ao.clientX,ao.clientY],P.grid);if(!ar){return}d[3]=ar[0];d[4]=ar[1];if(/[cdul]/.test(aq)){d[5]=b(ao)}if(aq=="m"){d[5]=g?U:b(ao)}if(aq=="w"){d[5]=+((ao.wheelDelta||ao.detail)<0)}}else{if("k"==aq){d[3]=/password/i.test(w.type)?1:ao.keyCode;d[4]=[+ao.altKey||0,+ao.ctrlKey||0,+ao.shiftKey||0,+ao.metaKey||0].join("")}else{if("h"==aq){d[3]=w.selectedIndex}}}}}}ak(d)}if(/[dcukio]/.test(aq)){X();K();W&&clearInterval(W);ac=0;W=setInterval(function(){X();K();if(ac++>3){W&&clearInterval(W);ac=0;W=0}},1000)}}function J(){if(!j){return}ai({cmd:"close",data:k(N.join("")+"z"+an()[i](36)+(P.group?"@@"+H.join(""):""))});t=h;N=[];H=[];j=0;Q()}function Z(w,d,ao){d=[];for(ao in w){if(typeof w[ao]!="undefined"){d.push(ao+"="+decodeURIComponent(w[ao]))}}return d.join("&")}function O(p,ao,w){if(!E||!E[q]){return}if(window._hunter_sid){return}if(j){return}j=new Date;C=e();x=L();I=(+j)[i](36)+(+Math.random().toFixed(8).substr(2))[i](36);window._hunter_sid=I;c="_e_"+I;R=0;t=h;N=[];H=[];s=[];m=[];f=[];aj=[];var d=/^u/.test(typeof am[r])?0:am[r];ak(["a",0,C[0],C[1],C[2],C[3],A(d)]);r=d;ai({cmd:"open",ref:k(k(am.referrer)),data:k(N.join(""))});for(p=0;ao=ad[p++];){if(/(focus.)|blur|focus/.test(ao[0])&&(!RegExp.$1^!am.all)){continue}V(ao[2]||am,ao[0],(function(ap){return function(aq){if(ap=="z"){J();w=an();while(an()-w<100){}return}if(g){if("d"==ap){U=b(aq)}if("u"==ap){U=0}}aa(ap,aq)}})(ao[1]))}K();X()}function A(ao){if(!ao||ao.nodeType!=1||/^(html|body)$/i.test(ao.tagName)){return ao&&/^html$/i.test(ao.tagName)?"~html":""}var ap=""+(ao.getAttribute&&ao.getAttribute("id"));if(ap&&ap.length<11&&!(/tangram/i.test(ap))&&am.getElementById(ap)==ao){return"."+ap.replace(/[!-\/\s~^]/g,function(aq){return"%"+(256+aq.charCodeAt())[i](16).substr(1)})}var w=1,p=ao[S],d="nodeName";while(p){w+=p[d]==ao[d];p=p[S]}return A(ao.parentNode)+"~"+(w<2?"":w)+ao[d].toLowerCase()}function F(d){if(!d||d.nodeType!=1||/^(html|body)$/i.test(d.tagName)){return}var p=d.getAttribute&&d.getAttribute("hgroup");if(p){return d}return F(d.parentNode)}function af(w,aq,p){var ao=w[q](),d=ah(w);p=p||1;function ap(ar){return String(+ar.toFixed(3)).replace(/^0\./g,".")}return[ap(~~((aq[0]-ao.left)/p)*p/d[0]),ap(~~((aq[1]-ao.top)/p)*p/d[1])]}function ah(d){var p=d[q]();return[~~(p.right-p.left),~~(p.bottom-p.top)]}function L(){var p=ah(E),d=ah(G);return[M(p[0],d[0],ab[n]||0,E.scrollWidth||0),M(p[1],d[1],ab[B]||0,E.scrollHeight||0)]}function e(){return[M(E.scrollLeft||0,G.scrollLeft||0,(l&&l.pageXOffset)||0),M(E.scrollTop||0,G.scrollTop||0,(l&&l.pageYOffset)||0),ab[n]||E.clientWidth||G.clientWidth||0,ab[B]||E.clientHeight||G.clientHeight||0]}function ai(aq){if(!aq){return}var ap=Hunter.logPath||P.logPath;for(var ao in v){aq[ao]=v[ao]}var p=am.createElement("img"),d,w=am.getElementsByTagName("head")[0]||bd;p.src=ap+"?"+Z({pid:P.pid,hid:P.hid,qid:ab.bdQid,gr:P.grid,sid:I,seq:R++,px:u,ps:x,vr:C,dv:3})+"&"+Z(aq);p.onerror=p.onload=p.onreadystatechange=function(){if(!d&&/^(loaded|complete)$/.test(this.readyState)){d=1;w.removeChild(p);p=0}};w.appendChild(p);C=e();x=L();s=[]}function T(d,p){if(!j){return}ts=an();d=["g",ts].concat(d);ak(d);if(p){ai({data:k(N.join(""))})}}if(typeof Hunter.param=="object"){for(var ae in Hunter.param){v[ae]=Hunter.param[ae]}}if(P.hid){O()}Hunter.start=function(){if(P.hid){O()}};Hunter.stop=function(){J();window._hunter_sid=null};Hunter.setParam=function(d,p){v[d]=p};Hunter.record=T}();