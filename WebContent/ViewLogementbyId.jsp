<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
  <head>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <title>EstateAgency Bootstrap Template</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
                   <a class="nav-link active" href = "FindLogement.jsp">Chercher un colocataire</a>
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
            <h1 class="title-single">${logement.titre_logement}</h1>
            
          </div>
        </div>
       
      </div>
    </div>
  </section>
  <!--/ Intro Single End /-->

  <!--/ Property Single Star /-->
  <section class="property-single nav-arrow-b">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
           <div id="property-single-carousel" class="owl-carousel owl-arrow gallery-property">
            <div class="carousel-item-b">
              <img src="img/slide-2.jpg" alt="">
            </div>
            <div class="carousel-item-b">
              <img src="img/slide-3.jpg" alt="">
            </div>
            <div class="carousel-item-b">
              <img src="img/slide-1.jpg" alt="">
            </div>
          </div>
          <div class="row justify-content-between">
            <div class="col-md-5 col-lg-4">
              <div class="property-price d-flex justify-content-center foo">
                <div class="card-header-c d-flex">
                  
                  <div class="card-title-c align-self-center">
                    <h5 class="title-c">Prix : ${logement.prix}  MAD / mois</h5>
                  </div>
                </div>
              </div>
              <div class="property-summary">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="title-box-d section-t4">
                      <h3 class="title-d">${logement.titre_logement}</h3>
                    </div>
                  </div>
                </div>
                <div class="summary-list">
                  <ul class="list">
                   
                    <li class="d-flex justify-content-between">
                      <strong>Adresse:</strong>
                      <span>${logement.pays} </span>
                      <span>${logement.ville} </span>
                      <span>${logement.rue} </span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>Disponible du :</strong>
                      <span>${logement.disponibilite_move_in}</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>Jusqu'à :</strong>
                      <span>${logement.disponibilite_move_out}</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>Chambres:</strong>
                      <span>${logement.nombre_chambre}</span>
                    </li>
					 <li class="d-flex justify-content-between">
                      <strong>Nombre de pièces :</strong>
                      <span>${logement.nombre_pieces}</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>Lits:</strong>
                      <span>${logement.nombre_lit}</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>Colocataires actuels:</strong>
                      <span>${logement.colocataires_actuels}</span>
                    </li>
                      <li class="d-flex justify-content-between">
                      <strong>Règles :</strong>
                      <span>${logement.regles}</span>
                    </li>
                    
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-md-7 col-lg-7 section-md-t3">
              <div class="row">
                <div class="col-sm-12">
                  <div class="title-box-d">
                    <h3 class="title-d">Description</h3>
                  </div>
                </div>
              </div>
              <div class="property-description">
                <p class="description color-text-a">
                  
                  ${logement.description}
                  
                  </p>
              
              </div>
              <div class="row section-t3">
                <div class="col-sm-12">
                  <div class="title-box-d">
                    <h3 class="title-d">Equipements</h3>
                  </div>
                </div>
              </div>
              <div class="amenities-list color-text-a">

                <br> ${logement.myList} </br>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-12">
          <div class="row section-t3">
            <div class="col-sm-12">
              <div class="title-box-d">
                <h3 class="title-d">Propriétaire :</h3>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 col-lg-4">
              <img src="img/avatar.PNG" alt="" class="img-fluid">
            </div>
            <div class="col-md-6 col-lg-4">
              <div class="property-agent">
                <h4 class="title-agent"> ${logement.nom} ${logement.prenom} </h4>
                <ul class="list-unstyled">
                  <li class="d-flex justify-content-between">
                    <strong>Phone:</strong>
                    <span class="color-text-a">${logement.GSM}</span>
                  </li>
                  
                  <li class="d-flex justify-content-between">
                    <strong>Email:</strong>
                    <span class="color-text-a">${logement.email}</span>
                  </li>
                 
                </ul>
               

                  </ul>
                    <c:if test="${user.statut== 'proprietaire' }">
                   <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=UpdateLogement&id=${user.id_user}">Mettre à jour cette annonce</a> 
                   <a class="dropdown-item" href = "${pageContext.request.contextPath}/LogementServlet?action=deleteLogement&id=${logement.id_logement}&id_proprietaire=${logement.id_proprietaire}">Supprimer cette annonce</a>
					</c:if>    
					 <c:if test="${user.statut== 'locataire' }">     
					 <a class="dropdown-item" href = "${pageContext.request.contextPath}/ProprietaireServlet?action=ViewProfile&id=${logement.id_user}">Voir profile</a>      
                </c:if>  
                </div>
              </div>
            </div>
           
          </div>
        </div>
      </div>
    </div>
  
<div class="container">
    <div class="row">
        <div class="col-8">
        <div class="title-box-d">
                <h3 class="title-d">Les avis  :</h3>
              </div>
              <c:forEach var="rate" items="${listRate}" >
            <div class="card card-white post">
                <div class="post-heading">
                    <div class="float-left image">
                        <p>
                    </div>
                    <div class="float-left meta">
                        <div class="title h5">
                            <a href="#"><b>${rate.prenom} ${rate.nom}</b></a>
                            a donné un avis .
                        </div>${rate.date_publication}
                       
                    
                    </div>
                </div> 
                <div class="post-description"> 
                
                    <p>${rate.comment}</p>
					    <h5>Rating :</h5>
                     <span class="star-rating star-5">
				<c:set var = "i" scope = "session" value = "${rate.rate}"/>
				      <c:if test = "${i == 1}">
				
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                  	   </c:if>
                  	    <c:if test = "${i == 2}">
				
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked ><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                  	   </c:if>
                  	    <c:if test = "${i == 3}">
				
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" ><i></i>
                     <input type="radio" name="rating" ><i></i>
                  	   </c:if>
                  	    <c:if test = "${i == 4}">
				
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked ><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" ><i></i>
                  	   </c:if>
                  	    <c:if test = "${i == 5}">
				
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                     <input type="radio" name="rating" checked><i></i>
                  	   </c:if>
                    </span>
                </div>
                
            </div>
            </c:forEach>
        </div>
        
    </div>
