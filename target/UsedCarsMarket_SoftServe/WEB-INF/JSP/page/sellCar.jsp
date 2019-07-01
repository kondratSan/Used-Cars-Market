<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 6/27/2019
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container ">
    <div class="row" style="margin-bottom: 150px; margin-top: 70px">
        <div class="col-md-6 blank"></div>
        <div class="col-md-6 blank"></div>
        <form action="/sellCarSubmit" method="post" enctype="multipart/form-data">
            <div class="row sellCarBody shadow-lg">
                <div class="col-12 d-flex justify-content-center mt-3">
                    <h1 id="sellCarTitle">Add&nbsp;information about&nbsp;the&nbsp;car</h1>
                </div>
                <div class="col-12 d-flex justify-content-center errRegMessage">
                    <%=(request.getAttribute("message") == null) ? "" : request.getAttribute("message")%>
                </div>
                <div class="col-12 d-flex justify-content-center errRegMessage" style="margin-left: 30px; padding-right: 75px; margin-bottom: 0px;">
                    <input type="text" name="title" class="form-control" placeholder="Title"
                           style="font-size: 25px"  required>
                </div>
                <div class="col-md-6 sellCarLeftSide p-5">
                    <div class="row">
                        <div class="col-12 sellCarBigText">
                            <span>General Information</span>
                        </div>
                        <div class="col-6">
                            <div class="row">
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Category</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Brand</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Model</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Year</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Fuel</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Engine Volume</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Engine Power</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Transmission</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Car Drive</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Kilometrage</span>
                                </div>
                                <div class="col-12 sellCarLeftSideTitle">
                                    <span>Color</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="row">
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <select name="category" class="browser-default custom-select" required>
                                            <option value="" disabled selected>Category</option>
                                            <option value="Sedan">Sedan</option>
                                            <option value="SUV">SUV</option>
                                            <option value="Minivan">Minivan</option>
                                            <option value="Hatch Back">Hatch Back</option>
                                            <option value="Sports Car">Sports Car</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="text" name="brand" class="form-control" placeholder="Brand"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="text" name="model" class="form-control" placeholder="Model"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="number" name="year" class="form-control" placeholder="Year"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <select name="fuel" class="browser-default custom-select" required>
                                            <option value="" disabled selected>Fuel</option>
                                            <option value="Gasoline">Gasoline</option>
                                            <option value="Diesel">Diesel</option>
                                            <option value="Electric">Electric</option>
                                            <option value="Hybrid">Hybrid</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="number" step="0.1" name="volume" class="form-control"
                                               placeholder="Volume" required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="number" name="power" class="form-control" placeholder="Horse Power"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <select name="transmission" class="browser-default custom-select" required>
                                            <option value="" disabled selected>Transmission</option>
                                            <option value="Manual">Manual</option>
                                            <option value="Automatic">Automatic</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <select name="carDrive" class="browser-default custom-select" required>
                                            <option value="" disabled selected>Car Drive</option>
                                            <option value="Front-Wheel Drive">Front-Wheel Drive</option>
                                            <option value="Rear-Wheel Drive">Rear-Wheel Drive</option>
                                            <option value="All-Wheel Drive">All-Wheel Drive</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="number" name="kilometrage" class="form-control" placeholder="Km"
                                               required>
                                    </div>
                                </div>
                                <div class="col-12 sellCarLeftSideSelect">
                                    <div class="input-group form-group">
                                        <input type="text" name="color" class="form-control" placeholder="Color"
                                               required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 sellCarRightSide p-5">
                    <div class="sellCarBigText">
                        <span>Add Photos</span>
                    </div>
                    <div class="input-group img-input">
                        <input type="file" name="photo1" size="50" style="border: solid silver 1px;
                         border-top-right-radius: 5px;
                         border-bottom-right-radius: 5px;
                         width: 100%;"/>
                    </div>
                    <div class="input-group img-input">
                        <input type="file" name="photo2" size="50" style="border: solid silver 1px;
                         border-top-right-radius: 5px;
                         border-bottom-right-radius: 5px;
                         width: 100%;"/>
                    </div>
                    <div class="input-group img-input">
                        <input type="file" name="photo3" size="50" style="border: solid silver 1px;
                         border-top-right-radius: 5px;
                         border-bottom-right-radius: 5px;
                         width: 100%;"/>
                    </div>
                    <div class="sellCarBigText">
                        <span>Description</span>
                    </div>
                    <textarea class="form-control rounded-0 mb-4" name="description" id="description" rows="12" required></textarea>
                    <input type="number" name="price" class="form-control" placeholder="Price, $"
                           style="font-size: 25px; color: #3c9706 " required>
                </div>
                <div class="col-12 d-flex justify-content-center mb-4">
                    <input type="submit" value="Submit"
                           class="btn float-center carSellSubmitBtn">
                    <div class="errRegMessage">
                        <%=(request.getAttribute("message") == null) ? "" : request.getAttribute("message")%>
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>
