<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/25/2019
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
        <form action="/search">
            <div class="col-md-9 ml-4 search">
                <div class="row">
                    <div class="col-md-6">
                        <div class="select">
                            <select name="category" class="browser-default custom-select">
                                <option selected value="">Category</option>
                                <option value="SUV">SUV</option>
                                <option value="Sedan">Sedan</option>
                                <option value="Hatch Back">Hatch Back</option>
                                <option value="Minivan">Minivan</option>
                                <option value="Sports Car">Sports Car</option>
                            </select>
                        </div>
                        <div class="select">
                            <input type="text" name="brand" class="form-control" placeholder="Brand" value="">
                        </div>
                        <div class="select">
                            <input type="text" name="model" class="form-control" placeholder="Model" value="">

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
                                            <input type="number" name="yearFrom" class="form-control priceSelect"
                                                   aria-label="Default"
                                                   aria-describedby="inputGroup-sizing-default" value="-1"
                                                   placeholder="From">
                                        </div>
                                        <input type="number" name="priceFrom" class="form-control priceSelect"
                                               aria-label="Default"
                                               aria-describedby="inputGroup-sizing-default" value="-1"
                                               placeholder="From">


                                    </div>
                                    <div class="col-6 rightdrop">
                                        <div class="dropdown-right">
                                            <input type="number" name="yearTo" class="form-control priceSelect"
                                                   aria-label="Default"
                                                   aria-describedby="inputGroup-sizing-default" value="999999"
                                                   placeholder="To">
                                        </div>
                                        <input type="number" name="priceTo" class="form-control priceSelect"
                                               aria-label="Default"
                                               aria-describedby="inputGroup-sizing-default" value="999999"
                                               placeholder="To">


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-center col-12">
                        <button class="btn btn-search" type="submit">
                            <i class="fa fa-search" aria-hidden="true"></i> Search
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<%--<h1>You are:  <% out.print(session.getAttribute("role") + " ");--%>
<%--out.print(session.getAttribute("email"));%></h1>--%>


<div class="container cars-home pt-1">
    <div class="row mt-5">
        <c:forEach var="ad" items="${adList}" begin="0" end="3">

            <div class="col-md-4 col-6 car-view">
                <form action="/car" id="${ad.id}">
                    <a href="javascript:{}" onclick="document.getElementById('${ad.id}').submit(); return false;">
                        <input type="hidden" name="ad_id" value="${ad.id}">
                        <div class="img-crop " style="height: 200px; text-align: center">
                            <img src="data:image/jpg;base64,${ad.car.photo1out}" alt="" class="car-img img-fluid"
                                 style=" max-height: 100%;">
                        </div>
                        <ul class="unstyle">
                            <li style="width: 300px; overflow: hidden">
                                <span class="carTitle-home"
                                      style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden"> ${ad.title} </span>
                            </li>
                            <li>
                                <span class="carPrice-home"><b>${ad.price} $</b></span>
                            </li>
                        </ul>
                    </a>
                </form>
            </div>

        </c:forEach>


    </div>

</div>


<div class="container searchByCat mt-3 mb-5">
    <h3>Search by category</h3>
    <div class="container-fluid">
        <hr id="searchByCatLine">
        <div class="row">
            <div class="offset-1 col-2 carCatIconHome ">
                <form action="/search" id="cat1search">
                    <a href="javascript:{}" onclick="document.getElementById('cat1search').submit(); return false;">
                        <input type="hidden" name="category" value="sedan">
                        <input type="hidden" name="brand" value="">
                        <input type="hidden" name="model" value="">
                        <input type="hidden" name="yearFrom" value="-1">
                        <input type="hidden" name="yearTo" value="-1">
                        <input type="hidden" name="priceFrom" value="-1">
                        <input type="hidden" name="priceTo" value="-1">
                        <div class="img-crop ">
                            <img src="../../../static/img/CarCatSed.JPG" alt="" class="car-img img-fluid">
                        </div>
                        <div class="carCatTitle-div">
                            <span class="carCatTitle-home"> Sedan </span>
                        </div>
                    </a>
                </form>
            </div>
            <div class="col-2 carCatIconHome">
                <form action="/search" id="cat2search">
                    <a href="javascript:{}" onclick="document.getElementById('cat2search').submit(); return false;">
                        <input type="hidden" name="category" value="SUV">
                        <input type="hidden" name="brand" value="">
                        <input type="hidden" name="model" value="">
                        <input type="hidden" name="yearFrom" value="-1">
                        <input type="hidden" name="yearTo" value="-1">
                        <input type="hidden" name="priceFrom" value="-1">
                        <input type="hidden" name="priceTo" value="-1">
                        <div class="img-crop ">
                            <img src="../../../static/img/CarCatSUV.JPG" alt="" class="car-img img-fluid">
                        </div>
                        <div class="carCatTitle-div">
                            <span class="carCatTitle-home"> SUV </span>
                        </div>
                    </a>
                </form>
            </div>
            <div class="col-2 carCatIconHome">
                <form action="/search" id="cat3search">
                    <a href="javascript:{}" onclick="document.getElementById('cat3search').submit(); return false;">
                        <input type="hidden" name="category" value="Minivan">
                        <input type="hidden" name="brand" value="">
                        <input type="hidden" name="model" value="">
                        <input type="hidden" name="yearFrom" value="-1">
                        <input type="hidden" name="yearTo" value="-1">
                        <input type="hidden" name="priceFrom" value="-1">
                        <input type="hidden" name="priceTo" value="-1">
                        <div class="img-crop ">
                            <img src="../../../static/img/CarCatMinivan.JPG" alt="" class="car-img img-fluid">
                        </div>
                        <div class="carCatTitle-div">
                            <span class="carCatTitle-home"> Minivan </span>
                        </div>
                    </a>
                </form>
            </div>
            <div class="col-2 carCatIconHome">
                <form action="/search" id="cat4search">
                    <a href="javascript:{}" onclick="document.getElementById('cat4search').submit(); return false;">
                        <input type="hidden" name="category" value="Hatch Back">
                        <input type="hidden" name="brand" value="">
                        <input type="hidden" name="model" value="">
                        <input type="hidden" name="yearFrom" value="-1">
                        <input type="hidden" name="yearTo" value="-1">
                        <input type="hidden" name="priceFrom" value="-1">
                        <input type="hidden" name="priceTo" value="-1">
                        <div class="img-crop ">
                            <img src="../../../static/img/CarCatHatch.JPG" alt="" class="car-img img-fluid">
                        </div>
                        <div class="carCatTitle-div">
                            <span class="carCatTitle-home"> Hatch Back </span>
                        </div>
                    </a>
                </form>
            </div>
            <div class="col-2 carCatIconHome">
                <form action="/search" id="cat5search">
                    <a href="javascript:{}" onclick="document.getElementById('cat5search').submit(); return false;">
                        <input type="hidden" name="category" value="Sports Car">
                        <input type="hidden" name="brand" value="">
                        <input type="hidden" name="model" value="">
                        <input type="hidden" name="yearFrom" value="-1">
                        <input type="hidden" name="yearTo" value="-1">
                        <input type="hidden" name="priceFrom" value="-1">
                        <input type="hidden" name="priceTo" value="-1">
                        <div class="img-crop ">
                            <img src="../../../static/img/CarCatSport.JPG" alt="" class="car-img img-fluid">
                        </div>
                        <div class="carCatTitle-div">
                            <span class="carCatTitle-home"> Sports Car </span>
                        </div>
                    </a>
                </form>
            </div>
        </div>
    </div>
</div>

