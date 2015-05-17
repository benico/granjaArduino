<%-- 
    Document   : index
    Created on : 17/05/2015, 15:50:13
    Author     : Winycius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>::: BeniGranja :::</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/benigranja.css">
    </head>
    <body>
        <div class="nonFooter fundo">
            <div class="container">
                <div class="login jumbotron centralizado">                    
                    <h2>Bem vindo a área corporativa da BeniGranja</h2>
                    <br/>
                    <div class="box-small centralizado">
                        <form action="Login" method="POST" class="well">
                            <div class="form-group">
                                <label> Login</label>
                                <input type="text" required="required" name="usuario" class="form-control " placeholder="Digite seu nome de usuario">                                                            
                                <br/>
                                <label> Senha</label>
                                <input type="password" required="required" name="senha" class="form-control" placeholder="Digite sua senha">                                
                                <br/>
                                <%
                                    Boolean falhaLogin = (Boolean) request.getAttribute("falhaLogin");
                                    if (falhaLogin != null) {%>
                                <div class="alert alert-danger" role="alert">
                                    <span class="sr-only">Error:</span>
                                    Nome de usuário e/ou senha inválidos!
                                </div>  
                                <%}
                                %>
                                <hr>
                                <input type="submit" value="Logar" class="btn btn-success " />
                            </div>                        
                        </form> 

                    </div>
                </div>
            </div>

            <div id="push"></div>
        </div>
        <footer class="stickyFooter">
            <div class="container">
                <div class="row center-block">
                    BeniGranja - Desenvolvido por Winycius Antonio do Canto - Versão 1.0
                </div>
            </div>
        </footer>
    </body>
</html>
