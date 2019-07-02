<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/26/2019
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container my-5">
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

<div class="container">
    <div class="row">
        <c:forEach var="ad" items="${adList}">
            <div class="col-12 mt-3">
                <form action="/car" id="${ad.id}">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <div class="row">
                        <a href="javascript:{}"
                           onclick="document.getElementById('${ad.id}').submit(); return false;">
                            <div  style="height: 200px; width: 350px; overflow: hidden">
                                <img src="data:image/jpg;base64,${ad.car.photo1out}" alt="" style="max-height: 100%" class="img-fluid">
                            </div>
                        </a>
                        <div class="col-lg-4">
                            <a href="javascript:{}"
                               onclick="document.getElementById('${ad.id}').submit(); return false;">
                                <span class="carSearchTitle"
                                      style="text-overflow: ellipsis; white-space: nowrap; overflow: hidden">${ad.title}title</span>
                                <br>
                            </a>
                            <span class="carSearchPrice"><b>${ad.price} $</b></span> <br>
                            <span> <i class="fa fa-map-marker" aria-hidden="true"></i> ${ad.user.city} </span> <br>
                            <br>
                            <div class="carSearchDesc">
                                <span>${ad.description}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 mt-5">
                        <hr class="searchCarLine">
                    </div>

                </form>
            </div>
        </c:forEach>

    </div>

</div>