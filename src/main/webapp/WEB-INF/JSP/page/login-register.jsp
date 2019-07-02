<%@ page import="com.softserve.ita.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/26/2019
  Time: 2:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container log/reg">
    <div class="row" style="margin-bottom: 150px; margin-top: 70px">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
        <div class="col-md-6">
            <div class="container card-container d-flex justify-content-center">
                <div class="card">
                    <div class="card-header d-flex justify-content-end">
                        <h3 class="SignInText">Sign In</h3>
                        <div class="brand_logo_container">
                            <img src="../../../static/img/logo2.png" class="brand_logo" alt="Logo">
                        </div>

                    </div>
                    <div class="card-body mt-3">
                        <form action="/login" method="post">
                            <div class="container">
                                <div class="input-group form-group">
                                    <div class="input-group-prepend prepend-login">
                                                            <span class="input-group-text"><i
                                                                    class="fa fa-user"></i></span>
                                    </div>
                                    <input type="email" class="form-control" name="email" placeholder="Email"  required>

                                </div>
                                <div class="input-group form-group">
                                    <div class="input-group-prepend prepend-login">
                                                            <span class="input-group-text"><i
                                                                    class="fa fa-key"></i></span>
                                    </div>
                                    <input type="password" class="form-control" name="password"
                                           placeholder="Password" required>
                                </div>
                                <div class="errRegMessage">
                                    <%=(request.getAttribute("loginErrMessage") == null) ? "" : request.getAttribute("loginErrMessage")%></div>
                                <div class="form-group mt-4">
                                    <input type="submit" value="Login"
                                           class="btn float-right login_btn">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="container card-container d-flex justify-content-center">
                <div class="card">
                    <div class="card-header">
                        <h3>New here? Sigh Up</h3>
                    </div>
                    <div class="card-body">
                        <form onsubmit="return validate()" action="/user" method="post">
                            <div class="container">
                                <div class="errRegMessage">
                                    <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" name="firstName" placeholder="First Name"
                                           required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" name="lastName" placeholder="Last Name"
                                           required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email" required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" name="age" placeholder="Age" required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" name="phoneNumber"
                                           placeholder="Phone number" required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" name="city" placeholder="City" required>
                                </div>
                                <div class="input-group form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password"
                                           required>
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="Register"
                                           class="btn float-right reg_btn">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

