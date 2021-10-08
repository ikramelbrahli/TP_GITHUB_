<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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
          <li class="nav-item">
                  <form action="Logout" method="post" >
         <button type="submit" class="btn btn-outline-danger" name="logout" value="logout"> Logout </button>
        </form>
          </li>
        
          
      </div>
      
    </div>
  </nav>
  <!--/ Nav End /-->
    <form action='${pageContext.request.contextPath}/FindProprietaire'  method ="post" >
      
                    
 <div class="col-md-12 section-t8">
          <div class="title-box-d">
            <h3 class="title-d">Trouvez un colocataire potentiel compatible avec vous !</h3>
           
           

    <div class="form-row">
     <div class="col-xs-3">
     <h5>Age :</h5>
      <input type="text" name="age" class="form-control" placeholder="Age">
    </div>
     <div class="col-xs-3">
     <h5>Sexe :</h5>
       <select name="sexe" class="custom-select">
 					 <option selected  value="Sexe">Sexe</option>
  					 <option  value="Homme">Homme</option>
  					 <option  value="Femme">Femme</option>
				</select>
    </div>
    </div>
    <div class="form-row">
     <div class="col-xs-3">
     <h5>Budget :</h5>
      <input type="text" name="budget" class="form-control" placeholder="Budget">
    </div>
      
 
  
	<div class="col-xs-3">
	<h5>Organisation :</h5>
         <select name="organisation" class="custom-select">
 					 <option selected  value="Organisation">Organisation</option>
  					 <option  value="Jamais">Jamais</option>
  					 <option  value="Parfois">Parfois</option>
  					 <option  value="Regulierement">Régulièrement</option>
		</select>
	</div>
	</div>
	<div class="form-row">
		<div class="col-xs-3">
		<h5>Nettoyage :</h5>
         <select name="nettoyage" class="custom-select">
 					 <option selected  value="Nettoyage">Nettoyage</option>
  					 <option  value="Jamais">Jamais</option>
  					 <option  value="Parfois">Parfois</option>
  					 <option  value="Regulierement">Régulièrement</option>
		</select>
	</div>
	<div class="col-xs-3">
	<h5>Fumer :</h5>
         <select name="fumer" class="custom-select">
 					 <option selected  value="Fumer">Fumer</option>
  					 <option  value="Jamais">Jamais</option>
  					 <option  value="Parfois">Parfois</option>
  					 <option  value="Regulierement">Régulièrement</option>
		</select>
	</div> 
	</div>
	<div class="col">
    <button type="submit" name="submit" class="btn btn-outline-primary" > Search </button>
    </div>

</form>            
          </div>
        </div>
        
        
        
        <div class="row property-grid grid">
       
<c:forEach var="proprietaire" items="${listProprietaire}" >
          <div class="col-md-4">
            <div class="card-box-a card-shadow">
              <div class="img-box-a">
                <img src="img/avatar.PNG" width="500" height="121" alt="" class="img-a img-fluid">
              </div>
              <div class="card-overlay">
                <div class="card-overlay-a-content">
                  <div class="card-header-a">
                    <h2 class="card-title-a">
                    <a href="#"><c:out value="${proprietaire.nom}" /> <c:out value="${proprietaire.prenom}" /> 
                   
                  </div>
                  <div class="card-body-a">
                    <div class="price-box d-flex">
                      <span class="price-a"> <c:out value="${proprietaire.age}" /> ans</span>
                    </div>
                    <a href="${pageContext.request.contextPath}/LocataireServlet?action=ViewProfile&id=${proprietaire.id_user}" class="link-a">Click here to view
                      <span class="ion-ios-arrow-forward"></span>
                    </a>
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
              </c:forEach>
          </div>
             
                    
</body>
</html>
