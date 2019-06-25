<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/26/2019
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <img src="../../../static/img/car.jpg" alt="" class="CarSearchImg">
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
                    <img src="../../../static/img/car.jpg" alt="" class="CarSearchImg">
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
                    <img src="../../../static/img/car.jpg" alt="" class="CarSearchImg">
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