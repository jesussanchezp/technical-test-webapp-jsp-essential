<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
            <div class="row">
                <div class="col-12">
                     <div class="card">
                        <div class="card-header text-bg-dark text-center">
                            <h3>
                                <i class="fa-solid fa-trash-can"></i>&nbsp;${title}
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <form action="delete" method="post">
                                        <div class="mb-3 text-center">
                                            <input type="hidden" name="id" value="${task.id}">
                                            <h3>¿Seguro que deseas eliminar esta tarea?</h3>
                                            <p><strong>Título:</strong> ${task.title}</p>
                                            <p><strong>Descripción:</strong> ${task.description}</p>
                                        </div>
                                        <div class="mb-3 text-center">
                                            <button type="button" class="btn btn-secondary btn-task-refresh">Regresar</button>
                                            <button type="submit" class="btn btn-danger">Eliminar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                     </div>
                 </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/components/footer.jsp"/>
        <jsp:include page="/WEB-INF/components/script.jsp"/>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".btn-task-refresh").on("click", function () {
                    window.location.href = "<%= request.getContextPath() %>/tasks";
                });
            });
        </script>
    </body>
</html>