<%-- 
    Document   : Template2
    Created on : Nov 5, 2017, 10:17:34 PM
    Author     : EJB Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Index</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Local CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/BlogStyle.css">
    </head>    
    <body>
        <div class="wrapper">
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3 class="blogCenter">Our Blog</h3>
                </div>
                <ul class="list-unstyled components">
                    <h4 id="links">Links:</h4>
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">Our Most Recent Posts</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li><a href="${pageContext.request.contextPath}/jsp/AdminHome.jsp">Temporary Redirect To Admin Pages</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/jsp/CreatePost.jsp">Create A Post</a>
                    </li>
                    <c:forEach var="spvml" items="${spvml}" varStatus="loop">
                        <li>
                            <a href="${pageContext.request.contextPath}/StaticPage/displaySelectedStaticPage?staticPageId=${spvml.staticPageId}">${spvml.staticPageTitle}</a>
                        </li>
                    </c:forEach>
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
                                    <li class="formbuffer"><label class="form-control" for="email">Login -</label></li>
                                    <li class="formbuffer"><label class="form-control" for="email">Email:</label></li>
                                    <li class="formbuffer"><input class="form-control" name="email" id="email" type="text" placeholder="Your Email"/></li>
                                    <li class="formbuffer"><label class="form-control" for="password">Password:</label></li>
                                    <li class="formbuffer"><input class="form-control" name="password" id="password" type="password" placeholder="Your Password"/></li>&nbsp;
                                    <li class="formbuffer"><button type="submit" class="btn-sm btn-primary formbuffer" id="loginButton">Login</button></li>
                                    <li class="formbuffer"><button type="button" class="btn-sm btn-primary formbuffer"><a href="${pageContext.request.contextPath}/jsp/BlogHome.jsp">Logout</a></button></li>
                                    <li class="formbuffer"><button type="button" class="btn-sm btn-primary formbuffer"><a href="${pageContext.request.contextPath}/jsp/Registration.jsp">Register</a></button></li>
                                </ul>
                            </form>
                        </div>
                    </nav>
                </div>
                    <div class="page">
                        <h2 class="blogCenter">${spvm.selectedStaticPage.staticPageTitle}</h2>
                        <br>
                        <p>${spvm.selectedStaticPage.staticPageContent}</p>

                    </div>

                    <div class="line"></div>
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
    </body>
</html>