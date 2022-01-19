<%-- 
    Document   : parking
    Created on : Jan 1, 2022, 11:16:05 AM
    Author     : houssamelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="asst/vendors/typicons.font/font/typicons.css">
        <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="asset/css/vertical-layout-light/style.css">
        <link rel="shortcut icon" href="asset/images/favicon.png" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <jsp:include page="template/header.jsp" /> 
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_settings-panel.html -->

                <!-- partial -->
                <!-- partial:partials/_sidebar.html -->
                <jsp:include page="template/sideBar.jsp" /> 
                <!-- partial -->
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-sm-12 p-3">
                                <h3 class="mb-0 font-weight-bold text-center">Parking Management</h3>

                            </div>
                        </div>

                        <div style="width: 900px; left: 120px; position: relative;background-color: white">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Quartier</th>
                                        <th scope="col">Supprimer</th>
                                        <th scope="col">Modifier</th>
                                    </tr
                                </thead>
                                <tbody id="content">
                                </tbody>

                            </table>

                        </div>
                        <div>
                            <div style ="top: 20px; position: relative; left: 500px">
                                <button class="btn btn-primary" id="toggle">Ajouter un Parking</button>
                            </div>
                            <div id="addition" style="position: relative;left: 400px; top:50px ">
                                <div class="row">
                                    <div class="col-xl-4 d-flex grid-margin stretch-card"  >
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="d-flex flex-wrap justify-content-between ml-5">
                                                    <h4 class="card-title mb-3 ml-2">Remplir ces Information </h4>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 mt-4" style="top: 25px">
                                                        <div class="row" >
                                                            <div class="col-sm-12">
                                                                <div class="d-flex justify-content-between mb-4">
                                                                    <label> Nom    :   </label>
                                                                    <input type="text" id="name" style="margin-left:20px"><br/>
                                                                </div>
                                                                <div class="d-flex justify-content-between mb-4">
                                                                    <label> Quartier : </label>
                                                                    <input type="text" id="quartier"><br/>
                                                                </div>
                                                                <div class="d-flex justify-content-between mb-4" style="position: relative ;top:15px !important; left: 80px">
                                                                    <button class="btn btn-primary" id="add" style="position: relative; left: 30px">Ajouter</button>
                                                                </div>
                                                                <div class="d-flex justify-content-between mb-4" style="position: relative ;top:15px !important; left: 80px">
                                                                    <button class="btn btn-primary" id="hiddenButton" style="position: relative; left: 30px">Modifier</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- content-wrapper ends -->
                        <!-- partial:partials/_footer.html -->
                        <jsp:include page="template/footer.jsp" />
                        <!-- partial -->
                    </div>
                    <!-- main-panel ends -->
                </div>
                <!-- page-body-wrapper ends -->
            </div>
        </div>
        <script src="script/parking.js"></script>
    </body>
</html>
