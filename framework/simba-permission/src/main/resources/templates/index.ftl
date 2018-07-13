<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>${longTitle}</title>
		<#include "adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/index.js"></script>
	</head>

	<body class="hold-transition skin-green-light sidebar-mini">

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modalDialog" style="display: none;" id="modalButton">
		  触发模态窗口的按钮
		</button>

		<!-- Modal -->
		<div class="modal fade bs-example-modal-lg" id="modalDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>
					<div class="modal-body" id="modalBody">
						<iframe id="modalbodyiframe" style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px;border-right-width: 0px;width: 100%;height:500px;" src="" frameborder="0" scrolling="auto"></iframe>
					</div>
				</div>
			</div>
		</div>

		<div class="wrapper">
			<header class="main-header">
				<!-- Logo -->
				<a href="#" class="logo">
					<!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><b>${shortTitle}</b></span>
					<!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><b>${longTitle}</b></span>
				</a>
				<!-- Header Navbar: style can be found in header.less -->
				<nav class="navbar navbar-static-top">
					<!-- Sidebar toggle button-->
					<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<div class="alert alert-danger alert-dismissible" role="alert" id="errDiv" style="position:fixed;margin: 0 auto;width:65%;height:5%;display: none;">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<div id="errInfo"></div>
					</div>
					<div class="alert alert-info alert-dismissible" role="alert" id="successDiv" style="position:fixed;margin: 0 auto;width:65%;height:5%;display: none;">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<div id="successInfo"></div>
					</div>
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<!-- User Account: style can be found in dropdown.less -->
							<li class="dropdown user user-menu">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<img src="${base}/img/user2-160x160.jpg" class="user-image" alt="User Image">
									<span class="hidden-xs" id="loginName"></span>
								</a>
								<ul class="dropdown-menu">
									<!-- Menu Footer-->
									<li class="user-footer" id="profile">
										<div class="pull-left">
											<a href="#" class="btn btn-default btn-flat" onclick="toModifyInfo();">个人信息</a>
										</div>
										<div class="pull-right">
											<a href="#" class="btn btn-default btn-flat" onclick="toModifyPwd();">修改密码</a>
										</div>
									</li>
								</ul>
							</li>

							<li>
								<a href="#" onclick="logout();" data-toggle="control-sidebar" title="退出"><i class="fa fa-power-off"></i></a>
							</li>

							<li>
								<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
							</li>
						</ul>
					</div>
				</nav>
			</header>
			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu" id="menuTree">
						<li class="header">主菜单</li>
					</ul>
				</section>
				<!-- /.sidebar -->
			</aside>
			<!--
			
-->
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<iframe id="contentiframe" name="contentiframe" style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px;border-right-width: 0px;width: 100%;" src="${base}/home" frameborder="0" scrolling="auto"></iframe>
			</div>
			<!-- /.content-wrapper -->

			<footer class="main-footer">
				<div class="pull-right hidden-xs">
					<b>版本</b> 2.0.0
				</div>
				<strong>Copyright &copy; 2014-2018 .</strong> All rights reserved.
			</footer>

			<!-- Control Sidebar -->
			<aside class="control-sidebar control-sidebar-dark">
				<!-- Tab panes -->
				<div class="tab-content">
					<div id="control-sidebar-theme-demo-options-tab" class="tab-pane active">
						<div>
							<h4 class="control-sidebar-heading">皮肤</h4>
							<ul class="list-unstyled clearfix">
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-blue-light');" data-skin="skin-blue-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9;"></span><span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px">浅蓝</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-black-light');" data-skin="skin-black-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix"><span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe;"></span><span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px">浅黑</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-purple-light');" data-skin="skin-purple-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span><span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px">浅紫</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-green-light');" data-skin="skin-green-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span><span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px">浅绿</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-red-light');" data-skin="skin-red-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span><span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px">浅红</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-yellow-light');" data-skin="skin-yellow-light" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span><span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #f9fafc;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin" style="font-size: 12px;">浅黄</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-blue');" data-skin="skin-blue" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px; background: #367fa9;"></span><span class="bg-light-blue" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">兰</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-black');" data-skin="skin-black" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div style="box-shadow: 0 0 2px rgba(0,0,0,0.1)" class="clearfix"><span style="display:block; width: 20%; float: left; height: 7px; background: #fefefe;"></span><span style="display:block; width: 80%; float: left; height: 7px; background: #fefefe;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">黑</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-purple');" data-skin="skin-purple" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-purple-active"></span><span class="bg-purple" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">紫</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-green');" data-skin="skin-green" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-green-active"></span><span class="bg-green" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">绿</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-red');" data-skin="skin-red" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-red-active"></span><span class="bg-red" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">红</p>
								</li>
								<li style="float:left; width: 33.33333%; padding: 5px;">
									<a href="javascript:changeSkin('skin-yellow');" data-skin="skin-yellow" style="display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)" class="clearfix full-opacity-hover">
										<div><span style="display:block; width: 20%; float: left; height: 7px;" class="bg-yellow-active"></span><span class="bg-yellow" style="display:block; width: 80%; float: left; height: 7px;"></span></div>
										<div><span style="display:block; width: 20%; float: left; height: 20px; background: #222d32;"></span><span style="display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;"></span></div>
									</a>
									<p class="text-center no-margin">黄</p>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</aside>

			<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
			<div class="control-sidebar-bg"></div>
		</div>
		<!-- ./wrapper -->
		<script type="application/javascript">
			$(document).ready(function() {
				initSkin();
			});
		</script>
	</body>

</html>