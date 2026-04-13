/*
 * Copyright 2026 Jesús Guillermo Sánchez Peralta. <https://jesussanchezp.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/error-handler")
public class ErrorController extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Integer status = (Integer) req.getAttribute("jakarta.servlet.error.status_code");

    Throwable exception = (Throwable) req.getAttribute("jakarta.servlet.error.exception");

    String message = exception != null ? exception.getMessage() : "Error desconocido";

    logger.info("Entrando a Error Controller {} - {}", status, message);

    req.setAttribute("isError", "true");
    req.setAttribute("message", message);

    if (status != null && status == 404) {
      req.setAttribute("title", "Página no encontrada");
    } else if (status != null && status == 405) {
      req.setAttribute("title", "Método no permitido");
    } else {
      req.setAttribute("title", "Error del servidor");
    }

    req.getRequestDispatcher("/WEB-INF/errors/" + status + ".jsp").forward(req, resp);
  }
}
