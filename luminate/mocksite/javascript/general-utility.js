var lwms =  lwms || {};

lwms.Util = {};

	//弹出窗口 [ID,上下位置,偏移值]
lwms.Util.openwin = function(id,path,dist){
		var stopbug=document.documentElement.scrollTop || document.body.scrollTop;
		var objid=lwms.Util.magicjs(id);
		console.log(objid.style.display);	
		objid.style.display=(objid.style.display != "block")?"block":"none"; //判断窗口显示隐藏  判断遮罩层显示隐藏
		console.log("dialog visibility: 1 " + objid.style.display);
		$("#winmask").height(document.body.scrollHeight+"px"); //设遮罩层高度
		$("#winmask").width(document.body.scrollWidth+"px"); //设遮罩层宽度		
		$("#winmask").css('z-index',(parseInt($("#"+id).css('z-index'))-1));//遮罩层在弹出窗口的下一层
		(objid.style.display=="none")?$("#winmask").hide():$("#winmask").show();
		
		console.log("dialog visibility: 2 " + objid.style.display);

		//winmask.style.height=document.body.scrollHeight+"px"; //设遮罩层高度
		//winmask.style.width=document.body.scrollWidth+"px"; //设遮罩层宽度
		//function getleft(){objid.style.left=(document.documentElement.clientWidth-objid.offsetWidth)/2+"px"} //打开时取得窗口left居中值
		//function gettop(){objid.style.top=(document.documentElement.clientHeight-objid.offsetHeight)/2+"px";} //打开时取得窗口top居中值
		//function ie6gettop(){objid.style.top=document.documentElement.scrollTop+dist+"px";} //ie6取得top值
		//function ie6getbottom(){objid.style.top=document.documentElement.clientHeight+document.documentElement.scrollTop-objid.offsetHeight-dist+"px";} //ie6取得top值，得到bottom值
		//function ie6getcen(){objid.style.top=(document.documentElement.clientHeight-objid.offsetHeight)/2+document.documentElement.scrollTop+"px";} //ie6取得top居中值
		lwms.Util.setLeftAndTop(objid);

		//getleft();gettop();
		var b_version=navigator.appVersion;
		var version=b_version.split(";");
		var trim_Version = "";
		if(version.length > 1){
			trim_Version = version[1].replace(/[ ]/g,""); 
		}
		if(trim_Version=="MSIE6.0"){ //判断IE6
			//window.onresize=window.onscroll=function(){getleft();if(!dist){ie6getcen()};}
			//if(dist){ie6gettop()}else{ie6getcen();}
		}else{
			window.onresize=function()
			{
				lwms.Util.setLeftAndTop(objid);
			}
		}
	};

	lwms.Util.setLeftAndTop = function(element) {
		var pos = lwms.Util.getLeftAndTop(element);
		element.style.left = pos.left + "px";
		element.style.top = pos.top + "px";
	};

  lwms.Util.getLeftAndTop = function(element) {
  	var left = (document.documentElement.clientWidth-element.offsetWidth)/2;
  	var top = (document.documentElement.clientHeight-element.offsetHeight)/2;
  	return {'left': left, 'top': top};
  };

	lwms.Util.magicjs = function(id)
	{
		return $("#"+id)[0];
	};

  lwms.Util.copy = function(o, ul) {
  	if(o._ex){return o;}else{for(var n in ul){o[n]=ul[n];}o._ex=true;return o;}
  }

	