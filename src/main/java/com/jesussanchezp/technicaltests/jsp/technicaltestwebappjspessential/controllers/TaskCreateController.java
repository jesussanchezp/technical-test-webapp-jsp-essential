/*
 * Copyright (c) 2026 Jesús Guillermo Sánchez Peralta <https://jesussanchezp.com>. All rights reserved.
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

import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.models.TaskModel;
import com.jesussanchezp.technicaltests.jsp.technicaltestwebappjspessential.services.TaskService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;

@WebServlet("/tasks/create")
public class TaskCreateController extends HttpServlet {

  @Inject private Logger logger;
  @Inject private TaskService taskService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    logger.info("Task to Create");
    req.setAttribute("title", "Registrar Nueva Tarea");
    req.setAttribute("isError", "false");
    req.getRequestDispatcher("/WEB-INF/views/task-create.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    TaskModel taskModel = new TaskModel();
    taskModel.setTitle(req.getParameter("title"));
    taskModel.setDescription(req.getParameter("description"));
    this.taskService.save(taskModel);
    resp.sendRedirect(req.getContextPath() + "/tasks");
  }
}
