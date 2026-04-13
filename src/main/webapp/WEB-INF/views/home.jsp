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
            <h1 class="text-center">Prueba Técnica</h1>
            <h4>El objetivo de esta prueba es medir el nivel de experiencia para un perfil de desarrollador senior.</h4>
            <p>
                Se deberá de realizar un CRUD de Tareas aplicando sus habilidades y conocimientos en Java principalmente.
                El cuál tendrá las siguientes opciones:
            </p>
            <ul>
                <li>Listado de Tareas</li>
                <li>Creación de Tareas</li>
                <li>Modificación de Tareas</li>
                <li>Eliminación de Tareas</li>
            </ul>
            <p>Se dará un tiempo máximo de 60 minutos para la realización de esta prueba técnica.</p>
        </div>
        <jsp:include page="/WEB-INF/components/footer.jsp"/>
        <jsp:include page="/WEB-INF/components/script.jsp"/>
    </body>
</html>