var http_request = false;
function makeRequest(url, functionName, httpType, sendData) {

    // '/e/public/digg/?classid=3&amp;id=19&amp;dotop=1&amp;doajax=1&amp;ajaxarea=diggnum','EchoReturnedText','GET',''
    http_request = false;
    if (!httpType) httpType = "GET";

    if (window.XMLHttpRequest) { // Non-IE...
        http_request = new XMLHttpRequest();
        if (http_request.overrideMimeType) {
            http_request.overrideMimeType('text/plain');
        }
    } else if (window.ActiveXObject) { // IE
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {}
        }
    }

    if (!http_request) {
        alert('Cannot send an XMLHTTP request');
        return false;
    }

    var changefunc="http_request.onreadystatechange = "+functionName;
    eval (changefunc);
    //http_request.onreadystatechange = alertContents;
    http_request.open(httpType, url, true);
    http_request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    http_request.send(sendData);
}

function getReturnedText () {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var messagereturn = http_request.responseText;
            return messagereturn;
        } else {
            alert('There was a problem with the request.');
        }
    }
}

function EchoReturnedText () {
    if (http_request.readyState == 4) {
        if (http_request.status == 200) {
            var messagereturn = http_request.responseText;
            if(messagereturn!='isfail')
            {
                var r;
                r=messagereturn.split('|');
                if(r.length!=1)
                {
                    if(r[0]!='')
                    {
                        document.getElementById(r[1]).innerHTML=r[0];
                    }
                    if(r[2]!='')
                    {
                        alert(r[2]);
                    }
                }
                else
                {
                    document.getElementById('ajaxarea').innerHTML=messagereturn;
                }
            }
        } else {
            alert('There was a problem with the request.');
        }
    }
}
function increaseViewCount(blogId) {
    if($.cookie("viewId") != blogId || $.cookie("viewId") == null){
        $.ajax({
            async: false,
            type: "POST",
            url: "/blog/view/" + blogId,
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                console.log(data);
                $(".view").html(data + 'Views');
                $.cookie(
                    "viewId",
                    blogId
                );
            },
            error: function () {
            }
        });
    }
}
//提交评论框
$("#comment_form").submit(function () {
    $.post("/comment",$("#comment_form").serialize(),function (data) {
        if(data.code == 1){
            alert("评论成功");
        }else{
            alert("评论失败");
        }
    });
});
//提交博客的数据
function blogForm() {
    var blogDataForm = document.getElementById("form-blog");
    if(document.getElementById("blog-id")){
        //如果包含id为blog-id的input标签，表示此时处于编辑的界面
        blogDataForm.action = "/admin/blog/update";
    }else{
        //否则处于新建博客的界面
        blogDataForm.action = "/admin/blog/add";
    }
    blogDataForm.submit();
}
//提交用户的数据
function userForm() {
    var dataForm = document.getElementById("form-user");
    if(document.getElementById("user-id")){
        //如果包含id为user-id的input标签，表示此时处于修改用户的界面
        dataForm.action = "/user/update";
    }else{
        dataForm.action = "/user/add";
    }
    dataForm.submit();
}


function edoshowkey(showid,vname,baseurl){
    document.getElementById(showid).innerHTML='<img src="'+baseurl+'e/ShowKey/?v='+vname+'&t='+Math.random()+'" name="'+vname+'KeyImg" id="'+vname+'KeyImg" align="bottom" onclick=edoshowkey("'+showid+'","'+vname+'","'+baseurl+'") title="看不清楚,点击刷新">';
}

function edozoomimg(o){
    var zoom=parseInt(o.style.zoom, 10)||100;zoom+=event.wheelDelta/12;if (zoom>0) o.style.zoom=zoom+'%';
    return false;
}

function edoautosimg(o){
    if(o.width>screen.width*0.5)
    {
        o.width=screen.width*0.5;
    }
}




