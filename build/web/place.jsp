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
                                <h3 class="mb-0 font-weight-bold text-center">Etage Management</h3>

                            </div>
                        </div>

                        <div style="width: 900px; left: 120px; position: relative;background-color: white">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Reference</th>
                                        <th scope="col">Etat</th>
                                        <th scope="col">Id Section</th>
                                        <th scope="col">Garer</th>
                                        <th scope="col">Deparquer</th>
                                    </tr
                                </thead>
                                <tbody id="content">
                                </tbody>

                            </table>

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
        <script src="script/place.js"></script>
    </body>
</html>
