<%-- 
    Document   : Template2
    Created on : Nov 5, 2017, 10:17:34 PM
    Author     : EJB Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Administrator -HOME-</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Local CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/BlogStyle.css">
    </head>  
    
   <body>
        <div class="wrapper">
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3 class="blogCenter">Admin Menu</h3>
                </div>
                <ul class="list-unstyled components">
                    <h4 id="links">Functions:</h4>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/jsp/AdminHome.jsp">Administrator Home</a>   
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/AdminManageUsers/displayUserPage">Manage Users</a>   
                    </li>
                    <li>
                        <a href="#managePageSubmenu" data-toggle="collapse" aria-expanded="false">Manage Pages</a>
                        <ul class="collapse list-unstyled" id="managePageSubmenu">                            
                            <li><a href="${pageContext.request.contextPath}/AdminManagePages/displayPageAdminPage">Manage Pages</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminManagePages/createPage">Create Page</a></li>                           
                        </ul>
                    </li>
                    <li>
                        <a href="#managePostsSubmenu" data-toggle="collapse" aria-expanded="false">Manage Posts</a>
                        <ul class="collapse list-unstyled" id="managePostsSubmenu">                            
                            <li><a href="${pageContext.request.contextPath}/AdminManagePosts/displayPostAdminPage">Manage Posts</a></li>
                            <li><a href="${pageContext.request.contextPath}/AdminManagePosts/displayPostApprovePage">Approve Posts</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/AdminManageHashtags/displayHashtagPage">Manage Hashtags</a>
                    </li>
                </ul>
            </nav>           
            <div id="content">
                <div class="container-fluid" id="topbar">
                    <nav class="navbar navbar-default" id="topbar1">
                        <div class="navbar-header" id="topbar2">
                            <button type="button" id="sidebarCollapse" class="navbar-btn">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <form class="form-group form-group-sm form-inline" id="loginform">
                                <ul class="nav navbar-nav navbar-right">                                   
                                    <li class="formbuffer"><button type="button" class="btn-sm btn-primary formbuffer"><a href="${pageContext.request.contextPath}/">Logout</a></button></li>                                   
                                </ul>
                            </form>
                        </div>
                    </nav>
                </div>
                                
                <div class="row">
                    <div class="col-sm-12">
                        <h2 class="blogCenter">Create New Page</h2>
                        <div class="spacingDiv"></div>
                        <div class="line"></div>
                        <div class="spacingDiv"></div>
                    </div>                   
                    <form id="createPageForm" class="form-horizontal" commandName="spcm" action="${pageContext.request.contextPath}/AdminManagePages/CreatePage" method="POST">
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Page Title</label>
                            <div class="col-xs-5">
                                <input type="text" name="staticPageTitle" id="staticPageTitle" class="form-control" rows="5" placeholder="Enter Title" path="pageTitle"></input>         
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-3 control-label">Page Content</label>
                            <div class="col-xs-5">
                                <input type="textarea" name="staticPageContent" id="staticPageContent" class="form-control" rows="5" placeholder="Enter Page Content" path="pageContent"></input>         
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-5 col-xs-offset-3">
                            <button type="submit" class="btn btn-default" id="btnCreatePost">Post Page</button>
                            <button type="submit" class="btn btn-default" id="btnCancel" formaction="${pageContext.request.contextPath}/jsp/AdminHome.jsp">Cancel</button>
                            </div>
                        </div>    
                    </form>
                </div>
            </div>
        </div>
        <footer>
        </footer>
        <!-- jQuery CDN -->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <!-- Bootstrap Js CDN -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- jQuery Nicescroll CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.6.8-fix/jquery.nicescroll.min.js"></script>
        <!-- Our JS file -->
        <script src="${pageContext.request.contextPath}/js/BlogJavascript.js" type="text/javascript"></script>   
        <script type="text/javascript" src="${pageContext.request.contextPath}/tinymce/js/tinymce/tinymce.min.js"></script>
        <script type="text/javascript">
            tinymce.init({
                selector: '#staticPageContent',
                theme: 'modern',
                width: 500,
                height: 200,
                plugins: [
                    'advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker',
                    'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
                    'save table contextmenu directionality emoticons template paste textcolor'
                ],
                content_css: 'css/content.css',
                toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons'

            });
        </script>
    </body>
</html>