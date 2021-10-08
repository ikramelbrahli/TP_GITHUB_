<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %> 
<%@page import="org.projet.beans.User ;" %> 

<% 
 
    if(request.getParameter("submit")!=null)
    {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        
        

        Connection con;
        PreparedStatement pst;
        PreparedStatement pstm;
        ResultSet rs;
        

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/location?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT","root","root");
        pst = con.prepareStatement("insert into user(nom,prenom,email,password,statut)values(?,?,?,?,'proprietaire')" , Statement.RETURN_GENERATED_KEYS );
        pst.setString(1, nom);
        pst.setString(2, prenom);
        pst.setString(3, email);
        pst.setString(4, mdp);
        pst.executeUpdate(); 
        ResultSet result = pst.getGeneratedKeys();

        if (result.next()) {
            long id = result.getLong(1);
            System.out.println("Inserted ID -" + id); // display inserted record
            pstm= con.prepareStatement("insert into proprietaire(id_user)values(?)") ;
            pstm.setLong(1,id);
            pstm.executeUpdate();
        }

%> 

    <script>   
        alert("Votre inscription est bien validée");     
    </script> 
    <%             
    }
   %>
    









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
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
  
  <style>
body {
  margin: 0;
  padding: 0;
  background-color: #2eca6a;
  height: 100vh;
}
#login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 600px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}

.text{
    color: black;
}

.submit{
    background:#2eca6a;
    border:#2eca6a;
    display:block;
    padding: 7px;
    margin: 20px;
    align: center;
}

</style>

</head>



<body>

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
            <a class="nav-link active" href="index.html">Acceuil</a>
          </li>
          
         <li class="nav-item">
            <a class="nav-link active" href="login.jsp">S'authentifier</a>
          </li>
        
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
              aria-haspopup="true" aria-expanded="false">
              S'inscrire
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="inscriptionPte.jsp">Propriétaire</a>
              <a class="dropdown-item" href="inscriptionLoca.jsp">Locataire</a>
            </div>
          </li>
        
        </ul>
      </div>
      
    </div>
  </nav>
  <!--/ Nav End /-->

  <!--/ inscription Star /-->
  <div id="login">
        <h3 class="text-center text-white pt-5"></h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="#" method="post">
                         <h3 class="text-center text">Inscrivez vous</h3>
                        
                            <div class="form-group">
                                <label for="username" class="text">Nom:</label><br>
                                <input type="text" name="nom" id="username" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text">Prénom:</label><br>
                                <input type="text" name="prenom" id="password" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text">Email:</label><br>
                                <input type="text" name="email" id="password" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text">Mot de passe:</label><br>
                                <input type="password" name="mdp" id="password" class="form-control" required>
                            </div>
                          
                                                    <div class="form-group">
                                <br>
                                <button type="submit" name="submit" class="btn btn-a">S'inscrire</button>    
                            </div>
                            <div id="register-link" class="text-right">
                                <br><!-- comment -->
                                
                                <a href="login.jsp" class="text-info"  align="center">S'authentifier</a>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  <!--/ inscription end /-->

  
 
  
  
  
  
  
  
  

 

  
  
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

