<%--
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
                        <form>
                            <div class="container">
                                <%--<form action="/login-register">--%>
                                    <%--<div class="input-group form-group">--%>
                                        <%--<div class="input-group-prepend prepend-login">--%>
                                                            <%--<span class="input-group-text"><i--%>
                                                                    <%--class="fa fa-user"></i></span>--%>
                                        <%--</div>--%>
                                        <%--<input type="text" class="form-control" name="uname" placeholder="Email">--%>

                                    <%--</div>--%>
                                    <%--<div class="input-group form-group">--%>
                                        <%--<div class="input-group-prepend prepend-login">--%>
                                                            <%--<span class="input-group-text"><i--%>
                                                                    <%--class="fa fa-key"></i></span>--%>
                                        <%--</div>--%>
                                        <%--<input type="password" class="form-control" name="pass"--%>
                                               <%--placeholder="Password">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group mt-4">--%>
                                        <%--<input type="submit" value="Login"--%>
                                               <%--class="btn float-right login_btn">--%>
                                    <%--</div>--%>
                                <%--</form>--%>
                                    <form class="mt-5 mb-5" action="/car">
                                        <input type="text" class="form-control" name="uname" placeholder="Email">
                                        <input type="password" class="form-control" name="pass">
                                        <input type="submit" value="Login"
                                               class="btn float-right login_btn">
                                    </form>
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
                        <form>
                            <div class="container">
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" placeholder="First Name">
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" placeholder="Last Name">
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" placeholder="Email">
                                </div>
                                <div class="input-group form-group">
                                    <input type="number" class="form-control" placeholder="Age">
                                </div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" placeholder="Phone number">
                                </div>
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>Region</option>
                                        <option value="1">Region1</option>
                                        <option value="2">Region2</option>
                                        <option value="3">Region3</option>
                                    </select>
                                </div>
                                <div class="input-group form-group">
                                    <select class="browser-default custom-select">
                                        <option selected>City</option>
                                        <option value="1">City1</option>
                                        <option value="2">City2</option>
                                        <option value="3">City3</option>
                                    </select></div>
                                <div class="input-group form-group">
                                    <input type="text" class="form-control" placeholder="Password">
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
