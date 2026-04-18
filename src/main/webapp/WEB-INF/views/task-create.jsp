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
                                <i class="fa-solid fa-file-circle-plus"></i>&nbsp;${title}
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <form id="formCreate" class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/tasks/create">
                                        <div class="mb-3">
                                            <label for="formTaskTitle" class="form-label"><strong>Título:</strong></label>
                                            <input id="formTaskTitle" name="title" type="text" class="form-control" placeholder="Task 01 - Title" required>
                                            <div class="invalid-feedback">
                                              El título es obligatorio.
                                            </div>
                                        </div>
                                        <div class="mb-3">
                                            <label for="formTaskDescription" class="form-label"><strong>Descripción:</strong></label>
                                            <input id="formTaskDescription" name="description" type="text" class="form-control" placeholder="Task 01 - Description" required>
                                            <div class="invalid-feedback">
                                              La descripción es obligatoria.
                                            </div>
                                        </div>
                                        <div class="mb-3 text-center">
                                            <button type="button" class="btn btn-secondary btn-task-refresh">Regresar</button>
                                            <button type="submit" class="btn btn-success">Guardar</button>
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

                $("form.needs-validation").on("submit", function (event) {
                    const form = this;
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    $(form).addClass("was-validated");
                });
            });
        </script>
    </body>
</html>