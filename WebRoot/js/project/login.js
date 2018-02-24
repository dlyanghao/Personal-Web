/**
 * login.jsp页面的JavaScript代码
 */
//使用pop插件定制弹出框插件，直接调用默认的，暂时不用定制

//使用JQuery插件Popover定制消息框
$(function () {
  $("[name='registerName']").popover({
	  title: "注册的用户名",
	  content: "只能输入2-10位英文字母、数字或者下划线",
	  placement: 'bottom', //top, bottom, left or right
	  trigger:'hover', //触发方式
	  //template: ''//你自定义的模板
  });
  
  $("[name='registerPsd']").popover({
	  title: "注册的密码",
	  content: "6-16位的英文字母数字下划线组合",
	  placement: 'bottom', //top, bottom, left or right
	  trigger:'hover', //触发方式
	  //template: ''//你自定义的模板
  });
  
  //$('[data-toggle="popover"]').popover();
  
})

//设置验证码图片的点击事件,每点击一次请求一次验证码
$(function(){
	$("#vCodeId").click(function(){
		$("#vCodeId").prop("src","vCode?time="+new Date().getSeconds());
	});
});
//注册表单的校验，使用独立校验方式
$(function(){
	$("#registerForm").submit(function(){
		
		//定义用户名和密码的正则表达式
		var regExpName = /^\w{2,10}$/g;
		var regExpPsd = /^\w{6,16}$/g;
		
		var registerName = $("[name='registerName']").val();
		var registerPsd = $("[name='registerPsd']").val();
		if(registerName==""){
			$.Pop("注册名不能为空");
			return false;
		}
		if(registerPsd==""){
			$.Pop("注册密码不能为空");
			return false;
		}
		if(!regExpName.test(registerName)){
			$.Pop('你的注册名不符合规范或者已经被注册');
			return false;
		}
		if(!regExpPsd.test(registerPsd)){
			$.Pop("你的密码不符合规范");
			return false;
		}
		
		return true;
	});
});

//登录表单的校验，使用validate.js插件做前端校验，form有一个onSubmit事件(Jquery中是submit事件)，为true的时候才提交，即全部校验通过的时候才返回true给该事件属性
$(function(){
	//先定义自定义校验方法（方法内使用正则）
	$.validator.addMethod("usernamevalidate",function(value,element,params){
		console.log("ssss");
		var reg = /^\w{2,10}$/g;
		return reg.test(value);
		
	},"用户名只能输入2-10位英文字母、数字或者下划线");

	$.validator.addMethod("passwordvlidate",function(value,element,params){
		
		var reg = /^\w{6,16}$/g;
		return reg.test(value);
		
	},"YANO说他也记不清你的密码了,应该是6-16位的英文字母数字下划线组合");

	$("#loginForm").validate({
		rules:{
			username:{
				required:true,
				usernamevalidate:true
			},
			password:{
				required:true,
				passwordvlidate:true
			},
			vCode:{
				required:true
			}
		},
		
		messages:{
			
			username:{
				required:"忘记用户名了吗？"
			},
			password:{
				required:"忘记用户密码了吗？"
			},
			vCode:{
				required:"忘记写验证码了？"
			}
			
		}
	});
});
	
//使用Ajax发送请求到服务器验证用户名是否存在,注意data返回的是一个字符串
$(function(){
	$("[name='registerName']").blur(function(){
		var pramater = $("[name='registerName']").val();
		if(pramater.length>=2){
			$.get("registerNameValidate",{testName:pramater},function(data){
				if(data=='true')
				{
					$("#registerTip").text("该用户名可用");
				}
				else
				{
					$("#registerTip").text("该用户名已被注册");
				}
			});
		}
		else
		{
			$("#registerTip").text("");
		}
	});
});

