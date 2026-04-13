<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
    <head>
        <jsp:include page="/WEB-INF/components/meta.jsp"/>
        <title>${title}</title>
        <jsp:include page="/WEB-INF/components/link.jsp"/>
    </head>
    <body class="bg-light">
        <jsp:include page="/WEB-INF/components/header.jsp"/>
        <div class="container mt-4">
            <div class="text-center mt-5">
                <h1 class="display-4 text-danger">404</h1>
                <p class="lead">La página que buscas no existe.</p>
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">
                    <i class="fa-solid fa-rotate-left"></i>&nbsp;Regresar al Inicio
                </a>
            </div>
        </div>
        <jsp:include page="/WEB-INF/components/footer.jsp"/>
        <jsp:include page="/WEB-INF/components/script.jsp"/>
    </body>
</html>