<div class="col-md-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div><b>短信剩余量</b></div>
        </div>
        <div class="tab-content">
            <div class="tab-pane active">
                <table class="table table-bordered" style="background-color:#fff">
                    <tbody>
                    <#list list as platform>
                    <tr>
                        <td valign="top" class="td_lable lang">${platform}</td>
                        <td id="${platform}"></td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>