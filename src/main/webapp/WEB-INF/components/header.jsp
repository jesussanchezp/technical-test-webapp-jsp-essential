<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<header>
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <i class="fa-regular fa-house fa-lg"></i>
            </a>
            <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarMenu"
                    aria-controls="navbarMenu" aria-expanded="false" aria-label="Menu">
                  <span class="navbar-toggler-icon"></span>
                </button>
            <div id="navbarMenu" class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/tasks">Mis Tareas</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>