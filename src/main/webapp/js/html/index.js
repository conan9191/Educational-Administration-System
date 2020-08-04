$(function(){
	//----------公共函数-------
	//生成验证码
	var timestamp;
	function getCode(){
		timestamp = new Date().getTime();
		$.ajax({
			type:"POST",
			url:"./../edu_system/user/getCode",
			data:{
				timestamp:timestamp,
			},
			dataType:"json",
			success:function(){
				//不做处理
			},
			error:function(){
				//不做处理
			}
		});
	}

	//--------------------注册---------------
	//注册滑块验证初始化

	$("#register-btn").click(function(){
		//表单验证
		var studentNumber = $("#register-studentNumber").val();
		var name = $("#register-name").val();
		var gender = $('input[name="register-gender"]:checked').val();

		$.ajax({
			type:"POST",
			url:"./../edu_system/user/register",
			data:{
				studentNumber:studentNumber,
				name:name,
				gender:gender
			},
			dataType:"json",
			success:function(data){
				if(data.errno=="0000"){
					//注册成功
					layer.msg(data.errmsg);
					setTimeout(function(){
						$("#register-to-login").click();
					},2000);
				}else{
					//注册失败
					layer.msg(data.errmsg);
				}
				
			},
			error:function(data){
				layer.msg("服务器错误请重试!");
			}
		});
	});



	//---------------登录--------------
	//登录滑块验证初始化
	$("#login-slider").slider({
	    width: 539, // width
	    height: 40, // height
	    sliderBg: "rgb(134, 134, 131)", // 滑块背景颜色
	    color: "#fff", // 文字颜色
	    fontSize: 14, // 文字大小
	    bgColor: "#33CC00", // 背景颜色
	    textMsg: "按住滑块，拖拽验证", // 提示文字
	    successMsg: "验证通过了哦", // 验证成功提示文字
	    successColor: "red", // 滑块验证成功提示文字颜色
	    time: 400, // 返回时间
	    callback:function(result) { // 回调函数，true(成功),false(失败)
			if(result === true){
				//后台生成验证码
				getCode();
			} else {
				//不做处理
			}
		}
	});

	$("#login-btn").click(function(){
		//表单验证
		var username = $("#login-username").val().trim();
		var password = $("#login-password").val().trim();

		$.ajax({
			type:"POST",
			url:"./../edu_system/user/login",
			data:{
				username:username,
				password:password,
				timestamp:timestamp
			},
			dataType:"json",
			success:function(data){
				//登录成功?
				if(data.errno=="0000"){
					layer.msg(data.errmsg);
					setTimeout(function(){
						window.location.href="./management.html";// "./" 当前目录
					},2000);
				}else{
					//登录失败
					layer.msg(data.errmsg);
				}
				
			},
			error:function(data){
				layer.msg("服务器错误请重试!");
			}
		});
	});

});