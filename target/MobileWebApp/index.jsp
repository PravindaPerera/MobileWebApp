<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="services.phones" %>
<%@ page import="java.util.ArrayList" %>

<html>

<head>

    <title>Mobile Details Analyzer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap 3.3.7 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>MD</b>A</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><h4><b>Mobile Details</b><br>Analyzer</h4></span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <!-- Notifications: style can be found in dropdown.less -->
                    <!-- Tasks: style can be found in dropdown.less -->
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="dist/img/hesh.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">FYP</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="dist/img/hesh.png" class="img-circle" alt="User Image">

                                <p>
                                    Final Year Research Project
                                    <small>25 Dec. 2016</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
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
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="dist/img/hesh.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>FYP</p>
                </div>
            </div>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>

                <li><a href="" data-toggle="modal" data-target="#LogIn"><i class="fa fa-th"></i> <span>Log In</span></a></li>

                <li><a href="" data-toggle="modal" data-target="#SignUp"><i class="fa fa-th"></i> <span>Sign Up</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Mobile Details Analyzer
            </h1>
        </section>

        <%--<section class="content">--%>
            <%--<% ArrayList<phones> pd = (ArrayList<phones>)request.getAttribute("phone_details");--%>
            <%--%>--%>

            <%--<table class="table table-bordered">--%>
                <%--<tr>--%>
                    <%--<th>Phone ID</th>--%>
                    <%--<th>Brand</th>--%>
                    <%--<th>Code</th>--%>
                    <%--<th>Storage</th>--%>
                    <%--<th>Display</th>--%>
                    <%--<th>Battery</th>--%>
                    <%--<th>Front Cam</th>--%>
                    <%--<th>Rear Cam</th>--%>
                    <%--<th>Price</th>--%>
                <%--</tr>--%>


                <%--<%--%>
                    <%--for(int i=0; i<pd.size(); i++){--%>
                <%--%>--%>

                <%--<tr>--%>
                        <%--<td><%= pd.get(i).getPhone_id()%></td>--%>
                        <%--<td><%= pd.get(i).getBrand()%></td>--%>
                        <%--<td><%= pd.get(i).getCode()%></td>--%>
                        <%--<td><%= pd.get(i).getStorage()%></td>--%>
                        <%--<td><%= pd.get(i).getDisplay()%></td>--%>
                        <%--<td><%= pd.get(i).getBattery()%></td>--%>
                        <%--<td><%= pd.get(i).getFront_cam()%></td>--%>
                        <%--<td><%= pd.get(i).getRear_cam()%></td>--%>
                        <%--<td><%= pd.get(i).getPrice()%></td>--%>
                <%--</tr>--%>
                <%--<%--%>

                    <%--}--%>
                <%--%>--%>

            <%--</table>--%>
        <%--</section>--%>


        <!-- Main content -->

        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->

    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- LogIn-->
<div id="LogIn" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Log In</h4>
            </div>
            <form role="form" method="POST" action="/login">
                <div class="modal-body">
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="ion ion-clipboard"></i>
                            <h3 class="box-title">Log In Form</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">

                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" class="form-control" style="width: 200px" name ="un" placeholder="Enter your username">
                            </div>

                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" class="form-control" style="width: 200px" name ="pw" placeholder="Enter your password">
                            </div>

                        </div><!-- /.box-body -->
                    </div>


                    <div class="modal-footer">
                        <div>
                            <input type="submit" name="submit" value="Log In" class="btn btn-info pull-right">
                        </div>
                    </div>
               </div>
            </form>
        </div>
    </div>

</div>

<!-- SignUp-->
<div id="SignUp" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sign Up</h4>
            </div>
            <form role="form" method="POST" action="/signup">
                <div class="modal-body">
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="ion ion-clipboard"></i>
                            <h3 class="box-title">Sign Up Form</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">

                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" class="form-control" style="width: 200px" name ="un" placeholder="Enter your username">
                            </div>

                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" class="form-control" style="width: 200px" name ="pw" placeholder="Enter your password">
                            </div>

                            <div class="form-group">
                                <label>Confirm Password:</label>
                                <input type="password" class="form-control" style="width: 200px" name ="cpw" placeholder="Confirm your password">
                            </div>

                        </div><!-- /.box-body -->
                    </div>


                    <div class="modal-footer">
                        <div>
                            <input type="submit" name="submit" value="Sign Up" class="btn btn-info pull-right">
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>

</div>

<%--<script src="http://code.jquery.com/jquery.js"></script>--%>

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${pageContext.request.contextPath}/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>




</body>
</html>
