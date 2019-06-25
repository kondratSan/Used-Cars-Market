<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/25/2019
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Go-Go Car - Home</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Viga&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
<header>
    <div class="container-fluid fixed-top top-bar">
        <div class="container">
            <div class="row ">
                <div class="d-flex justify-content-center justify-content-sm-start p-2 col-md-2 col-sm-6 logo order-md-1">
                    <a href="/home">
                        <img src="/static/img/logo2.png" height="85">
                    </a>
                </div>
                <div class="col-md-3 col-sm-6 login order-md-3">
                    <div class="row p-2">
                        <div class="col-12 d-flex justify-content-center justify-content-sm-end loginDivHome">
                            <img src="/static/img/humanIcon.JPG" height="35">
                            <a href="login-register.html" class="loginHome"> &nbsp;&nbsp;&nbsp;Log&nbsp;in&nbsp;/&nbsp;Register&nbsp;&nbsp;</a>
                        </div>
                        <div class="col-12 p-2 d-flex justify-content-center justify-content-sm-end">
                            <button type="button" onclick="window.location.href = 'sellCar.html'" class="btn btn-info">
                                <b class="sell-button"><i class="fa fa-plus "></i> SELL A CAR</b>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="col-md-7 col-sm-12 text-center order-md-2 slogan">
                    <img src="/static/img/slogan.JPG" height="85" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</header>


<%--<jsp:include page="${currentPage }" />--%>
<%--<jsp:include page="page/searchPage.jsp" />--%>
///////////
<div class="container my-5">
    <div class="row">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
        <div class="col-md-7 ml-4 search">
            <div class="row">
                <div class="col-md-6">
                    <div class="select">
                        <select class="browser-default custom-select">
                            <option selected>Category</option>
                            <option value="1">Category1</option>
                            <option value="2">Category2</option>
                            <option value="3">Category3</option>
                        </select>
                    </div>
                    <div class="select">
                        <select class="browser-default custom-select">
                            <option selected>Brand</option>
                            <option value="1">Brand1</option>
                            <option value="2">Brand2</option>
                            <option value="3">Brand3</option>
                        </select>
                    </div>
                    <div class="select">
                        <select class="browser-default custom-select">
                            <option selected>Model</option>
                            <option value="1">Model1</option>
                            <option value="2">Model2</option>
                            <option value="3">Model3</option>
                        </select>
                    </div>

                </div>

                <div class="col-md-6">
                    <div class="row">
                        <div class="col-4">
                            <div class="year">Year</div>
                            <div class="year">Price,&nbsp$</div>
                        </div>
                        <div class="col-8 ">
                            <div class="row ">
                                <div class="col-6 rightdrop">

                                    <div class="dropdown-right">
                                        <select class="browser-default custom-select">
                                            <option selected>From</option>
                                            <option value="1">2000</option>
                                            <option value="2">2001</option>
                                            <option value="3">2002</option>
                                        </select>
                                    </div>
                                    <input type="number" class="form-control priceSelect" aria-label="Default"
                                           aria-describedby="inputGroup-sizing-default" value="0">


                                </div>
                                <div class="col-6 rightdrop">
                                    <div class="dropdown-right">
                                        <select class="browser-default custom-select">
                                            <option selected>To</option>
                                            <option value="1">2010</option>
                                            <option value="2">2011</option>
                                            <option value="3">2012</option>
                                        </select>
                                    </div>
                                    <input type="number" class="form-control priceSelect" aria-label="Default"
                                           aria-describedby="inputGroup-sizing-default" value="999999">


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="d-flex justify-content-center col-12">
                    <button class="btn btn-search" type="button" onclick="window.location.href = 'searchPage.html'">
                        <i class="fa fa-search" aria-hidden="true"></i> Search
                    </button>
                </div>


            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-12 mt-3">
            <div class="row">
                <div class="col-lg-4 CarSearchImgDiv">
                    <img src="images/car.jpg" alt="" class="CarSearchImg">
                </div>
                <div class="col-lg-8">
                    <span class="carSearchTitle">Hyundai Santa Fe 2019</span> <br>
                    <span class="carSearchPrice"><b>29&nbsp;700 $</b></span> <br>
                    <span > <i class="fa fa-map-marker" aria-hidden="true"></i> Location </span> <br> <br>
                    <div class="carSearchDesc">
                    <span>The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.</span>
                    </div>
                </div>
            </div>
            <div class="col-12 mt-5">
                <hr class="searchCarLine">
            </div>
        </div>
        <div class="col-12 mt-3">
            <div class="row">
                <div class="col-lg-4 CarSearchImgDiv">
                    <img src="images/car.jpg" alt="" class="CarSearchImg">
                </div>
                <div class="col-lg-8">
                    <span class="carSearchTitle">Hyundai Santa Fe 2019</span> <br>
                    <span class="carSearchPrice"><b>29&nbsp;700 $</b></span> <br>
                    <span > <i class="fa fa-map-marker" aria-hidden="true"></i> Location </span> <br> <br>
                    <div class="carSearchDesc">
                    <span>The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.</span>
                    </div>
                </div>
            </div>
            <div class="col-12 mt-5">
                <hr class="searchCarLine">
            </div>
        </div>
        <div class="col-12 mt-3">
            <div class="row">
                <div class="col-lg-4 CarSearchImgDiv">
                    <img src="images/car.jpg" alt="" class="CarSearchImg">
                </div>
                <div class="col-lg-8">
                    <span class="carSearchTitle">Hyundai Santa Fe 2019</span> <br>
                    <span class="carSearchPrice"><b>29&nbsp;700 $</b></span> <br>
                    <span > <i class="fa fa-map-marker" aria-hidden="true"></i> Location </span> <br> <br>
                    <div class="carSearchDesc">
                    <span>The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.
                        The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever. The best car ever.</span>
                    </div>
                </div>
            </div>
            <div class="col-12 mt-5">
                <hr class="searchCarLine">
            </div>
        </div>
    </div>

</div>


///////////

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12 pt-4 d-flex justify-content-center">
                <span id="keepConnected"><h2>Keep Connected</h2></span><br><br>
            </div>
            <div class="col-md-12 pt-4">
                <div class="mb-3 d-flex justify-content-center">
                    <a class="fb-ic" href="https://www.facebook.com/profile.php?id=100004691676273&ref=bookmarks"
                       target="_blank">
                        <i class="fa fafooter fa-facebook-f fa-lg mr-md-5 mr-3 fa-2x"> </i>
                    </a>
                    <a class="tw-ic" href="https://twitter.com/?lang=en" target="_blank">
                        <i class="fa fafooter fa-twitter fa-lg mr-md-5 mr-3 fa-2x"> </i>
                    </a>
                    <a class="li-ic" href="https://www.linkedin.com/in/oleksandr-kondrat-705a69184/" target="_blank">
                        <i class="fa fafooter fa-linkedin fa-lg mr-md-5 mr-3 fa-2x"> </i>
                    </a>
                    <a class="ins-ic" href="https://www.instagram.com/kondrat.san/" target="_blank">
                        <i class="fa fafooter fa-instagram fa-lg mr-md-5 mr-3 fa-2x"> </i>
                    </a>
                    <a class="pin-ic" href="https://www.pinterest.com/" target="_blank">
                        <i class="fa fafooter fa-pinterest fa-lg fa-2x"> </i>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
        <a href="/home" style="color: black"> Go-GoCar.com</a>
    </div>

</footer>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>