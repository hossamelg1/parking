<%-- 
    Document   : home
    Created on : Dec 31, 2021, 11:43:01 PM
    Author     : houssamelg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ page import="services.ParkingService, services.SectionService, services.EtageService" %>
    <%
        ParkingService ps = new ParkingService();
        SectionService ss = new SectionService();
        EtageService es = new EtageService();
        int number = ps.getCount();
    %>
    <head>
        <script src="script/jquery-3.3.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js" integrity="sha512-TW5s0IT/IppJtu76UbysrBH9Hy/5X41OTAbQuffZFU6lQ1rdcLHzpU5BzVvr/YFykoiMYZVWlr/PX1mDcfM9Qg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Home</title>
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
                                <h3 class="mb-0 font-weight-bold text-center">Parking Management APP</h3>

                            </div>
                        </div>

                        <div class="row "id="cont">
                            
                        
                        <script src="script/home.js"></script>
                        <!-- main-panel ends -->
                    </div>
                        <jsp:include page="template/footer.jsp" />
                    <!-- page-body-wrapper ends -->
                </div>
            </div>
    </body>
</html>