</div>



  </section>
  <!--/ Property Single End /-->
  

  
 
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
  
  <style>
  .card-white  .card-heading {
  color: #333;
  background-color: #fff;
  border-color: #ddd;
   border: 1px solid #dddddd;
}
.card-white  .card-footer {
  background-color: #fff;
  border-color: #ddd;
}
.card-white .h5 {
    font-size:14px;
    //font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}
.card-white .time {
    font-size:12px;
    //font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}
.post .post-heading {
  height: 95px;
  padding: 20px 15px;
}
.post .post-heading .avatar {
  width: 60px;
  height: 60px;
  display: block;
  margin-right: 15px;
}
.post .post-heading .meta .title {
  margin-bottom: 0;
}
.post .post-heading .meta .title a {
  color: black;
}
.post .post-heading .meta .title a:hover {
  color: #aaaaaa;
}
.post .post-heading .meta .time {
  margin-top: 8px;
  color: #999;
}
.post .post-image .image {
  width: 100%;
  height: auto;
}
.post .post-description {
  padding: 15px;
}
.post .post-description p {
  font-size: 14px;
}
.post .post-description .stats {
  margin-top: 20px;
}
.post .post-description .stats .stat-item {
  display: inline-block;
  margin-right: 15px;
}
.post .post-description .stats .stat-item .icon {
  margin-right: 8px;
}
.post .post-footer {
  border-top: 1px solid #ddd;
  padding: 15px;
}
.post .post-footer .input-group-addon a {
  color: #454545;
}
.post .post-footer .comments-list {
  padding: 0;
  margin-top: 20px;
  list-style-type: none;
}
.post .post-footer .comments-list .comment {
  display: block;
  width: 100%;
  margin: 20px 0;
}
.post .post-footer .comments-list .comment .avatar {
  width: 35px;
  height: 35px;
}
.post .post-footer .comments-list .comment .comment-heading {
  display: block;
  width: 100%;
}
.post .post-footer .comments-list .comment .comment-heading .user {
  font-size: 14px;
  font-weight: bold;
  display: inline;
  margin-top: 0;
  margin-right: 10px;
}
.post .post-footer .comments-list .comment .comment-heading .time {
  font-size: 12px;
  color: #aaa;
  margin-top: 0;
  display: inline;
}
.post .post-footer .comments-list .comment .comment-body {
  margin-left: 50px;
}
.post .post-footer .comments-list .comment > .comments-list {
  margin-left: 50px;
}
  </style>
  <style>
	.star-rating {
  font-size: 0;
  white-space: nowrap;
  display: inline-block;
  /* width: 250px; remove this */
  height: 50px;
  overflow: hidden;
  position: relative;
  background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjREREREREIiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
  background-size: contain;
}
.star-rating i {
  opacity: 0;
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  /* width: 20%; remove this */
  z-index: 1;
  background: url('data:image/svg+xml;base64,PHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMjBweCIgaGVpZ2h0PSIyMHB4IiB2aWV3Qm94PSIwIDAgMjAgMjAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDIwIDIwIiB4bWw6c3BhY2U9InByZXNlcnZlIj48cG9seWdvbiBmaWxsPSIjRkZERjg4IiBwb2ludHM9IjEwLDAgMTMuMDksNi41ODMgMjAsNy42MzkgMTUsMTIuNzY0IDE2LjE4LDIwIDEwLDE2LjU4MyAzLjgyLDIwIDUsMTIuNzY0IDAsNy42MzkgNi45MSw2LjU4MyAiLz48L3N2Zz4=');
  background-size: contain;
}
.star-rating input {
  -moz-appearance: none;
  -webkit-appearance: none;
  opacity: 0;
  display: inline-block;
  /* width: 20%; remove this */
  height: 100%;
  margin: 0;
  padding: 0;
  z-index: 2;
  position: relative;
}
.star-rating input:hover + i,
.star-rating input:checked + i {
  opacity: 1;
}
.star-rating i ~ i {
  width: 40%;
}
.star-rating i ~ i ~ i {
  width: 60%;
}
.star-rating i ~ i ~ i ~ i {
  width: 80%;
}
.star-rating i ~ i ~ i ~ i ~ i {
  width: 100%;
}
::after,
::before {
  height: 100%;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  text-align: center;
  vertical-align: middle;
}

.star-rating.star-5 {width: 250px;}
.star-rating.star-5 input,
.star-rating.star-5 i {width: 20%;}
.star-rating.star-5 i ~ i {width: 40%;}
.star-rating.star-5 i ~ i ~ i {width: 60%;}
.star-rating.star-5 i ~ i ~ i ~ i {width: 80%;}
.star-rating.star-5 i ~ i ~ i ~ i ~i {width: 100%;}

.star-rating.star-3 {width: 150px;}
.star-rating.star-3 input,
.star-rating.star-3 i {width: 33.33%;}
.star-rating.star-3 i ~ i {width: 66.66%;}
.star-rating.star-3 i ~ i ~ i {width: 100%;}
	
	</style>

</body>
</html>