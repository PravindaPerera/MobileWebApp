<%--
  Created by IntelliJ IDEA.
  User: Pravinda Perera
  Date: 12/5/2016
  Time: 6:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="services.phones" %>
<%@ page import="services.comments" %>
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/swtAlert/sweetalert.css">


    <script>
        function selectSearchType() {
            $.ajax({
                        url:'${pageContext.request.contextPath}/selectSearchType',
                        data:{search_type: document.getElementById("search_type").value},
                        type:'post',
                        cache:false,
                        success:function(responseJson){
                            var select = $("#results");
                            select.empty();
                            $.each(responseJson, function(index, item) {
                                $("<option>").text(item).appendTo(select);

                            });
                        },
                        error:function(){
                            alert('error');
                        }
                    }
            );
        }

    </script>

    <script>

        $(document).on("click", "#searchOnResults", function() {
            alert("ccxc")// When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.post("${pageContext.request.contextPath}/finalSearch", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
                var $ul = $("<tr>").appendTo($("#finalRes"));
                $.each(responseJson, function(index, item) {

                    $("<td>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
                });
            });
        });

    </script>

    <%--<script>--%>
        <%--function searchOnResults() {--%>
            <%--alert("tata");--%>
            <%--$.post("${pageContext.request.contextPath}/finalSearch", function(responseJson) {--%>
                <%--alert(responseJson);--%>
                <%--var $ul = $("<tr>").appendTo($("#finalRes"));--%>
                <%--$.each(responseJson, function(index, item) {--%>

                    <%--$("<td>").text(item).appendTo($ul);--%>

                <%--});--%>
            <%--});--%>
        <%--}--%>

    <%--</script>--%>

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
                            <img src="${pageContext.request.contextPath}/dist/img/profile_pic.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${profile_name}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${pageContext.request.contextPath}/dist/img/profile_pic.jpg" class="img-circle" alt="User Image">

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
                    <img src="${pageContext.request.contextPath}/dist/img/profile_pic.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${profile_name}</p>
                </div>
            </div>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">MAIN NAVIGATION</li>

                <li><a href="" data-toggle="modal" data-target="#Comment"><i class="fa fa-th"></i> <span>Post Comment</span></a></li>

                <li><a href="/logout"><i class="fa fa-th"></i> <span>Logout</span></a></li>
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

        <section class="content">
        <div class="row">
            <div class="col-md-6">
                <button class="btn btn-warning" type="button" data-toggle="collapse" data-target="#FilterFeatures" aria-expanded="false" aria-controls="FilterFeatures">Filter by Basic Features</button>

                <div class="collapse" id="FilterFeatures" style="padding-top: 10px">

                    <form role="form" id="form1" name="form1" method="POST" action="">
                        <div>
                            <label>Search Type:</label>
                            <select name="search_type" id="search_type" onchange="selectSearchType()" style="width: 100%;">
                                <option>Select Search Type</option>
                                <option>Brand</option>
                                <option>Code</option>
                                <option>Storage</option>
                                <option>Display</option>
                                <option>Battery</option>
                                <option>Front Camera</option>
                                <option>Rear Camera</option>
                            </select>
                        </div>
                        <div>
                            <label>Search Results:</label>
                            <select id="results"  name="results" style="width: 100%;">
                                <option>Search Results</option>
                            </select>

                        </div>
                        <input type="button" id="searchOnResults" value="Search">
                        <%--<input hidden type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">--%>
                    </form>

                </div>
            </div>

            <div class="col-md-6">
                <button class="btn btn-warning" type="button" data-toggle="collapse" data-target="#FilterPrice" aria-expanded="false" aria-controls="FilterPrice">Filter by Price</button>

                <div class="collapse" id="FilterPrice" style="padding-top: 10px">

                </div>
            </div>

        </div>


        <div class="row">


        <%
            ArrayList<phones> pd = (ArrayList<phones>)request.getAttribute("phone_details");
            ArrayList<comments> cd = (ArrayList<comments>)request.getAttribute("comment_details");
        %>

        <table class="table table-bordered">
        <tr>
        <th>Phone ID</th>
        <th>Brand</th>
        <th>Code</th>
        <th>Storage</th>
        <th>Display</th>
        <th>Battery</th>
        <th>Front Cam</th>
        <th>Rear Cam</th>
        <th>Price</th>
        <th>Comments</th>
        </tr>


        <%
        for(int i=0; i<pd.size(); i++){
        %>
        <div id="finalRes">

            <tr>
                <td><%= pd.get(i).getPhone_id()%></td>
                <td><%= pd.get(i).getBrand()%></td>
                <td><%= pd.get(i).getCode()%></td>
                <td><%= pd.get(i).getStorage()%></td>
                <td><%= pd.get(i).getDisplay()%></td>
                <td><%= pd.get(i).getBattery()%></td>
                <td><%= pd.get(i).getFront_cam()%></td>
                <td><%= pd.get(i).getRear_cam()%></td>
                <td><%= pd.get(i).getPrice()%></td>
                <td>
                    <%
                        for(int y=0; y<cd.size(); y++){
                            if(cd.get(y).getPhone_id() == pd.get(i).getPhone_id()){
                    %><i class="fa fa-comments" aria-hidden="true"></i><%= cd.get(y).getCmnt()%><br><%
                        }
                    }
                %>
                </td>
            </tr>

        </div>

        <%

        }
        %>

        </table>

        </div>

        </section>


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

<!-- Comment-->
<div id="Comment" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Post Comment</h4>
            </div>
            <form role="form" method="POST" action="/comments">
                <div class="modal-body">
                    <div class="box box-primary">
                        <div class="box-header">
                            <i class="ion ion-clipboard"></i>
                            <h3 class="box-title">Comment Form</h3>
                            <div class="box-tools pull-right">
                            </div>
                        </div><!-- /.box-header -->
                        <div class="box-body">

                            <div class="form-group">
                                <label>Phone ID:</label>
                                <select style="width: 100px" name="phone_id">
                                    <%for (int i=0; i<pd.size(); i++){
                                        %>
                                    <option value="<%= pd.get(i).getPhone_id()%>"><%= pd.get(i).getPhone_id()%></option>
                                    <%
                                    }
                                    %>

                                </select>
                            </div>

                            <div class="form-group">
                                <label>Comment:</label>
                                <input type="text" class="form-control" style="width: 500px; height: 100px" name ="cmt" placeholder="Post a comment">
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


<p>Your are logged in succesfully</p>
<p>${profile_name}</p>

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

<script src="${pageContext.request.contextPath}/dist/swtAlert/sweetalert.min.js"></script>

</body>
</html>
