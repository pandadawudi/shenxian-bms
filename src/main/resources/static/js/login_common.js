//登录输入框效果
$('.form_text_ipt input').focus(function(){
    $(this).parent().css({
        'box-shadow':'0 0 3px #bbb',
    });
});
$('.form_text_ipt input').blur(function(){
    $(this).parent().css({
        'box-shadow':'none',
    });

});

function checkInput(e){
    if(e.val()==""){
        e.css({
            'color':'red',
        });
        e.parent().css({
            'border':'solid 1px red',
        });
        e.parent().next().show();
        return false;
    }else{
        e.css({
            'color':'#ccc',
        });
        e.parent().css({
            'border':'solid 1px #ccc',
        });
        e.parent().next().hide();
        return true;
    }
}
