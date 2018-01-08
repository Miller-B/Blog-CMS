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
        <title>Registration</title>
         <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Local CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/BlogStyle.css">
    </head>    
    <body>
        <div class="wrapper">
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3>Registration</h3>
                </div>
                <ul class="list-unstyled components">
                    <h4 id="links">Links:</h4>
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">Home</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li><a href="#">Home 1</a></li>
                            <li><a href="#">Home 2</a></li>
                            <li><a href="#">Home 3</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">About Us</a>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">Pages</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li><a href="#">Page 1</a></li>
                            <li><a href="#">Page 2</a></li>
                            <li><a href="#">Page 3</a></li>
                        </ul>
                    </li>
<!--                    <li>
                        <a href="#">Portfolio</a>
                    </li>-->
                    <li>
                        <a href="#">Contact Us</a>
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
                <div class="apost">
                    <h4 id="registrationTitle">Thanks for looking into joining our page, please enter your information below and hit submit or back-out by clicking cancel.</h4>
                </div>
                <div class="line"></div>
                <div class="container-fluid">
                    <div class="container-fluid" id="registrationFormBuffer">
                    </div>
                    <div class="col-sm-3">                        
                    </div>
                    <div class="col-sm-6" id="registrationFormBox">
                    <sf:form id="createUserForm" class="form-horizontal" commandName="ucm"
                             action="${pageContext.request.contextPath}/AdminManageUsers/CreateUser" method="POST">
                            <div class="form-group">
                              <label class="control-label col-sm-2" for="userName">User Name:</label>
                              <div class="col-sm-10">
                                <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter A User Name" path="userName">
                              </div>
                            </div>
                            <div class="form-group">
                              <label class="control-label col-sm-2" for="userEmail">Email:</label>
                              <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" name="userEmail" placeholder="Enter Your Email" path="userEmail">
                              </div>
                            </div>
                            <div class="form-group">
                              <label class="control-label col-sm-2" for="userPassword">Password:</label>
                              <div class="col-sm-10">
                                <input type="password" class="form-control" id="password" name="userPassword" placeholder="Enter A Password" path="userPassword">
                              </div>
                            </div>
                            <div class="form-group" id="registrationButtonBackground">
                              <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn-sm btn-primary formbuffer">Submit</button>
                                <button type="button" class="btn-sm btn-primary formbuffer"><a href="${pageContext.request.contextPath}/">Cancel</a></button>
                              </div>
                            </div>
                          </sf:form> 
                    </div>
                    <div class="col-sm-3">                       
                    </div>
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
    </body>
</html>