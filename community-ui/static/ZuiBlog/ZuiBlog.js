//è®¾ç½®cookie
function setCookie(name, value) {

    if (value) {

        var Days = 365
        var exp = new Date()
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000)
        document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString() + "; path=/";
    }
}
//èŽ·å–cookie
function getCookie(NameOfCookie) {
    if (document.cookie.length > 0) {
        begin = document.cookie.indexOf(NameOfCookie + "=");
        if (begin !== -1) {
            begin += NameOfCookie.length + 1;
            end = document.cookie.indexOf(";", begin);
            if (end === -1) end = document.cookie.length;
            return unescape(document.cookie.substring(begin, end));
        }
    }
    return null;
}
//删除 –cookie
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=/";
}

//èŽ·å–urlå‚æ•°
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) { return pair[1]; }
    }
    return (false);
}

/**
 * 错误代码检测
 * @param {*} obj
 */
function check(obj) {
    if (obj == "") {
        return false;
    }
    else if (obj.code == '0x444') {
        alert(obj.message);
        //跳转登入页面
        window.location.href = "/h/cn/user/login";
        return false;
    } else if (obj.code == '0x445') {
        alert(obj.message);
        //跳转首页
        window.location.href = "/h";
        return false;
    } else if (obj.code == '0x500') {
        alert("操作失败");
        return false;
    } else if (obj.code == '0x501') {
        alert("服务器接受数据异常");
        return false;
    } else if (obj.code == '0x502') {
        alert(obj.message);
        return false;
    } else if (obj.code == '0x501') {
        alert(obj.message);
        return false;
    } else if (obj.code == '0x504') {
        alert(obj.message);
        window.location.href = "/h";
        return false;
    } else if (obj.code == '0x505') {
        alert(obj.message);
        return false;
    } else if (obj.code == '0x506') {
        alert(obj.message);
        return false;
    } else if (obj.code == '0x507') {
        alert(obj.message);
        return false;
    } else if (obj.code == '0x508') {
        alert(obj.message);
        //跳转首页
        window.location.href = "/h";
        return false;
    } else if (obj.code == '0x446') {
        //跳转首页
        window.location.href = "/h/admin/login";
        return false;
    } else if (obj.code == '0x447') {
        //跳转首页
        alert("账号密码错误");
        return false;
    } else if (obj.code == '0x448') {
        alert("选择失败您已经选择了床位");
        return false;
    } else if (obj.code == '0x449') {
        alert("手慢了，已经被他人选择");
        return false;
    } else if (obj.code == '0x450') {
        alert("您还没有缴费，无法选择该床位");
        return false;
    }

    return true;
}
