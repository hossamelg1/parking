<%-- 
    Document   : statistics
    Created on : Jan 11, 2022, 5:25:57 PM
    Author     : houssamelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ page import="services.ParkingService, services.SectionService, services.EtageService, entities.Parking" %>
    <%
        ParkingService ps = new ParkingService();
        SectionService ss = new SectionService();
        EtageService es = new EtageService();
        int number = ps.getCount();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="script/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js" integrity="sha512-TW5s0IT/IppJtu76UbysrBH9Hy/5X41OTAbQuffZFU6lQ1rdcLHzpU5BzVvr/YFykoiMYZVWlr/PX1mDcfM9Qg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Statistics</title>
        <link rel="stylesheet" href="asst/vendors/typicons.font/font/typicons.css">
        <link rel="stylesheet" href="asset/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="asset/css/vertical-layout-light/style.css">
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
                                <h3 class="mb-0 font-weight-bold text-center">Parking Management Statistics</h3>

                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xl-4 d-flex grid-margin stretch-card"  >
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-wrap justify-content-between ml-5">
                                            <h4 class="card-title mb-3 ml-2">Parking Management</h4>
                                        </div>
                                        <div class="row">
                                            <div class="col-12 mt-4" style="top: 25px">
                                                <div class="row" >
                                                    <div class="col-sm-12">
                                                        <div class="d-flex justify-content-between mb-4">
                                                            <div class="text-secondary font-weight-medium">Nombre des parkings</div>
                                                            <div ><%=ps.getCount()%></div>
                                                        </div>
                                                        <div class="d-flex justify-content-between mb-4" style="position: relative ;top:15px !important; left: 80px">
                                                            <button class="btn btn-primary" id="pStats">Voir Stats</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 d-flex grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-wrap justify-content-between ml-5">
                                            <h4 class="card-title mb-3 ml-2">Etage Management</h4>
                                        </div>
                                        <div class="row">
                                            <div class="col-12 mt-4" style="top: 25px">
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="d-flex justify-content-between mb-4">
                                                            <div class="text-secondary font-weight-medium">Nombre des etages</div>
                                                            <div class=""><%=es.getCount()%></div>
                                                        </div>
                                                        <div class="d-flex justify-content-between mb-4" style="position: relative ;top:15px !important; left: 80px">
                                                            <button class="btn btn-primary" id='eStats' >Voir Stats</button>
                                                        </div>
                                                        <div id='for_etage'style="margin-top: 40px">
                                                            
                                                            <label class="text-secondary font-weight-medium "  > Choisir un Parking </label>
                                                            
                                                            <select name="cars" id="options" style="position: relative;left: 15px;">
                                                                 <option disabled selected value> parking  </option>
                                                                <%for (Parking park : ps.findAll()) {%>
                                                                <option value="<%=park.getName()%>"><%=park.getName()%></option>
                                                                <%}%>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4 d-flex grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-wrap justify-content-between ml-5">
                                            <h4 class="card-title mb-3 ml-2 ">Section Management</h4>
                                        </div>
                                        <div class="row">
                                            <div class="col-12 mt-4" style="top: 25px">
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="d-flex justify-content-between mb-4">
                                                            <div class="text-secondary font-weight-medium">Nombre des sections</div>
                                                            <div class=""><%=ss.getCount()%></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>                             
                        <div style="width:800px; height: 800px; position: relative; left: 180px" id="chart">
                            <canvas style="background-color:white;" id="myChart" ></canvas>
                        </div>

                    </div>
                    <jsp:include page="template/footer.jsp" />
                    <!-- main-panel ends -->
                </div>
            </div>
        </div>>
        <script src="script/statistic.js"></script>
        <script>

        </script>

    </body>
</html>
