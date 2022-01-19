<%-- 
    Document   : section
    Created on : Jan 2, 2022, 5:54:47 PM
    Author     : houssamelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="services.ParkingService, services.SectionService, services.EtageService, entities.Parking" %>
<%
    ParkingService ps = new ParkingService();
    SectionService ss = new SectionService();
    EtageService es = new EtageService();
%>
<html>
    <head>
        <script src="script/jquery-3.3.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Etage mangagement</title>
        <!-- base:css -->
        <link rel="stylesheet" href="asst/vendors/typicons.font/font/typicons.css">
        <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
        <!-- endinject --> 
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="asset/css/vertical-layout-light/style.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="asset/images/favicon.png" />

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
                                <h3 class="mb-0 font-weight-bold text-center">Section Management</h3>

                            </div>
                        </div>

                        <div style="width: 900px; left: 120px; position: relative;background-color: white">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Reference</th>
                                        <th scope="col">Etage</th>
                                        <th scope="col">Supprimer</th>
                                        <th scope="col">Generer les places</th>
                                    </tr
                                </thead>
                                <tbody id="content">
                                </tbody>

                            </table>

                        </div>
                        <div>
                            <div style ="top: 20px; position: relative; left: 500px">
                                <button class="btn btn-primary" id="toggle">Ajouter Section</button>
                            </div>
                            <div id="addition" style="position: relative;left: 400px; top:50px ">
                                <div class="row">
                                    <div class="col-xl-4 d-flex grid-margin stretch-card"  >
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="d-flex flex-wrap justify-content-between ml-5">
                                                    <h4 class="card-title mb-3 ml-2">Rempir ces information</h4>
                                                </div>
                                                <div class="row">
                                                    <div class="col-12 mt-4" style="top: 25px">
                                                        <div class="row" >
                                                            <div class="col-sm-12">
                                                                <div class="d-flex justify-content-between mb-4">
                                                                    <label> parking </label>
                                                                    <select name="cars" id="options" style="margin-right: 20px; width: 180px; text-align: center">
                                                                        <option disabled selected value> parking  </option>
                                                                        <%for (Parking park : ps.findAll()) {%>
                                                                        <option value="<%=park.getName()%>"><%=park.getName()%></option>
                                                                        <%}%>
                                                                    </select>
                                                                </div>
                                                                <div class="d-flex justify-content-between mb-4">
                                                                    <label>     Etage:  </label>
                                                                    <select name="cars" id="etageOption" style=";position: relative;left: 70px; width: 180px; text-align: center">
                                                                        <option disabled selected value>  Etage </option>
                                                                    </select>
                                                                    <div style=" margin-right: 100px" id="et"></div>
                                                                </div>
                                                                    <div class="d-flex justify-content-between mb-4">
                                                                    <label> Section:  </label>
                                                                    <select name="cars" id="SectionOption" style="position: relative;left: 70px ;width: 180px; text-align: center">
                                                                        <option disabled selected value> Section </option>
                                                                    </select>
                                                                    <div style=" margin-right: 100px" id="et"></div>
                                                                </div>
                                                                <div class="d-flex justify-content-between mb-4" style="position: relative ;top:15px !important; left: 80px">
                                                                    <button class="btn btn-primary" id="add" style="position: relative; left: 30px">Ajouter</button>
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
        <script src="script/section.js"></script>
    </body>
</html>
