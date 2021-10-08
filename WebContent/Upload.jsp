
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.projet.beans.User"%>
<%@page import="org.projet.db.LoginDB"%>
<%@page import="org.projet.beans.Proprietaire"%>
<%@page import="org.projet.db.ProprietaireDB"%>
<!DOCTYPE html>
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

  <!-- =======================================================
    Theme Name: EstateAgency
    Theme URL: https://bootstrapmade.com/real-estate-agency-bootstrap-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>

<body>

  <div class="click-closed"></div>
  <!--/ Form Search Star /-->
  <div class="box-collapse">
    <div class="title-box-d">
      <h3 class="title-d">Search Property</h3>
    </div>
    <span class="close-box-collapse right-boxed ion-ios-close"></span>
    <div class="box-collapse-wrap form">
      <form class="form-a">
        <div class="row">
          <div class="col-md-12 mb-2">
            <div class="form-group">
              <label for="Type">Keyword</label>
              <input type="text" class="form-control form-control-lg form-control-a" placeholder="Keyword">
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="Type">Type</label>
              <select class="form-control form-control-lg form-control-a" id="Type">
                <option>All Type</option>
                <option>For Rent</option>
                <option>For Sale</option>
                <option>Open House</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="city">City</label>
              <select class="form-control form-control-lg form-control-a" id="city">
                <option>All City</option>
                <option>Alabama</option>
                <option>Arizona</option>
                <option>California</option>
                <option>Colorado</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="bedrooms">Bedrooms</label>
              <select class="form-control form-control-lg form-control-a" id="bedrooms">
                <option>Any</option>
                <option>01</option>
                <option>02</option>
                <option>03</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="garages">Garages</label>
              <select class="form-control form-control-lg form-control-a" id="garages">
                <option>Any</option>
                <option>01</option>
                <option>02</option>
                <option>03</option>
                <option>04</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="bathrooms">Bathrooms</label>
              <select class="form-control form-control-lg form-control-a" id="bathrooms">
                <option>Any</option>
                <option>01</option>
                <option>02</option>
                <option>03</option>
              </select>
            </div>
          </div>
          <div class="col-md-6 mb-2">
            <div class="form-group">
              <label for="price">Min Price</label>
              <select class="form-control form-control-lg form-control-a" id="price">
                <option>Unlimite</option>
                <option>$50,000</option>
                <option>$100,000</option>
                <option>$150,000</option>
                <option>$200,000</option>
              </select>
            </div>
          </div>
          <div class="col-md-12">
            <button type="submit" class="btn btn-b">Search Property</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <!--/ Form Search End /-->

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
          
            <a class="nav-link active" href="home_proprietaire.jsp">Bienvenue</a>
          </li>
          <li class="nav-item">
           <c:if test = "${user.statut == 'locataire'}" > 
            <a class="nav-link" href="${pageContext.request.contextPath}/ReservationServlet?action=ViewAllReservations&id=${user.id_user}">Réservations </a>
             </c:if>
          </li>
           <li class="nav-item">
           <c:if test = "${user.statut == 'proprietaire'}" > 
            <a class="nav-link" href="${pageContext.request.contextPath}/ReservationServlet?action=ViewAllReservationsProp&id=${user.id_user}">Réservations </a>
             </c:if>
          </li>
       <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
             Logements
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
             <c:if test = "${user.statut == 'locataire'}" > 
                   <a class="nav-link" href = "FindLogement.jsp">Chercher un logement</a>
                   <a class="nav-link" href = "FindProprietaire.jsp">Chercher un propriétaire</a>
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
              <c:if test = "${user.statut == 'proprietaire'}" > 
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=ViewProfile&id=${user.id_user}">Voir profile</a>
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=UpdateProfile&id=${user.id_user}">Mettre à jour</a>
            </div>
             </c:if>
             <c:if test = "${user.statut == 'locataire'}" > 
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/LocataireServlet?action=ViewProfile&id=${user.id_user}">Voir profile</a>
              <a class="dropdown-item" href = "${pageContext.request.contextPath}/LocataireServlet?action=UpdateProfile&id=${user.id_user}">Mettre à jour</a>
            	</div> 
              </c:if>
          </li>
          <li class="nav-item">
              <form action="Logout" method="post" >
         <button type="submit" class="btn btn-outline-danger" value="Logout"> Logout </button>
        </form>
          </li>
        
          
      </div>
      
    </div>
  </nav>
  <!--/ Nav End /-->

  <!--/ Carousel Star /-->
  <div class="intro intro-carousel">
    <div id="carousel" class="owl-carousel owl-theme">
      <div class="carousel-item-a intro-item bg-image" style="background-image: url(img/slide-1.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="carousel-item-a intro-item bg-image" style="background-image: url(img/slide-2.jpg)">
        <div class="overlay overlay-a"></div>
        <div class="intro-content display-table">
          <div class="table-cell">
            <div class="container">
              <div class="row">
                <div class="col-lg-8">
                  <div class="intro-body">
                  <!--    <h1 class="intro-title mb-4">
                      <span class="color-b">203 </span> AGDAL
                      <br>Apparetement individuel</h1>
                    <p class="intro-subtitle intro-price">
                      <a href="#"><span class="price-a">A louer |4000 DH</span></a> -->
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    
    </div>
  </div>
  <!--/ Carousel end /-->

  <!--/ Services Star /-->
  <section class="section-services section-t8">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="title-wrap d-flex justify-content-between">
            <div class="title-box">
              <h2 class="title-a">Nos services</h2>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <div class="card-box-c foo">
            <div class="card-header-c d-flex">
              <div class="card-title-c align-self-center">
                <h2 class="title-c">Spécialisé en location,pas en vacances</h2>
              </div>
            </div>
            <div class="card-body-c">
              <p class="content-c">
                Les locataires restent généralement des mois, pas des jours. Nous exigeons une vérification des locataires, soutenons les baux et les dépôts de garantie, et permettons aux locataires de trouver des colocataires pour les espaces à plusieurs lits
              </p>
            </div>
            <div class="card-footer-c">
              <a href="#" class="link-c link-icon">Lire plus
                <span class="ion-ios-arrow-forward"></span>
              </a>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card-box-c foo">
            <div class="card-header-c d-flex">
              <div class="card-title-c align-self-center">
                <h2 class="title-c">Au service d'une variété de locataires professionnels</h2>
              </div>
            </div>
            <div class="card-body-c">
              <p class="content-c">
                Les locataires déménagent pour de nouvelles opportunités de travail ou d'éducation. Cela comprend les stagiaires, les infirmières de voyage, les étudiants diplômés et doctorants, les nomades numériques et les personnes qui déménagent dans une nouvelle ville.
              </p>
            </div>
            <div class="card-footer-c">
              <a href="#" class="link-c link-icon">Lire plus
                <span class="ion-ios-arrow-forward"></span>
              </a>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card-box-c foo">
            <div class="card-header-c d-flex">
              <div class="card-title-c align-self-center">
                <h2 class="title-c">Demandes de location obligatoires pour tous les locataires</h2>
              </div>
            </div>
            <div class="card-body-c">
              <p class="content-c">
                Avant qu'un locataire puisse vous envoyer un message ou vous demander de louer , il doit remplir une demande de location.
              </p>
            </div>
            <div class="card-footer-c">
              <a href="#" class="link-c link-icon">Lire plus
                <span class="ion-ios-arrow-forward"></span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--/ Services End /-->

 

  <!--/ footer Star /-->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="copyright-footer">
            
          </div>
          
        </div>
      </div>
    </div>
  </footer>
  <!--/ Footer End /-->

  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
  <div id="preloader"></div>

  <!-- JavaScript Libraries -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/popper/popper.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="lib/scrollreveal/scrollreveal.min.js"></script>
  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Main Javascript File -->
  <script src="js/main.js"></script>

</body>
</html>
