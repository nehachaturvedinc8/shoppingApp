<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url  var="css" value="/resources/css"/>
<spring:url  var="js" value="/resources/js"/>
<spring:url  var="images" value="/resources/images"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title} </title>

<script >
window.menu='${title}';
</script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
     <link href="${css}/bootstrap_superHero.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>
<div class="wrapper">
    <!-- Navigation -->
   <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <!-- Loading when user click Home -->
    <div class="content">
    <c:if test="${userClickHome==true}">
  <%@include file="home.jsp" %>
  </c:if>
   <!-- Loading when user click About -->
   <c:if test="${userClickAbout==true}">
  <%@include file="about.jsp" %>
  </c:if>
   <!-- Loading when user click Contact -->
   <c:if test="${userClickContact==true}">
  <%@include file="contact.jsp" %>
  </c:if>
  

  
  <!-- Loading when user click all products or single category products-->
   <c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
  <%@include file="listProducts.jsp" %>
  </c:if>
</div>
    <!-- Footer -->
    <div class="footer">
   <%@include file="./shared/footer.jsp" %>
</div>
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>

<!-- Self coded JS -->
    <script src="${js}/myapp.js"></script>
    
    </div>
  </body>

</html>
