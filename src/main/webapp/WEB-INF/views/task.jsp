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
                        <div class="card-header text-bg-dark">
                            <h3>
                                <i class="fa-solid fa-list-check"></i>&nbsp;${title}
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="card-title">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-dark btn-task-refresh">
                                        <i class="fa-solid fa-arrow-rotate-right"></i>&nbsp;Refrescar
                                    </button>
                                    <button type="button" class="btn btn-dark btn-task-create">
                                        <i class="fa-solid fa-file-circle-plus"></i>&nbsp;Registrar
                                    </button>
                                </div>
                            </div>
                            <div class="row">&nbsp;</div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <table class="table table-bordered table-striped">
                                        <thead class="table-dark">
                                            <tr class="text-center">
                                                <th scope="col">Título</th>
                                                <th scope="col">Descripción</th>
                                                <th scope="col">Estado</th>
                                                <th scope="col">Fecha de Creación</th>
                                                <th scope="col">Opciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="task" items="${taskList}">
                                                <tr>
                                                    <td class="text-justify">${task.title}</td>
                                                    <td class="text-justify">${task.description}</td>
                                                    <td class="text-center">
                                                        <c:choose>
                                                            <c:when test="${task.status == 'PENDING'}">
                                                                Pendiente
                                                            </c:when>
                                                            <c:when test="${task.status == 'IN_PROCESS'}">
                                                                En Proceso
                                                            </c:when>
                                                            <c:when test="${task.status == 'COMPLETED'}">
                                                                Completada
                                                            </c:when>
                                                            <c:otherwise>
                                                                Desconocido
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="text-center">${localDateTimeUtil.formatter(task.createdAt, "dd/MM/yyyy HH:mm:ss")}</td>
                                                    <td class="text-center">
                                                        <div class="btn-group mr-2" aria-label="Options">
                                                            <button id="btnEdit" type="button" class="btn btn-sm btn-primary btn-task-edit"
                                                                    data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-title="Editar"
                                                                    data-id="${task.id}">
                                                                <i class="fa-regular fa-pen-to-square"></i>
                                                            </button>
                                                            <button id="btnDelete" type="button" class="btn btn-sm btn-danger btn-task-delete"
                                                                    data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-title="Eliminar"
                                                                    data-id="${task.id}">
                                                                <i class="fa-regular fa-trash-can"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <c:if test="${empty taskList}">
                                        <div class="alert alert-primary" role="alert">
                                            <i class="fa-solid fa-circle-exclamation"></i>&nbsp;No se encontrarón tareas registradas.
                                        </div>
                                    </c:if>
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
                $(".btn-task-create").on("click", function () {
                    window.location.href = "<%= request.getContextPath() %>/tasks/create";
                });
                $(".btn-task-edit").on("click", function () {
                    let id = $(this).data("id");
                    console.log("Edit Task: " + id);
                    window.location.href = "<%= request.getContextPath() %>/tasks/edit?id=" + id;
                });
                $(".btn-task-delete").on("click", function () {
                    let id = $(this).data("id");
                    console.log("Delete Task: " + id);
                    window.location.href = "<%= request.getContextPath() %>/tasks/delete?id=" + id;
                });
            });
        </script>
    </body>
</html>