<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv=" Expires "content=" Wed, Num FEB 1997 08:21:57 GMT ">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>LocationAgency</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">
  
  
  
  
  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="css/style.css" rel="stylesheet">
  <style>
  .card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}
  </style>

  <!-- =======================================================
    Theme Name: EstateAgency
    Theme URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>



  <!--/ Nav Star /-->
   <!--/ Nav Star /-->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container">
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <a class="navbar-brand text-brand" href="index.html">Location<span class="color-b">Agency</span></a>
      <button type="button" class="btn btn-link nav-search navbar-toggle-box-collapse d-md-none" data-toggle="collapse"
        data-target="#navbarTogglerDemo01" aria-expanded="false">
        <span class="fa fa-search" aria-hidden="true"></span>
      </button>
      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
       <ul class="navbar-nav">
        
        <li class="nav-item">
          
            <h8 class="nav-link active" >Bienvenue </h8>
          </li>
                 
          <li class="nav-item">
          
            <a class="nav-link active" href="home_proprietaire.jsp">Acceuil</a>
          </li>
       <li class="nav-item">
           <c:if test = "${user.statut == 'locataire'}" > 
            <a class="nav-link active" href="${pageContext.request.contextPath}/ReservationServlet?action=ViewAllReservations&id=${user.id_user}">Réservations </a>
             </c:if>
          </li>
           <li class="nav-item">
           <c:if test = "${user.statut == 'proprietaire'}" > 
            <a class="nav-link active" href="${pageContext.request.contextPath}/ReservationServlet?action=ViewAllReservationsProp&id=${user.id_user}">Réservations </a>
             </c:if>
          </li>
       <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
             Logements
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <c:if test = "${user.statut == 'locataire'}" > 
                   <a class="nav-link active" href = "FindLogement.jsp">Chercher un logement</a>
                   <a class="nav-link active" href = "FindProprietaire.jsp">Chercher un colocataire</a>
               </c:if>
                <c:if test = "${user.statut == 'proprietaire'}" > 
               <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=AddLogement&id=${user.id_user}">Publier une annonce</a> 
             
               <a class="dropdown-item" href = "${pageContext.request.contextPath}/LogementServlet?action=ViewAllLogement&id=${prop.id_proprietaire}">Vos logements</a>
           		</c:if>	
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
              Profile
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=ViewProfile&id=${user.id_user}">Voir profile</a>
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=UpdateProfile&id=${user.id_user}">Mettre à jour</a>
            </div>
          </li>
     <form action="Logout" method="post" >
         <button type="submit" class="btn btn-outline-danger" name="logout" value="logout"> Logout </button>
        </form>
          </li>
        
          
      </div>
      
    </div>
  </nav>
  <!--/ Nav End /-->
    <!--/ Intro Single star /-->
  <section class="intro-single">
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-lg-8">
          <div class="title-single-box">
            <h1 class="title-single">${prop.prenom} ${prop.nom}</h1>
            <span class="color-text-a">${user.statut}</span>
          </div>
        </div>
        
      </div>
    </div>
  </section>
  <!--/ Intro Single End /-->
  <!--/ Agent Single Star /-->
  <section class="agent-single">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <div class="row">
            <div class="col-md-6">
              <div class="agent-avatar-box">
                <img src="img/avatar.PNG" alt="" class="agent-avatar img-fluid">
               
              </div>
            </div>
            <div class="col-md-5 section-md-t3">
              <div class="agent-info-box">
                <div class="agent-title">
                  <div class="title-box-d">
                    <h3 class="title-d">${prop.prenom}
                      <br> ${prop.nom}</h3>
                  </div>
                </div>
                <div class="agent-content mb-3">
                  <p class="content-d color-text-a">
                   ${prop.description}
              
                  </p>
                  <div class="info-agents color-a">
                     <p>
                      <strong>Temps de réponse: </strong>
                      <span class="color-text-a"> ${prop.temps_de_reponse}</span>
                    </p> 
                    <p>
                      <strong>GSM: </strong>
                      <span class="color-text-a"> ${prop.GSM}</span>
                    </p>
                    <p>
                      <strong>Age: </strong>
                      <span class="color-text-a"> ${prop.age}</span>
                    </p>
                    <p>
                      <strong>Sexe: </strong>
                      <span class="color-text-a"> ${prop.sexe}</span>
                    </p>
                    <p>
                      <strong>Email: </strong>
                      <span class="color-text-a"> ${prop.email}</span>
                    </p>
                    <p>
                      <strong>Organisation:</strong>
                      <span class="color-text-a">${prop.organisation}</span>
                    </p>
                    <p>
                      <strong>Nettoyage:</strong>
                      <span class="color-text-a"> ${prop.nettoyage}</span>
                    </p>
                    <p>
                      <strong>Fumer: </strong>
                      <span class="color-text-a"> ${prop.fumer}</span>
                    </p>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
        </div>
        </div>
        </div>
       
        </section>