<#assign base=request.getContextPath()>
<!DOCTYPE html>
<html lang="zh-CN"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>iOS版本下载</title>
    <style>
    html,body{
        font-family:"ff-tisa-web-pro-1","ff-tisa-web-pro-2","Lucida Grande","Helvetica Neue",Helvetica,Arial,"Microsoft YaHei","Hiragino Sans GB","Hiragino Sans GB W3","WenQuanYi Micro Hei",sans-serif;
        -webkit-font-smoothing:antialiased;
        height: 100%;
        padding: 0;
        margin: 0;
        
    }
    html{
        background: url(${base}/images/bg.jpg) no-repeat center center;
        -webkit-background-size: cover;
        background-size: cover;
        background-attachment: fixed;
    }
    body{
        display:table;
        text-align:center;
        table-layout: fixed;
        border-collapse: collapse;
        width: 100%;
    }
    .wrapper{
        margin: auto;
        width: 100%;
        height: 100%;
        position: relative;
        overflow: hidden;
        display: table-cell;
        vertical-align: middle;
    }

    #btnContainer{
        height: 86px;
        width: 229px;
        display: block;
        margin: 0 auto;
        position: relative;
        background: transparent;
    }
    #btnA{
        height: 86px;
        width: 229px;
        border-radius: 1em;
        display: block;
        background: url(${base}/images/i.png) no-repeat;
        -webkit-background-size: 229px 172px;
        background-size: 229px 172px;
        text-decoration: none;
        position: relative;
        z-index: 2;
    }
    #btnA:active, #btnA.active{
        background-position: 0px -92px;
        -webkit-background-size: 229px 172px;
        background-size: 229px 172px;
    }

    #slogan{
        position: relative; top: -2em;
        width: 230px; height: 68px; margin: 0 auto;
        background: url(http://www.ut.com.cn/UTMobile/api-slogan.png) no-repeat center center;
        -webkit-background-size: contain;
        background-size: contain;
    }

    #btnSpan2,#btnSpan3{
        font-size: .8em;
        color: #A7A7A7;
        position: absolute;
        top: 20px;
        left: 68px;
    }
    #btnSpan3{
        top: 44px;
    }

    </style>
</head>
<body>
    <div class="wrapper">
        <h1 id="slogan"></h1>
        <div id="btnContainer">
            <a id="btnA" href="itms-services://?action=download-manifest&url=${url}">
                <span id="btnSpan2">${fileName}</span>
                <span id="btnSpan3">${fileSize}M</span>
            </a>
        </div>
		<div>注意:微信、QQ等扫描进入此页面无法点击下载，请点击微信右上角的功能键，使用“在Safari中打开”</div>
    </div>
    <script type="text/javascript">
        window.onload = function(){
            var btn = document.getElementById('btnA');
            btn.addEventListener('touchstart',function(event){
                this.className = 'active';
            },false);
            btn.addEventListener('mousedown',function(event){
                this.className = 'active';
            },false);
            btn.addEventListener('touchend',function(event){
                this.className = '';
            },false);
            btn.addEventListener('mouseup',function(event){
                this.className = '';
            },false);
        };
    </script>

</body></html>
