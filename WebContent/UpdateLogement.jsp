<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv= "Pragma" content= "No-cache" > <meta http-equiv= "Cache-control" content= "No-cache" 
, Must-revalidate "> 
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
          
            <h8 class="nav-link active" >Bienvenue</h8>
          </li>
       
          <li class="nav-item">
          
            <a class="nav-link active" href="home.jsp">Acceuil</a>
          </li>
          <li class="nav-item">
          
            <a class="nav-link active" href="home.jsp">Réservations </a>
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

<!--/ Property Single Star /-->
  <section class="property-single nav-arrow-b">
    <div class="container">
      <div class="row">
        
        <div class="col-md-12">
          <div class="row section-t3">
            <div class="col-sm-12">
              <div class="title-box-d">
                <h3 class="title-d"></h3>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 col-lg-4">
             
              
              
            </div>
            <div class="col-md-6 col-lg-4">
              <div class="property-agent">
                <p class="color-text-a">
                    <form class="form-a contactForm" action='${pageContext.request.contextPath}/UpdateLogement'  method ="post" >
                   <td>  <input type=hidden name ="id" value="${prop.id_proprietaire}"/></td>
                   <td>  <input type=hidden name ="id_logement" value="${logement.id_logement}"/></td>
                	<!--  <input type="file" name="photo" value="${prop.profile_image}"/>-->
               		<div class="form-group">
                    <h5>Titre du logement :</h5>
                      <input name="titre_logement" type="text"  value="${logement.titre_logement}" class="form-control form-control-lg form-control-a">
                    </div>
                </p>
             <p class="color-text-a">
                  <div class="form-group">
                    <h5>Description :</h5>
                      <input name="description" type="text"  value="${logement.description}" class="form-control form-control-lg form-control-a" >
                    </div>
                </p>
               <p class="color-text-a">
                  <div class="form-group">
                    <h5>Nombre de pièces :</h5>
                      <input name="nombre_pieces" type="text" value="${logement.nombre_pieces}"  class="form-control form-control-lg form-control-a" >
                    </div>
                </p>
                  <p class="color-text-a">
                  <div class="form-group">
                    <h5>Pays : </h5>
                      <input name="pays" type="text"  value="${logement.pays}" class="form-control form-control-lg form-control-a" >
                    </div>
                </p>
                <p class="color-text-a">
                  <div class="form-group">
                    <h5>Ville : </h5>
                      <input name="ville" value="${logement.ville}" class="form-control form-control-lg form-control-a">
                    </div>
                </p>
                 <p class="color-text-a">
                  <div class="form-group">
                    <h5>Rue : </h5>
                      <input name="rue" value="${logement.rue}" class="form-control form-control-lg form-control-a">
                    </div>
                </p>            
              </div>
            </div>
            <div class="col-md-12 col-lg-4">
              <div class="property-contact">
              
                  <div class="row">
                    <div class="col-md-12 mb-1">
                    
                   <div class="form-group">
                   <h5>Disponible de :</h5>
                     <input name="disponibilite_move_in" value="${logement.disponibilite_move_in}"   type="date" class="form-control form-control-lg form-control-a" >
                   </div>
                   <div class="form-group">
                   <h5>Jusqu'à :</h5>
                     <input name="disponibilite_move_out" value="${logement.disponibilite_move_out}"  type="date" class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
                   <div class="form-group">
                   <div class="col-md-12 mb-1">
                 <h5>Equipements : </h5>
                 
 		<div class="form-check">
 			<p class="font-weight-bold">  </p>
    
    		<input name="equipement" type="text"  value="${logement.myList}"  class="form-control form-control-lg form-control-a" >
 		</div> 
				</div>
				</div>
				<div class="col-md-12 mb-1">
                   <div class="form-group">
                    <h5>Régles : </h5>
                     <input name="regles" value="${logement.regles}" type="text"  class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
                 <div class="col-md-12 mb-1">
                   <div class="form-group">
                    <h5>Colocataires actuels : </h5>
                     <input name="nombres_coloc" value="${logement.colocataires_actuels}" type="text"  class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
            <div class="col-md-12 mb-1">
                   <div class="form-group">
                   <h5> Nombre de chambres : </h5>
                     <input name="nombre_chambre" value="${logement.nombre_chambre}" type="text"  class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
            <div class="col-md-12 mb-1">
                   <div class="form-group">
                    <h5>Nombre de lits : </h5>
                     <input name="nombre_lit" type="text" value="${logement.nombre_lit}"  class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
                    <div class="col-md-12 mb-1">
                   <div class="form-group">
                    <h5>Prix de location d'un mois :</h5>
                     <input name="prix" type="text" value="${logement.prix}" class="form-control form-control-lg form-control-a" >
                   </div>
                   </div>
                   
                    <div class="col-md-12">
                      <button type="submit" name="submit" class="btn btn-a">Mettre à jour </button>            
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>

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
