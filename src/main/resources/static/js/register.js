layui.use(['layer', 'form' ,'jquery'], function() {
    var layer = layui.layer, form = layui.form;
    var $ = layui.$;

    //验证密码是否一致
    $("[name='rePassword']").blur(function(){
        checkPassword();
    });
    //验证密码方法
    function checkPassword(){
        var password = $("[name='password']").val();
        var rePassword = $("[name='rePassword']").val();
        if(password !== rePassword){
            layer.msg("输入的重复密码不正确")
        }
    }

    //验证手机号码
    $("[name='phone']").blur(function(){
        checkPhone();
    });
    //验证手机号码方法
    function checkPhone(){
        var phone = $("[name='phone']").val();
        if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phone))){
            layer.msg("手机号码格式不正确")
            return false;
        }
    }

    //验证邮箱
    $("[name='email']").blur(function(){
        checkEmail();
    });
    //验证邮箱方法
    function checkEmail(){
        var email = $("[name='email']").val();
        if(!(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(email))){
            layer.msg("邮箱格式不正确")
            return false;
        }
    }

    /*注册提交*/
    form.on('submit(registerSubmit)', function(data){
        var username = $("[name='username']");
        var password = $("[name='password']");
        var rePassword = $("[name='rePassword']");
        var realName = $("[name='realName']");
        var phone = $("[name='phone']");
        var email = $("[name='email']");
        var sex = $("[name='sex']").val();
        if(!checkInput(username)){
            return;
        }
        if(!checkInput(password)){
            return;
        }
        if(!checkInput(rePassword)){
            return;
        }
        if(!checkInput(realName)){
            return;
        }
        if(!checkInput(phone)){
            return;
        }
        if(!checkInput(email)){
            return;
        }

        var registerUrl = "/login/doRegister.do";
        $.ajax({
            url: registerUrl,
            type: "POST",
            data: {userName: username.val(), password: password.val(), realName: realName.val(),
                phone: phone.val(), email: email.val(), sex: sex},
            success: function (data) {
                layer.msg(data.msg);
                if(data.code == 200){
                    setTimeout(function(){window.location.href = "/login/login.html"}, 1000)
                }
            },
            error: function (data) {
                layer.msg(data.msg);
            }
        });
    });
});