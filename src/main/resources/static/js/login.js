layui.use(['layer', 'form', 'jquery'], function(){
	var layer = layui.layer, form = layui.form;
	var $ = layui.$;

	//登陆提交
	form.on('submit(formSubmit)', function(data){
		var userName = $("[name='username']");
		var password = $("[name='password']");
		if(!checkInput(userName)){
			return;
		}
		if(!checkInput(password)){
			return;
		}
		var submitUrl = "/login/doLogin.do";
		$.ajax({
			url: submitUrl,
			type: "POST",
			data: {userName: userName.val(), password: password.val()},
			success: function (data) {
				layer.msg(data.msg);
				if(data.code == 200){
					setTimeout(function(){window.location.href = "/login/main.html"}, 1000)
				}
			},
			error: function (data) {
				layer.msg(data.msg);
			}
		});
	});
});