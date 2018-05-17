<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca UFAB</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean-1.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <%-- NavBar --%>
    <div>
        <nav class="navbar navbar-dark navbar-expand-md navigation-clean" style="background-color:#7ab73d;color:rgb(255,255,255);">
            <div class="container"><a class="navbar-brand" href="#"><i class="fa fa-book"></i></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <p class="navbar-text">Biblioteca UFAB</p>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">${usuarioAuth.getNomeCompleto()} - ${usuarioAuth.getPerfil().getTipoPerfil().toString()}</a>
                            <div class="dropdown-menu justify-content-center align-content-center" role="menu">
                            <a class="dropdown-item text-capitalize justify-content-center align-items-center align-self-center" role="presentation" href="<c:url value='/logout'/>">Sair</a></div>
                        </li>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <%-- Fim NavBar --%>
    <div class="justify-content-center align-items-center align-content-center align-self-center" style="/*height:100vh;*/overflow-y:auto;">
        <div class="container-fluid d-flex justify-content-center container-form">
            <div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 d-inline-flex align-self-end box-app" data-aos="fade-down" data-aos-delay="250">
                <h1>Usuários -&nbsp;<i class="fa fa-users"></i></h1>
            </div>
        </div>
        <hr>
        <div class="container-fluid d-flex justify-content-center container-form">
            <div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 box-overlay-app" data-aos="fade-right" data-aos-delay="500" id="form-side">
                <form class="box-app">
                    <div class="form-group">
                        <h4 class="text-left">Papel:</h4><select class="form-control"><option value="" selected="">Administrador</option><option value="">Funcionário</option><option value="">Aluno</option></select></div>
                    <hr>
                    <div class="form-group">
                        <h4 class="text-left">Tipo de aluno:</h4><select class="form-control"><option value="">Graduação</option><option value="">Mestrado</option><option value="">Doutorado</option><option value="">Especialização</option></select></div>
                    <div class="form-group">
                        <h4 class="text-left">Matrícula:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10"></div>
                    <div class="form-group">
                        <h4 class="text-left">Nome da mãe:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10"></div>
                    <hr>
                    <hr>
                    <div class="form-group">
                        <h4 class="text-left">Usuário:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10"></div>
                    <hr>
                    <div class="form-group">
                        <h4 class="text-left">CPF:</h4><input class="form-control form-control" type="text" required="" maxlength="11" minlength="11" autofocus=""></div>
                    <div class="form-group">
                        <h4 class="text-left">Nome:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10"></div>
                    <div class="form-group">
                        <h4 class="text-left">Senha:</h4><input class="form-control" type="password"></div>
                    <div class="form-group">
                        <h4 class="text-left">Data de nascimento:</h4><input class="form-control form-control" type="text" required="" placeholder="##/##/###" maxlength="10" minlength="10"></div>
                    <div class="form-group">
                        <h4 class="text-left">Endereço:</h4><input class="form-control form-control" type="text" required="" maxlength="100" minlength="10"></div>
                    <div class="form-group">
                        <h4 class="text-left">Telefone celular:</h4><input class="form-control form-control" type="text" required="" placeholder="(###) # ####-####" maxlength="15" minlength="14"></div>
                    <div class="form-group">
                        <h4 class="text-left">Naturalidade:</h4><input class="form-control form-control" type="text" required="" maxlength="50" minlength="10"></div>
                    <div class="form-group">
                        <h4 class="text-left">RG:</h4><input class="form-control form-control" type="text" required="" maxlength="50" minlength="10"></div>
                    <div class="form-row">
                        <div class="col"><button class="btn btn-success btn-block" type="button">Inserir</button></div>
                        <div class="col"><button class="btn btn-primary btn-block" type="button">Atualizar</button></div>
                    </div>
                </form>
            </div>
            <div class="col-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 box-overlay-app" data-aos="fade-down" data-aos-delay="250" id="table-side">
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-sm">
                        <thead>
                            <tr>
                                <th>CPF</th>
                                <th>Nome</th>
                                <th>Papel</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody class="justify-content-center align-items-center align-content-center">
                            <tr>
                                <td>117.765.994-54</td>
                                <td>Sérgio Davi</td>
                                <td>Adminstrador</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td>117.765.994-54</td>
                                <td>Sérgio Davi</td>
                                <td>Adminstrador</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td>117.765.994-54</td>
                                <td>Sérgio Davi</td>
                                <td>Adminstrador</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                            <tr>
                                <td>117.765.994-54</td>
                                <td>Sérgio Davi</td>
                                <td>Adminstrador</td>
                                <td class="d-inline float-left"><button class="btn btn-light btn-table" type="button"><i class="fa fa-edit"></i></button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>