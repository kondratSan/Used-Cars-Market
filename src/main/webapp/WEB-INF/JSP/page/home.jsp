<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/25/2019
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-5">
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
                    <button class="btn btn-search" type="button" onclick="window.location.href = '/search'">
                        <i class="fa fa-search" aria-hidden="true"></i> Search
                    </button>
                </div>


            </div>
        </div>
        <div class="offset-1 col-3  viewAllUsersButtonDiv">
            <button class="btn btn-danger" type="button" onclick="window.location.href = '/viewAllUsers'">
                View all users
            </button>
        </div>
    </div>
</div>


<div class="container cars-home pt-1">
    <div class="row mt-5">

        <div class="col-md-4 col-6 car-view">
            <a href="/car">
                <div class="img-crop ">
                    <img src="../../../static/img/car.jpg" alt="" class="car-img img-fluid">
                </div>
                <ul class="unstyle">
                    <li>
                        <span class="carTitle-home"> Hyundai Santa Fe 2019 </span>
                    </li>
                    <li>
                        <span class="carPrice-home"><b>29&nbsp;700 $</b></span>
                    </li>
                </ul>
            </a>
        </div>
        <div class="col-md-4 col-6 car-view">
            <a href="/car">
                <div class="img-crop ">
                    <img src="../../../static/img/car.jpg" alt="" class="car-img img-fluid">
                </div>
                <ul class="unstyle">
                    <li>
                        <span class="carTitle-home"> Hyundai Santa Fe 2019 </span>
                    </li>
                    <li>
                        <span class="carPrice-home"><b>29&nbsp;700 $</b></span>
                    </li>
                </ul>
            </a>
        </div>
        <div class="col-md-4 col-6 car-view">
            <a href="/car">
                <div class="img-crop">
                    <img src="../../../static/img/car.jpg" alt="" class="car-img img-fluid">
                </div>
                <ul class="unstyle">
                    <li>
                        <span class="carTitle-home"> Hyundai Santa Fe 2019 </span>
                    </li>
                    <li>
                        <span class="carPrice-home"><b>29&nbsp;700 $</b></span>
                    </li>
                </ul>
            </a>
        </div>
    </div>

</div>

<%--<h1>Welcome ${email}</h1>--%>



<div class="container searchByCat  mt-3 mb-5">
    <h3>Search by category</h3>
    <div class="container-fluid">
        <hr id="searchByCatLine">
        <div class="row">
            <div class="offset-1 col-2 carCatIconHome ">
                <a href="/search">
                    <div class="img-crop ">
                        <img src="../../../static/img/CarCatSed.JPG" alt="" class="car-img img-fluid">
                    </div>
                    <div class="carCatTitle-div">
                        <span class="carCatTitle-home"> Sedan </span>
                    </div>
                </a>
            </div>
            <div class="col-2 carCatIconHome">
                <a href="/search">
                    <div class="img-crop ">
                        <img src="../../../static/img/CarCatSUV.JPG" alt="" class="car-img img-fluid">
                    </div>
                    <div class="carCatTitle-div">
                        <span class="carCatTitle-home"> SUV </span>
                    </div>
                </a>
            </div>
            <div class="col-2 carCatIconHome">
                <a href="/search">
                    <div class="img-crop ">
                        <img src="../../../static/img/CarCatMinivan.JPG" alt="" class="car-img img-fluid">
                    </div>
                    <div class="carCatTitle-div">
                        <span class="carCatTitle-home"> Minivan </span>
                    </div>
                </a>
            </div>
            <div class="col-2 carCatIconHome">
                <a href="/search">
                    <div class="img-crop ">
                        <img src="../../../static/img/CarCatHatch.JPG" alt="" class="car-img img-fluid">
                    </div>
                    <div class="carCatTitle-div">
                        <span class="carCatTitle-home"> Hatch Back </span>
                    </div>
                </a>
            </div>
            <div class="col-2 carCatIconHome">
                <a href="/search">
                    <div class="img-crop ">
                        <img src="../../../static/img/CarCatSport.JPG" alt="" class="car-img img-fluid">
                    </div>
                    <div class="carCatTitle-div " style="margin-top: 7px">
                        <span class="carCatTitle-home"> Sports Car </span>
                    </div>
                </a>
            </div>

        </div>
    </div>
</div>