<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Focus Admin: Widget</title>

    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">

    <!-- Styles -->
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="bg-primary">

<div class="unix-login">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="dashboard.jsp"><span>UP-AND-COMING BANK</span></a>
                    </div>
                    <div class="login-form">
                        <h4>Register </h4>

                        <c:if test="${requestScope.passwordMisMatch!= null}">
                            <div class ="alert alert-danger text-center border border-danger">

                                <b>${requestScope.passwordMisMatch}</b>
                            </div>
                        </c:if>

                        <c:if test="${requestScope.success!= null}">
                            <div class ="alert alert-success text-center border border-success">

                                <b>${requestScope.success}</b>
                            </div>
                        </c:if>
                        <form:form  action="/register" modelAttribute="registerUser">
                            <div class="form-group">
                                <label>First Name</label>
                                <form:input type="text" path="first_name" class="form-control" placeholder="First Name"/>
                                <form:errors path="first_name" class="text-white bg-danger"/>

                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <form:input type="text"  path="last_name" class="form-control" placeholder="Last Name"/>
                                <form:errors path="last_name" class="text-white bg-danger"/>

                            </div>

                            <div class="form-group">
                                <label>Email address</label>
                                <form:input type="email" path="email"  class="form-control" placeholder="Email"/>
                                <form:errors path="email" class="text-white bg-danger"/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                                <form:errors path="password" class="text-white bg-danger"/>
                            </div>
                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input type="password"  name = "confirm_password" class="form-control" placeholder="Confirm Password">
                                <small class="text-white bg-danger"> ${confirm_pass}</small>
                            </div>

                            <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30" >Register</button>

                            <div class="register-link m-t-15 text-center">
                                <p>Already have account ? <a href="/login"> Sign in</a></p>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>