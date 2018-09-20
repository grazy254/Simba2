<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<title>系统错误</title>
		<#include "../adminlte.ftl"/>
	</head>

	<body>
	<div>
    <!-- Content Wrapper. Contains page content -->
    <div class="">
        <section class="content">
            <div class="row">

                <!-- /.col -->
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">校验信息</h3>
                        </div>

                            <div class="box-body">
                                <div class="row">
                                    <!--
                                    <div class="col-sm-4 col-sm-offset-3">
	                                     <form role="form" class="horizontal-form">
	                                     	<div class="form-group">
	                                     	    <label class="control-label col-sm-4">提示</label>
	                                     	    <div class="col-sm-5">
	                                     	    	<p class="form-control-static bg-danger">
	                                     	    		${message!}
	                                     	    	</p>
	                                     	    </div>
	                                     	</div>
	                                     	<div class="form-group">
	                                     	    <button class="btn btn-primary" onclick="history.back();">返回</button>
	                                     	</div>
	                                     </form>
                                    </div>
                                    -->
                                   
                                    <div class="col-sm-3 col-sm-offset-4">
                                    	<p class="text-danger bg-info" style="padding: 10px;height: 250px;width: 100%; font-size: 24px;">
										    提示：<br/>
										    <span style="padding-left: 60px;">${message!}</span>	
									    </p>
									    
									    <button class="btn btn-primary btn-block" onclick="history.back();">返回</button>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <#--<div class="box-footer">-->
                               <#---->
                            <#--</div>-->


                    </div>
                </div>
                <!-- /. box -->
            </div>
            <!-- /.col -->
    </div>
    <!-- /.row -->
    </section>
    <!-- /.content -->

</div>
<!-- /.content-wrapper -->
<!-- Add the sidebar's background. This div must be placed
immediately after the control sidebar -->
</div>
<!-- ./wrapper -->
	</body>

</html>